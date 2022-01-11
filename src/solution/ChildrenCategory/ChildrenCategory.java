package solution.ChildrenCategory;

import database.Children;
import database.SantaGift;

import java.util.ArrayList;
import java.util.List;

public abstract class ChildrenCategory {

    protected Integer id;
    protected String lastName;
    protected String firstName;
    protected String city;
    protected Integer age;
    protected List<String> giftsPreferences;
    protected Double averageScore;
    protected List<Double> niceScoreHistory;
    protected Double assignedBudget;
    protected List<SantaGift> receivedGifts = new ArrayList<>();

    private static ChildrenCategory instance = null;

    /**
     * Metoda necesara pentru a face clasa ChildrenCategory de
     * tip Singleton
     *
     * @return returneaza instanta unica creata de tip ChildrenCategory
     */
    public static ChildrenCategory getInstance() {
        if (instance == null) {
            instance = new ChildrenCategory() {
                @Override
                public void calculateAverageScore() {

                }
            };
        }
        return instance;
    }

    public ChildrenCategory() {

    }

    /**
     * Initializeaza obiectele din cadrul clasei ChildrenCategory primind ca parametru
     * datele unui copil
     *
     * @param children Copilul ale carui date sunt asignate obiectelor corespunzatoare
     */
    public void setChildrenCategory(final Children children) {
        this.id = children.getId();
        this.lastName = children.getLastName();
        this.firstName = children.getFirstName();
        this.city = children.getCity();
        this.age = children.getAge();
        this.giftsPreferences = children.getGiftsPreferences();
        this.niceScoreHistory = new ArrayList<>();
        this.niceScoreHistory.add(children.getNiceScore());
        this.receivedGifts = new ArrayList<>();
    }

    public final Integer getId() {
        return id;
    }

    public final String getLastName() {
        return lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getCity() {
        return city;
    }

    public final Integer getAge() {
        return age;
    }

    public final List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public final Double getAverageScore() {
        return averageScore;
    }

    public final List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public final Double getAssignedBudget() {
        return assignedBudget;
    }

    public final List<SantaGift> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * La lista de niceScore-uri a copilului curent se adauga noua valoare primita
     * in cazul in care aceasta este diferita de null
     *
     * @param niceScore
     */
    public void updateNiceScoreHistory(final Double niceScore) {
        if (niceScore != null) {
            niceScoreHistory.add(niceScore);
        }
    }

    /**
     * Se adauga noi categorii de cadouri preferate la cele deja existente.
     * Noile categorii de preferinta au prioritate fata de cele deja existente,
     * fiind puse la inceput. De asemenea, daca sunt dubluri in urma acestor adaugari
     * sunt excluse cele care au prioritatea mai mica
     *
     * @param giftsPreferencesUpdate Lista de categorii de cadouri ce trebuie adaugata
     */
    public void updateGiftsPreferences(final List<String> giftsPreferencesUpdate) {
        List<String> newGiftsPreferences = new ArrayList<>();
        for (String newGift : giftsPreferencesUpdate) {
            boolean ok = true;
            for (String gift : newGiftsPreferences) {
                if (gift.equals(newGift)) {
                    ok = false;
                }
            }
            if (ok) {
                newGiftsPreferences.add(newGift);
            }
        }

        for (String newGift : this.giftsPreferences) {
            boolean ok = true;
            for (String gift : newGiftsPreferences) {
                if (gift.equals(newGift)) {
                    ok = false;
                }
            }
            if (ok) {
                newGiftsPreferences.add(newGift);
            }
        }
        this.giftsPreferences = newGiftsPreferences;
    }

    /**
     * In urma fiecarei runde varsta copilului se updateaza, aceasta crescand cu o unitate
     */
    public void updateAge() {
        ++age;
    }

    /**
     * Aceasta metoda are rolul de a calcula average score-ul in functie de categoria
     * de varsta a copilului. Din acest motiv clasa este abstracta si va fi implementata in
     * subclasele corespunzatoare
     */
    public abstract void calculateAverageScore();

    /**
     * Se calculeaza bugetul valabil pentru copilul curent
     * @param budgetUnit Unitatea bugetara dupa care se realizeaza calculele
     */
    public void calculateAssignedBudget(final Double budgetUnit) {
        assignedBudget = averageScore * budgetUnit;
    }

}
