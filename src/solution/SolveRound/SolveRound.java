package solution.SolveRound;

import database.Input.Input;
import database.SantaGift;
import enums.Category;
import solution.ChildrenCategory.ChildrenCategory;

import java.util.List;

public final class SolveRound {

    private static SolveRound instance = null;

    private SolveRound() {

    }

    /**
     * Metoda necesara pentru a face clasa SolveRound de
     * tip Singleton
     *
     * @return returneaza instanta unica creata de tip SolveRound
     */
    public static SolveRound getInstance() {
        if (instance == null) {
            instance = new SolveRound();
        }
        return instance;
    }

    /**
     * Realizeaza impartirea cadorilor in functie de bugetul si preferintele
     * fiecarui copil. In cadrul acestei metode se calculeaza bugetul asignat
     * fiecarui copil si apoi se parcurg listele de preferinte si cadorurile
     * existente, fiind cumparat cate un cadou din fiecare categorie aflata in
     * preferinte cat timp bugetul este indeajuns. De asemenea, ordinea ascendenta
     * a preturilor cadourilor este asigurata de sortarea cadourilor realizata dupa
     * acest criteriu inaintea apelului acestei metode
     *
     * @param input Datele din care se preia bugetul Modului pentru anul respectiv si lista
     *              de cadouri disponibile
     * @param childrenCategoryList Lista de copii pentru care trebuie cumparate cadouri
     */
    public void solve(final Input input,
                                  final List<ChildrenCategory> childrenCategoryList) {

        Double sumAverageScores = 0.0;
        for (ChildrenCategory childrenCategory : childrenCategoryList) {
            childrenCategory.calculateAverageScore();
            sumAverageScores += childrenCategory.getAverageScore();
        }

        Double budgetUnit = input.getSantaBudget() / sumAverageScores;

        for (ChildrenCategory childrenCategory : childrenCategoryList) {
            childrenCategory.calculateAssignedBudget(budgetUnit);
        }

        for (ChildrenCategory childrenCategory : childrenCategoryList) {
            Double assignedBudget = childrenCategory.getAssignedBudget();
            for (String giftPreference : childrenCategory.getGiftsPreferences()) {
                Double lowestPricedGift;
                for (SantaGift santaGift : input.getInitialData().getSantaGiftsList()) {
                    if (santaGift.getCategory().equals(Category.findCategory(giftPreference))) {
                        lowestPricedGift = santaGift.getPrice();
                        if (lowestPricedGift <= assignedBudget) {
                            childrenCategory.getReceivedGifts().add(santaGift);
                            assignedBudget -= lowestPricedGift;
                            break;
                        }
                    }
                }
            }
        }

    }
}
