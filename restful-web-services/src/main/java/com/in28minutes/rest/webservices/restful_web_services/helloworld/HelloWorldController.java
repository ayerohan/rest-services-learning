package com.in28minutes.rest.webservices.restful_web_services.helloworld;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    // @RequestMapping(method = RequestMethod.GET, path = "/hello-world")  (or)
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean HelloWorldBean() {
        return new HelloWorldBean("Hello world");
    }

    // path parameters
    // /users/{id}/todos/{id} => /users/2/todos/200
    // /hello-world/path-variable/{name}

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        // return new HelloWorldBean("hello world" + name);
        return new HelloWorldBean(String.format("hello world , %s"  , name));
    }

    /*
    Request Methods for REST API
    GET - retrieves the resource
    POST - creates the resource
    PUT - updates the resource
    PATCH - updates the part of the resource
    DELETE - deletes the resource
    */



}