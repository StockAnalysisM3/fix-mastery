package com.fixmastery.mic.model;

import com.fixmastery.mic.dao.CountryRepository;

import javax.persistence.Id;
import java.util.Collection;

public class Country {
    @Id
    private String Id;
    private String name;
    private String countryCode;

    public CountryRepository countryRepo;

    public Country() {}

    public Country(String name, String code) {
        this.name = name;
        this.countryCode = code;
    }


    public String getId() { return this.Id; }

    public void setId(String id) { this.Id = id; }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public String getCountryCode() { return this.countryCode; }

    public void setCountryCode(String code) { this.countryCode = code; }



    @Override
    public String toString() {
        return "Country{" +
                "id='" + Id + '\'' +
                ",name='" + name + '\'' +
                ",countryCode='" + countryCode +
                '}';
    }
}
