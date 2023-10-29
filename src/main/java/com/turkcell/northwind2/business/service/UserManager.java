package com.turkcell.northwind2.business.service;

import com.turkcell.northwind2.core.utilities.config.JwtAuthService;
import com.turkcell.northwind2.dataAccess.UserRepository;
import com.turkcell.northwind2.dto.authDto.AuthResponse;
import com.turkcell.northwind2.dto.authDto.LoginRequest;
import com.turkcell.northwind2.dto.authDto.RegisterRequest;
import com.turkcell.northwind2.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtAuthService service;
    private final AuthenticationManager manager;

    public AuthResponse adminRegister(RegisterRequest request){
        User user=new User();
        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(User.Role.ADMIN);
        userRepository.save(user);
        String token=service.generatedToken(user);
        return new AuthResponse(token);
    }
    public AuthResponse login(LoginRequest request){
        manager.authenticate(new UsernamePasswordAuthenticationToken(request.getPassword(),request.getUsername()));
       User user= userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=service.generatedToken(user);
        return new AuthResponse(token);
    }
}