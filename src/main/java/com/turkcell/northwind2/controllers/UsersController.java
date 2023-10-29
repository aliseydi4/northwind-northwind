package com.turkcell.northwind2.controllers;

import com.turkcell.northwind2.business.service.UserManager;
import com.turkcell.northwind2.dto.authDto.AuthResponse;
import com.turkcell.northwind2.dto.authDto.LoginRequest;
import com.turkcell.northwind2.dto.authDto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserManager manager;

    @PostMapping("adminRegister")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AuthResponse adminRegister(@RequestBody RegisterRequest request) {
        return manager.adminRegister(request);
    }

    @PostMapping("login")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AuthResponse login(@RequestBody LoginRequest request) {
        return manager.login(request);
    }
}
