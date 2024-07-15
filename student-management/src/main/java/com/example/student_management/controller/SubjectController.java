package com.example.student_management.controller;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.subject.AddSubjectDTO;
import com.example.student_management.dto.subject.SubjectDTO;
import com.example.student_management.dto.subject.UpdateSubjectDTO;
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

    @GetMapping("id/{id}")
    public SubjectDTO findById(@PathVariable Long id){
        return subjectService.findSubjectById(id);
    }

    @GetMapping("name/{name}")
    public List<SubjectDTO> findByName(@PathVariable String name){
        return subjectService.findSubjectByName(name);
    }

    @PostMapping
    public ApiResponse<AddSubjectDTO> addSubject(@RequestBody @Valid AddSubjectDTO addSubjectDTO){
        ApiResponse<AddSubjectDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(subjectService.addSubject(addSubjectDTO));

        return apiResponse;
    }

    @PutMapping
    public ApiResponse<UpdateSubjectDTO> updateSubject(@RequestBody @Valid UpdateSubjectDTO updateSubjectDTO){
        ApiResponse<UpdateSubjectDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(subjectService.updateSubject(updateSubjectDTO));

        return apiResponse;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        subjectService.deleteSubject(id);
    }
}
