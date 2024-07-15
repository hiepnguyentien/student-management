package com.example.student_management.service;

import com.example.student_management.dto.faculty.AddNewFacultyDTO;
import com.example.student_management.dto.faculty.FacultyDTO;
import com.example.student_management.dto.faculty.UpdateFacultyDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.model.Faculty;
import com.example.student_management.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyService implements IFacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    private FacultyDTO convertToDTO(Faculty faculty) {
        return new FacultyDTO(
                faculty.getFacultyId(),
                faculty.getFacultyName());
    }
    
    @Override
    public List<FacultyDTO> findFacultyByName(String name) {
        return facultyRepository.findAll().stream().filter(f -> f.getFacultyName().contains(name))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FacultyDTO> findFacultyById(Long id) {
        return facultyRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public List<FacultyDTO> findAll() {
        return facultyRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Faculty addNew(AddNewFacultyDTO addNewFacultyDTO) {
        Faculty faculty = new Faculty();
        faculty.setFacultyName(addNewFacultyDTO.getName());
        return facultyRepository.save(faculty);
    }

    @Override
    public void update(UpdateFacultyDTO updateFacultyDTO) {
        Faculty faculty = facultyRepository.findById(updateFacultyDTO.getId()).orElseThrow();
        faculty.setFacultyName(updateFacultyDTO.getName());
        facultyRepository.save(faculty);
    }

    @Override
    public void delete(Long id) {
        Faculty faculty = facultyRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.FACULTY_NOTFOUND));
        facultyRepository.delete(faculty);
    }
}
