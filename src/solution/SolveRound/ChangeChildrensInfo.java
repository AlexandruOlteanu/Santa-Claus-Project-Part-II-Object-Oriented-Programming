package solution.SolveRound;

import database.ChildrenUpdate;
import solution.ChildrenCategory.ChildrenCategory;

import java.util.List;

public final class ChangeChildrensInfo {

    private static ChangeChildrensInfo instance = null;

    private ChangeChildrensInfo() {

    }

    /**
     * Metoda necesara pentru a face clasa ChangeChildrensInfo de
     * tip Singleton
     *
     * @return returneaza instanta unica creata de tip ChangeChildrensInfo
     */
    public static ChangeChildrensInfo getInstance() {
        if (instance == null) {
            instance = new ChangeChildrensInfo();
        }
        return instance;
    }
    /**
     * Se fac schimbarile necesare copiilor din lista curenta a Mosului care
     * au id-ul corespunzator. Acestora li se modifica lista nice score-urilor
     * si lista de preferinte pentru categorii
     *
     * @param childrenCategoryList Lista de copii asupra carora se vor face schimbarile necesare
     * @param childrenUpdates Lista de schimbari in functie de id-ul copiilor
     */
    public void update(final List<ChildrenCategory> childrenCategoryList,
                                                final List<ChildrenUpdate> childrenUpdates) {
        for (ChildrenUpdate childrenUpdate : childrenUpdates) {
            for (ChildrenCategory childrenCategory : childrenCategoryList) {
                if (childrenCategory.getId().equals(childrenUpdate.getId())) {
                        childrenCategory.updateNiceScoreHistory(childrenUpdate.getNiceScore());
                        childrenCategory.updateGiftsPreferences(
                                childrenUpdate.getGiftsPreferences());
                }
            }
        }
    }
}
