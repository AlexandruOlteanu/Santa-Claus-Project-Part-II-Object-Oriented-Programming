package solution.SortChildrens;

import solution.ChildrenCategory.ChildrenCategory;
import java.util.List;

public final class NiceScoreSort implements SortChildren {

    /**
     * Copiii sunt sortati in functie de nice score si in caz de egalitate
     * in functie de Id
     * @param childrenCategoryList Lista de copii ce trebuie sortata
     */
    @Override
    public void makeSort(final List<ChildrenCategory> childrenCategoryList) {
        childrenCategoryList.sort((o1, o2) -> {
            if (Double.compare(o1.getAverageScore(), o2.getAverageScore()) == 0) {
                return o1.getId().compareTo(o2.getId());
            }
            return -Double.compare(o1.getAverageScore(), o2.getAverageScore());
        });
    }
}
