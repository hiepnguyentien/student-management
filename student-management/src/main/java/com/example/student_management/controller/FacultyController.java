package com.example.student_management.controller;

import com.example.student_management.dto.faculty.AddNewFacultyDTO;
import com.example.student_management.dto.faculty.FacultyDTO;
import com.example.student_management.dto.faculty.UpdateFacultyDTO;
import com.example.student_management.service.implement.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "faculty")
public class FacultyController {
    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/find-all")
    public List<FacultyDTO> findAll(){
        return facultyService.findAll();
    }

    @GetMapping("id/{id}")
    public Optional<FacultyDTO> findById(@PathVariable Long id){
        return facultyService.findFacultyById(id);
    }

    @GetMapping("name/{name}")
    public List<FacultyDTO> findByName(@PathVariable String name){
        return facultyService.findFacultyByName(name);
    }

    @PostMapping
    public void addNew(@RequestBody AddNewFacultyDTO addNewFacultyDTO){
        facultyService.addNew(addNewFacultyDTO);
    }

    @PutMapping
    public void update(@RequestBody UpdateFacultyDTO facultyDTO){
        facultyService.update(facultyDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        facultyService.delete(id);
    }
}
