package solution.City;

public final class City {

    private String name;
    private Double niceScoreCity;
    private Integer numberChildrens;

    public City(final String name) {
        this.name = name;
        this.niceScoreCity = 0.0;
        this.numberChildrens = 0;
    }

    /**
     * Un nou scor se adauga la orasul curent. De asemenea, numarul copiilor din
     * acest oras creste cu o unitate
     * @param childrenAverageScore  scorul ce trebuie adaugat
     */
    public void add(final Double childrenAverageScore) {
        this.niceScoreCity += childrenAverageScore;
        ++numberChildrens;
    }

    /**
     * Se calculeaza media aritmetica a scorurilor pentru copiii din orasul curent
     * Daca niciun copil nu este prezent in acest oras media aritmetica ramane 0,
     * in caz contrar este modificata
     */
    public void solve() {
        if (!(numberChildrens.equals(0))) {
            niceScoreCity /= numberChildrens;
        }
    }

    public String getName() {
        return name;
    }

    public Double getNiceScoreCity() {
        return niceScoreCity;
    }
}
