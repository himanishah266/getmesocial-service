package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.exception.RestrictedInfoException;
import com.example.getmesocialservice.model.FirebaseUser;
import com.example.getmesocialservice.model.UserDb;
import com.example.getmesocialservice.service.FirebaseService;
import com.example.getmesocialservice.service.UserDbService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController   //this annotation applied to a class as request handler, it's used to create Restful web services using spring MVC.
@RequestMapping("/api/users")     //rest endpoint path starts with
//all the methods in the class starts with rest server
public class UserDbResource {

    //using this annotation,
    // it's gonna create object and transfer to the spring container
    @Autowired
    private UserDbService userService;

    @Autowired
    private FirebaseService firebaseService;

    //send request body to save the data in json format., sending data
    //@valid: it would try to validate all field of post depends on annotation of model classes
    @PostMapping
    public UserDb saveUser(@RequestBody @Valid UserDb user, @RequestHeader(name="idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        //if id token is valid then you can save the user info.
        if(firebaseUser!= null){
            return userService.saveUser(user);
        }
        return  null;
    }

    @GetMapping    //getting all the data in the list
    public List<UserDb> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/find-by-address")
    public List<UserDb> getByAddress(@RequestParam("address") String address) throws RestrictedInfoException{
        if(address.equalsIgnoreCase("area51")) {
            throw new RestrictedInfoException();
        }
       return userService.getByAddress(address);
    }


    @GetMapping("/find-by-id")
    public UserDb getById(@RequestParam(name = "id") String id){
        return userService.getByID(id);
    }


    @GetMapping("/findByName")
    public List<UserDb> getByName(@RequestParam(name = "name") String name){
       return userService.getByName(name);
    }

    @GetMapping("/findByNameStartingWith")
    public List<UserDb> getByNameStartingwith(@RequestParam(name = "nameStartingLetter") String name){
        return userService.getByNameStartingwith(name);
    }

    @PutMapping
    public UserDb updateUser(@RequestBody UserDb userDb){
        return userService.updateUser(userDb);

    }


    @DeleteMapping
    public void deleteUser(@RequestParam(name = "userID") String userId) {
        userService.deleteUser(userId);
    }







    /*//getting data in json format
    @GetMapping("/user")     //return the values in json format, getting data
    public User getUser(){
        return userService.getUser();
    }


    //getting data based on userId
    //whatever comes here in Json format based on parameter variable(field) userId.
    //taking the path endpoint-userId, that value comes here in parameter would be converted into userID
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") int userId){
        return userService.getUserById(userId);
    }


    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable("userId") int userId, @RequestBody User user){
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/user")
    public User deleteUser(@RequestParam(name = "userId") int userId){
        return userService.deleteUser(userId);

    }
*/
}

