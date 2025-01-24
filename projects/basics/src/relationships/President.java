package relationships;

public class President {

    private String name;
    private Country country;

    public President(String name) {
        this.name = name;
        // note: null country
    }

    public President(String name, Country country) {
        this.name = name;
        this.country = country;

        // notify country
        country.setPresident(this);

    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        // return "President(" + this.name + ", " + this.country.toString() + ")";
        return "President(" + this.name + ")";
    }
}
