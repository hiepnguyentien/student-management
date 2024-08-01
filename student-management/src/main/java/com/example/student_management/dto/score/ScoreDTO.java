package com.example.student_management.dto.score;

import com.example.student_management.enums.Grade;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class ScoreDTO {
    Long scoreId;
    Long studentId;
    Long subjectClassId;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    Float attendanceScore;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    Float midTermScore;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    Float endTermScore;
    @DecimalMin(value = "1.0", inclusive = true)
    @DecimalMax(value = "3.0", inclusive = true)
    Integer semester;
    Float processScore;
    Float finalScore;
    Float GPA;
    String grade;

    public Float getProcessScore() {
        return Math.round((getAttendanceScore() + getMidTermScore()) / 2 * 10.0f) / 10.0f;
    }

    public Float getFinalScore() {
        return Math.round((getProcessScore() * 0.3f + getEndTermScore() * 0.7f) * 10.0f) / 10.0f;
    }

    public Float getGPA(){
        float finalScore = getFinalScore();
        if (finalScore >= 8.5f)
            return 4.0f;
        else if (finalScore >= 8.0f)
            return 3.5f;
        else if (finalScore >= 7.0f)
            return 3.0f;
        else if (finalScore >= 6.5f)
            return 2.5f;
        else if (finalScore >= 5.5f)
            return 2.0f;
        else if (finalScore >= 5.0f)
            return 1.5f;
        else if (finalScore >= 4.0f)
            return 1.0f;
        else
            return 0f;
    }
    public String getGrade(){
        return Grade.fromScore(getFinalScore());
    }
}
