package com.example.HotelBooking.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class LoginResponse {
    private int success;
    private String message;
    private Object data;

    public static LoginResponseBuilder builder() {
        return new LoginResponseBuilder();
    }

    public static class LoginResponseBuilder {
        private int success;
        private String message;
        private Object data;

        public LoginResponseBuilder success(int success) {
            this.success = success;
            return this;
        }

        public LoginResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public LoginResponseBuilder data(Object data) {
            this.data = data;
            return this;
        }

        public LoginResponse build() {
            LoginResponse response = new LoginResponse();
            response.success = this.success;
            response.message = this.message;
            response.data = this.data;
            return response;
        }
    }
}
