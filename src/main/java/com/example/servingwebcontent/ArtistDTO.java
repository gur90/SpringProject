package com.example.servingwebcontent;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor

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
