package com.example.servingwebcontent.event;

import com.example.servingwebcontent.artist.Artist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NewEventDTO {
    private String name;
    private int placeId;
    private int artistId;
}
