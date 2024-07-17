package com.example.student_management.mapper;

import com.example.student_management.dto.lecturer.AddLecturerDTO;
import com.example.student_management.dto.lecturer.LecturerDTO;
import com.example.student_management.dto.lecturer.UpdateLecturerDTO;
import com.example.student_management.model.Lecturer;
import com.example.student_management.model.ManagementClass;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class LecturerMapperImpl implements LecturerMapper {

    @Override
    public Lecturer toLecturer(AddLecturerDTO request) {
        if ( request == null ) {
            return null;
        }

        Lecturer.LecturerBuilder lecturer = Lecturer.builder();

        lecturer.facultyId( request.getFacultyId() );

        return lecturer.build();
    }

    @Override
    public LecturerDTO toLecturerDTO(Lecturer lecturer) {
        if ( lecturer == null ) {
            return null;
        }

        LecturerDTO.LecturerDTOBuilder lecturerDTO = LecturerDTO.builder();

        lecturerDTO.managementClassId( lecturerManagementClassManagementClassId( lecturer ) );
        lecturerDTO.lecturerId( lecturer.getLecturerId() );
        lecturerDTO.firstName( lecturer.getFirstName() );
        lecturerDTO.lastName( lecturer.getLastName() );
        lecturerDTO.email( lecturer.getEmail() );
        lecturerDTO.phoneNumber( lecturer.getPhoneNumber() );
        lecturerDTO.address( lecturer.getAddress() );
        lecturerDTO.gender( lecturer.getGender() );
        lecturerDTO.dateOfBirth( lecturer.getDateOfBirth() );
        lecturerDTO.facultyId( lecturer.getFacultyId() );

        return lecturerDTO.build();
    }

    @Override
    public void updateLecturer(Lecturer lecturer, UpdateLecturerDTO request) {
        if ( request == null ) {
            return;
        }

        lecturer.setFirstName( request.getFirstName() );
        lecturer.setLastName( request.getLastName() );
        lecturer.setAddress( request.getAddress() );
        lecturer.setEmail( request.getEmail() );
        lecturer.setPhoneNumber( request.getPhoneNumber() );
        lecturer.setGender( request.getGender() );
        lecturer.setDateOfBirth( request.getDateOfBirth() );
        lecturer.setFacultyId( request.getFacultyId() );
    }

    private Long lecturerManagementClassManagementClassId(Lecturer lecturer) {
        if ( lecturer == null ) {
            return null;
        }
        ManagementClass managementClass = lecturer.getManagementClass();
        if ( managementClass == null ) {
            return null;
        }
        Long managementClassId = managementClass.getManagementClassId();
        if ( managementClassId == null ) {
            return null;
        }
        return managementClassId;
    }
}
