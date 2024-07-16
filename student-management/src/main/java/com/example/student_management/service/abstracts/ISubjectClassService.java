package com.example.student_management.service.abstracts;

import com.example.student_management.dto.subject_class.AddSubjectClassDTO;
import com.example.student_management.dto.subject_class.SubjectClassDTO;
import com.example.student_management.dto.subject_class.UpdateSubjectClassDTO;
import com.example.student_management.model.SubjectClass;

import java.util.List;
import java.util.Optional;

public interface ISubjectClassService {
    public List<SubjectClassDTO> findAll();

    public SubjectClassDTO findById(Long id);

    public Optional<SubjectClass> findByIdForService(Long id);

    public List<SubjectClassDTO> findByName(String name);

    public UpdateSubjectClassDTO updateSubjectClass(UpdateSubjectClassDTO updateSubjectClassDTO);

    public AddSubjectClassDTO addSubjectClass(AddSubjectClassDTO addSubjectClassDTO);

    public void delete(Long id);
}
