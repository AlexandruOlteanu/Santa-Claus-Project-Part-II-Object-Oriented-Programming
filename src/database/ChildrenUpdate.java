package database;

import java.util.List;

public final class ChildrenUpdate {

    private Integer id;
    private Double niceScore;
    private List<String> giftsPreferences;
    private String elf;

    public ChildrenUpdate() {
        this.id = null;
        this.niceScore = null;
        this.giftsPreferences = null;
        this.elf = null;
    }

    public ChildrenUpdate(final Integer id, final Double niceScore,
                          final List<String> giftsPreferences, final String elf) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.elf = elf;
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

    public String getElf() {
        return elf;
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

    public void setElf(final String elf) {
        this.elf = elf;
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
