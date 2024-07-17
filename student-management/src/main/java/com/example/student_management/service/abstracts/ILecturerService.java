package com.example.student_management.service.abstracts;

import com.example.student_management.dto.lecturer.AddLecturerDTO;
import com.example.student_management.dto.lecturer.LecturerDTO;
import com.example.student_management.dto.lecturer.UpdateLecturerDTO;

import java.util.List;

public interface ILecturerService {
    public List<LecturerDTO> findAll();

    public LecturerDTO findLecturerById(Long id);

    public List<LecturerDTO> findLecturerByName(String name);

    public List<LecturerDTO> findLecturerByFacultyId(Long id);

    public LecturerDTO findLecturerByManagementClassId(Long id);

    public LecturerDTO updateLecturer(Long id, UpdateLecturerDTO updateLecturerDTO);

    public LecturerDTO addLecturer(AddLecturerDTO addLecturerDTO);

    public void deleteLecturer(Long id);
}
