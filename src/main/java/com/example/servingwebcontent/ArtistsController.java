package com.example.servingwebcontent;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "About Artists")
@RestController
@RequestMapping("artists")

public class ArtistsController {
 private ArtistService service;
    //@RequestMapping(value="/artists", method= RequestMethod.GET)

    @Operation(summary = "Get all artists", description = "Get all artists filtered by genre")
    //@ResponseStatus(code = HttpStatus.OK, reason = "OK")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ArtistDTO.class))))
    })
    @GetMapping(value = "")
    public List<ArtistDTO> listArtists(@RequestParam(name = "genre", required = false, defaultValue = "all") String genre) {
      return service.getArtists(genre);
    }

    @Operation(summary = "Get artists by id", description = "Get artists by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ArtistDTO.class))))
    })
    @ApiResponse(responseCode = "404", description = "not found")
    @GetMapping(value = "/{artistId}")
    public ArtistDTO getArtist(@PathVariable int artistId) {
      ArtistDTO artistDTO =service.getArtist(artistId);
        return artistDTO;
    }

    @Operation(summary = "Delete artists", description = "Delete artists by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "400", description = "invalid input")})
            @DeleteMapping(value = "/{artistId}")
            public ArtistDTO deleteArtist(@PathVariable int artistId) {
        return service.deleteArtist(artistId);

    }
    @Operation(summary = "Post new artist")
    @PostMapping(value = "")
    public ArtistDTO createArtist(@RequestBody ArtistDTO artistDTO){
        return  service.createArtist(artistDTO);
    }
    @Operation(summary = "Put  artists", description = "Put new artists")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "400", description = "invalid input")})



    @PutMapping(value = "/{artistId}")
    public ArtistDTO updateArtist(@PathVariable int artistId, @RequestBody ArtistDTO newArtistDTO) {
       ArtistDTO artistDTO = service.updateArtist(artistId, newArtistDTO);
       artistDTO = newArtistDTO;
       return artistDTO;
    }
}
