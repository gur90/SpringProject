package com.example.servingwebcontent.user.controllers;

import com.example.servingwebcontent.user.UsersPage;
import com.example.servingwebcontent.user.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersController implements UsersApi {
    private final UsersService usersService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public ResponseEntity<UsersPage> getAll() {
        return ResponseEntity
                .ok(usersService.getAll());
    }
}
