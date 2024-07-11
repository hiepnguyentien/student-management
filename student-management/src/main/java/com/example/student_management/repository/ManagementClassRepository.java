package com.example.student_management.repository;

import com.example.student_management.model.ManagementClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementClassRepository extends JpaRepository<ManagementClass, Long>{
    
}
