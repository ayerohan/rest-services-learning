package com.in28minutes.rest.webservices.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


/*
    Request Methods for REST API
    GET - retrieves the resource
    POST - creates the resource
    PUT - updates the resource
    PATCH - updates the part of the resource
    DELETE - deletes the resource
*/

@Entity(name = "user_details")
public class User { // user is a keyword in H2


    protected User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3,message = "The length should be more than 2")
//    @JsonProperty("user_name")
    private String name;

    @Past(message = "The birth date should be in the past")
//    @JsonProperty("user_birth_date")
    private LocalDate birthDate;

//    @OneToMany(mappedBy = "user")
//    @JsonIgnore
//    private List<Post> posts;

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
