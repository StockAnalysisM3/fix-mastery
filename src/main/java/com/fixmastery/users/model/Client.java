package com.fixmastery.users.model;

import javax.persistence.*;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    private String id;
    private String userName;
    private String displayName;
    private String password;
    private String roles;
    private boolean active = false;

    public Client() {
    }

    public Client(String userName, String displayName, String password, String roles) {
        this.userName = this.id = userName;
        this.displayName = displayName;
        this.password = password;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean toggleActive() {
        this.active = !this.active;
        return this.active;
    }
}

