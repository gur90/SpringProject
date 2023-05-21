package com.example.servingwebcontent;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "About Artists")
@RestController
@RequestMapping("artists")

public class ArtistsController {
    static final List<Artist> artists = new ArrayList<Artist>() {{
        add(new Artist("Paolo Roberty", "drama"));
        add(new Artist("Ann Hayway", "musical"));
        add(new Artist("Jery Jim", "drama"));
        add(new Artist("Deny Makgregor", "comedy"));
    }};
    //@RequestMapping(value="/artists", method= RequestMethod.GET)

    @Operation(summary = "Get all artists", description = "Get all artists filtered by genre")
    //@ResponseStatus(code = HttpStatus.OK, reason = "OK")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Artist.class))))
    })
    @GetMapping(value = "")
    public List<Artist> listArtists(@RequestParam(name = "genre", required = false, defaultValue = "all") String genre) {
        List<Artist> result = artists;

        if (!genre.equals("all")) {
            result = artists.stream().filter(e -> e.getGenre().equals(genre)).collect(Collectors.toList());
        }
        return result;
    }

    @Operation(summary = "Get artists by id", description = "Get artists by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Artist.class))))
    })
    @ApiResponse(responseCode = "404", description = "not found")
    @GetMapping(value = "/{artistId}")
    public Artist getArtist(@PathVariable int artistId) {
        Artist artist = artists.get(artistId);
        return artist;
    }

    @Operation(summary = "Delete artists", description = "Delete artists by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "400", description = "invalid input")})
            @DeleteMapping(value = "/{artistId}")
            public Artist deleteArtist(@PathVariable int artistId) {
        Artist artist = artists.get(artistId);
        return artist;
    }

    @Operation(summary = "Put  artists", description = "Put new artists")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "400", description = "invalid input")})

    @PutMapping(value = "/{artistId}")
    public Artist updateArtist(@PathVariable int artistId, @RequestBody Artist newArtist) {
        Artist artist = artists.get(artistId);
        artist = newArtist;
        return artist;
    }
}
