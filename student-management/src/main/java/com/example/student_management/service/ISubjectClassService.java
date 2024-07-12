package com.example.student_management.service;

import com.example.student_management.dto.subjectClass.AddSubjectClassDTO;
import com.example.student_management.dto.subjectClass.SubjectClassDTO;
import com.example.student_management.dto.subjectClass.UpdateSubjectClassDTO;

import java.util.List;

public interface ISubjectClassService {
    public List<SubjectClassDTO> findAll();

    public SubjectClassDTO findById(Long id);

    public List<SubjectClassDTO> findByName(String name);

    public UpdateSubjectClassDTO updateSubjectClass(UpdateSubjectClassDTO updateSubjectClassDTO);

    public AddSubjectClassDTO addSubjectClass(AddSubjectClassDTO addSubjectClassDTO);

    public void delete(Long id);
}
