package com.example.getmesocialservice.resource;


import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController             //rest endpoint
@RequestMapping("/api")     //rest endpoint path starts with
//all the methods in the class starts with rest server
public class UserResource {

    //using this annotation,
    // it's gonna create object and transfer to the spring container
    @Autowired
    private UserService userService;

    @GetMapping("/user")     //return the values in json format
    public User getUser(){
        return userService.getUser();
    }


}
