package com.example.getmesocialservice.resource;


import com.example.getmesocialservice.model.AlbumDb;
import com.example.getmesocialservice.model.FirebaseUser;
import com.example.getmesocialservice.service.AlbumDbService;
import com.example.getmesocialservice.service.FirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

//this annotation applied to a class as request handler, it's used to create Restful web services using spring MVC.
@RestController
@RequestMapping("/api/albumsDb")
public class AlbumDbResource {

    @Autowired
    private AlbumDbService albumService;

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping
    public AlbumDb saveAlbums(@RequestBody @Valid AlbumDb album){
        return albumService.saveAlbum(album);
    }

    @CrossOrigin
    @GetMapping
    public List<AlbumDb> getAllAlbums(@RequestHeader(name ="idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);

        if(firebaseUser!= null){
            return albumService.getAllAlbums();
        }
        return null;
    }

    @GetMapping("/find-by-id")
    public List<AlbumDb> getById(@RequestParam(name = "id") String id){
        return albumService.getById(id);
    }

    @PutMapping
    public AlbumDb updateAlbum(@RequestBody AlbumDb albumDb){
        return albumService.updateAlbum(albumDb);
    }

    @DeleteMapping
    public void deleteAlbum(@RequestParam(name= "albumId") String id){
         albumService.deleteAlbum(id);
    }



}
