package solution.SortChildrens;

public final class SortChildrenFactory {

    private static SortChildrenFactory instance = null;

    private SortChildrenFactory() {

    }

    /**
     * Metoda necesara pentru a face clasa SortChildrenFactory de
     * tip Singleton
     *
     * @return returneaza instanta unica creata de tip SortChildrenFactory
     */
    public static SortChildrenFactory getInstance() {
        if (instance == null) {
            instance = new SortChildrenFactory();
        }
        return instance;
    }

    /**
     * Creeaza o instanta noua pentru un obiect corespunzator din care
     * tipul de sortare face parte. Acest procedeu reprezinta un Factory
     * Design Pattern
     *
     * @param type Tipul in functie de care se creeaza clasa corespunzatoare
     *             metodei de sortare necesara
     * @return returneaza o noua instanta a obiectului necesar pentru sortare sau
     *         IllegalArgumentException daca aceast tip de sortare nu este recunoscut
     */
    public SortChildren createSortMethod(final String type) {
        switch (type) {
            case "id" -> {
                return new IdSort();
            }
            case "niceScore" -> {
                return new NiceScoreSort();
            }
            case "niceScoreCity" -> {
                return new NiceScoreCitySort();
            }
            default -> {
                throw new IllegalArgumentException("The Sorting Type " + type
                        + "is not recognized");
            }
        }
    }
}
