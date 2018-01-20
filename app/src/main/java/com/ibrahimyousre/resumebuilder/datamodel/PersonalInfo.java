package com.ibrahimyousre.resumebuilder.datamodel;

import java.io.Serializable;

/**
 * Created by ibrahim on 1/18/18.
 */

public class PersonalInfo implements Serializable {
    private String name;
    private String jobTitle;
    private String addressLine1;
    private String addressLine2;
    private String phone;
    private String email;

    public PersonalInfo() {
        this(
                "Jone Doe",
                "Android Developer",
                "123 Your Street",
                "Your City, ST 12345",
                "(123) 456-7890",
                "no_reply@example.com");
    }

    public PersonalInfo(String name, String jobTitle, String addressLine1, String addressLine2, String phone, String email) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
