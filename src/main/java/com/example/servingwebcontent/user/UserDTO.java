package com.example.servingwebcontent.user;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Registered user")
public class UserDTO {
    @Schema(description = "user id")
    private int id;
    @Schema(description = "user name")
    private String username;
}
