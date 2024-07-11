package com.example.student_management.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management.dto.managementClass.ManagementClassDTO;
import com.example.student_management.service.ManagementClassService;

@RestController
@RequestMapping(path = "management")
public class ManagementClassController {
    private final ManagementClassService managementClassService;

    @Autowired
    public ManagementClassController(ManagementClassService managementClassService) {
        this.managementClassService = managementClassService;
    }

    // @GetMapping("/find-all")
    // public List<ManagementClassDTO> findAllManagementClass() {
    //     return managementClassService.findAll();
    // }

    @GetMapping("id/{id}")
    public Optional<ManagementClassDTO> findById(@PathVariable Long id){
        Optional<ManagementClassDTO> managementClass = managementClassService.findManagementClassById(id);
        return managementClass;
    }
}
