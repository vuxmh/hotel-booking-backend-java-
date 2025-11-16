package com.example.HotelBooking.Service;

import com.example.HotelBooking.Config.JwtUtil;
import com.example.HotelBooking.DTO.LoginRequest;
import com.example.HotelBooking.DTO.LoginResponse;
import com.example.HotelBooking.Entity.User;
import com.example.HotelBooking.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    //public AuthService(UserRepository userRepo, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        //this.userRepo = userRepo;
        //this.jwtUtil = jwtUtil;
        //this.passwordEncoder = passwordEncoder;
    //}

    public LoginResponse login(LoginRequest request) {

        User user = userRepo.findByEmail(request.getEmail())
                .orElse(null);

        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return LoginResponse.builder()
                    .success(0)
                    .message("Email hoặc mật khẩu không đúng")
                    .build();
        }

        String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole().name());

        return LoginResponse.builder()
                .success(1)
                .message("Đăng nhập thành công")
                .data(
                        new Object() {
                            public final Object token = new Object() {
                                public final String accessToken = token.toString();
                                public final String refreshToken = token.toString();
                            };
                        }
                )
                .build();
    }
}
