package com.example.student_management.service.implement;

import com.example.student_management.dto.lecturer.AddLecturerDTO;
import com.example.student_management.dto.lecturer.LecturerDTO;
import com.example.student_management.dto.lecturer.UpdateLecturerDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.mapper.LecturerMapper;
import com.example.student_management.model.Lecturer;
import com.example.student_management.repository.LecturerRepository;
import com.example.student_management.service.abstracts.ILecturerService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LecturerService implements ILecturerService {
    LecturerRepository lecturerRepository;
    LecturerMapper lecturerMapper;

    @Override
    public List<LecturerDTO> findAll() {
        return lecturerRepository.findAll().stream()
                .map(lecturerMapper::toLecturerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LecturerDTO findLecturerById(Long id) {
        return lecturerMapper.toLecturerDTO(lecturerRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOT_FOUND)));
    }

    @Override
    public List<LecturerDTO> findLecturerByName(String name) {
        return lecturerRepository.findAll()
                .stream()
                .filter(l -> l.getFirstName().contains(name) || l.getLastName().contains(name))
                .map(lecturerMapper::toLecturerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LecturerDTO> findLecturerByFacultyId(Long id) {
        boolean isExist = lecturerRepository.findAll().stream()
                .anyMatch(lecturer -> lecturer.getFacultyId().equals(id));

        if (!isExist) {
            throw new AppException(ErrorCode.FACULTY_NOT_FOUND);
        }

        return lecturerRepository.findAll().stream()
                .map(lecturerMapper::toLecturerDTO)
                .filter(lecturer -> lecturer.getFacultyId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public LecturerDTO findLecturerByManagementClassId(Long id) {
        boolean isExist = lecturerRepository.findAll().stream()
                .anyMatch(lecturer -> lecturer.getManagementClass().getManagementClassId().equals(id));

        if (!isExist) {
            throw new AppException(ErrorCode.MANAGEMENT_CLASS_NOT_FOUND);
        }

        return lecturerRepository.findAll().stream()
                .map(lecturerMapper::toLecturerDTO)
                .filter(lecturer -> lecturer.getManagementClassId().equals(id))
                .findFirst()
                .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOT_FOUND));
    }

    @Override
    @Transactional
    public LecturerDTO updateLecturer(Long id, UpdateLecturerDTO updateLecturerDTO) {
        Lecturer lecturer = lecturerRepository.findById(updateLecturerDTO.id)
                .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOT_FOUND));
                
        boolean isExist = lecturerRepository.findAll().stream()
                .anyMatch(
                        l -> l.getManagementClass().getManagementClassId().equals(updateLecturerDTO.managementClassId));

        if (!lecturer.getManagementClass().getManagementClassId().equals(updateLecturerDTO.managementClassId) 
        || !lecturer.getLecturerId().equals(id)
        && isExist ) {
            throw new AppException(ErrorCode.ANOTHER_LECTURER_IN_MANAGEMENT_CLASS);
        }

        lecturerMapper.updateLecturer(lecturer, updateLecturerDTO);

        lecturerRepository.save(lecturer);

        return lecturerMapper.toLecturerDTO(lecturer);
    }

    @Override
    @Transactional
    public LecturerDTO addLecturer(AddLecturerDTO addLecturerDTO) {
        if (lecturerRepository.existsByEmail(addLecturerDTO.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        if (lecturerRepository.existsByPhoneNumber(addLecturerDTO.getPhoneNumber())) {
            throw new AppException(ErrorCode.PHONE_NUMBER_ALREADY_EXISTS);
        }
        Lecturer lecturer = lecturerMapper.toLecturer(addLecturerDTO);
        lecturerRepository.save(lecturer);
        return lecturerMapper.toLecturerDTO(lecturer);
    }

    @Override
    @Transactional
    public void deleteLecturer(Long id) {
        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOT_FOUND));
        lecturerRepository.delete(lecturer);
    }
}
