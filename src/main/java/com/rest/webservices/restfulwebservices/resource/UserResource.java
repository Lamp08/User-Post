package com.rest.webservices.restfulwebservices.resource;

import com.rest.webservices.restfulwebservices.data.User;
import com.rest.webservices.restfulwebservices.exceptions.UserNotfoundException;
import com.rest.webservices.restfulwebservices.service.UserService;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @PostMapping("/users-save")
    public ResponseEntity<User> saveUsers(@Valid @RequestBody User user){
        User newUser = userService.saveUser(user);
        //this gives 201 created before this it was giving 200 ok//
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getUsersById(@PathVariable int id){
        User user = userService.userById(id);

        if(user == null)
            throw new UserNotfoundException("id:"+id);
        EntityModel<User> model = EntityModel.of(user);
        //use of Hateoas to provide the link
        WebMvcLinkBuilder linktoUser =
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsers());
        model.add(linktoUser.withRel("all-users"));
        return model;
    }

    @DeleteMapping("/users-delete/{id}")
    public User deleteUserById(@PathVariable int id){
        User user = userService.deleteUserById(id);
        if(user == null)
            throw new UserNotfoundException("id:"+id);
        return user;
    }
}
