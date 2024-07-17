package com.example.student_management.service.abstracts;

import java.util.List;
import java.util.Optional;

import com.example.student_management.dto.subject.AddSubjectDTO;
import com.example.student_management.dto.subject.SubjectDTO;
import com.example.student_management.dto.subject.UpdateSubjectDTO;
import com.example.student_management.model.Subject;

public interface ISubjectService {
    public List<SubjectDTO> findAll();

    public List<SubjectDTO> findSubjectByName(String name);

    public SubjectDTO findSubjectById(Long id);

    public Optional<Subject> findSubjectByIdForService(Long id);

    public SubjectDTO addSubject(AddSubjectDTO subjectDTO);

    public SubjectDTO updateSubject(Long id, UpdateSubjectDTO subjectDTO);

    public void deleteSubject(Long id);
}
