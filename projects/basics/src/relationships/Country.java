package relationships;

public class Country {
    private String name;
    private President president;

    public Country(String name) {
        this.name = name;
    }

    public Country(String name, President president) {
        this.name = name;
        this.president = president;

        // notify president
        president.setCountry(this);
    }

    public President getPresident() {
        return president;
    }

    public void setPresident(President president) {
        this.president = president;
    }

    @Override
    public String toString() {
        return "Country(" + name + ", President(" + president.toString() + "))";
    }

}
