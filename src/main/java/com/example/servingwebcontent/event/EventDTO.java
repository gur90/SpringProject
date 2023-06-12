package com.example.servingwebcontent.event;

import com.example.servingwebcontent.artist.Artist;
import com.example.servingwebcontent.artist.ArtistDTO;
import com.example.servingwebcontent.place.Place;
import com.example.servingwebcontent.place.PlaceDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public
class EventDTO {
    @Schema(description = "Name of the event")
    @Getter
    @Setter
    private String name;
    @Schema(description = "Location of the event")
    @Getter
    @Setter
            //private String city;
    private PlaceDTO place;
    @Getter
    @Setter
           //artistDTO
    private ArtistDTO artist;
}

