package com.example.student_management.controller;

import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management.dto.management_class.ManagementClassDTO;
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
    public ManagementClassDTO findById(@PathVariable Long id, @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return managementClassService.findManagementClassById(id, locale);
    }
}
