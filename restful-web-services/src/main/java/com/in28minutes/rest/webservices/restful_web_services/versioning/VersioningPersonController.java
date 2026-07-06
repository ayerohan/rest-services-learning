package com.in28minutes.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    /* Types of versioning
    1. URI versioning - just by using Uri(uniform resource identifier).
                        Example: /api/v1/users and /api/v2/users

    2. Request Parameter versioning - using a params for version identification parameter
                                      and for mapping annotations.
                                      Example: /api/users?version=1

    3. Custom Header versioning - using a unique custom HTTP header to pass the version
                                  number while keeping the URI clean.
                                  Example: X-API-VERSION: 2

    4. Media Type versioning - using the 'Accept' or 'Content-Type' header with a custom
                               mime type to request a specific data representation.
                               Example: Accept: application/vnd.company.app-v1+json

     Spring Boot actually provides us with in built versioning - VersioningPersonSbiController
    */

    // 1. URI versioning ---Started---
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Pranav Rohan");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Pranav" ,"Rohan"));
    }
    // URI versioning ---Ended---

    // 2. Request Parameter versioning ---Started--
    // url is http://localhost:8080/person?version=1
    @GetMapping(path = "/person" , params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter(){
        return new PersonV1("Pranav Rohan");
    }

    @GetMapping(path = "/person" , params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter(){
        return new PersonV2(new Name("Ritika" , "Malla"));
    }
    // Request Parameter versioning ---Ended--

    // 3. Custom headers versioning ---Started--
    @GetMapping(path = "/person/header" , headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader(){
        return new PersonV1("Pranav Rohan");
    }

    @GetMapping(path = "/person/header" , headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader(){
        return new PersonV2(new Name("Ritika" , "Malla"));
    }
    // Custom headers versioning ---Ended--

    // 4. Media type versioning ---Started--
    // accept header

    @GetMapping(path = "/person/accept" , produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader(){
        return new PersonV1("Pranav Rohan");
    }

    @GetMapping(path = "/person/accept" , produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader(){
        return new PersonV2(new Name("Ritika" , "Malla"));
    }
    // Media type versioning ---Ended--

}
