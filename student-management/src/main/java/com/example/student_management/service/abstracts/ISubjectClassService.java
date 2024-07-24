package com.example.student_management.service.abstracts;

import com.example.student_management.dto.subject_class.AddSubjectClassDTO;
import com.example.student_management.dto.subject_class.SubjectClassDTO;
import com.example.student_management.dto.subject_class.UpdateSubjectClassDTO;

import java.util.List;
import java.util.Locale;

public interface ISubjectClassService {
    public List<SubjectClassDTO> findAll();

    public SubjectClassDTO findById(Long id, Locale locale);

    public List<SubjectClassDTO> findByName(String name);

    public SubjectClassDTO updateSubjectClass(Long id, UpdateSubjectClassDTO updateSubjectClassDTO, Locale locale);

    public SubjectClassDTO addSubjectClass(AddSubjectClassDTO addSubjectClassDTO);

    public void delete(Long id, Locale locale);
}
