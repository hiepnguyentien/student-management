package com.example.student_management.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "management_class")
@Entity(name = "management_class")
public class ManagementClass {
    @Id
    private Long managementClassId;
    @Column(
        nullable = false,
        unique = true
        )
    private String name;
    @Column(nullable = false)
    private Long facultyId;
    @Column(nullable = false)
    private Long lecturerId;
}
