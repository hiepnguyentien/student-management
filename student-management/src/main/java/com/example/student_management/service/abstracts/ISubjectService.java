package com.example.student_management.service.abstracts;

import java.util.List;
import java.util.Locale;

import com.example.student_management.dto.subject.AddSubjectDTO;
import com.example.student_management.dto.subject.SubjectDTO;
import com.example.student_management.dto.subject.UpdateSubjectDTO;

public interface ISubjectService {
    public List<SubjectDTO> findAll();

    public List<SubjectDTO> findSubjectByName(String name);

    public SubjectDTO findSubjectById(Long id, Locale locale);

    public SubjectDTO addSubject(AddSubjectDTO subjectDTO, Locale locale);

    public SubjectDTO updateSubject(Long id, UpdateSubjectDTO subjectDTO, Locale locale);

    public void deleteSubject(Long id, Locale locale);
}
