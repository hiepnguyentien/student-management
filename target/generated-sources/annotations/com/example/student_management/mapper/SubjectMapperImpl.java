package com.example.student_management.mapper;

import com.example.student_management.dto.subject.AddSubjectDTO;
import com.example.student_management.dto.subject.SubjectDTO;
import com.example.student_management.dto.subject.UpdateSubjectDTO;
import com.example.student_management.model.Subject;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public Subject toSubject(AddSubjectDTO request) {
        if ( request == null ) {
            return null;
        }

        Subject.SubjectBuilder subject = Subject.builder();

        subject.name( request.getName() );
        subject.description( request.getDescription() );
        subject.credit( request.getCredit() );

        return subject.build();
    }

    @Override
    public SubjectDTO toSubjectDTO(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectDTO.SubjectDTOBuilder subjectDTO = SubjectDTO.builder();

        subjectDTO.subjectId( subject.getSubjectId() );
        subjectDTO.name( subject.getName() );
        subjectDTO.description( subject.getDescription() );
        subjectDTO.credit( subject.getCredit() );

        return subjectDTO.build();
    }

    @Override
    public void updateSubject(Subject subject, UpdateSubjectDTO request) {
        if ( request == null ) {
            return;
        }

        subject.setName( request.getName() );
        subject.setDescription( request.getDescription() );
        subject.setCredit( request.getCredit() );
    }
}
