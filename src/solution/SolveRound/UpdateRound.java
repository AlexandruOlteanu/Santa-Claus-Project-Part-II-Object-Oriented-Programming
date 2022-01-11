package solution.SolveRound;

import database.AnnualChanges;
import database.Children;
import database.Input.Input;
import database.SantaGift;
import solution.ChildrenCategory.ChildrenCategory;
import solution.ChildrenCategory.ChildrenFactory;
import solution.YoungAdult.YoungAdult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class UpdateRound {

    private static UpdateRound instance = null;

    private UpdateRound() {

    }

    /**
     * Metoda necesara pentru a face clasa UpdateRound de
     * tip Singleton
     *
     * @return returneaza instanta unica creata de tip UpdateRound
     */
    public static UpdateRound getInstance() {
        if (instance == null) {
            instance = new UpdateRound();
        }
        return instance;
    }

    /**
     * Aceasta metoda aplica schimbarile aferente corespunzatoare anului curent.
     * In primul rand se modifica varsta fiecarui copil prezent in lista dupa care
     * sunt exclusi cei care au devenit copii de tipul YoungAdult. Se modifica apoi
     * bugetul total al Mosului pentru anul respectiv. In continuare se adauga noile
     * cadouri la lista existenta si se face sortarea acestora in functie de pret.
     * Se aplica apoi schimarile anuale asupra copiilor existenti in lista si in
     * final se adauga copiii care nu sunt de tipul YoungAdult la lista de copiii.
     * In acest mod schimbarile sunt realizate si calculele pentru noul an pot fi
     * realizate in mod corect
     *
     * @param annualChange Schimbarile ce trebuiesc aplicate in anul curent
     * @param childrenCategoryList Lista de copii asupra carora se realizeaza
     *                             schimbarile
     * @param input Datele din care se preia lista de cadorui deja existenta
     * @return returnaza o lista de obiecte de tipul ChildrenCategory ce reprezinta
     * lista de copii in urma modificarilor
     */
    public List<ChildrenCategory> update(final AnnualChanges annualChange,
                    final List<ChildrenCategory> childrenCategoryList, final Input input) {

        List<ChildrenCategory> newChildrenCategoryList = new ArrayList<>();

        ChildrenFactory childrenFactory = ChildrenFactory.getInstance();

        for (ChildrenCategory child : childrenCategoryList) {
            child.updateAge();
            ChildrenCategory newChild = childrenFactory.createChildren(
                    childrenFactory.getChildrenType(child.getAge()), child);
            if (!(newChild instanceof YoungAdult)) {
                newChildrenCategoryList.add(newChild);
            }
        }

        input.setSantaBudget(annualChange.getNewSantaBudget());
        for (SantaGift santaGift : annualChange.getNewGifts()) {
            input.getInitialData().getSantaGiftsList().add(santaGift);
        }

        input.getInitialData().getSantaGiftsList().sort(Comparator.comparingDouble(
                        SantaGift::getPrice));
        ChangeChildrensInfo changeChildrensInfo = ChangeChildrensInfo.getInstance();
        changeChildrensInfo.update(newChildrenCategoryList, annualChange.getChildrenUpdates());

        for (Children children : annualChange.getNewChildren()) {
            ChildrenCategory childrenCategory = new ChildrenCategory() {
                @Override
                public void calculateAverageScore() { }
            };
            childrenCategory.setChildrenCategory(children);
            childrenCategory = childrenFactory.createChildren(
                    childrenFactory.getChildrenType(children.getAge()), childrenCategory);
            if (!(childrenCategory instanceof YoungAdult)) {
                newChildrenCategoryList.add(childrenCategory);
            }
        }

        return newChildrenCategoryList;
    }

}
