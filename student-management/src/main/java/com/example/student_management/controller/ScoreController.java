package com.example.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.score.AddScoreDTO;
import com.example.student_management.dto.score.ScoreDTO;
import com.example.student_management.dto.score.UpdateScoreDTO;
import com.example.student_management.service.implement.ScoreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/score")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class ScoreController {
    ScoreService scoreService;

    @GetMapping("/student/{id}")
    public List<ScoreDTO> getScoreByStudentId(@PathVariable Long id) {
        return scoreService.getScoreByStudentId(id);
    }    

    @GetMapping("/subject-class/{id}")
    public List<ScoreDTO> getScoreBySubjectClassId(@PathVariable Long id) {
        return scoreService.getScoreBySubjectClassId(id);
    }

    @GetMapping("/subject-class/{subjectClassId}/student/{studentId}")
    public ScoreDTO getScoreBySubjectIdViaStudent(
            @PathVariable Long subjectClassId,
            @PathVariable Long studentId) {
        return scoreService.getScoreBySubjectIdViaStudent(subjectClassId, studentId);
    }

    @GetMapping("/semester/{semester}/student/{studentId}")
    public List<ScoreDTO> getScoreBySemesterViaStudent(
            @PathVariable Long studentId,
            @PathVariable Integer semester) {
        return scoreService.getScoreBySemesterViaStudent(studentId, semester);
    }

    @PutMapping("/id/{scoreId}")
    public ApiResponse<ScoreDTO> updateScoreViaStudentAndSubjectClassId(
            @PathVariable @Valid Long scoreId,
            @RequestBody @Valid UpdateScoreDTO updateScoreDTO) {
        ApiResponse<ScoreDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(scoreService.updateScoreViaStudentAndSubjectClassId(scoreId, updateScoreDTO));

        return apiResponse;
    }

    @PostMapping
    public ApiResponse<ScoreDTO> addScoreViaStudentAndSubjectClassId(
            @RequestBody @Valid AddScoreDTO addScoreDTO) {
        ApiResponse<ScoreDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(scoreService.addScoreViaStudentAndSubjectClassId(addScoreDTO));

        return apiResponse;
    }

    @DeleteMapping("/student/{studentId}/subject-class/{subjectClassId}")
    public void delete(
            @PathVariable Long studentId,
            @PathVariable Long subjectClassId) {
        scoreService.deleteScore(studentId, subjectClassId);
    }
}
