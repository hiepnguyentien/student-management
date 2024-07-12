package com.example.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student_management.model.Lecturer;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long>{
    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);
}