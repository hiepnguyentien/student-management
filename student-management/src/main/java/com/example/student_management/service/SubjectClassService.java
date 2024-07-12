package com.example.student_management.service;

import com.example.student_management.dto.subjectClass.AddSubjectClassDTO;
import com.example.student_management.dto.subjectClass.SubjectClassDTO;
import com.example.student_management.dto.subjectClass.UpdateSubjectClassDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.model.Lecturer;
import com.example.student_management.model.Subject;
import com.example.student_management.model.SubjectClass;
import com.example.student_management.repository.SubjectClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectClassService implements ISubjectClassService{

    private final SubjectClassRepository subjectClassRepository;
    private final SubjectService subjectService;
    private final LecturerService lecturerService;

    @Autowired
    public SubjectClassService(SubjectClassRepository subjectClassRepository, SubjectService subjectService, LecturerService lecturerService) {
        this.subjectClassRepository = subjectClassRepository;
        this.subjectService = subjectService;
        this.lecturerService = lecturerService;
    }

    private SubjectClassDTO convertToDTO(SubjectClass subjectClass){
        return new SubjectClassDTO(
                subjectClass.getSubjectClassId(),
                subjectClass.getName(),
                subjectClass.getSubject().getSubjectId(),
                subjectClass.getLecturer().getLecturerId()
        );
    }

    @Override
    public List<SubjectClassDTO> findAll() {
        return subjectClassRepository.findAll()
        .stream().map(this::convertToDTO)
        .collect(Collectors.toList());
    }

    @Override
    public SubjectClassDTO findById(Long id) {
        return subjectClassRepository.findById(id)
        .map(this::convertToDTO)
        .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_CLASS_NOTFOUND));
    }

    @Override
    public List<SubjectClassDTO> findByName(String name) {
        return subjectClassRepository.findAll()
        .stream().map(this::convertToDTO).filter(s -> s.getName().contains(name))
        .collect(Collectors.toList());
    }

    @Override
    public UpdateSubjectClassDTO updateSubjectClass(UpdateSubjectClassDTO updateSubjectClassDTO) {
        SubjectClass subjectClass = subjectClassRepository.findById(updateSubjectClassDTO.getId())
        .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_CLASS_NOTFOUND));

        subjectClass.setName(updateSubjectClassDTO.getName());

        Subject subject = subjectService
        .findSubjectByIdForService(updateSubjectClassDTO.getSubjectId())
        .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_NOTFOUND));
        subjectClass.setSubject(subject);

        Lecturer lecturer = lecturerService
        .findLecturerByIdForService(updateSubjectClassDTO.getLecturerId())
        .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOTFOUND));
        subjectClass.setLecturer(lecturer);

        subjectClassRepository.save(subjectClass);
        return updateSubjectClassDTO;
    }

    @Override
    public AddSubjectClassDTO addSubjectClass(AddSubjectClassDTO addSubjectClassDTO) {
        SubjectClass subjectClass = new SubjectClass();
        subjectClass.setName(addSubjectClassDTO.getName());

        Subject subject = subjectService
                .findSubjectByIdForService(addSubjectClassDTO.getSubjectId())
                .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_NOTFOUND));
        subjectClass.setSubject(subject);

        Lecturer lecturer = lecturerService
                .findLecturerByIdForService(addSubjectClassDTO.getLecturerId())
                .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOTFOUND));
        subjectClass.setLecturer(lecturer);
        subjectClassRepository.save(subjectClass);

        return addSubjectClassDTO;
    }

    @Override
    public void delete(Long id) {
        SubjectClass subjectClass = subjectClassRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_CLASS_NOTFOUND));
        subjectClassRepository.delete(subjectClass);
    }
}
