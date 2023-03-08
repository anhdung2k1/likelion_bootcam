package com.example.practicesecurity.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_db")
public class LoginRequest {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_name")
    private String userName;
    @Column(name="password")
    private String password;
}