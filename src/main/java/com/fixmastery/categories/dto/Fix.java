package com.fixmastery.categories.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fix {
    @Id
    @GeneratedValue
    private int Id;

    private int tag;
    private String name;
    private String value;
    private String descr;

    public Fix() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Fix{" +
                "Id=" + Id +
                ", tag=" + tag +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }
}
