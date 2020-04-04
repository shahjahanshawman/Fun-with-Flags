package com.example.assignment;

import java.util.ArrayList;

public class Countries {

    private String countries;

    public Countries() {
    }
    public Countries(String countries) {
        this.countries = countries;

    }

    public String getCountry() {

        return countries;
    }

    public void setCountry(String countries) {

        this.countries = countries;
    }

    public static ArrayList<Countries> getCountries() {
        ArrayList<Countries> countries = new ArrayList<>();
        countries.add(new Countries("China"));
        countries.add(new Countries("Bangladesh"));
        countries.add(new Countries("Indonesia"));
        countries.add(new Countries("India"));
        countries.add(new Countries("Malaysia"));
        countries.add(new Countries("Korea"));
        countries.add(new Countries("Japan"));
        countries.add(new Countries("Philippines"));
        return countries;
    }
}
