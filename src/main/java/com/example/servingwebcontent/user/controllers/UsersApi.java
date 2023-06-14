package com.example.servingwebcontent.user.controllers;

import com.example.servingwebcontent.user.UsersPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tags(value = {
        @Tag(name = "Users")
})
@RequestMapping("/api/users")
public interface UsersApi {
    @Operation(summary = "get users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "List of users",
            content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = UsersPage.class))
            })
    })
    @GetMapping
    ResponseEntity<UsersPage> getAll();
}
