package com.example.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.student_management.model.Lecturer;
import com.example.student_management.model.Subject;
import com.example.student_management.model.SubjectClass;

@Repository
public interface SubjectClassRepository extends JpaRepository<SubjectClass, Long>{
    @Query("SELECT s FROM Lecturer s WHERE s.lecturerId = ?1")
    Lecturer findLecturerById(Long lecturerId);

    @Query("SELECT s FROM Subject s WHERE s.subjectId = ?1")
    Subject findSubjectById(Long subjectId);
}
