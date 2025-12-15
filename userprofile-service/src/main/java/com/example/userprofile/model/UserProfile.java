package com.example.userprofile.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_profiles")
@AllArgsConstructor
@Getter
@Builder
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public UserProfile() {
    }

    public UserProfile(String username, String email, UserRole role) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.status = UserStatus.ACTIVE;
    }

    public void suspend() {
        this.status = UserStatus.SUSPENDED;
    }

    public boolean isActive() {
        return this.status == UserStatus.ACTIVE;
    }

}

