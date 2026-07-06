package com.in28minutes.rest.webservices.restful_web_services.versioning;

public class PersonV2 {

    private Name name;

    public PersonV2(Name name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name.toString();
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
