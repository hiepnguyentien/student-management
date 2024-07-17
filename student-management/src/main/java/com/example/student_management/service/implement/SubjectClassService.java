package com.example.student_management.service.implement;

import com.example.student_management.dto.subject_class.AddSubjectClassDTO;
import com.example.student_management.dto.subject_class.SubjectClassDTO;
import com.example.student_management.dto.subject_class.UpdateSubjectClassDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.mapper.SubjectClassMapper;
import com.example.student_management.model.SubjectClass;
import com.example.student_management.repository.SubjectClassRepository;
import com.example.student_management.service.abstracts.ISubjectClassService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubjectClassService implements ISubjectClassService {

    SubjectClassRepository subjectClassRepository;
    SubjectClassMapper subjectClassMapper;

    @Override
    public List<SubjectClassDTO> findAll() {
        return subjectClassRepository.findAll()
        .stream().map(subjectClassMapper::toSubjectClassDTO)
        .collect(Collectors.toList());
    }

    @Override
    public SubjectClassDTO findById(Long id) {
        return subjectClassRepository.findById(id)
        .map(subjectClassMapper::toSubjectClassDTO)
        .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_CLASS_NOT_FOUND));
    }

    @Override
    public List<SubjectClassDTO> findByName(String name) {
        return subjectClassRepository.findAll()
        .stream().map(subjectClassMapper::toSubjectClassDTO).filter(s -> s.getName().contains(name))
        .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public SubjectClassDTO updateSubjectClass(Long id, UpdateSubjectClassDTO updateSubjectClassDTO) {
        SubjectClass subjectClass = subjectClassRepository.findById(updateSubjectClassDTO.getId())
        .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_CLASS_NOT_FOUND));

        subjectClassMapper.updateSubjectClass(subjectClass, updateSubjectClassDTO);
        subjectClassRepository.save(subjectClass);
        return subjectClassMapper.toSubjectClassDTO(subjectClass);
    }

    @Override
    @Transactional
    public SubjectClassDTO addSubjectClass(AddSubjectClassDTO addSubjectClassDTO) {
        boolean existSubject = subjectClassRepository.findAll().stream()
        .anyMatch(s -> s.getSubject().getSubjectId().equals(addSubjectClassDTO.getSubjectId()));
        if(!existSubject) {
            throw new AppException(ErrorCode.SUBJECT_NOT_FOUND);
        }

        boolean existLecturer = subjectClassRepository.findAll().stream()
        .anyMatch(l -> l.getLecturer().getLecturerId().equals(addSubjectClassDTO.getLecturerId()));
        if(!existLecturer) {
            throw new AppException(ErrorCode.LECTURER_NOT_FOUND);
        }

        SubjectClass subjectClass = subjectClassMapper.toSubjectClass(addSubjectClassDTO);
        subjectClassRepository.save(subjectClass);
        return subjectClassMapper.toSubjectClassDTO(subjectClass);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        SubjectClass subjectClass = subjectClassRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_CLASS_NOT_FOUND));
        subjectClassRepository.delete(subjectClass);
    }
}
