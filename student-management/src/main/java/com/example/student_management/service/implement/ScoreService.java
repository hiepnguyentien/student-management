package com.example.student_management.service.implement;

import com.example.student_management.dto.score.AddScoreDTO;
import com.example.student_management.dto.score.ScoreDTO;
import com.example.student_management.dto.score.UpdateScoreDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.mapper.ScoreMapper;
import com.example.student_management.model.Score;
import com.example.student_management.repository.ScoreRepository;

import com.example.student_management.service.abstracts.IScoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ScoreService implements IScoreService {

    ScoreRepository scoreRepository;
    ScoreMapper scoreMapper;
    MessageSource messageSource;

    @Override
    public List<ScoreDTO> getScoreByStudentId(Long id, Locale locale) {
        boolean exist = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getStudent().getStudentId().equals(id));

        if (!exist) {
            throw new AppException(ErrorCode.STUDENT_NOT_FOUND, messageSource, locale);
        }

        return scoreRepository.findAll()
                .stream().map(scoreMapper::toScoreDTO)
                .filter(s -> s.getStudentId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScoreDTO> getScoreBySubjectClassId(Long id, Locale locale) {
        boolean exist = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getSubjectClass().getSubjectClassId().equals(id));

        if (!exist) {
            throw new AppException(ErrorCode.SUBJECT_CLASS_NOT_FOUND, messageSource, locale);
        }

        return scoreRepository.findAll()
                .stream().map(scoreMapper::toScoreDTO)
                .filter(s -> s.getSubjectClassId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public ScoreDTO getScoreBySubjectIdViaStudent(Long subjectClassId, Long studentId, Locale locale) {
        boolean existSubjectClass = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getSubjectClass().getSubjectClassId().equals(subjectClassId));

        if (!existSubjectClass) {
            throw new AppException(ErrorCode.SUBJECT_CLASS_NOT_FOUND, messageSource, locale);
        }
        boolean existStudent = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getStudent().getStudentId().equals(studentId));

        if (!existStudent) {
            throw new AppException(ErrorCode.STUDENT_NOT_FOUND, messageSource, locale);
        }

        return scoreRepository.findAll()
                .stream().map(scoreMapper::toScoreDTO)
                .filter(s -> s.getStudentId().equals(studentId) && s.getSubjectClassId().equals(subjectClassId))
                .findFirst()
                .orElseThrow(() -> new AppException(ErrorCode.SCORE_DOES_NOT_EXIST, messageSource, locale));
    }

    @Override
    public List<ScoreDTO> getScoreBySemesterViaStudent(Long studentId, Integer semester, Locale locale) {
        boolean existStudent = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getStudent().getStudentId().equals(studentId));

        if (!existStudent) {
            throw new AppException(ErrorCode.STUDENT_NOT_FOUND, messageSource, locale);
        }

        return scoreRepository.findAll()
                .stream().map(scoreMapper::toScoreDTO)
                .filter(s -> s.getSemester().equals(semester))
                .collect(Collectors.toList());
    }

    private boolean isFlunked(Score score) {
        return score.getFinalScore() < 4;
    }

    @Override
    @Transactional
    public ScoreDTO updateScoreViaStudentAndSubjectClassId(Long scoreId, UpdateScoreDTO updateScoreDTO, Locale locale) {
        boolean existSubjectClass = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getSubjectClass().getSubjectClassId().equals(updateScoreDTO.getSubjectClassId()));

        if (!existSubjectClass) {
            throw new AppException(ErrorCode.SUBJECT_CLASS_NOT_FOUND, messageSource, locale);
        }
        boolean existStudent = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getStudent().getStudentId().equals(updateScoreDTO.getStudentId()));

        if (!existStudent) {
            throw new AppException(ErrorCode.STUDENT_NOT_FOUND, messageSource, locale);
        }
        Score score = scoreRepository.findById(scoreId)
                .orElseThrow(() -> new AppException(ErrorCode.SCORE_DOES_NOT_EXIST, messageSource, locale));

        scoreMapper.updateScore(score, updateScoreDTO);
        scoreRepository.save(score);
        return scoreMapper.toScoreDTO(score);
    }

    @Override
    @Transactional
    public ScoreDTO addScoreViaStudentAndSubjectClassId(AddScoreDTO addScoreDTO, Locale locale) {
        boolean existSubjectClass = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getSubjectClass()
                .getSubjectClassId().equals(addScoreDTO.getSubjectClassId()));

        if (!existSubjectClass) {
            throw new AppException(ErrorCode.SUBJECT_CLASS_NOT_FOUND, messageSource, locale);
        }

        boolean existStudent = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getStudent().getStudentId().equals(addScoreDTO.getStudentId()));

        if (!existStudent) {
            throw new AppException(ErrorCode.STUDENT_NOT_FOUND, messageSource, locale);
        }

        Score score1 = scoreRepository.findByStudentIdAndSubjectClassId(addScoreDTO.getStudentId(), addScoreDTO.getSubjectClassId());
        if (score1 != null) {
            if (!isFlunked(score1)) {
                throw new AppException(ErrorCode.SCORE_FOUND, messageSource, locale);
            }
        }
        
        Score score = scoreMapper.toScore(addScoreDTO);
        scoreRepository.save(score);
        return scoreMapper.toScoreDTO(score);
    }

    @Override
    @Transactional
    public void deleteScore(Long studentId, Long subjectClassId, Locale locale) {
        boolean existSubjectClass = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getSubjectClass().getSubjectClassId().equals(subjectClassId));

        if (!existSubjectClass) {
            throw new AppException(ErrorCode.SUBJECT_CLASS_NOT_FOUND, messageSource, locale);
        }

        boolean existStudent = scoreRepository.findAll().stream()
                .anyMatch(s -> s.getStudent().getStudentId().equals(studentId));

        if (!existStudent) {
            throw new AppException(ErrorCode.STUDENT_NOT_FOUND, messageSource, locale);
        }

        Score score = scoreRepository.findByStudentIdAndSubjectClassId(studentId, subjectClassId);

        if (score == null) {
            throw new AppException(ErrorCode.SCORE_DOES_NOT_EXIST, messageSource, locale);
        }

        scoreRepository.delete(score);
    }
}
