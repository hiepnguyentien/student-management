package com.example.student_management.service;

import com.example.student_management.dto.Subject.SubjectDTO;

import java.util.List;
import java.util.Optional;

public interface ISubjectService {
    public List<SubjectDTO> findAll();

    public List<SubjectDTO> findByName(String name);

    public Optional<SubjectDTO> findById(Long id);


}
