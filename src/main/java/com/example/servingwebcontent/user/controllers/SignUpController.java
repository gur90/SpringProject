package com.example.servingwebcontent.user.controllers;

import com.example.servingwebcontent.user.NewUserDTO;
import com.example.servingwebcontent.user.SignUpService;
import com.example.servingwebcontent.user.UserDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

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
