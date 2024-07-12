package com.example.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student_management.model.SubjectClass;

@Repository
public interface SubjectClassRepository extends JpaRepository<SubjectClass, Long>{
    
}
