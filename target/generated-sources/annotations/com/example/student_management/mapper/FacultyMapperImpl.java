package com.example.student_management.mapper;

import com.example.student_management.dto.faculty.AddNewFacultyDTO;
import com.example.student_management.dto.faculty.FacultyDTO;
import com.example.student_management.dto.faculty.UpdateFacultyDTO;
import com.example.student_management.model.Faculty;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class FacultyMapperImpl implements FacultyMapper {

    @Override
    public Faculty toFaculty(AddNewFacultyDTO request) {
        if ( request == null ) {
            return null;
        }

        Faculty.FacultyBuilder faculty = Faculty.builder();

        faculty.facultyName( request.getFacultyName() );

        return faculty.build();
    }

    @Override
    public FacultyDTO toFacultyDTO(Faculty faculty) {
        if ( faculty == null ) {
            return null;
        }

        FacultyDTO.FacultyDTOBuilder facultyDTO = FacultyDTO.builder();

        facultyDTO.facultyId( faculty.getFacultyId() );
        facultyDTO.facultyName( faculty.getFacultyName() );

        return facultyDTO.build();
    }

    @Override
    public void updateFaculty(Faculty faculty, UpdateFacultyDTO request) {
        if ( request == null ) {
            return;
        }

        faculty.setFacultyName( request.getFacultyName() );
    }
}
