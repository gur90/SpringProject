package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Artist{
    private String name;
    private String genre;

    public Artist(String artist, String genre) {
        this.name = artist;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }
}
@RestController
public class ArtistsController {
    static final List<Artist> artists = new ArrayList<Artist>(){{
        add(new Artist("Paolo Roberty", "drama"));
        add(new Artist("Ann Hayway", "musical"));
        add(new Artist("Jery Jim", "drama"));
        add(new Artist("Deny Makgregor", "comedy"));
    }};
    //@RequestMapping(value="/artists", method= RequestMethod.GET)
    @GetMapping(value="/artists")
    public List<Artist> listArtists(@RequestParam(name = "genre",required = false, defaultValue = "all")String genre){
        List<Artist> result=artists;

        if(!genre.equals("all")){
           result  = artists.stream().filter(e -> e.getGenre().equals(genre)).collect(Collectors.toList());
        }
        return result;
    }
    @GetMapping(value="/artists/{artistId}")
    public Artist getArtist(@PathVariable int artistId){
        Artist artist=artists.get(artistId);
        return artist;
    }
    @DeleteMapping(value="/artists/{artistId}")
    public Artist deleteArtist(@PathVariable int artistId){
        Artist artist=artists.get(artistId);
        return artist;
    }
    @PutMapping(value="/artists/{artistId}")
    public Artist updateArtist(@PathVariable int artistId, @RequestBody Artist newArtist){
        Artist artist=artists.get(artistId);
        artist=newArtist;
        return artist;
    }
}
