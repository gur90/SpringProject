package com.example.servingwebcontent.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Schema(description = "page with users")
public class UsersPage {
    @Schema(description = "users")
    private List<UserDTO> data;
}
