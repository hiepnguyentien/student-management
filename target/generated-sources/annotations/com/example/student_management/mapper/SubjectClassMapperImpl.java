package com.example.student_management.mapper;

import com.example.student_management.dto.subject_class.AddSubjectClassDTO;
import com.example.student_management.dto.subject_class.SubjectClassDTO;
import com.example.student_management.dto.subject_class.UpdateSubjectClassDTO;
import com.example.student_management.model.Lecturer;
import com.example.student_management.model.Subject;
import com.example.student_management.model.SubjectClass;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class SubjectClassMapperImpl implements SubjectClassMapper {

    @Override
    public SubjectClass toSubjectClass(AddSubjectClassDTO request) {
        if ( request == null ) {
            return null;
        }

        SubjectClass.SubjectClassBuilder subjectClass = SubjectClass.builder();

        subjectClass.lecturer( addSubjectClassDTOToLecturer( request ) );
        subjectClass.subject( addSubjectClassDTOToSubject( request ) );
        subjectClass.name( request.getName() );

        return subjectClass.build();
    }

    @Override
    public SubjectClassDTO toSubjectClassDTO(SubjectClass subjectClass) {
        if ( subjectClass == null ) {
            return null;
        }

        SubjectClassDTO.SubjectClassDTOBuilder subjectClassDTO = SubjectClassDTO.builder();

        subjectClassDTO.lecturerId( subjectClassLecturerLecturerId( subjectClass ) );
        subjectClassDTO.subjectId( subjectClassSubjectSubjectId( subjectClass ) );
        subjectClassDTO.subjectClassId( subjectClass.getSubjectClassId() );
        subjectClassDTO.name( subjectClass.getName() );

        return subjectClassDTO.build();
    }

    @Override
    public void updateSubjectClass(SubjectClass subjectClass, UpdateSubjectClassDTO request) {
        if ( request == null ) {
            return;
        }

        subjectClass.setName( request.getName() );
    }

    protected Lecturer addSubjectClassDTOToLecturer(AddSubjectClassDTO addSubjectClassDTO) {
        if ( addSubjectClassDTO == null ) {
            return null;
        }

        Lecturer.LecturerBuilder lecturer = Lecturer.builder();

        lecturer.lecturerId( addSubjectClassDTO.getLecturerId() );

        return lecturer.build();
    }

    protected Subject addSubjectClassDTOToSubject(AddSubjectClassDTO addSubjectClassDTO) {
        if ( addSubjectClassDTO == null ) {
            return null;
        }

        Subject.SubjectBuilder subject = Subject.builder();

        subject.subjectId( addSubjectClassDTO.getSubjectId() );

        return subject.build();
    }

    private Long subjectClassLecturerLecturerId(SubjectClass subjectClass) {
        if ( subjectClass == null ) {
            return null;
        }
        Lecturer lecturer = subjectClass.getLecturer();
        if ( lecturer == null ) {
            return null;
        }
        Long lecturerId = lecturer.getLecturerId();
        if ( lecturerId == null ) {
            return null;
        }
        return lecturerId;
    }

    private Long subjectClassSubjectSubjectId(SubjectClass subjectClass) {
        if ( subjectClass == null ) {
            return null;
        }
        Subject subject = subjectClass.getSubject();
        if ( subject == null ) {
            return null;
        }
        Long subjectId = subject.getSubjectId();
        if ( subjectId == null ) {
            return null;
        }
        return subjectId;
    }
}
