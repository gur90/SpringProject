package com.example.servingwebcontent.artist;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
class ArtistDTO {
    @Schema(description = "Name of artist")
    @Getter
    @Setter
    private String name;
    @Schema(description = "Genre of play")
    @Getter
    @Setter
    private String genre;

}
