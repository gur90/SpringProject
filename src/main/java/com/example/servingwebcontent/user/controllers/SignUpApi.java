package com.example.servingwebcontent.user.controllers;

import com.example.servingwebcontent.user.NewUserDTO;
import com.example.servingwebcontent.user.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Users")
@RequestMapping("/api/signUp")
public interface SignUpApi {

    @Operation(summary = "Registration users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Registered user",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserDTO.class))
                    }
            )
    })
    @PostMapping
    ResponseEntity<UserDTO> signUp(@RequestBody NewUserDTO newUser);
}
