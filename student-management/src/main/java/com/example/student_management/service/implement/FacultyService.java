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

import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FacultyService implements IFacultyService {
    FacultyRepository facultyRepository;
    FacultyMapper facultyMapper;
    MessageSource messageSource;

    @Override
    public List<FacultyDTO> findFacultyByName(String name) {
        return facultyRepository.findAll().stream().filter(f -> f.getFacultyName().contains(name))
                .map(facultyMapper::toFacultyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FacultyDTO findFacultyById(Long id, Locale locale) {
        return facultyRepository.findById(id)
                .map(facultyMapper::toFacultyDTO)
                .orElseThrow(() -> new AppException(ErrorCode.FACULTY_NOT_FOUND, messageSource, locale));
    }

    @Override
    public List<FacultyDTO> findAll() {
        return facultyRepository.findAll()
        .stream().map(facultyMapper::toFacultyDTO)
        .collect(Collectors.toList());
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public FacultyDTO addNew(AddNewFacultyDTO addNewFacultyDTO) {
        Faculty faculty = facultyMapper.toFaculty(addNewFacultyDTO);
        facultyRepository.save(faculty);
        return facultyMapper.toFacultyDTO(faculty);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public FacultyDTO update(Long id, UpdateFacultyDTO updateFacultyDTO, Locale locale) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.FACULTY_NOT_FOUND, messageSource, locale));
        facultyMapper.updateFaculty(faculty, updateFacultyDTO);
        facultyRepository.save(faculty);
        return facultyMapper.toFacultyDTO(faculty);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long id, Locale locale) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.FACULTY_NOT_FOUND, messageSource, locale));
        facultyRepository.delete(faculty);
    }
}
