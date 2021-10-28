package com.example.getmesocialservice.resource;


import com.example.getmesocialservice.model.FirebaseUser;
import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.service.FirebaseService;
import com.example.getmesocialservice.service.PhotoService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {


    @Autowired
    private PhotoService photoService;

    @Autowired
    private FirebaseService firebaseService;


    @PostMapping
    public Photo savePhoto(@RequestBody @Valid  Photo photo){
        return photoService.savePhoto(photo);
    }


    @GetMapping
    public List<Photo> getAllPhotos(@RequestHeader(name ="idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);

        if(firebaseUser!= null){
            return photoService.getAllPhotos();
        }
        return null;
    }


    @GetMapping("/find-by-id")
    public List<Photo> getByID(String id) {
        return photoService.getById(id) ;
    }

    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo){
        return photoService.updatePhoto(photo);

    }

    @DeleteMapping
    public void deletePhotosById(String id){
        photoService.deletePhotos(id);
    }








}
