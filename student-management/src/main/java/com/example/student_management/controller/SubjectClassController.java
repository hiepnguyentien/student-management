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
import com.example.student_management.dto.subjectClass.AddSubjectClassDTO;
import com.example.student_management.dto.subjectClass.SubjectClassDTO;
import com.example.student_management.dto.subjectClass.UpdateSubjectClassDTO;
import com.example.student_management.service.SubjectClassService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "subject-class")
public class SubjectClassController {

    private final SubjectClassService subjectClassService;

    @Autowired
    public SubjectClassController(SubjectClassService subjectClassService) {
        this.subjectClassService = subjectClassService;
    }
    
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

    @PutMapping
    public ApiResponse<UpdateSubjectClassDTO> updateSubjectClass(@RequestBody @Valid UpdateSubjectClassDTO updateSubjectClassDTO) {
        ApiResponse<UpdateSubjectClassDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(subjectClassService.updateSubjectClass(updateSubjectClassDTO));

        return apiResponse;
    }

    @PostMapping
    public ApiResponse<AddSubjectClassDTO> addSubjectClass(@RequestBody @Valid AddSubjectClassDTO addSubjectClassDTO) {
        ApiResponse<AddSubjectClassDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(subjectClassService.addSubjectClass(addSubjectClassDTO));

        return apiResponse;
    }

    @DeleteMapping("id/{id}")
    public void delete(@PathVariable Long id) {
        subjectClassService.delete(id);
    }
}
