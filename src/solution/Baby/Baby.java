package solution.Baby;

import common.Constants;
import solution.ChildrenCategory.ChildrenCategory;

public final class Baby extends ChildrenCategory {

    public Baby(final ChildrenCategory childrenCategory) {
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
     * Se calculeaza average score-ul pentru un copil din categoria de varsta Baby,
     * valoarea asignata fiind egala cu 10. In continuare se adauga conform formulei
     * scorul bonus al acestuia. Daca in final scorul depaseste 10, este trunchiat la 10.
     * De asemenea, implementarea acestei metodeface parte din caracteristica
     * Strategy Pattern-ului.
     */
    @Override
    public void calculateAverageScore() {
        this.averageScore = Constants.BABY_AVERAGE_SCORE;
        this.averageScore += this.averageScore * niceScoreBonus / Constants.ONE_HUNDRED;
        if (Double.compare(this.averageScore, Constants.MAX_NICE_SCORE) > 0) {
            this.averageScore = Constants.MAX_NICE_SCORE;
        }
    }

}
