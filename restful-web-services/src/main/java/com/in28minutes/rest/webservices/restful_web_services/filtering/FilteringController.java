package com.in28minutes.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    public Somebean somebean;

    // 1. Static filtering - Static(permanent) fields (permanently set by the Somebean class - field1 and field3)
    @GetMapping("/filtering")
    public Somebean filtering() {
        return new Somebean("value1", "value2" , "value3");
    }

    @GetMapping("/filtering-list")
    public List<Somebean> fliteringlist(){
        return Arrays.asList(new Somebean("value1", "value2" , "value3") ,
                new Somebean("value3", "value4" , "value5"));
    }

    // 2. Dynamic filtering - Custom Fields and return types for different URLs - Using Views(Json views)
    @GetMapping("/filtering-with-view")
    @JsonView(View.View1.class)
    public Somebean filteringWithView() { // return field1 and field2
        return new Somebean("value1", "value2" , "value3");
    }

    @GetMapping("/filtering-list-with-view")
    @JsonView(View.View2.class)
    public List<Somebean> fliteringlistWithView(){ // return field1 and field3
        return Arrays.asList(new Somebean("value1", "value2" , "value3") ,
                new Somebean("value3", "value4" , "value5"));
    }


}
