package com.example.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.student_management.model.Lecturer;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long>{
    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<Lecturer> findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO lecturer_role (lecturer_id, role_name) VALUES (?1, ?2)", nativeQuery = true)
    void insertLecturerRole(Long lecturerId, String roleName);
}
