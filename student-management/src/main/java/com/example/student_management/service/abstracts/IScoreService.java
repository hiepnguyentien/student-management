package com.example.student_management.service.abstracts;

import com.example.student_management.dto.score.AddScoreDTO;
import com.example.student_management.dto.score.ScoreDTO;
import com.example.student_management.dto.score.UpdateScoreDTO;

import java.util.List;
import java.util.Locale;

public interface IScoreService {
    public List<ScoreDTO> getScoreByStudentId(Long id, Locale locale);

    public List<ScoreDTO> getScoreBySubjectClassId(Long id, Locale locale);

    public ScoreDTO getScoreBySubjectClassIdViaStudent(Long subjectClassId, Long studentId, Locale locale);

    public List<ScoreDTO> getScoreBySemesterViaStudent(Long studentId, Integer semester, Locale locale);

    public ScoreDTO updateScoreViaStudentAndSubjectClassId(Long scoreId, UpdateScoreDTO updateScoreDTO, Locale locale);

    public ScoreDTO addScoreViaStudentAndSubjectClassId(AddScoreDTO addScoreDTO, Locale locale);

    public void deleteScore(Long studentId, Long subjectClassId, Locale locale);
}
