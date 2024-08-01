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

import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubjectClassService implements ISubjectClassService {
    SubjectClassRepository subjectClassRepository;
    SubjectClassMapper subjectClassMapper;
    MessageSource messageSource;

    @Override
//    @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAuthority('FIND_ALL_SUBJECT_CLASS')")
    public List<SubjectClassDTO> findAll() {
        return subjectClassRepository.findAll()
        .stream().map(subjectClassMapper::toSubjectClassDTO)
        .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasAuthority('FIND_SUBJECT_CLASS_BY_ID')")
//    @PreAuthorize("hasRole('LECTURER')")
    public SubjectClassDTO findById(Long id, Locale locale) {
        return subjectClassRepository.findById(id)
        .map(subjectClassMapper::toSubjectClassDTO)
        .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_CLASS_NOT_FOUND, messageSource, locale));
    }

    @Override
    @PreAuthorize("hasAuthority('FIND_SUBJECT_CLASS_BY_NAME')")
//    @PreAuthorize("hasRole('LECTURER')")
    public List<SubjectClassDTO> findByName(String name) {
        return subjectClassRepository.findAll()
        .stream().map(subjectClassMapper::toSubjectClassDTO).filter(s -> s.getName().contains(name))
        .collect(Collectors.toList());
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('UPDATE_SUBJECT_CLASS')")
//    @PreAuthorize("hasRole('ADMIN')")
    public SubjectClassDTO updateSubjectClass(Long id, UpdateSubjectClassDTO updateSubjectClassDTO, Locale locale) {
        SubjectClass subjectClass = subjectClassRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_CLASS_NOT_FOUND, messageSource, locale));

        subjectClassMapper.updateSubjectClass(subjectClass, updateSubjectClassDTO);
        subjectClassRepository.save(subjectClass);
        return subjectClassMapper.toSubjectClassDTO(subjectClass);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('ADD_SUBJECT_CLASS')")
//    @PreAuthorize("hasRole('ADMIN')")
    public SubjectClassDTO addSubjectClass(AddSubjectClassDTO addSubjectClassDTO) {
        boolean existSubject = subjectClassRepository.findAll().stream()
        .anyMatch(s -> s.getSubject().getSubjectId().equals(addSubjectClassDTO.getSubjectId()));
        if(!existSubject) {
            throw new AppException(ErrorCode.SUBJECT_NOT_FOUND, messageSource, Locale.getDefault());
        }

        boolean existLecturer = subjectClassRepository.findAll().stream()
        .anyMatch(l -> l.getLecturer().getLecturerId().equals(addSubjectClassDTO.getLecturerId()));
        if(!existLecturer) {
            throw new AppException(ErrorCode.LECTURER_NOT_FOUND, messageSource, Locale.getDefault());
        }

        SubjectClass subjectClass = subjectClassMapper.toSubjectClass(addSubjectClassDTO);
        subjectClassRepository.save(subjectClass);
        return subjectClassMapper.toSubjectClassDTO(subjectClass);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('DELETE_SUBJECT_CLASS')")
//    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long id, Locale locale) {
        SubjectClass subjectClass = subjectClassRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_CLASS_NOT_FOUND, messageSource, locale));
        subjectClassRepository.delete(subjectClass);
    }
}
