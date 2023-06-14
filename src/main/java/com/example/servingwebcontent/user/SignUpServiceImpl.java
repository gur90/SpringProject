package com.example.servingwebcontent.user;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.servingwebcontent.user.UserDTO.from;

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

        return from(user);
    }
}
