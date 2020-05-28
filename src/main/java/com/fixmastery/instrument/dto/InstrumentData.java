package com.fixmastery.instrument.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "Instrument")
public class InstrumentData {
    @Id
    @GeneratedValue
    private int Id;

    @Column(name ="instrument")
    @NotNull
    private String instrument;

    @Column(name ="ric")
    private String ric;

    @Column(name ="isin")
    private String isin;

    @Column(name ="sedol")
    private String sedol;

    @Column(name ="cusip")
    private String cusip;

    @Column(name ="bbid")
    private String bbid;

    @Column(name ="mic")
    private String mic;

    @Column(name ="name")
    private String name;

    public InstrumentData(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getRic() {
        return ric;
    }

    public void setRic(String ric) {
        this.ric = ric;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getSedol() {
        return sedol;
    }

    public void setSedol(String sedol) {
        this.sedol = sedol;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getBbid() {
        return bbid;
    }

    public void setBbid(String bbid) {
        this.bbid = bbid;
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
                "Id=" + Id +
                ", instrument=" + instrument +
                ", ric='" + ric + '\'' +
                ", isin='" + isin + '\'' +
                ", sedol='" + sedol + '\'' +
                ", cusip='" + cusip + '\'' +
                ", bbid='" + bbid + '\'' +
                ", mic='" + mic + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
