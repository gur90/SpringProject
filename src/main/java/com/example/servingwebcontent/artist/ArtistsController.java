package com.example.servingwebcontent.artist;

import com.example.servingwebcontent.event.EventDTO;
import com.example.servingwebcontent.event.EventRepository;
import com.example.servingwebcontent.event.EventService;
import com.example.servingwebcontent.genre.GenreService;
import com.example.servingwebcontent.place.PlaceDTO;
import com.example.servingwebcontent.place.PlaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "About Artists")
@RestController
@RequestMapping("artists")

public class ArtistsController {
    private ArtistService service;
    private EventService eventService;
    private PlaceService placeService;
    private GenreService genreService;
@Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @Autowired
    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    //@RequestMapping(value="/artists", method= RequestMethod.GET)
    @Autowired
    public ArtistsController(ArtistService service) {
        this.service = service;
    }

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
        ArtistDTO artistDTO = service.getArtist(artistId);
        return artistDTO;
    }

    @Operation(summary = "Delete artists", description = "Delete artists by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "400", description = "invalid input")})
    @DeleteMapping(value = "/{artistId}")
    public void deleteArtist(@PathVariable int artistId) {
        service.deleteArtist(artistId);

    }

    @Operation(summary = "Post new artist")
    @PostMapping(value = "")
    public int createArtist(@RequestBody NewArtistDTO artistDTO) {
        return service.createArtist(artistDTO);
    }

    @Operation(summary = "Put  artists", description = "Put new artists")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "400", description = "invalid input")})


    @PutMapping(value = "/{artistId}")
    public void updateArtist(@PathVariable int artistId, @RequestBody NewArtistDTO newArtistDTO) {
        service.updateArtist(artistId, newArtistDTO);

    }

    @GetMapping(value = "/{artistId}/events")
    public List<EventDTO> getEventsForArtist(@PathVariable int artistId) {
        return eventService.getEventsForArtist(artistId);
    }

    @GetMapping(value = "/{artistId}/places")
    public List<PlaceDTO> getPlaceByArtistId(@PathVariable int artistId) {
        return placeService.getPlaceByArtistId(artistId);

    }
    @GetMapping(value = "/by-genre/{genre}")
    public List<ArtistDTO> getArtistsByGenreName(@PathVariable String genre){
        return genreService.getArtistsByGenreName(genre);
    }
}
