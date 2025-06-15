package com.jwt.prova.controller;

import com.jwt.prova.dto.LoginRequest;
import com.jwt.prova.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import com.jwt.prova.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jwt.prova.security.JWTUtil;
import com.jwt.prova.service.UserService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JWTUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        User user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(req.getPassword())
                .role(req.getRole())
                .build();
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        return userService.findByEmail(req.getEmail())
                .filter(u -> u.getPassword().equals(req.getPassword()))
                .map(u -> ResponseEntity.ok(jwtUtil.generateToken(u)))
                .orElse(ResponseEntity.status(401).body("Credenciais inválidas"));
    }
}