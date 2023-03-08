package com.example.practicesecurity.service;

import com.example.practicesecurity.CustomUserDetails;
import com.example.practicesecurity.entity.UserEntity;
import com.example.practicesecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username).get();
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }
    public UserDetails loadUserById(long userId){
        Optional<UserEntity> user = userRepository.findById(userId);
        if(user.isPresent() == false){
            throw new UsernameNotFoundException("Long " + userId);
        }
        return new CustomUserDetails(user.get());
    }
}
