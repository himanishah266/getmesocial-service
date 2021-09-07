package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User getUser(){
        return new User("him","Canada", 18, "dd" );
    }

}
