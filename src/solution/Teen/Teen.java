package solution.Teen;
import solution.ChildrenCategory.ChildrenCategory;

public final class Teen extends ChildrenCategory {
    public Teen(final ChildrenCategory childrenCategory) {
        this.id = childrenCategory.getId();
        this.lastName = childrenCategory.getLastName();
        this.firstName = childrenCategory.getFirstName();
        this.city = childrenCategory.getCity();
        this.age = childrenCategory.getAge();
        this.giftsPreferences = childrenCategory.getGiftsPreferences();
        this.niceScoreHistory = childrenCategory.getNiceScoreHistory();
    }

    /**
     * Se calculeaza average score-ul pentru un copil din categoria de varsta Teen,
     * valoarea asignata fiind egala cu media ponderata a average score-urilor
     * pe care le-a avut acesta vreodata
     */
    @Override
    public void calculateAverageScore() {
        averageScore = 0.0;
        double sum = 0.0;
        for (int i = 0; i < niceScoreHistory.size(); ++i) {
            averageScore += (i + 1) * niceScoreHistory.get(i);
            sum += i + 1;
        }
        averageScore /= sum;
    }

}
