package com.example.practicesecurity.controller;

import com.example.practicesecurity.CustomUserDetails;
import com.example.practicesecurity.config.JwtTokenProvider;
import com.example.practicesecurity.entity.LoginRequest;
import com.example.practicesecurity.entity.LoginResponse;
import com.example.practicesecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails user = userRepository.findByUserName(loginRequest.getUserName()).get();
        String jwt = tokenProvider.generateToken(user);
        return ResponseEntity.ok(LoginResponse.builder().token(jwt).build());
    }
    @GetMapping("/random")
    public String randomStuff(){
        return "JWT valid can find this page";
    }

}
