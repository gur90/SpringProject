package com.example.servingwebcontent.genre;

import com.example.servingwebcontent.artist.ArtistDTO;
import com.example.servingwebcontent.artist.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Tag(name = "About genre")
@RestController
@RequestMapping("genres")
public class GenreController {
    private GenreService genreService;
    private ArtistService artistService;
@Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }
@Autowired
    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }
    @PostMapping
    public int createGenre(@RequestBody NewGenreDTO newGenreDTO){
    return genreService.createGenre(newGenreDTO);
    }

    @Operation(summary = "Get genre by id",description = "Get genre by id")
    @GetMapping(value = "/{id}")
    public GenreDTO getGenre(@PathVariable int id ){
    return genreService.getGenre(id);
    }
    @Operation(summary = "get all artists by genre", description = "get all artists by genre")
    @GetMapping(value = "/{genreId}/genres")
    public List<ArtistDTO> getArtistsByGenre(@PathVariable int genreId){
    return artistService.getArtistsByGenre(genreId);
    }
}
