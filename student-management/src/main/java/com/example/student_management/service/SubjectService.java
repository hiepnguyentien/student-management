package com.example.student_management.service;

import com.example.student_management.dto.subject.AddSubjectDTO;
import com.example.student_management.dto.subject.SubjectDTO;
import com.example.student_management.dto.subject.UpdateSubjectDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.model.Subject;
import com.example.student_management.repository.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService implements ISubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    private SubjectDTO convertToDTO(Subject subject) {
        return new SubjectDTO(
                subject.getSubjectId(),
                subject.getName(),
                subject.getDescription(),
                subject.getCredit());
    }

    @Override
    public List<SubjectDTO> findAll() {
        return subjectRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<SubjectDTO> findSubjectByName(String name) {
        return subjectRepository.findAll().stream()
                .filter(subject -> subject.getName().contains(name))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDTO findSubjectById(Long id) {
        return subjectRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_NOT_FOUND));
    }

    @Override
    public Optional<Subject> findSubjectByIdForService(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public AddSubjectDTO addSubject(AddSubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setName(subjectDTO.getName());
        subject.setDescription(subjectDTO.getDescription());
        subject.setCredit(subjectDTO.getCredit());
        subjectRepository.save(subject);
        return subjectDTO;
    }

    @Override
    public UpdateSubjectDTO updateSubject(UpdateSubjectDTO subjectDTO) {
        Subject subject = subjectRepository
                .findById(subjectDTO.getId()).orElseThrow(() -> new AppException(ErrorCode.SUBJECT_NOT_FOUND));
        subject.setName(subjectDTO.getName());
        subject.setDescription(subjectDTO.getDescription());
        subject.setCredit(subjectDTO.getCredit());
        subjectRepository.save(subject);
        return subjectDTO;
    }

    @Override
    public void deleteSubject(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_NOT_FOUND));
        subjectRepository.delete(subject);
    }
}
