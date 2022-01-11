package solution.ChildrenCategory;

import common.Constants;
import solution.Baby.Baby;
import solution.Kid.Kid;
import solution.Teen.Teen;
import solution.YoungAdult.YoungAdult;

public final class ChildrenFactory {

    private static ChildrenFactory instance = null;

    private ChildrenFactory() {

    }

    /**
     * Metoda necesara pentru a face clasa ChildrenFactory de
     * tip Singleton
     *
     * @return returneaza instanta unica creata de tip ChildrenFactory
     */
    public static ChildrenFactory getInstance() {
        if (instance == null) {
            instance = new ChildrenFactory();
        }
        return instance;
    }

    public enum ChildrenType {
        Baby, Kid, Teen, YoungAdult
    }

    /**
     * Calculeaza categoria din care face parte un copil in functie de
     * varsta acestuia
     *
     * @param age Varsta copilului
     * @return returneaza categoria din care face parte copilul
     */
    public ChildrenType getChildrenType(final Integer age) {
        if (age < Constants.BABY_AGE) {
            return ChildrenType.Baby;
        }
        if (age < Constants.KID_AGE) {
            return ChildrenType.Kid;
        }
        if (age <= Constants.TEEN_AGE) {
            return ChildrenType.Teen;
        }
        return ChildrenType.YoungAdult;
    }

    /**
     * Creeaza o instanta noua pentru un obiect corespunzator categoriei din care
     * copilul curent face parte. Acest procedeu reprezinta un Factory Design Pattern
     *
     * @param childrenType Categoria din care face parte copilul curent
     * @param childrenCategory Datele copilului ce trebuie pus in obiectul din categoria
     * corespunzatoare
     * @return returneaza o noua instanta a obiectului necesar pentru categoria data sau
     * IllegalArgumentException daca aceasta categorie nu este recunoscuta
     */
    public ChildrenCategory createChildren(final ChildrenType childrenType,
                                                  final ChildrenCategory childrenCategory) {
        switch (childrenType) {
            case Baby -> {
                return new Baby(childrenCategory);
            }
            case Kid -> {
                return new Kid(childrenCategory);
            }
            case Teen -> {
                return new Teen(childrenCategory);
            }
            case YoungAdult -> {
                return new YoungAdult(childrenCategory);
            }
            default -> {
                throw new IllegalArgumentException("The Children Type" + childrenType
                        + "is not recognized");
            }
        }
    }
}
