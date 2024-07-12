package com.example.student_management.service;

import com.example.student_management.dto.lecturer.AddLecturerDTO;
import com.example.student_management.dto.lecturer.LecturerDTO;
import com.example.student_management.dto.lecturer.UpdateLecturerDTO;
import com.example.student_management.model.Lecturer;

import java.util.List;
import java.util.Optional;

public interface ILecturerService {
    public List<LecturerDTO> findAll();

    public LecturerDTO findLecturerById(Long id);

    public List<LecturerDTO> findLecturerByName(String name);

    public List<LecturerDTO> findLecturerByFacultyId(Long id);

    public Optional<Lecturer> findLecturerByIdForService(Long id);

    public LecturerDTO findLecturerByManagementClassId(Long id);

    public UpdateLecturerDTO updateLecturer(UpdateLecturerDTO updateLecturerDTO);

    public AddLecturerDTO addLecturer(AddLecturerDTO addLecturerDTO);

    public void deleteLecturer(Long id);
}
