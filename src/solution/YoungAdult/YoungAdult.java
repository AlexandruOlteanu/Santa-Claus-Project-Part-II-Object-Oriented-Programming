package solution.YoungAdult;

import solution.ChildrenCategory.ChildrenCategory;

public class YoungAdult extends ChildrenCategory {

    public YoungAdult(final ChildrenCategory childrenCategory) {
        this.id = childrenCategory.getId();
        this.lastName = childrenCategory.getLastName();
        this.firstName = childrenCategory.getFirstName();
        this.city = childrenCategory.getCity();
        this.age = childrenCategory.getAge();
        this.giftsPreferences = childrenCategory.getGiftsPreferences();
        this.niceScoreHistory = childrenCategory.getNiceScoreHistory();
    }

    /**
     * Se calculeaza average score-ul pentru un copil din categoria de varsta Kid.
     * Aceasta metoda nu este apelata deoarece copiii de acest tip nu mai primesc cadouri
     */
    @Override
    public void calculateAverageScore() {

    }

}
