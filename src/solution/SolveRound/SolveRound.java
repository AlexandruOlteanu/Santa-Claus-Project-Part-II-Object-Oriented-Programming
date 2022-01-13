package solution.SolveRound;

import database.AnnualChanges;
import database.Input.Input;
import database.SantaGift;
import enums.Category;
import solution.ChildrenCategory.ChildrenCategory;
import solution.SortChildrens.SortChildren;
import solution.SortChildrens.SortChildrenFactory;

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
     * fiecarui copil, se sorteaza lista de copii dupa strategia din input cu ajutorul
     * unui FactoryPattern folosit pentru crearea clasei corespunzatoare de sortare
     * si apoi se parcurg listele de preferinte si cadorurile
     * existente, fiind cumparat cate un cadou din fiecare categorie aflata in
     * preferinte cat timp bugetul este indeajuns. In final, se verifica pentru fiecare
     * copil care nu a primit niciun cadou daca elful acestuia este yellow. In caz afirmativ
     * se cauta cel mai ieftin cadou din categoria cea mai preferata de acesta si se asigneaza
     * un cadou daca inca este in stoc. De asemenea, ordinea ascendenta
     * a preturilor cadourilor este asigurata de sortarea cadourilor realizata dupa
     * acest criteriu inaintea apelului acestei metode
     *
     * @param input Datele din care se preia bugetul Modului pentru anul respectiv si lista
     *              de cadouri disponibile
     * @param childrenCategoryList Lista de copii pentru care trebuie cumparate cadouri
     */
    public void solve(final Input input,
                      final List<ChildrenCategory> childrenCategoryList,
                      final AnnualChanges annualChange) {

        Double sumAverageScores = 0.0;
        for (ChildrenCategory childrenCategory : childrenCategoryList) {
            childrenCategory.calculateAverageScore();
            sumAverageScores += childrenCategory.getAverageScore();
        }

        Double budgetUnit = input.getSantaBudget() / sumAverageScores;

        for (ChildrenCategory childrenCategory : childrenCategoryList) {
            childrenCategory.calculateAssignedBudget(budgetUnit);
        }
        SortChildrenFactory sortChildrenFactory = SortChildrenFactory.getInstance();
        if (annualChange == null) {
            SortChildren sortChildren = sortChildrenFactory.createSortMethod("id");
            sortChildren.makeSort(childrenCategoryList);
        } else {
            SortChildren sortChildren = sortChildrenFactory.createSortMethod(
                    annualChange.getStrategy());
            sortChildren.makeSort(childrenCategoryList);
        }
        for (ChildrenCategory childrenCategory : childrenCategoryList) {
            Double assignedBudget = childrenCategory.getAssignedBudget();
            for (String giftPreference : childrenCategory.getGiftsPreferences()) {
                Double lowestPricedGift;
                for (SantaGift santaGift : input.getInitialData().getSantaGiftsList()) {
                    if (santaGift.getCategory().equals(Category.findCategory(giftPreference))
                            && santaGift.quantity() != 0) {
                        lowestPricedGift = santaGift.getPrice();
                        if (lowestPricedGift <= assignedBudget) {
                            childrenCategory.getReceivedGifts().add(santaGift);
                            assignedBudget -= lowestPricedGift;
                            santaGift.setQuantity(santaGift.quantity() - 1);
                            break;
                        }
                    }
                }
            }
        }

        for (ChildrenCategory childrenCategory : childrenCategoryList) {
            if (childrenCategory.elf().equals("yellow")) {
                if (childrenCategory.getReceivedGifts().isEmpty()
                        && !childrenCategory.getGiftsPreferences().isEmpty()) {
                    String giftPreference = childrenCategory.getGiftsPreferences().get(0);
                    for (SantaGift santaGift : input.getInitialData().getSantaGiftsList()) {
                        if (santaGift.getCategory().equals(
                                Category.findCategory(giftPreference))) {
                            if (santaGift.quantity() != 0) {
                                childrenCategory.getReceivedGifts().add(santaGift);
                                santaGift.setQuantity(santaGift.quantity() - 1);
                            }
                            break;
                        }
                    }
                }
            }
        }

        SortChildren sortChildren = sortChildrenFactory.createSortMethod("id");
        sortChildren.makeSort(childrenCategoryList);
    }
}
