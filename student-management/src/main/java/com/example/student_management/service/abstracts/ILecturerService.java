package com.example.student_management.service.abstracts;

import com.example.student_management.dto.lecturer.AddLecturerDTO;
import com.example.student_management.dto.lecturer.LecturerDTO;
import com.example.student_management.dto.lecturer.UpdateLecturerDTO;

import java.util.List;
import java.util.Locale;

public interface ILecturerService {
    public List<LecturerDTO> findAll();

    public LecturerDTO findLecturerById(Long id, Locale locale);

    public List<LecturerDTO> findLecturerByName(String name);

    public List<LecturerDTO> findLecturerByFacultyId(Long id, Locale locale);

    public LecturerDTO findLecturerByManagementClassId(Long id, Locale locale);

    public LecturerDTO updateLecturer(Long id, UpdateLecturerDTO updateLecturerDTO, Locale locale);

    public LecturerDTO addLecturer(AddLecturerDTO addLecturerDTO, Locale locale);

    public void deleteLecturer(Long id, Locale locale);
}
