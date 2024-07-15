package com.example.student_management.service;

import com.example.student_management.dto.score.AddScoreDTO;
import com.example.student_management.dto.score.ScoreDTO;
import com.example.student_management.dto.score.UpdateScoreDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.model.Score;
import com.example.student_management.repository.ScoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreService implements IScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    private ScoreDTO convertToDTO(Score score) {
        return new ScoreDTO(
                score.getScoreId(),
                score.getSubjectClass().getSubjectClassId(),
                score.getStudent().getStudentId(),
                score.getAttendanceScore(),
                score.getMidTermScore(),
                score.getEndTermScore(),
                score.getSemester(),
                score.getProcessScore(),
                score.getFinalScore(),
                score.getGPA(),
                score.getGrade().toString());
    }

    @Override
    public List<ScoreDTO> getScoreByStudentId(Long id) {
        boolean exist = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getStudent().getStudentId().equals(id));

        if (!exist) {
            throw new AppException(ErrorCode.STUDENT_NOTFOUND);
        }

        return scoreRepository.findAll()
                .stream().map(this::convertToDTO)
                .filter(s -> s.getStudentId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScoreDTO> getScoreBySubjectClassId(Long id) {
        boolean exist = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getSubjectClass().getSubjectClassId().equals(id));

        if (!exist) {
            throw new AppException(ErrorCode.SUBJECT_CLASS_NOTFOUND);
        }

        return scoreRepository.findAll()
                .stream().map(this::convertToDTO)
                .filter(s -> s.getSubjectClassId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public ScoreDTO getScoreBySubjectIdViaStudent(Long subjectClassId, Long studentId) {
        boolean existSubjectClass = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getSubjectClass().getSubjectClassId().equals(subjectClassId));

        if (!existSubjectClass) {
            throw new AppException(ErrorCode.SUBJECT_CLASS_NOTFOUND);
        }
        boolean existStudent = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getStudent().getStudentId().equals(studentId));

        if (!existStudent) {
            throw new AppException(ErrorCode.STUDENT_NOTFOUND);
        }

        return scoreRepository.findAll()
                .stream().map(this::convertToDTO)
                .filter(s -> s.getStudentId().equals(studentId) && s.getSubjectClassId().equals(subjectClassId))
                .findFirst()
                .orElseThrow(() -> new AppException(ErrorCode.SCORE_DOES_NOT_EXIST));
    }

    @Override
    public List<ScoreDTO> getScoreBySemesterViaStudent(Long studentId, Integer semester) {
        boolean existStudent = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getStudent().getStudentId().equals(studentId));

        if (!existStudent) {
            throw new AppException(ErrorCode.STUDENT_NOTFOUND);
        }

        return scoreRepository.findAll()
                .stream().map(this::convertToDTO)
                .filter(s -> s.getSemester().equals(semester))
                .collect(Collectors.toList());
    }

    @Override
    public UpdateScoreDTO updateScoreViaStudentAndSubjectClassId(UpdateScoreDTO updateScoreDTO, Long studentId,
            Long subjectClassId) {
        boolean existSubjectClass = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getSubjectClass().getSubjectClassId().equals(subjectClassId));

        if (!existSubjectClass) {
            throw new AppException(ErrorCode.SUBJECT_CLASS_NOTFOUND);
        }
        boolean existStudent = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getStudent().getStudentId().equals(studentId));

        if (!existStudent) {
            throw new AppException(ErrorCode.STUDENT_NOTFOUND);
        }

        Score score = scoreRepository.findByStudentIdAndSubjectClassId(studentId, subjectClassId);

        if (score == null) {
            throw new AppException(ErrorCode.SCORE_DOES_NOT_EXIST);
        }
        score.setAttendanceScore(updateScoreDTO.getAttendanceScore());
        score.setMidTermScore(updateScoreDTO.getMidTermScore());
        score.setEndTermScore(updateScoreDTO.getEndTermScore());

        scoreRepository.save(score);
        return updateScoreDTO;
    }

    @Override
    public AddScoreDTO addScoreViaStudentAndSubjectClassId(AddScoreDTO addScoreDTO, Long studentId,
            Long subjectClassId) {
        boolean existSubjectClass = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getSubjectClass().getSubjectClassId().equals(subjectClassId));

        if (!existSubjectClass) {
            throw new AppException(ErrorCode.SUBJECT_CLASS_NOTFOUND);
        }

        boolean existStudent = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getStudent().getStudentId().equals(studentId));

        if (!existStudent) {
            throw new AppException(ErrorCode.STUDENT_NOTFOUND);
        }

        Score score = new Score();
        score.setAttendanceScore(addScoreDTO.getAttendanceScore());
        score.setMidTermScore(addScoreDTO.getMidTermScore());
        score.setEndTermScore(addScoreDTO.getEndTermScore());
        score.setSemester(addScoreDTO.getSemester());

        scoreRepository.save(score);
        return addScoreDTO;
    }

    @Override
    public void deleteScore(Long studentId, Long subjectClassId) {
        boolean existSubjectClass = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getSubjectClass().getSubjectClassId().equals(subjectClassId));

        if (!existSubjectClass) {
            throw new AppException(ErrorCode.SUBJECT_CLASS_NOTFOUND);
        }

        boolean existStudent = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getStudent().getStudentId().equals(studentId));

        if (!existStudent) {
            throw new AppException(ErrorCode.STUDENT_NOTFOUND);
        }

        Score score = scoreRepository.findByStudentIdAndSubjectClassId(studentId, subjectClassId);

        if (score == null) {
            throw new AppException(ErrorCode.SCORE_DOES_NOT_EXIST);
        }

        scoreRepository.delete(score);
    }
}
