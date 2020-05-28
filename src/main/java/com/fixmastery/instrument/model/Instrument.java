package com.fixmastery.instrument.model;

import javax.persistence.Id;

public class Instrument {
    @Id
    private String Id;


    //to be replace by Hema's entity?
    private String mic;

    private String name;

    public Instrument(String id, String name, String mic){
        this.Id = id;
        this.name = name;
        this.mic = mic;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }


    public String getMic() {
        return mic;
    }

    public void setMic(String mic) {
        this.mic = mic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id='" + Id + '\'' +
                ",name='" + name + '\'' +
                ",mic='" + mic +
                '}';
    }
}
