package com.ayoh.coreshop.withoutspringsecurity.controller;

import com.ayoh.coreshop.withoutspringsecurity.auth.UserCredentials;
import com.ayoh.coreshop.withoutspringsecurity.entity.User;
import com.ayoh.coreshop.withoutspringsecurity.repository.UserRepository;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserCredentials credentials, HttpSession session) {
        // Verify user credentials
        Optional<User> user = userRepository.findByUsernameAndPassword(credentials.getUsername(),
                                                                       credentials.getPassword());

        // FIXME
        if (user.isPresent()) {
            // Set the user ID in the session to maintain user state
            session.setAttribute("userId", user.get().getId());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        // Invalidate the session to log the user out
        session.invalidate();
        return ResponseEntity.ok().build();
    }

}
