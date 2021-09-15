package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.UserDb;
import com.example.getmesocialservice.repository.UserDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDbService {
    @Autowired
    private UserDbRepository userRepository;

    public UserDb saveUser(UserDb user) {
        return userRepository.save(user);
    }

    public List<UserDb> getAllUsers() {
        return userRepository.findAll();
    }


    public UserDb getByID(String id) {
        return userRepository.findById(id).get();
    }


    public UserDb updateUser(UserDb userDb) {
        return userRepository.save(userDb);

    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<UserDb> getByAddress(String address) {
        return userRepository.findAllByAddress(address);
    }

    public  List<UserDb> getByName(String name) {
        return userRepository.findAllByName(name);
    }

    public List<UserDb> getByNameStartingwith(String name) {
        return userRepository.findAllByNameStartingWith(name);

    }





 /*
    public User getUser() {
        return userRepository.getUser();
    }




    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    public User updateUser(int userId, User user) {
        return userRepository.updateUser(userId, user);
    }

    public User deleteUser(int userId) {
        return userRepository.deleteUser(userId);
    }*/

}
