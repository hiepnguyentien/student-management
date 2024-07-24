package com.example.student_management.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<ScoreDTO> getScoreByStudentId(@PathVariable Long id, @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return scoreService.getScoreByStudentId(id, locale);
    }    

    @GetMapping("/subject-class/{id}")
    public List<ScoreDTO> getScoreBySubjectClassId(@PathVariable Long id, @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return scoreService.getScoreBySubjectClassId(id, locale);
    }

    @GetMapping("/subject-class/{subjectClassId}/student/{studentId}")
    public ScoreDTO getScoreBySubjectIdViaStudent(
            @PathVariable Long subjectClassId,
            @PathVariable Long studentId,
            @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return scoreService.getScoreBySubjectIdViaStudent(subjectClassId, studentId, locale);
    }

    @GetMapping("/semester/{semester}/student/{studentId}")
    public List<ScoreDTO> getScoreBySemesterViaStudent(
            @PathVariable Long studentId,
            @PathVariable Integer semester,
            @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return scoreService.getScoreBySemesterViaStudent(studentId, semester, locale);
    }

    @PutMapping("/id/{scoreId}")
    public ApiResponse<ScoreDTO> updateScoreViaStudentAndSubjectClassId(
            @PathVariable @Valid Long scoreId,
            @RequestBody @Valid UpdateScoreDTO updateScoreDTO,
            @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<ScoreDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(scoreService.updateScoreViaStudentAndSubjectClassId(scoreId, updateScoreDTO, locale));

        return apiResponse;
    }

    @PostMapping
    public ApiResponse<ScoreDTO> addScoreViaStudentAndSubjectClassId(
            @RequestBody @Valid AddScoreDTO addScoreDTO,
            @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<ScoreDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(scoreService.addScoreViaStudentAndSubjectClassId(addScoreDTO, locale));

        return apiResponse;
    }

    @DeleteMapping("/student/{studentId}/subject-class/{subjectClassId}")
    public void delete(
            @PathVariable Long studentId,
            @PathVariable Long subjectClassId,
            @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        scoreService.deleteScore(studentId, subjectClassId, locale);
    }
}
