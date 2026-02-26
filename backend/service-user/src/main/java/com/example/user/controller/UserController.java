package com.example.user.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP", "service", "service-user");
    }

    @GetMapping("/users/{id}")
    public Map<String, Object> getUserById(@PathVariable Long id) {
        return Map.of(
                "id", id,
                "name", "user-" + id,
                "email", "user" + id + "@example.com"
        );
    }
}
