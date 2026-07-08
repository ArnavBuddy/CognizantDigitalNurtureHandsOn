package com.cognizant.jwtauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.jwtauth.model.AuthResponse;
import com.cognizant.jwtauth.util.JwtUtil;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public AuthResponse authenticate(HttpServletRequest request) {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Missing Authorization header");
        }

        String base64Credentials = authHeader.substring(6);
        String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                StandardCharsets.UTF_8);

        String[] values = credentials.split(":", 2);

        String username = values[0];
        String password = values[1];

        // Simple validation (as per training requirement)
        if ("user".equals(username) && "pwd".equals(password)) {
            String token = jwtUtil.generateToken(username);
            return new AuthResponse(token);
        }

        throw new RuntimeException("Invalid credentials");
    }
}