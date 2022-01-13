package database.Input;

import database.AnnualChanges;
import database.InitialData;

import java.util.List;

public final class Input {

    private Integer numberOfYears;

    private Integer santaBudget;

    private InitialData initialData;

    private List<AnnualChanges> annualChanges;

    private static Input instance = null;

    /**
     * Metoda necesara pentru a face clasa Input de
     * tip Singleton
     *
     * @return returneaza instanta unica creata de tip Input
     */
    public static Input getInstance() {
        if (instance == null) {
            instance = new Input();
        }
        return instance;
    }

    private Input() {

    }

    /**
     * Initializeaza obiectele din cadrul clasei Input
     *
     * @param numberOfYearsGiven Numarul de ani pe care se desfasoara procesul
     * @param santaBudgetGiven Bugetul initial al Mosului
     * @param initialDataGiven Datele initiale (copiii si cadourile) prezenta in input
     * @param annualChangesGiven Schimbarile Anuale ce au loc
     */
    public void init(final Integer numberOfYearsGiven, final Integer santaBudgetGiven,
                 final InitialData initialDataGiven, final List<AnnualChanges> annualChangesGiven) {
        numberOfYears = numberOfYearsGiven;
        santaBudget = santaBudgetGiven;
        initialData = initialDataGiven;
        annualChanges = annualChangesGiven;
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public Integer getSantaBudget() {
        return santaBudget;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public List<AnnualChanges> getAnnualChanges() {
        return annualChanges;
    }

    public void setNumberOfYears(final Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setSantaBudget(final Integer santaBudget) {
        this.santaBudget = santaBudget;
    }

    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    public void setAnnualChanges(final List<AnnualChanges> annualChanges) {
        this.annualChanges = annualChanges;
    }

    @Override
    public String toString() {
        return "Input{"
                + "numberOfYears=" + numberOfYears
                + ", santaBudget=" + santaBudget
                + ", initialData=" + initialData
                + ", annualChanges=" + annualChanges
                + '}';
    }
}
