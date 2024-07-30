package com.example.student_management.controller;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.authentication.*;
import com.example.student_management.dto.lecturer.AddLecturerDTO;
import com.example.student_management.dto.lecturer.LecturerDTO;
import com.example.student_management.dto.lecturer.UpdateLecturerDTO;
import com.example.student_management.service.implement.LecturerAuthenticationService;
import com.example.student_management.service.implement.LecturerService;
import com.nimbusds.jose.JOSEException;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(path = "/lecturer")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LecturerController {
    LecturerService lecturerService;
    LecturerAuthenticationService lecturerAuthenticationService;

    @GetMapping("/find-all")
    public List<LecturerDTO> findAll() {
        return lecturerService.findAll();
    }

    @GetMapping("id/{id}")
    public LecturerDTO findLecturerById(@PathVariable Long id,
            @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return lecturerService.findLecturerById(id, locale);
    }

    @GetMapping("name/{name}")
    public List<LecturerDTO> findLecturerByName(@PathVariable String name) {
        return lecturerService.findLecturerByName(name);
    }

    @GetMapping("faculty/{id}")
    public ApiResponse<List<LecturerDTO>> findLecturerByFacultyId(@PathVariable @Valid Long id,
            @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<List<LecturerDTO>> apiResponse = new ApiResponse<>();

        apiResponse.setResult(lecturerService.findLecturerByFacultyId(id, locale));

        return apiResponse;
    }

    @GetMapping("management-class/{id}")
    public ApiResponse<LecturerDTO> findLecturerByManagementClassId(@PathVariable @Valid Long id,
            @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<LecturerDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(lecturerService.findLecturerByManagementClassId(id, locale));

        return apiResponse;
    }

    @PutMapping("/{id}")
    public ApiResponse<LecturerDTO> updateLecturer(@PathVariable @Valid Long id,
            @RequestBody @Valid UpdateLecturerDTO updateLecturerDTO,
            @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<LecturerDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(lecturerService.updateLecturer(id, updateLecturerDTO, locale));

        return apiResponse;
    }

    @PostMapping
    public ApiResponse<LecturerDTO> addLecturer(@RequestBody @Valid AddLecturerDTO addLecturerDTO,
            @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<LecturerDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(lecturerService.addLecturer(addLecturerDTO, locale));

        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public void deleteLecturer(@PathVariable Long id, @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        lecturerService.deleteLecturer(id, locale);
    }

    @PostMapping("/auth/token")
    ApiResponse<AuthenticationResponse> logIn(@RequestBody AuthenticationRequest authenticationRequest, @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        var result = lecturerAuthenticationService.authenticate(authenticationRequest, locale);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/auth/introspect")
    ApiResponse<IntrospectResponse> logIn(@RequestBody IntrospectRequest introspectRequest)
            throws ParseException, JOSEException {
        var result = lecturerAuthenticationService.introspect(introspectRequest);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/auth/logout")
    ApiResponse<Void> logout(@RequestBody LogoutRequest introspectRequest)
        throws ParseException, JOSEException {
        lecturerAuthenticationService.logout(introspectRequest);
        return ApiResponse.<Void>builder()
                .build();
    }

    @PostMapping("/auth/refresh")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody RefreshRequest request)
            throws ParseException, JOSEException {
        var result = lecturerAuthenticationService.refreshToken(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }
}
