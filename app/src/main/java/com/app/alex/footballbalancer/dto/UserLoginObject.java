package com.app.alex.footballbalancer.dto;


import java.io.Serializable;

/**
 * Created by alex on 9/25/15.
 */
public class UserLoginObject {
    private String id;
    private String firstName;
    private String lastName;

    public UserLoginObject(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
