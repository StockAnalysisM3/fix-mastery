package com.fixmastery.mic.model;

import javax.persistence.Id;


public class MarketInstitution {
    @Id
    private String Id;
    private String countryId;
    //private String name;//id
    private String acronym;
    private String city;
    private String website;
    private String description;

    public MarketInstitution() {

    }

    public MarketInstitution(
            String id,
            String cid,
            //String name,
            String acronym,
            String city,
            String website,
            String description) {
        this.Id = id;
        this.countryId = cid;
        //this.name = name;
        this.acronym = acronym;
        this.city = city;
        this.website = website;
        this.description = description;
    }


    public String getId() { return this.Id; }

    public void setId(String id) { this.Id = id; }

    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String cid) { this.countryId = cid; }

    //public String getName() { return this.name; }

    //public void setName(String name) { this.name = name; }

    public String getAcronym() { return this.acronym; }

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
//                "id='" + Id + '\'' +
//                ",name='" + name + '\'' +
//                ",countryId='" + countryId + '\'' +
//                ",acronym='" + acronym + '\'' +
//                ",city='" + city + '\'' +
//                ",website='" + website + '\'' +
//                ",description='" + description +
//                '}';
//    }
}
