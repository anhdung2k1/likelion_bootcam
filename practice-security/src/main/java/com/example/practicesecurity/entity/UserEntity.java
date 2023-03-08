package com.example.practicesecurity.entity;

import com.example.practicesecurity.CustomUserDetails;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_db")
@Getter
@Setter
public class UserEntity extends CustomUserDetails {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, name="user_name")
    private String userName;
    @Column(name = "password")
    private String password;

    public UserEntity(UserEntity user) {
        super(user);
    }
}
