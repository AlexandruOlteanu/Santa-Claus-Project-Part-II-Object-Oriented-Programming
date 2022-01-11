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

    public Children() {
        this.id = null;
        this.lastName = null;
        this.firstName = null;
        this.age = null;
        this.city = null;
        this.niceScore = null;
        this.giftsPreferences = null;
    }

    public Children(final Integer id, final String lastName, final String firstName,
                    final Integer age, final String city, final Double niceScore,
                    final List<String> giftsPreferences) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
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
