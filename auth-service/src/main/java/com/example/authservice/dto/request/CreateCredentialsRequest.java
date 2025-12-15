package com.example.authservice.dto.request;

public record CreateCredentialsRequest(String username, String rawPassword) {
}
