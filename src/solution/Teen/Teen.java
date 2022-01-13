package solution.Teen;
import common.Constants;
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
        this.niceScoreBonus = childrenCategory.niceScoreBonus();
        this.elf = childrenCategory.elf();
    }

    /**
     * Se calculeaza average score-ul pentru un copil din categoria de varsta Teen,
     * valoarea asignata fiind egala cu media ponderata a average score-urilor
     * pe care le-a avut acesta vreodata. In continuare se adauga conform formulei
     * scorul bonus al acestuia. Daca in final scorul depaseste 10, este trunchiat la 10.
     * De asemenea, implementarea acestei metodeface parte din caracteristica
     * Strategy Pattern-ului.
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
        this.averageScore += this.averageScore * niceScoreBonus / Constants.ONE_HUNDRED;
        if (Double.compare(this.averageScore, Constants.MAX_NICE_SCORE) > 0) {
            this.averageScore = Constants.MAX_NICE_SCORE;
        }
    }

}
