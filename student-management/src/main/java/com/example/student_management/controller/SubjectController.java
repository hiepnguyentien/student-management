package com.example.student_management.controller;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.Subject.AddSubjectDTO;
import com.example.student_management.dto.Subject.SubjectDTO;
import com.example.student_management.dto.Subject.UpdateSubjectDTO;
import com.example.student_management.dto.student.UpdateStudentDTO;
import com.example.student_management.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/find-all")
    public List<SubjectDTO> findAll(){
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    public SubjectDTO findById(@PathVariable Long id){
        return subjectService.findById(id);
    }

    @GetMapping("/{name}")
    public List<SubjectDTO> findByName(@PathVariable String name){
        return subjectService.findByName(name);
    }

    @PostMapping
    public ApiResponse<AddSubjectDTO> addSubject(@RequestBody @Valid AddSubjectDTO addSubjectDTO){
        ApiResponse<AddSubjectDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(subjectService.add(addSubjectDTO));

        return apiResponse;
    }

    @PutMapping
    public ApiResponse<UpdateSubjectDTO> updateSubject(@RequestBody @Valid UpdateSubjectDTO updateSubjectDTO){
        ApiResponse<UpdateSubjectDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(subjectService.update(updateSubjectDTO));

        return apiResponse;
    }

    @DeleteMapping("{id}")
    public void delete(Long id){
        subjectService.delete(id);
    }
}
