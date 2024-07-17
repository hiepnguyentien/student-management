package com.example.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.subject_class.AddSubjectClassDTO;
import com.example.student_management.dto.subject_class.SubjectClassDTO;
import com.example.student_management.dto.subject_class.UpdateSubjectClassDTO;
import com.example.student_management.service.implement.SubjectClassService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@RestController
@RequestMapping(path = "subject-class")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubjectClassController {
    SubjectClassService subjectClassService;

    @GetMapping("find-all")
    public List<SubjectClassDTO> findAll() {
        return subjectClassService.findAll();
    }

    @GetMapping("id/{id}")
    public SubjectClassDTO findById(@PathVariable Long id) {
        return subjectClassService.findById(id);
    }

    @GetMapping("name/{name}")
    public List<SubjectClassDTO> findByName(@PathVariable String name) {
        return subjectClassService.findByName(name);
    }

    @PutMapping("/{id}")
    public ApiResponse<SubjectClassDTO> updateSubjectClass(@PathVariable @Valid Long id,
            @RequestBody @Valid UpdateSubjectClassDTO updateSubjectClassDTO) {
        ApiResponse<SubjectClassDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(subjectClassService.updateSubjectClass(id, updateSubjectClassDTO));

        return apiResponse;
    }

    @PostMapping
    public ApiResponse<SubjectClassDTO> addSubjectClass(@RequestBody @Valid AddSubjectClassDTO addSubjectClassDTO) {
        ApiResponse<SubjectClassDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(subjectClassService.addSubjectClass(addSubjectClassDTO));

        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subjectClassService.delete(id);
    }
}
