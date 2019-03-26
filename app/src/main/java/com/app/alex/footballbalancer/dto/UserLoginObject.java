package com.app.alex.footballbalancer.dto;


import com.google.inject.Singleton;

import java.io.Serializable;

/**
 * Created by alex on 9/25/15.
 */

public class UserLoginObject implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String taxNumber;
    private String passportNumber;

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param taxNumber
     * @param passportNumber
     */
    public UserLoginObject(String id, String firstName, String lastName, String taxNumber, String passportNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.taxNumber = taxNumber;
        this.passportNumber = passportNumber;
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

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "UserLoginObject{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        UserLoginObject that = (UserLoginObject) object;
        return java.util.Objects.equals(id, that.id) &&
                java.util.Objects.equals(firstName, that.firstName) &&
                java.util.Objects.equals(lastName, that.lastName) &&
                java.util.Objects.equals(taxNumber, that.taxNumber);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id, firstName, lastName, taxNumber);
    }
}
