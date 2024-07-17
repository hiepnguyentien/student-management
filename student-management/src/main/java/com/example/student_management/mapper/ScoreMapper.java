package com.example.student_management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.student_management.dto.score.AddScoreDTO;
import com.example.student_management.dto.score.ScoreDTO;
import com.example.student_management.dto.score.UpdateScoreDTO;
import com.example.student_management.model.Score;

@Mapper(componentModel = "spring")
public interface ScoreMapper {
    @Mapping(source = "studentId", target = "student.studentId")
    @Mapping(source = "subjectClassId", target = "subjectClass.subjectClassId")
    Score toScore(AddScoreDTO addScoreDTO);

    @Mapping(source = "student.studentId", target = "studentId")
    @Mapping(source = "subjectClass.subjectClassId", target = "subjectClassId")
    ScoreDTO toScoreDTO(Score score);
    
    void updateScore(@MappingTarget Score score, UpdateScoreDTO request);
}
