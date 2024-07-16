package com.example.student_management.controller;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.lecturer.AddLecturerDTO;
import com.example.student_management.dto.lecturer.LecturerDTO;
import com.example.student_management.dto.lecturer.UpdateLecturerDTO;
import com.example.student_management.service.implement.LecturerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/lecturer")
public class LecturerController {
    private final LecturerService lecturerService;

    @Autowired
    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping("/find-all")
    public List<LecturerDTO> findAll(){
        return lecturerService.findAll();
    }

    @GetMapping("id/{id}")
    public LecturerDTO findLecturerById(@PathVariable Long id){
        return lecturerService.findLecturerById(id);
    }

    @GetMapping("name/{name}")
    public List<LecturerDTO> findLecturerByName(@PathVariable String name){
        return lecturerService.findLecturerByName(name);
    }

    @GetMapping("faculty/{id}")
    public ApiResponse<List<LecturerDTO>> findLecturerByFacultyId(@PathVariable @Valid Long id){
        ApiResponse<List<LecturerDTO>> apiResponse = new ApiResponse<>();

        apiResponse.setResult(lecturerService.findLecturerByFacultyId(id));

        return apiResponse;
    }

    @GetMapping("management-class/{id}")
    public ApiResponse<LecturerDTO> findLecturerByManagementClassId(@PathVariable @Valid Long id){
        ApiResponse<LecturerDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(lecturerService.findLecturerByManagementClassId(id));

        return apiResponse;
    }

    @PutMapping
    public ApiResponse<UpdateLecturerDTO> updateLecturer(@RequestBody @Valid UpdateLecturerDTO updateLecturerDTO){
        ApiResponse<UpdateLecturerDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(lecturerService.updateLecturer(updateLecturerDTO));

        return apiResponse;
    }

    @PostMapping
    public ApiResponse<AddLecturerDTO> addLecturer(@RequestBody @Valid AddLecturerDTO addLecturerDTO){
        ApiResponse<AddLecturerDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(lecturerService.addLecturer(addLecturerDTO));

        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public void deleteLecturer(@PathVariable Long id){
        lecturerService.deleteLecturer(id);
    }
}
