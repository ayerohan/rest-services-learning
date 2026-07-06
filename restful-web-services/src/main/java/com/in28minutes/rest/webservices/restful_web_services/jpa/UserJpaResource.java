package com.in28minutes.rest.webservices.restful_web_services.jpa;

import com.in28minutes.rest.webservices.restful_web_services.user.User;
import com.in28minutes.rest.webservices.restful_web_services.user.UserDaoService;
import com.in28minutes.rest.webservices.restful_web_services.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/*
    Request Methods for REST API
    GET - retrieves the resource
    POST - creates the resource
    PUT - updates the resource
    PATCH - updates the part of the resource
    DELETE - deletes the resource
*/

@RestController
public class UserJpaResource {

    public UserRepository userRepository;

    public UserJpaResource(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            // 404 custom exception has been created
            throw new UserNotFoundException("id: " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User newuser = userRepository.save(user);

        // uri gets you the link of the currently saved user.
        // /users/4 => /users/{id} , user.getID
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newuser.getId()).toUri();

        // for no uri - return ResponseEntity.created(null).build();
        return ResponseEntity.created(location).build();
    }

}
