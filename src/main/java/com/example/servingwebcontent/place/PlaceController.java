package com.example.servingwebcontent.place;

import com.example.servingwebcontent.artist.ArtistDTO;
import com.example.servingwebcontent.artist.ArtistService;
import com.example.servingwebcontent.event.Event;
import com.example.servingwebcontent.event.EventDTO;
import com.example.servingwebcontent.event.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "About places")
@RestController
@RequestMapping("places")
public class PlaceController {
    private PlaceService placeService;
    private EventService eventsService;
    private ArtistService artistService;

    @Autowired
    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Autowired
    public void setEventsService(EventService eventsService) {
        this.eventsService = eventsService;
    }

    @Autowired
    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public int createPlace(@RequestBody NewPlaceDTO newPlaceDTO) {
        return placeService.createPlace(newPlaceDTO);
    }

    @Operation(summary = "Get place by id ", description = "Get place by id")
    @GetMapping(value = "/{id}")
    public PlaceDTO getPlace(@PathVariable int id) {
        return placeService.getPlace(id);
    }

    @Operation(summary = "Get all events by place", description = "Get all events by place")
    @GetMapping(value = "/{placeId}/events")
    public List<EventDTO> getEventsByPlace(@PathVariable int placeId) {
        return eventsService.getEventsByPlace(placeId);
    }

    @GetMapping(value = "/{placeId}/artists")
    public List<ArtistDTO> getArtistsByPlaceId(@PathVariable int placeId) {
        return artistService.getArtistByPlaceId(placeId);
    }
    @GetMapping(value = "/by-city/{city}")
    public List<PlaceDTO> getPlaceByCity(@PathVariable String city){
        return placeService.getPlaceByCityName(city);
    }
    @GetMapping(value = "/by-city/{city}/address/{address}")
    public List<PlaceDTO> getPlacesByCityAndAddress(@PathVariable String city, @PathVariable String address ){
        return placeService.getPlacesByCityWithAddress(city,address);
    }

}
