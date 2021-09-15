package com.example.getmesocialservice.resource;


import com.example.getmesocialservice.model.AlbumDb;
import com.example.getmesocialservice.service.AlbumDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//this annotation applied to a class as request handler, it's used to create Restful web services using spring MVC.
@RestController
@RequestMapping("/api/albumsDb")
public class AlbumDbResource {

    @Autowired
    private AlbumDbService albumService;

    @PostMapping
    public AlbumDb saveAlbums(@RequestBody AlbumDb album){
        return albumService.saveAlbum(album);
    }

    @GetMapping
    public List<AlbumDb> getAllAlbums(){
        return albumService.getAllAlbums();
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
