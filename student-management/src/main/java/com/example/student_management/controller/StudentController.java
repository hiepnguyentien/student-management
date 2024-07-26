package com.example.student_management.controller;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.student.AddStudentDTO;
import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.dto.student.UpdateStudentDTO;
import com.example.student_management.service.implement.StudentService;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@Slf4j
@RequestMapping(path = "student")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    StudentService studentService;

    @GetMapping("/find-all")
    public List<StudentDTO> findAllStudents() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info("GrantedAuthority: {}", grantedAuthority.getAuthority()));

        return studentService.findAll();
    }

    @GetMapping("id/{id}")
    public StudentDTO findById(@PathVariable Long id, @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return studentService.findStudentById(id, locale);
    }

    @GetMapping("/my-info")
    public StudentDTO getMyInfo(@RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return studentService.getMyInfo(locale);
    }

    @GetMapping("name/{name}")
    public List<StudentDTO> findStudentByName(@PathVariable String name){
        return studentService.findStudentByName(name);
    }

    @GetMapping("class-name/{name}")
    public List<StudentDTO> findStudentByManagementClassName(@PathVariable String name){
        return studentService.findStudentByManagementClassName(name);
    }

    @GetMapping("class-id/{id}")
    public ApiResponse<List<StudentDTO>> findStudentByManagementClassId(@PathVariable @Valid Long id, @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<List<StudentDTO>> apiResponse = new ApiResponse<>();

        apiResponse.setResult(studentService.findStudentByManagementClassId(id, locale));

        return apiResponse;
    }

    @PostMapping
    public ApiResponse<StudentDTO> addNewStudent(@RequestBody @Valid AddStudentDTO student, @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<StudentDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(studentService.addNewStudent(student, locale));

        return apiResponse;
    }

    @PutMapping("/{id}")
    public ApiResponse<StudentDTO> updateStudent(@PathVariable @Valid Long id, 
    @RequestBody @Valid UpdateStudentDTO student,
    @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<StudentDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(studentService.updateStudent(id, student, locale));

        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id, @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        studentService.deleteStudent(id, locale);
    }
}
