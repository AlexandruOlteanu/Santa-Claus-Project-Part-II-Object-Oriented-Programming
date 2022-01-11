package database;

import java.util.List;

public final class ChildrenUpdate {

    private Integer id;
    private Double niceScore;
    private List<String> giftsPreferences;

    public ChildrenUpdate() {
        this.id = null;
        this.niceScore = null;
        this.giftsPreferences = null;
    }

    public ChildrenUpdate(final Integer id, final Double niceScore,
                          final List<String> giftsPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }

    public Integer getId() {
        return id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public void setGiftsPreferences(final List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    @Override
    public String toString() {
        return "ChildrenUpdate{"
                + "id=" + id
                + ", niceScore=" + niceScore
                + ", giftsPreferences=" + giftsPreferences
                + '}';
    }
}
