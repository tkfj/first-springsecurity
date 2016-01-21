package com.example.security.domain.model;

import java.io.Serializable;

public class Account implements Serializable {

    private static final long serialVersionUID = -5785674182270126494L;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String companyId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Account [username=" + username + ", password=" + password + ", firstName="
                + firstName + ", lastName=" + lastName + ", companyId" + companyId + "]";
    }
}
