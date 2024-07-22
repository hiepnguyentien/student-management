package com.example.student_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management.model.ManagementClass;
import com.example.student_management.service.implement.ManagementClassService;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@RestController
@RequestMapping(path = "management")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ManagementClassController {
    ManagementClassService managementClassService;

    // @GetMapping("/find-all")
    // public List<ManagementClassDTO> findAllManagementClass() {
    //     return managementClassService.findAll();
    // }

    @GetMapping("id/{id}")
    public ManagementClass findById(@PathVariable Long id){
        return managementClassService.findManagementClassById(id);
    }
}
