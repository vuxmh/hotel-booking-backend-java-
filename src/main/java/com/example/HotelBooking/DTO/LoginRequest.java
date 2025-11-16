package com.example.HotelBooking.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;

    public String getEmail() {
        return "";
    }

    public CharSequence getPassword() {
        return null;
    }
}
