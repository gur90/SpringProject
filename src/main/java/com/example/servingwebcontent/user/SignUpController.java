package com.example.servingwebcontent.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Users")
@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class SignUpController implements SignUpApi {
    private final SignUpService signUpService;

    @Override
    public ResponseEntity<UserDTO> signUp(NewUserDTO newUser) {
        return ResponseEntity
                .status(201)
                .body(signUpService.signUp(newUser));
    }
}
