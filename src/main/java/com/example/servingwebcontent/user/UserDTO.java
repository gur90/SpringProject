package com.example.servingwebcontent.user;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

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
    public static UserDTO from(User user){
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
    public static List<UserDTO> from(List<User> users){
        return users.stream()
                .map(UserDTO::from)
                .collect(Collectors.toList());
    }
}
