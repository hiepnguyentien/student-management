package com.example.student_management.mapper;

import com.example.student_management.dto.score.AddScoreDTO;
import com.example.student_management.dto.score.ScoreDTO;
import com.example.student_management.dto.score.UpdateScoreDTO;
import com.example.student_management.model.Score;
import com.example.student_management.model.Student;
import com.example.student_management.model.SubjectClass;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class ScoreMapperImpl implements ScoreMapper {

    @Override
    public Score toScore(AddScoreDTO addScoreDTO) {
        if ( addScoreDTO == null ) {
            return null;
        }

        Score.ScoreBuilder score = Score.builder();

        score.student( addScoreDTOToStudent( addScoreDTO ) );
        score.subjectClass( addScoreDTOToSubjectClass( addScoreDTO ) );
        score.attendanceScore( addScoreDTO.getAttendanceScore() );
        score.midTermScore( addScoreDTO.getMidTermScore() );
        score.endTermScore( addScoreDTO.getEndTermScore() );
        score.semester( addScoreDTO.getSemester() );

        return score.build();
    }

    @Override
    public ScoreDTO toScoreDTO(Score score) {
        if ( score == null ) {
            return null;
        }

        ScoreDTO.ScoreDTOBuilder scoreDTO = ScoreDTO.builder();

        scoreDTO.studentId( scoreStudentStudentId( score ) );
        scoreDTO.subjectClassId( scoreSubjectClassSubjectClassId( score ) );
        scoreDTO.scoreId( score.getScoreId() );
        scoreDTO.attendanceScore( score.getAttendanceScore() );
        scoreDTO.midTermScore( score.getMidTermScore() );
        scoreDTO.endTermScore( score.getEndTermScore() );
        scoreDTO.semester( score.getSemester() );
        scoreDTO.processScore( score.getProcessScore() );
        scoreDTO.finalScore( score.getFinalScore() );
        scoreDTO.GPA( score.getGPA() );
        scoreDTO.grade( score.getGrade() );

        return scoreDTO.build();
    }

    @Override
    public void updateScore(Score score, UpdateScoreDTO request) {
        if ( request == null ) {
            return;
        }

        score.setScoreId( request.getScoreId() );
        score.setAttendanceScore( request.getAttendanceScore() );
        score.setMidTermScore( request.getMidTermScore() );
        score.setEndTermScore( request.getEndTermScore() );
        score.setSemester( request.getSemester() );
    }

    protected Student addScoreDTOToStudent(AddScoreDTO addScoreDTO) {
        if ( addScoreDTO == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.studentId( addScoreDTO.getStudentId() );

        return student.build();
    }

    protected SubjectClass addScoreDTOToSubjectClass(AddScoreDTO addScoreDTO) {
        if ( addScoreDTO == null ) {
            return null;
        }

        SubjectClass.SubjectClassBuilder subjectClass = SubjectClass.builder();

        subjectClass.subjectClassId( addScoreDTO.getSubjectClassId() );

        return subjectClass.build();
    }

    private Long scoreStudentStudentId(Score score) {
        if ( score == null ) {
            return null;
        }
        Student student = score.getStudent();
        if ( student == null ) {
            return null;
        }
        Long studentId = student.getStudentId();
        if ( studentId == null ) {
            return null;
        }
        return studentId;
    }

    private Long scoreSubjectClassSubjectClassId(Score score) {
        if ( score == null ) {
            return null;
        }
        SubjectClass subjectClass = score.getSubjectClass();
        if ( subjectClass == null ) {
            return null;
        }
        Long subjectClassId = subjectClass.getSubjectClassId();
        if ( subjectClassId == null ) {
            return null;
        }
        return subjectClassId;
    }
}
