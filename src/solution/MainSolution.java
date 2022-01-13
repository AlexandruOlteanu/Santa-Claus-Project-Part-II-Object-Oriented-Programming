package solution;

import database.AnnualChanges;
import database.Children;
import database.Input.Input;
import database.SantaGift;
import database.Writer.ChildrenWriter;
import solution.ChildrenCategory.ChildrenCategory;
import solution.ChildrenCategory.ChildrenFactory;
import solution.SolveRound.SolveRound;
import solution.SolveRound.UpdateRound;
import solution.YoungAdult.YoungAdult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class MainSolution {

    private Input input;
    private String output;

    private static MainSolution instance = null;

    /**
     * Metoda necesara pentru a face clasa MainSolution de
     * tip Singleton
     *
     * @return returneaza instanta unica creata de tip MainSolution
     */
    public static MainSolution getInstance() {
        if (instance == null) {
            instance = new MainSolution();
        }
        return instance;
    }

    private MainSolution() {

    }

    /**
     * Initializeaza obiectele din cadrul clasei MainSolution
     *
     * @param inputGiven Datele din input dupa parsarea acestora
     * @param outputGiven Path catre fisierul unde trebuie scrise rezultatele
     */
    public void init(final Input inputGiven, final String outputGiven) {
        input = inputGiven;
        output = outputGiven;
    }

    /**
     * Aceasta metoda reprezinta parcurgerea tuturor rundelor efectuate in
     * cadrul unui anumit test. Pentru inceput se pun copiii din input in functie
     * de categoria de varsta a fiecaruia intr-o lista cu obiecte de tipul ChildrenCategory,
     * obiecte create cu ajutorul unui BuildPattern. In continuare se sorteaza lista de cadorui
     * in functie de pret in ordine crescatoare si se apeleaza metoda de rezolvare a unei runde din
     * clasa SolveRound dupa care se adauga datele corespunzatoare pentru acesti copii in
     * JSONArray-ul final Se traverseaza apoi prin fiecare runda in parte si se face update-ul
     * corespunzator, apoi rezolvarea rundei si in cele din urma adaugarea datelor in JSONArray-ul
     * final La finalul celor numberOfYears + 1 runde se scrie in fisierul corespunzator aceste
     * date din JSONArray cu ajutorul metodei closeFile().
     *
     * @throws IOException
     */
    public void solve() throws IOException {

        List<ChildrenCategory> childrenCategoryList = new ArrayList<>();

        List<Children> childrenList = input.getInitialData().getChildrenList();

        for (Children children : childrenList) {
            ChildrenCategory.ChildrenCategoryBuilder childrenCategoryBuilder =
                    new ChildrenCategory.ChildrenCategoryBuilder(children.getId(),
                            children.getLastName(), children.getFirstName(),
                            children.getCity(), children.getAge());
            childrenCategoryBuilder.giftsPreferences(children.getGiftsPreferences());
            List<Double> niceScoreHistory = new ArrayList<>();
            niceScoreHistory.add(children.getNiceScore());
            childrenCategoryBuilder.niceScoreHistory(niceScoreHistory);
            childrenCategoryBuilder.niceScoreBonus(children.getNiceScoreBonus());
            childrenCategoryBuilder.elf(children.getElf());
            List<SantaGift> receivedGifts = new ArrayList<>();
            childrenCategoryBuilder.receivedGifts(receivedGifts);
            ChildrenCategory childrenCategory = childrenCategoryBuilder.build();

            ChildrenFactory childrenFactory = ChildrenFactory.getInstance();

            childrenCategory = childrenFactory.createChildren(
                    childrenFactory.getChildrenType(children.getAge()), childrenCategory);

            if (!(childrenCategory instanceof YoungAdult)) {
                childrenCategoryList.add(childrenCategory);
            }
        }

        SolveRound solveRound = SolveRound.getInstance();
        UpdateRound updateRound = UpdateRound.getInstance();

        input.getInitialData().getSantaGiftsList().sort(
                Comparator.comparingDouble(SantaGift::getPrice));
        solveRound.solve(input, childrenCategoryList, null);

        ChildrenWriter childrenWriter = ChildrenWriter.getInstance();
        childrenWriter.init(output);
        childrenWriter.writeFile(childrenCategoryList);
        for (int i = 0; i < input.getNumberOfYears(); ++i) {
            AnnualChanges annualChange = input.getAnnualChanges().get(i);
            childrenCategoryList = updateRound.update(annualChange,
                    childrenCategoryList, input);
            solveRound.solve(input, childrenCategoryList, annualChange);
            childrenWriter.writeFile(childrenCategoryList);
        }
        childrenWriter.closeFile();
    }

}
