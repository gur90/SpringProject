package com.example.servingwebcontent;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
class Event {
    @Schema(description = "Name of the event")
    @Getter
    @Setter
    private String name;
    @Schema(description = "Location of the event")
    @Getter
    @Setter
    private String city;


}

