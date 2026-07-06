package com.in28minutes.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonSbiController {

    // TO USE THIS spring boot versioning we need to make changes in application.properties
    // Spring boot provides us with sematic versioning like '1.0.12' or '3.7.1' instead of '1' or '2'

//    @GetMapping(value = "/{version}/personsbi" , version =  "1.0.0")
//    public PersonV1 getFirstVersionOfPerson(){
//        return new PersonV1("Pranav Rohan");
//    }
//
//    @GetMapping(value = "/{version}/personsbi" , version =  "2.0.2")
//    public PersonV2 getSecondVersionOfPerson(){
//        return new PersonV2(new Name("Pranav" ,"Rohan"));
//    }

    @GetMapping(path = "/personsbi" , params = "version=1.0.0")
    public PersonV1 getFirstVersionOfPersonRequestParameter(){
        return new PersonV1("Pranav Rohan");
    }

    @GetMapping(path = "/personsbi" , params = "version=2.0.0")
    public PersonV2 getSecondVersionOfPersonRequestParameter(){
        return new PersonV2(new Name("Ritika" , "Malla"));
    }


}
