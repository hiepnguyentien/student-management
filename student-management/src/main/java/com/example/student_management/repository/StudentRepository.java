package com.example.student_management.repository;

import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    StudentDTO findStudentByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 OR s.lastName = ?1")
    List<StudentDTO> findStudentByName(String name);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);
}
