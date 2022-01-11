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
    }

    /**
     * Se calculeaza average score-ul pentru un copil din categoria de varsta Baby,
     * valoarea asignata fiind egala cu 10
     */
    @Override
    public void calculateAverageScore() {
        this.averageScore = Constants.BABY_AVERAGE_SCORE;
    }

}
