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
import com.example.student_management.service.abstracts.IScoreService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/score")
public class ScoreController {
    
    private final IScoreService scoreService;

    @Autowired
    public ScoreController(IScoreService scoreService) {
        this.scoreService = scoreService;
    }

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

    @PutMapping("/student/{studentId}/subject-class/{subjectClassId}")
    public ApiResponse<UpdateScoreDTO> updateScoreViaStudentAndSubjectClassId(
            @RequestBody @Valid UpdateScoreDTO updateScoreDTO,
            @PathVariable @Valid Long studentId,
            @PathVariable @Valid Long subjectClassId) {
        ApiResponse<UpdateScoreDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(scoreService.updateScoreViaStudentAndSubjectClassId(updateScoreDTO, studentId, subjectClassId));

        return apiResponse;
    }

    @PostMapping("/student/{studentId}/subject-class/{subjectClassId}")
    public ApiResponse<AddScoreDTO> addScoreViaStudentAndSubjectClassId(
            @RequestBody @Valid AddScoreDTO addScoreDTO,
            @PathVariable Long studentId,
            @PathVariable Long subjectClassId) {
        ApiResponse<AddScoreDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(scoreService.addScoreViaStudentAndSubjectClassId(addScoreDTO, studentId, subjectClassId));

        return apiResponse;
    }

    @DeleteMapping("/student/{studentId}/subject-class/{subjectClassId}")
    public void delete(
            @PathVariable Long studentId,
            @PathVariable Long subjectClassId) {
        scoreService.deleteScore(studentId, subjectClassId);
    }
}
