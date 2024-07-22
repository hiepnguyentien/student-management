package com.example.student_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "score")
@Entity
public class Score {
    @Id
    @SequenceGenerator(name = "score_sequence", sequenceName = "score_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "score_sequence")
    @Column(name = "score_id")
    Long scoreId;
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    Float attendanceScore;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    Float midTermScore;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    Float endTermScore;
    @ManyToOne
    @JoinColumn(name = "subject_class_id")
    SubjectClass subjectClass;
    @DecimalMin(value = "1.0", inclusive = true)
    @DecimalMax(value = "3.0", inclusive = true)
    Integer semester;

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
        return Grade.fromScore(getGPA());
    }
}
