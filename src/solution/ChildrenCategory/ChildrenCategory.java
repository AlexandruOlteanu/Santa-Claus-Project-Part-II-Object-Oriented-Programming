package solution.ChildrenCategory;

import common.Constants;
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
    protected Double niceScoreBonus;
    protected String elf;
    protected Double assignedBudget;
    protected List<SantaGift> receivedGifts = new ArrayList<>();

    private ChildrenCategory(final ChildrenCategoryBuilder builder) {
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.city = builder.city;
        this.age = builder.age;
        this.giftsPreferences = builder.giftsPreferences;
        this.averageScore = builder.averageScore;
        this.niceScoreHistory = builder.niceScoreHistory;
        this.niceScoreBonus = builder.niceScoreBonus;
        this.elf = builder.elf;
        this.assignedBudget = builder.assignedBudget;
        this.receivedGifts = builder.receivedGifts;
    }

    public ChildrenCategory() {

    }


    public static final class ChildrenCategoryBuilder {

        // mandatory
        private Integer id;
        private String lastName;
        private String firstName;
        private String city;
        private Integer age;

        // optional
        private List<String> giftsPreferences;
        private Double averageScore;
        private List<Double> niceScoreHistory;
        private Double niceScoreBonus;
        private String elf;
        private Double assignedBudget;
        private List<SantaGift> receivedGifts = new ArrayList<>();

        public ChildrenCategoryBuilder(final Integer id, final String lastName,
                                       final String firstName, final String city,
                                       final Integer age) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.city = city;
            this.age = age;
        }

        /**
         * Se modifica valoarea campului giftsPreferences
         * @param newGiftsPreferences Noua lista de preferinte ce va fi asignata corespunzator
         * @return
         */
        public ChildrenCategoryBuilder giftsPreferences(final List<String> newGiftsPreferences) {
            this.giftsPreferences = newGiftsPreferences;
            return this;
        }

        /**
         * Se modifica valoarea campului averageScore
         * @param newAverageScore Noul averageScore ce va fi asignat corespunzator
         * @return
         */
        public ChildrenCategoryBuilder averageScore(final Double newAverageScore) {
            this.averageScore = newAverageScore;
            return this;
        }

        /**
         * Se modifica valoarea istoricului de niceScore-uri
         * @param newNiceScoreHistory Noua lista ce va fi asignata corespunzator
         * @return
         */
        public ChildrenCategoryBuilder niceScoreHistory(final List<Double> newNiceScoreHistory) {
            this.niceScoreHistory = newNiceScoreHistory;
            return this;
        }

        /**
         * Se modifica valoarea campului scorului bonus
         * @param newNiceScoreBonus Noul scor bonus ce va fi asignat corespunzator
         * @return
         */
        public ChildrenCategoryBuilder niceScoreBonus(final Double newNiceScoreBonus) {
            this.niceScoreBonus = newNiceScoreBonus;
            return this;
        }

        /**
         * Se modifica valoarea campului elf
         * @param newElf Noul elf ce va fi asignat corespunzator
         * @return
         */
        public ChildrenCategoryBuilder elf(final String newElf) {
            this.elf = newElf;
            return this;
        }

        /**
         * Se modifica valoarea campului buget
         * @param newAssignedBudget Noul buget ce va fi asignat corespunzator
         * @return
         */
        public ChildrenCategoryBuilder assignedBudget(final Double newAssignedBudget) {
            this.assignedBudget = newAssignedBudget;
            return this;
        }

        /**
         * Se modifica campul tuturor cadourilor primite
         * @param newReceivedGifts Noua lista de cadouri primite ce va fi asignata corespunzator
         * @return
         */
        public ChildrenCategoryBuilder receivedGifts(final List<SantaGift> newReceivedGifts) {
            this.receivedGifts = newReceivedGifts;
            return this;
        }

        /**
         * Functie ce va crea un nou copil cu informatiile stocate in Builder
         * @return
         */
        public ChildrenCategory build() {
            return new ChildrenCategory(this) {
                @Override
                public void calculateAverageScore() { }
            };
        }


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
     * @return Intoarce valoarea scorului bonus
     */
    public final Double niceScoreBonus() {
        return niceScoreBonus;
    }

    /**
     * @return Intoarce valoarea elfului
     */
    public final String elf() {
        return this.elf;
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
     * Elful copilului curent este modificat
     * @param newElf elful ce il va inlocui pe cel curent
     */
    public void updateElf(final String newElf) {
        this.elf = newElf;
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
     * subclasele corespunzatoare, fiind astfel un Strategy Design Pattern
     */
    public abstract void calculateAverageScore();

    /**
     * Se calculeaza bugetul valabil pentru copilul curent
     * Apoi, in cazul in care copilul are un elf black sau pink se aplica regula de schimbare
     * a valorii bugetului
     * @param budgetUnit Unitatea bugetara dupa care se realizeaza calculele
     */
    public void calculateAssignedBudget(final Double budgetUnit) {
        assignedBudget = averageScore * budgetUnit;
        if (elf.equals("black")) {
            assignedBudget -= assignedBudget * Constants.THIRTY / Constants.ONE_HUNDRED;
        }
        if (elf.equals("pink")) {
            assignedBudget += assignedBudget * Constants.THIRTY / Constants.ONE_HUNDRED;
        }
    }

}
