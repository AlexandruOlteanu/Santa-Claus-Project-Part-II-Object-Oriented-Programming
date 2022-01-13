package solution.SortChildrens;

import solution.ChildrenCategory.ChildrenCategory;

import java.util.List;

public interface SortChildren {
    /**
     * Interfata comuna pentru clasele de sortare. Am folosit
     * Strategy Pattern pentru o mai usoara implementare
     * @param childrenCategoryList Lista de copii ce trebuie sortata
     */
    void makeSort(List<ChildrenCategory> childrenCategoryList);
}
