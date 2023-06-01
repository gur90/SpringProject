package com.example.servingwebcontent.artist;

import com.example.servingwebcontent.genre.GenreDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class ArtistDTO {
    @Schema(description = "Name of artist")
    @Getter
    @Setter
    private String name;
    @Schema(description = "Genre of play")
    @Getter
    @Setter
    private GenreDTO genre;

}
