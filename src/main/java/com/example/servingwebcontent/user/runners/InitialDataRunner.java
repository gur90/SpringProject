package com.example.servingwebcontent.user.runners;

import com.example.servingwebcontent.user.User;
import com.example.servingwebcontent.user.UserRepository;
import io.swagger.v3.oas.annotations.media.Content;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class InitialDataRunner implements CommandLineRunner {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

   @Override
    public void run(String... args) throws Exception {
        User admin = User.builder()
                .username("admin")
                .role(User.Role.ADMIN)
                .hashPassword(passwordEncoder.encode("admin")).build();
        User anna = User.builder()
                .username("anna")
                .role(User.Role.USER)
                .hashPassword(passwordEncoder.encode("anna")).build();
        userRepository.saveAll(Arrays.asList(admin,anna));

    }
}
