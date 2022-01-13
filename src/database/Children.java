package database;

import java.util.List;

public final class Children {

    private Integer id;
    private String lastName;
    private String firstName;
    private Integer age;
    private String city;
    private Double niceScore;
    private List<String> giftsPreferences;
    private Double niceScoreBonus;
    private String elf;

    public Children() {
        this.id = null;
        this.lastName = null;
        this.firstName = null;
        this.age = null;
        this.city = null;
        this.niceScore = null;
        this.giftsPreferences = null;
        this.niceScoreBonus = null;
        this.elf = null;
    }

    public Children(final Integer id, final String lastName, final String firstName,
                    final Integer age, final String city, final Double niceScore,
                    final List<String> giftsPreferences, final Double niceScoreBonus,
                    final String elf) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.niceScoreBonus = niceScoreBonus;
        this.elf = elf;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public String getElf() {
        return elf;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public void setGiftsPreferences(final List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public void setElf(final String elf) {
        this.elf = elf;
    }

    @Override
    public String toString() {
        return "Children{"
                + "id=" + id
                + ", lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\''
                + ", age=" + age
                + ", city='" + city + '\''
                + ", niceScore=" + niceScore
                + ", giftsPreferences=" + giftsPreferences
                + '}';
    }
}
