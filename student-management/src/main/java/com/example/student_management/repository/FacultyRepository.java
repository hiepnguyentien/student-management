package com.example.student_management.repository;

import com.example.student_management.dto.faculty.FacultyDTO;
import com.example.student_management.model.Faculty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}
