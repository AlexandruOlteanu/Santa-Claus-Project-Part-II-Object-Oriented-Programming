package database.Writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import solution.ChildrenCategory.ChildrenCategory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class ChildrenWriter {

    private FileWriter file;
    private JSONObject objects = new JSONObject();
    private JSONArray jsonArray = new JSONArray();

    private static ChildrenWriter instance = null;

    /**
     * Metoda necesara pentru a face clasa ChildrenWriter de
     * tip Singleton.
     *
     * @return returneaza instanta unica creata de tip ChildrenWriter
     */
    public static ChildrenWriter getInstance() {
       if (instance == null) {
           instance = new ChildrenWriter();
       }
       return instance;
    }

    private ChildrenWriter() {

    }

    /**
     * Initializeaza obiectele din cadrul clasei ChildrenWriter
     *
     * @param pathGiven Un sir de caractere ce reprezinta path-ul unde vor fi scrise datele
     * @throws IOException
     */
    public void init(final String pathGiven) throws IOException {
        objects.clear();
        jsonArray.clear();
        file = new FileWriter(pathGiven);
    }

    /**
     * Realizeaza asignarea unui obiect JSON de catre o lista de copii din categorii diferite
     * de varsta. Se face apoi un Deep Copy pentru acest obiuect JSON care apoi este adaugat
     * in array-ul de obiecte JSON, "jsonArray"
     *
     * @param childrenCategoryList lista de copii din categorii diferite de varsta
     * @throws IOException
     */
    public void writeFile(final List<ChildrenCategory> childrenCategoryList) throws IOException {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("children", childrenCategoryList);
        ObjectMapper mapper = new ObjectMapper();
        String jsonSource = mapper.writeValueAsString(jsonObject);
        JSONObject jsonObjectClone = mapper.readValue(jsonSource, JSONObject.class);
        jsonArray.add(jsonObjectClone);
    }

    /**
     * Se creeaza un nou obiect de tip JSON in care se adauga array-ul construit la testul
     * curent. Acesta se mapeaza ca fiind un String Human Readable care apoi se scrie in fisierul
     * dorit si se inchide acest fisier
     *
     * @throws IOException
     */
    public void closeFile() throws IOException {
        objects.put("annualChildren", jsonArray);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objects);
        file.write(jsonString);
        file.flush();
        file.close();
    }

}
