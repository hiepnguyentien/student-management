package com.example.student_management.controller;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.lecturer.AddLecturerDTO;
import com.example.student_management.dto.lecturer.LecturerDTO;
import com.example.student_management.dto.lecturer.UpdateLecturerDTO;
import com.example.student_management.service.implement.LecturerService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/lecturer")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LecturerController {
    LecturerService lecturerService;

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

    @PutMapping("/{id}")
    public ApiResponse<LecturerDTO> updateLecturer(@PathVariable @Valid Long id, @RequestBody @Valid UpdateLecturerDTO updateLecturerDTO){
        ApiResponse<LecturerDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(lecturerService.updateLecturer(id, updateLecturerDTO));

        return apiResponse;
    }

    @PostMapping
    public ApiResponse<LecturerDTO> addLecturer(@RequestBody @Valid AddLecturerDTO addLecturerDTO){
        System.out.println("-------request " + addLecturerDTO + "-------------");
        ApiResponse<LecturerDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(lecturerService.addLecturer(addLecturerDTO));

        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public void deleteLecturer(@PathVariable Long id){
        lecturerService.deleteLecturer(id);
    }
}
