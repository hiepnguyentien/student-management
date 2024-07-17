package com.example.student_management.service.abstracts;

import com.example.student_management.dto.faculty.AddNewFacultyDTO;
import com.example.student_management.dto.faculty.FacultyDTO;
import com.example.student_management.dto.faculty.UpdateFacultyDTO;

import java.util.List;
import java.util.Optional;

public interface IFacultyService {
    public List<FacultyDTO> findFacultyByName(String name);

    public Optional<FacultyDTO> findFacultyById(Long id);

    public List<FacultyDTO> findAll();

    public FacultyDTO addNew(AddNewFacultyDTO input);

    public FacultyDTO update(Long id, UpdateFacultyDTO updateFacultyDTO);

    public void delete(Long id);
}
