package com.example.student_management.repository;

import com.example.student_management.DTO.StudentDTO;
import com.example.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<StudentDTO> findStudentByEmail(String email);
}
