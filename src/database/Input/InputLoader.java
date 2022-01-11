package database.Input;

import database.Children;
import database.ChildrenUpdate;
import database.SantaGift;
import database.AnnualChanges;
import database.InitialData;
import enums.Category;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class InputLoader {

    private String inputPath;
    private static InputLoader instance = null;

    /**
     * Metoda necesara pentru a face clasa InputLoader de
     * tip Singleton
     *
     * @return returneaza instanta unica creata de tip InputLoader
     */
    public static InputLoader getInstance() {
        if (instance == null) {
            instance = new InputLoader();
        }
        return instance;
    }

    private InputLoader() {

    }

    /**
     * Initializeaza obiectele din cadrul clasei InputLoader
     *
     * @param inputPathGiven Un sir de caractere ce reprezinta calea de acces catre input
     */
    public void init(final String inputPathGiven) {
        this.inputPath = inputPathGiven;
    }

    /**
     * Parseaza datele din input sub forma de blocuri Json si le muta in clasele
     * corespunzatoare
     *
     * @return Intoarce un obiect de tip Input ce stocheaza toate datele prezente in input si ce
     * va fi folosit pentru realizarea calculelor
     */
    public Input readData() {

        JSONParser jsonParser = new JSONParser();
        Integer numberOfYears = null;

        Integer santaBudget = null;

        InitialData initialData = null;

        List<AnnualChanges> annualChanges = null;

        try {

            JSONObject jsonObject = (JSONObject) jsonParser.parse(new
                    FileReader(inputPath));
            numberOfYears = ((Long) jsonObject.get("numberOfYears")).intValue();
            santaBudget = ((Long) jsonObject.get("santaBudget")).intValue();

            JSONObject jsonInitialData = (JSONObject) jsonObject.get("initialData");
            JSONArray jsonChildrenList = (JSONArray) jsonInitialData.get("children");
            JSONArray jsonSantaGiftsList = (JSONArray) jsonInitialData.get("santaGiftsList");

            List<Children> childrenList = readChildren(jsonChildrenList);

            List<SantaGift> santaGiftsList = readSantaGift(jsonSantaGiftsList);

            initialData = new InitialData(childrenList, santaGiftsList);

            JSONArray jsonAnnualChanges = (JSONArray) jsonObject.get("annualChanges");
            annualChanges = readAnnualChanges(jsonAnnualChanges);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        Input input = Input.getInstance();
        input.init(numberOfYears, santaBudget, initialData, annualChanges);
        return input;
    }

    /**
     * Metoda ce realizeaza parsarea listei de copii prezenti initial in mod independent
     *
     * @param jsonChildrenList Lista de tip JSONArray din care vor fi parsate datele
     * @return returneaza o lista de copii sub forma de obiecte de tip Children
     */
    public List<Children> readChildren(final JSONArray jsonChildrenList) {
        List<Children> childrenList = new ArrayList<Children>();
        if (jsonChildrenList != null) {
            for (Object jsonChildren : jsonChildrenList) {
                List<String> giftsPreferences = new ArrayList<>();
                JSONArray jsonGiftsPreferences = (JSONArray)
                        ((JSONObject) jsonChildren).get("giftsPreferences");
                for (Object jsonGiftPreference : jsonGiftsPreferences) {
                    giftsPreferences.add(jsonGiftPreference.toString());
                }

                childrenList.add(new Children(
                        ((Long) ((JSONObject) jsonChildren).get("id")).intValue(),
                        (String) ((JSONObject) jsonChildren).get("lastName"),
                        (String) ((JSONObject) jsonChildren).get("firstName"),
                        ((Long) ((JSONObject) jsonChildren).get("age")).intValue(),
                        (String) ((JSONObject) jsonChildren).get("city"),
                        ((Long) ((JSONObject) jsonChildren).get("niceScore")).doubleValue(),
                        giftsPreferences
                ));
            }
        }

        return childrenList;
    }

    /**
     * Metoda ce realizeaza parsarea listei de cadouri prezente initial in mod independent
     *
     * @param jsonSantaGiftsList Lista de tip JSONArray din care vor fi parsate datele
     * @return returneaza lista de cadouri sub forma de obiecte de tip SantaGift
     */
    public List<SantaGift> readSantaGift(final JSONArray jsonSantaGiftsList) {
        List<SantaGift> santaGiftsList = new ArrayList<SantaGift>();

        if (jsonSantaGiftsList != null) {
            for (Object jsonSantaGifts : jsonSantaGiftsList) {

                String name = (String) ((JSONObject) jsonSantaGifts).get("category");
                Category category;

                switch (name) {
                    case "Books" -> {
                        category = Category.BOOKS;
                    }
                    case "Board Games" -> {
                        category = Category.BOARD_GAMES;
                    }
                    case "Clothes" -> {
                        category = Category.CLOTHES;
                    }
                    case "Sweets" -> {
                        category = Category.SWEETS;
                    }
                    case "Technology" -> {
                        category = Category.TECHNOLOGY;
                    }
                    case "Toys" -> {
                        category = Category.TOYS;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + name);
                }

                santaGiftsList.add(new SantaGift(
                        (String) ((JSONObject) jsonSantaGifts).get("productName"),
                        ((Long) ((JSONObject) jsonSantaGifts).get("price")).doubleValue(),
                        category
                ));
            }
        }
        return santaGiftsList;
    }

    /**
     * Metoda ce realizeaza parsarea listei de schimbari in cadrul listei de copii
     * in mod independent
     *
     * @param jsonChildrenUpdate Lista de tip JSONArray din care vor fi parsate datele
     * @return returneaza o lista de astfel de schimbari sub forma unor obiecte de tipul
     * ChildrenUpdate
     */
    public List<ChildrenUpdate> readChildrenUpdate(final JSONArray jsonChildrenUpdate) {
        List<ChildrenUpdate> childrenUpdates = new ArrayList<>();

        if (jsonChildrenUpdate != null) {
           for (Object jsonChildren : jsonChildrenUpdate) {
               List<String> giftsPreferences = new ArrayList<>();
               JSONArray jsonGiftsPreferences = (JSONArray)
                       ((JSONObject) jsonChildren).get("giftsPreferences");
               for (Object jsonGiftPreference : jsonGiftsPreferences) {
                   giftsPreferences.add(jsonGiftPreference.toString());
               }

               Double niceScore = null;
               if (((JSONObject) jsonChildren).get("niceScore") != null) {
                   niceScore = ((Long) ((JSONObject) jsonChildren).get("niceScore")).doubleValue();
               }

               childrenUpdates.add(new ChildrenUpdate(
                       ((Long) ((JSONObject) jsonChildren).get("id")).intValue(),
                       niceScore,
                       giftsPreferences
               ));
           }
        }

        return childrenUpdates;
    }

    /**
     * Metoda ce realizeaza parsarea listei de schimbari anuale in mod independent
     *
     * @param jsonAnnualChanges Lista de tip JSONArray din care vor fi parsate datele
     * @return returneaza o lista de schimbari anuale sub forma unor obiecte de tipul
     * AnnualChanges
     */
    public List<AnnualChanges> readAnnualChanges(final JSONArray jsonAnnualChanges) {
        List<AnnualChanges> annualChanges = new ArrayList<>();
        if (jsonAnnualChanges != null) {
            for (Object jsonAnnualChange : jsonAnnualChanges) {
                JSONArray jsonNewGifts = (JSONArray) ((JSONObject)
                        jsonAnnualChange).get("newGifts");
                JSONArray jsonNewChildren = (JSONArray) ((JSONObject)
                        jsonAnnualChange).get("newChildren");
                JSONArray jsonChildrenUpdate = (JSONArray) ((JSONObject)
                        jsonAnnualChange).get("childrenUpdates");
                annualChanges.add(new AnnualChanges(
                        ((Long) ((JSONObject) jsonAnnualChange).get("newSantaBudget")).intValue(),
                        readSantaGift(jsonNewGifts),
                        readChildren(jsonNewChildren),
                        readChildrenUpdate(jsonChildrenUpdate)
                ));
            }
        }

        return annualChanges;
    }
}
