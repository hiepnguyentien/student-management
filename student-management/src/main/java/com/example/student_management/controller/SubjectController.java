package com.example.student_management.controller;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.subject.AddSubjectDTO;
import com.example.student_management.dto.subject.SubjectDTO;
import com.example.student_management.dto.subject.UpdateSubjectDTO;
import com.example.student_management.service.implement.SubjectService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "subject")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubjectController {
    SubjectService subjectService;

    @GetMapping("/find-all")
    public List<SubjectDTO> findAll(){
        return subjectService.findAll();
    }

    @GetMapping("id/{id}")
    public SubjectDTO findById(@PathVariable Long id){
        return subjectService.findSubjectById(id);
    }

    @GetMapping("name/{name}")
    public List<SubjectDTO> findByName(@PathVariable String name){
        return subjectService.findSubjectByName(name);
    }

    @PostMapping
    public ApiResponse<SubjectDTO> addSubject(@RequestBody @Valid AddSubjectDTO addSubjectDTO){
        ApiResponse<SubjectDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(subjectService.addSubject(addSubjectDTO));

        return apiResponse;
    }

    @PutMapping({"/{id}"})
    public ApiResponse<SubjectDTO> updateSubject(@PathVariable @Valid Long id, 
    @RequestBody @Valid UpdateSubjectDTO updateSubjectDTO){
        ApiResponse<SubjectDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(subjectService.updateSubject(id, updateSubjectDTO));

        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
    }
}
