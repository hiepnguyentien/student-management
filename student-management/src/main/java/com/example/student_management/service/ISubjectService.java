package com.example.student_management.service;

import com.example.student_management.dto.Subject.AddSubjectDTO;
import com.example.student_management.dto.Subject.SubjectDTO;
import com.example.student_management.dto.Subject.UpdateSubjectDTO;

import java.util.List;
import java.util.Optional;

public interface ISubjectService {
    public List<SubjectDTO> findAll();

    public List<SubjectDTO> findByName(String name);

    public SubjectDTO findById(Long id);

    public AddSubjectDTO add(AddSubjectDTO subjectDTO);

    public UpdateSubjectDTO update(UpdateSubjectDTO subjectDTO);

    public void delete(Long id);
}
