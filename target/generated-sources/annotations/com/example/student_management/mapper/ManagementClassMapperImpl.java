package com.example.student_management.mapper;

import com.example.student_management.dto.management_class.ManagementClassDTO;
import com.example.student_management.dto.management_class.UpdateManagementClassDTO;
import com.example.student_management.model.Faculty;
import com.example.student_management.model.Lecturer;
import com.example.student_management.model.ManagementClass;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class ManagementClassMapperImpl implements ManagementClassMapper {

    @Override
    public ManagementClass toManagementClass(ManagementClassDTO managementClassDTO) {
        if ( managementClassDTO == null ) {
            return null;
        }

        ManagementClass.ManagementClassBuilder managementClass = ManagementClass.builder();

        managementClass.lecturer( managementClassDTOToLecturer( managementClassDTO ) );
        managementClass.faculty( managementClassDTOToFaculty( managementClassDTO ) );
        managementClass.managementClassId( managementClassDTO.getManagementClassId() );
        managementClass.name( managementClassDTO.getName() );

        return managementClass.build();
    }

    @Override
    public ManagementClassDTO toManagementClassDTO(ManagementClass managementClass) {
        if ( managementClass == null ) {
            return null;
        }

        ManagementClassDTO.ManagementClassDTOBuilder managementClassDTO = ManagementClassDTO.builder();

        managementClassDTO.lecturerId( managementClassLecturerLecturerId( managementClass ) );
        managementClassDTO.facultyId( managementClassFacultyFacultyId( managementClass ) );
        managementClassDTO.managementClassId( managementClass.getManagementClassId() );
        managementClassDTO.name( managementClass.getName() );

        return managementClassDTO.build();
    }

    @Override
    public void updateManagementClassDTO(ManagementClass managementClass, UpdateManagementClassDTO request) {
        if ( request == null ) {
            return;
        }

        managementClass.setManagementClassId( request.getManagementClassId() );
        managementClass.setName( request.getName() );
    }

    protected Lecturer managementClassDTOToLecturer(ManagementClassDTO managementClassDTO) {
        if ( managementClassDTO == null ) {
            return null;
        }

        Lecturer.LecturerBuilder lecturer = Lecturer.builder();

        lecturer.lecturerId( managementClassDTO.getLecturerId() );

        return lecturer.build();
    }

    protected Faculty managementClassDTOToFaculty(ManagementClassDTO managementClassDTO) {
        if ( managementClassDTO == null ) {
            return null;
        }

        Faculty.FacultyBuilder faculty = Faculty.builder();

        faculty.facultyId( managementClassDTO.getFacultyId() );

        return faculty.build();
    }

    private Long managementClassLecturerLecturerId(ManagementClass managementClass) {
        if ( managementClass == null ) {
            return null;
        }
        Lecturer lecturer = managementClass.getLecturer();
        if ( lecturer == null ) {
            return null;
        }
        Long lecturerId = lecturer.getLecturerId();
        if ( lecturerId == null ) {
            return null;
        }
        return lecturerId;
    }

    private Long managementClassFacultyFacultyId(ManagementClass managementClass) {
        if ( managementClass == null ) {
            return null;
        }
        Faculty faculty = managementClass.getFaculty();
        if ( faculty == null ) {
            return null;
        }
        Long facultyId = faculty.getFacultyId();
        if ( facultyId == null ) {
            return null;
        }
        return facultyId;
    }
}
