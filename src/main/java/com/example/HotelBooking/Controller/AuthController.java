package com.example.HotelBooking.Controller;

import com.example.HotelBooking.DTO.LoginRequest;
import com.example.HotelBooking.DTO.LoginResponse;
import com.example.HotelBooking.Service.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
