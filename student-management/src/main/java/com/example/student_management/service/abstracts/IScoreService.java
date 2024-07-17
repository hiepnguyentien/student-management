package com.example.student_management.service.abstracts;

import com.example.student_management.dto.score.AddScoreDTO;
import com.example.student_management.dto.score.ScoreDTO;
import com.example.student_management.dto.score.UpdateScoreDTO;

import java.util.List;

public interface IScoreService {
    public List<ScoreDTO> getScoreByStudentId(Long id);

    public List<ScoreDTO> getScoreBySubjectClassId(Long id);

    public ScoreDTO getScoreBySubjectIdViaStudent(Long subjectClassId, Long studentId);

    public List<ScoreDTO> getScoreBySemesterViaStudent(Long studentId, Integer semester);

    public ScoreDTO updateScoreViaStudentAndSubjectClassId(Long scoreId, UpdateScoreDTO updateScoreDTO);

    public ScoreDTO addScoreViaStudentAndSubjectClassId(AddScoreDTO addScoreDTO);

    public void deleteScore(Long studentId, Long subjectClassId);
}
