package solution.Kid;

import solution.ChildrenCategory.ChildrenCategory;

public final class Kid extends ChildrenCategory {


    public Kid(final ChildrenCategory childrenCategory) {
        this.id = childrenCategory.getId();
        this.lastName = childrenCategory.getLastName();
        this.firstName = childrenCategory.getFirstName();
        this.city = childrenCategory.getCity();
        this.age = childrenCategory.getAge();
        this.giftsPreferences = childrenCategory.getGiftsPreferences();
        this.niceScoreHistory = childrenCategory.getNiceScoreHistory();
    }

    /**
     * Se calculeaza average score-ul pentru un copil din categoria de varsta Kid,
     * valoarea asignata fiind egala cu media aritmetica a average score-urilor
     * pe care le-a avut acesta vreodata
     */
    @Override
    public void calculateAverageScore() {
        this.averageScore = 0.0;
        for (Double score : niceScoreHistory) {
            this.averageScore += score;
        }
        this.averageScore /= niceScoreHistory.size();
    }
}
