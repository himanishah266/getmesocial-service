package com.example.getmesocialservice.resource;


import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {


    @Autowired
    private PhotoService photoService;

    @PostMapping
    public Photo savePhoto(@RequestBody @Valid  Photo photo){
        return photoService.savePhoto(photo);
    }


    @GetMapping
    public List<Photo> getAllPhotos() {
        return photoService.getAllPhotos();
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
