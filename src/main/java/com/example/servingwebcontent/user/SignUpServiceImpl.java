package com.example.servingwebcontent.user;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService{

    private final UserRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDTO signUp(NewUserDTO newUser) {
        User user = User.builder()
                .username(newUser.getUsername())
                .hashPassword(passwordEncoder.encode(newUser.getPassword()))
                .build();

        usersRepository.save(user);

        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
