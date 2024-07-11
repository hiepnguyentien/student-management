package com.example.student_management.service;

import com.example.student_management.dto.Subject.AddSubjectDTO;
import com.example.student_management.dto.Subject.SubjectDTO;
import com.example.student_management.dto.Subject.UpdateSubjectDTO;
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

    private SubjectDTO convertToDTO(Subject subject){
        return new SubjectDTO(
                subject.getSubjectId(),
                subject.getName(),
                subject.getDescription(),
                subject.getCredit()
        );
    }

    @Override
    public List<SubjectDTO> findAll() {
        return subjectRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<SubjectDTO> findByName(String name) {
        return subjectRepository.findAll().stream()
                .filter(subject -> subject.getName().contains(name))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDTO findById(Long id) {
        return subjectRepository.findById(id).map(this::convertToDTO)
                .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_NOTFOUND));
    }

    @Override
    public AddSubjectDTO add(AddSubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setName(subjectDTO.getName());
        subject.setDescription(subjectDTO.getDescription());
        subject.setCredit(subjectDTO.getCredit());
        subjectRepository.save(subject);
        return subjectDTO;
    }

    @Override
    public UpdateSubjectDTO update(UpdateSubjectDTO subjectDTO) {
        Subject subject = subjectRepository
        .findById(subjectDTO.getId()).orElseThrow(() -> new AppException(ErrorCode.SUBJECT_NOTFOUND));
        subject.setName(subjectDTO.getName());
        subject.setDescription(subjectDTO.getDescription());
        subject.setCredit(subjectDTO.getCredit());
        subjectRepository.save(subject);
        return subjectDTO;
    }

    @Override
    public void delete(Long id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.SUBJECT_NOTFOUND));
        subjectRepository.delete(subject);
    }
}
