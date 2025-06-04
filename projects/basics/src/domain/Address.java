package domain;

import java.util.ArrayList;
import java.util.List;



public class Address {

    private String city;
    private Country country;

    public Address(String city, Country country) {

        this.city = city;
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public static List<Address> getSampleAddresses() {

        Country UK = new Country("GB", "United Kingdom");
        Country US = new Country("US", "United States");
        Country FR = new Country("FR", "France");
        Country JP = new Country("JP", "Japan");

        return List.of(new Address("London", UK),
                new Address("Washington", US),
                new Address("New York", US),
                new Address("Paris", FR),
                new Address("Tokyo", JP));

    }

    @Override
    public String toString() {
        return "Address(" + city + ", " + country + ")";
    }
}
