package com.example.student_management.service;

import com.example.student_management.dto.score.AddScoreDTO;
import com.example.student_management.dto.score.ScoreDTO;
import com.example.student_management.dto.score.UpdateScoreDTO;

import java.util.List;

public interface IScoreService {
    public List<ScoreDTO> getScoreByStudentId(Long id);

    public List<ScoreDTO> getScoreBySubjectClassId(Long id);

    public ScoreDTO getScoreBySubjectIdViaStudent(Long subjectClassId, Long studentId);

    public List<ScoreDTO> getScoreBySemesterViaStudent(Long studentId, Integer semester);

    public UpdateScoreDTO updateScoreViaStudentAndSubjectClassId(UpdateScoreDTO updateScoreDTO, Long studentId, Long subjectClassId);

    public AddScoreDTO addScoreViaStudentAndSubjectClassId(AddScoreDTO addScoreDTO, Long studentId, Long subjectClassId);

    public void deleteScore(Long studentId, Long subjectClassId);
}
