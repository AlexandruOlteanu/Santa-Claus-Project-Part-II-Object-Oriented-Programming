package solution.SortChildrens;

import solution.ChildrenCategory.ChildrenCategory;

import java.util.Comparator;
import java.util.List;

public final class IdSort implements SortChildren {

    /**
     * Sorteaza lista de copii in ordine crescatoare dupa id
     * @param childrenCategoryList Lista de copii ce trebuie sortata
     */
    @Override
    public void makeSort(final List<ChildrenCategory> childrenCategoryList) {

        childrenCategoryList.sort(Comparator.comparing(ChildrenCategory::getId));

    }
}
