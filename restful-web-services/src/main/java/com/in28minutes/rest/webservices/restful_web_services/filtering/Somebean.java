package com.in28minutes.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

// @JsonIgnoreProperties({"field2" , "field1"})
public class Somebean {

    @JsonView({View.View1.class , View.View2.class})
    private String field1;

    // JsonIgnore - static filtering
    @JsonView(View.View1.class) // - dynamic filtering using views
    private String field2;

    @JsonView(View.View2.class)
    private String field3;

    public Somebean(String field1, String field2, String field3) {
        super();
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getValue1() {
        return field1;
    }

    public void setValue1(String value1) {
        this.field1 = field1;
    }

    public String getValue2() {
        return field2;
    }

    public void setValue2(String value2) {
        this.field2 = field2;
    }

    public String getValue3() {
        return field3;
    }

    public void setValue3(String value3) {
        this.field3 = field3;
    }

    @Override
    public String toString() {
        return "Somebean{" +
                "value1='" + field1 + '\'' +
                ", value2='" + field2 + '\'' +
                ", value3='" + field3 + '\'' +
                '}';
    }
}
