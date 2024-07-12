package com.example.student_management.repository;

import com.example.student_management.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    @Query("SELECT s FROM Score s WHERE s.student.id = ?1 AND s.subjectClass.id = ?2")
    Score findByStudentIdAndSubjectClassId(Long studentId, Long subjectClassId);
}
