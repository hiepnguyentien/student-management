package com.example.student_management.controller;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.authentication.AuthenticationRequest;
import com.example.student_management.dto.authentication.AuthenticationResponse;
import com.example.student_management.service.implement.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> logIn(@RequestBody AuthenticationRequest authenticationRequest, @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        var result = authenticationService.authenticate(authenticationRequest, locale);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }
}
