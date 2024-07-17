package com.example.student_management.service.abstracts;

import com.example.student_management.dto.subject_class.AddSubjectClassDTO;
import com.example.student_management.dto.subject_class.SubjectClassDTO;
import com.example.student_management.dto.subject_class.UpdateSubjectClassDTO;

import java.util.List;

public interface ISubjectClassService {
    public List<SubjectClassDTO> findAll();

    public SubjectClassDTO findById(Long id);

    public List<SubjectClassDTO> findByName(String name);

    public SubjectClassDTO updateSubjectClass(Long id, UpdateSubjectClassDTO updateSubjectClassDTO);

    public SubjectClassDTO addSubjectClass(AddSubjectClassDTO addSubjectClassDTO);

    public void delete(Long id);
}
