package com.example.student_management.controller;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.faculty.AddNewFacultyDTO;
import com.example.student_management.dto.faculty.FacultyDTO;
import com.example.student_management.dto.faculty.UpdateFacultyDTO;
import com.example.student_management.service.implement.FacultyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping(path = "faculty")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FacultyController {
    FacultyService facultyService;

    @GetMapping("/find-all")
    public List<FacultyDTO> findAll() {
        return facultyService.findAll();
    }

    @GetMapping("id/{id}")
    public FacultyDTO findById(@PathVariable Long id, @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return facultyService.findFacultyById(id, locale);
    }

    @GetMapping("name/{name}")
    public List<FacultyDTO> findByName(@PathVariable String name) {
        return facultyService.findFacultyByName(name);
    }

    @PostMapping
    public ApiResponse<FacultyDTO> addNew(@RequestBody @Valid AddNewFacultyDTO addNewFacultyDTO) {
        ApiResponse<FacultyDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(facultyService.addNew(addNewFacultyDTO));

        return apiResponse;
    }

    @PutMapping("/{id}")
    public ApiResponse<FacultyDTO> update(@PathVariable @Valid Long id,
            @RequestBody @Valid UpdateFacultyDTO facultyDTO,
            @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<FacultyDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(facultyService.update(id, facultyDTO, locale));

        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        facultyService.delete(id, locale);
    }
}
