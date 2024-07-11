package com.example.student_management.service;

import com.example.student_management.dto.Subject.SubjectDTO;
import com.example.student_management.model.Subject;
import com.example.student_management.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService implements ISubjectService {

    private final SubjectRepository subjectRepository;

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
        return List.of();
    }

    @Override
    public Optional<SubjectDTO> findById(Long id) {
        return Optional.empty();
    }
}
