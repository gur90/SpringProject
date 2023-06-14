package com.example.servingwebcontent.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.servingwebcontent.user.UserDTO.from;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService{
    private final UserRepository userRepository;
    @Override
    public UsersPage getAll(){
        List<User> users = userRepository.findAll();
        return UsersPage.builder()
                .data(from(users)).build();
    }
}
