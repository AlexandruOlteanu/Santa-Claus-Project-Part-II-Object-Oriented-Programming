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
        this.niceScoreBonus = childrenCategory.niceScoreBonus();
        this.elf = childrenCategory.elf();
    }

    /**
     * Se calculeaza average score-ul pentru un copil din categoria de varsta Kid.
     * Aceasta metoda nu este apelata deoarece copiii de acest tip nu mai primesc cadouri.
     * De asemenea, implementarea acestei metode face parte din caracteristica
     * Strategy Pattern-ului.
     */
    @Override
    public void calculateAverageScore() {

    }

}
