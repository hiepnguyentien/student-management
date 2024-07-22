package com.example.student_management.mapper;

import com.example.student_management.dto.student.AddStudentDTO;
import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.dto.student.UpdateStudentDTO;
import com.example.student_management.model.ManagementClass;
import com.example.student_management.model.Student;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toStudent(AddStudentDTO request) {
        if ( request == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.managementClass( addStudentDTOToManagementClass( request ) );
        student.enrollDate( request.getEnrollDate() );
        student.batch( request.getBatch() );
        student.firstName( request.getFirstName() );
        student.lastName( request.getLastName() );
        student.address( request.getAddress() );
        student.email( request.getEmail() );
        student.phoneNumber( request.getPhoneNumber() );
        student.gender( request.getGender() );
        student.dateOfBirth( request.getDateOfBirth() );

        return student.build();
    }

    @Override
    public StudentDTO toStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO.StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.managementClassId( studentManagementClassManagementClassId( student ) );
        studentDTO.studentId( student.getStudentId() );
        studentDTO.firstName( student.getFirstName() );
        studentDTO.lastName( student.getLastName() );
        studentDTO.email( student.getEmail() );
        studentDTO.phoneNumber( student.getPhoneNumber() );
        studentDTO.address( student.getAddress() );
        studentDTO.gender( student.getGender() );
        studentDTO.batch( student.getBatch() );
        studentDTO.dateOfBirth( student.getDateOfBirth() );

        return studentDTO.build();
    }

    @Override
    public void updateStudent(Student student, UpdateStudentDTO request) {
        if ( request == null ) {
            return;
        }

        student.setStudentId( request.getStudentId() );
        student.setEnrollDate( request.getEnrollDate() );
        student.setFirstName( request.getFirstName() );
        student.setLastName( request.getLastName() );
        student.setAddress( request.getAddress() );
        student.setEmail( request.getEmail() );
        student.setPhoneNumber( request.getPhoneNumber() );
        student.setGender( request.getGender() );
        student.setDateOfBirth( request.getDateOfBirth() );
    }

    protected ManagementClass addStudentDTOToManagementClass(AddStudentDTO addStudentDTO) {
        if ( addStudentDTO == null ) {
            return null;
        }

        ManagementClass.ManagementClassBuilder managementClass = ManagementClass.builder();

        managementClass.managementClassId( addStudentDTO.getManagementClassId() );

        return managementClass.build();
    }

    private Long studentManagementClassManagementClassId(Student student) {
        if ( student == null ) {
            return null;
        }
        ManagementClass managementClass = student.getManagementClass();
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
