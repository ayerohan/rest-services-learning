package com.in28minutes.rest.webservices.restful_web_services.versioning;

public class Name {
    private String FirstName;
    private String SecondName;

    public Name(String firstName, String secondName) {
        FirstName = firstName;
        SecondName = secondName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "FirstName='" + FirstName + '\'' +
                ", SecondName='" + SecondName + '\'' +
                '}';
    }
}
