package com.example.student_management.service.implement;

import com.example.student_management.dto.subject.AddSubjectDTO;
import com.example.student_management.dto.subject.SubjectDTO;
import com.example.student_management.dto.subject.UpdateSubjectDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.mapper.SubjectMapper;
import com.example.student_management.model.Subject;
import com.example.student_management.repository.SubjectRepository;

import com.example.student_management.service.abstracts.ISubjectService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SubjectService implements ISubjectService {
    SubjectRepository subjectRepository;
    SubjectMapper subjectMapper;

    @Override
    public List<SubjectDTO> findAll() {
        return subjectRepository.findAll().stream()
                .map(subjectMapper::toSubjectDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubjectDTO> findSubjectByName(String name) {
        return subjectRepository.findAll().stream()
                .filter(subject -> subject.getName().contains(name))
                .map(subjectMapper::toSubjectDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDTO findSubjectById(Long id) {
        return subjectRepository.findById(id)
                .map(subjectMapper::toSubjectDTO)
                .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_NOT_FOUND));
    }

    @Override
    public Optional<Subject> findSubjectByIdForService(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    @Transactional
    public SubjectDTO addSubject(AddSubjectDTO subjectDTO) {
        Subject subject = subjectMapper.toSubject(subjectDTO);
        subjectRepository.save(subject);
        return subjectMapper.toSubjectDTO(subject);
    }

    @Override
    @Transactional
    public SubjectDTO updateSubject(Long id, UpdateSubjectDTO subjectDTO) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_NOT_FOUND));
        subjectMapper.updateSubject(subject, subjectDTO);
        subjectRepository.save(subject);
        return subjectMapper.toSubjectDTO(subject);
    }

    @Override
    @Transactional
    public void deleteSubject(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_NOT_FOUND));
        subjectRepository.delete(subject);
    }
}
