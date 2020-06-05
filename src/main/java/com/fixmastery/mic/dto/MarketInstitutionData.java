package com.fixmastery.mic.dto;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "MIC")
public class MarketInstitutionData {
//    @Id
//    @GeneratedValue
//    private int Id;
    @Id
    @Column(name="mic")
    @NotNull
    private String id;

    @Column(name="operatingmic")
    @NotNull
    private String operatingMic;

    @Column(name="country")
    @NotNull
    private String country;

    @Column(name="isocountrycode")
    @NotNull
    private String countryCode;

    @Column(name="acronym")
    private String acronym;

    @Column(name="city")
    private String city;

    @Column(name="website")
    private String website;

    @Column(name="nameinstitutiondescription")
    private String description;

    public MarketInstitutionData() {}

    //public String getId() { return Integer.toString(Id); }

    public String getOperatingMic() { return operatingMic; }

   // public void setId(int id) { Id = id; }

    public String getId() { return id; }

    public void setId(String mic) { this.id = id; }

    public String getCountry() { return country; }

//    public String addCountryToCountriesTable(Country country) {
//        Country country = new Country()
//    }

    public void setCountry(String country) {this.country = country; }

    public String getCountryCode() { return countryCode; }

    public void setCountryCode(String countryCode) {this.countryCode = countryCode; }

    public String getAcronym() { return acronym; }

    public void setAcronym(String acronym) { this.acronym = acronym; }

    public String getCity() { return this.city; }

    public void setCity(String city) { this.city = city; }

    public String getWebsite() { return this.website; }

    public void setWebsite(String website) { this.website = website; }

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

//    @Override
//    public String toString() {
//        return "MarketInstitution{" +
//                "Id=" + Id +
//                ", parentMic=" + parentMic +
//                ", operatingMic='" + operatingMic + '\'' +
//                ", country='" + country + '\'' +
//                ", countryCode='" + countryCode + '\'' +
//                ", acronym='" + acronym + '\'' +
//                ", city='" + city + '\'' +
//                ", website='" + website + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
}
