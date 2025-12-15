package com.example.authservice.dto;

public record UserProfileResponse(
        String username,
        String email,
        String status,
        String role
) {}
