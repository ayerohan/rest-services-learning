package com.in28minutes.rest.webservices.restful_web_services.helloworld;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

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


    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
         return messageSource.getMessage("good.morning.message", null , "Default Message", locale);
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