package com.example.student_management.service.implement;

import com.example.student_management.dto.faculty.AddNewFacultyDTO;
import com.example.student_management.dto.faculty.FacultyDTO;
import com.example.student_management.dto.faculty.UpdateFacultyDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.mapper.FacultyMapper;
import com.example.student_management.model.Faculty;
import com.example.student_management.repository.FacultyRepository;
import com.example.student_management.service.abstracts.IFacultyService;

import jakarta.transaction.Transactional;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FacultyService implements IFacultyService {
    FacultyRepository facultyRepository;
    FacultyMapper facultyMapper;

    @Override
    public List<FacultyDTO> findFacultyByName(String name) {
        return facultyRepository.findAll().stream().filter(f -> f.getFacultyName().contains(name))
                .map(facultyMapper::toFacultyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FacultyDTO> findFacultyById(Long id) {
        return facultyRepository.findById(id)
                .map(facultyMapper::toFacultyDTO);
    }

    @Override
    public List<FacultyDTO> findAll() {
        return facultyRepository.findAll()
        .stream().map(facultyMapper::toFacultyDTO)
        .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public FacultyDTO addNew(AddNewFacultyDTO addNewFacultyDTO) {
        Faculty faculty = facultyMapper.toFaculty(addNewFacultyDTO);
        facultyRepository.save(faculty);
        return facultyMapper.toFacultyDTO(faculty);
    }

    @Override
    @Transactional
    public FacultyDTO update(Long id, UpdateFacultyDTO updateFacultyDTO) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.FACULTY_NOT_FOUND));
        facultyMapper.updateFaculty(faculty, updateFacultyDTO);
        facultyRepository.save(faculty);
        return facultyMapper.toFacultyDTO(faculty);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.FACULTY_NOT_FOUND));
        facultyRepository.delete(faculty);
    }
}
