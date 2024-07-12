package com.example.student_management.dto.lecturer;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;
import java.util.Objects;

public class LecturerDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String address;
    public String gender;
    public LocalDate dateOfBirth;
    public Long facultyId;
    public Long managementClassId;


    public LecturerDTO() {
    }

    public LecturerDTO(Long id, String firstName, String lastName, String email, String phoneNumber, String address, String gender, LocalDate dateOfBirth, Long facultyId, Long managementClassId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.facultyId = facultyId;
        this.managementClassId = managementClassId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getFacultyId() {
        return this.facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public Long getManagementClassId() {
        return this.managementClassId;
    }

    public void setManagementClassId(Long managementClassId) {
        this.managementClassId = managementClassId;
    }

    public LecturerDTO id(Long id) {
        setId(id);
        return this;
    }

    public LecturerDTO firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public LecturerDTO lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public LecturerDTO email(String email) {
        setEmail(email);
        return this;
    }

    public LecturerDTO phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public LecturerDTO address(String address) {
        setAddress(address);
        return this;
    }

    public LecturerDTO gender(String gender) {
        setGender(gender);
        return this;
    }

    public LecturerDTO dateOfBirth(LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    public LecturerDTO facultyId(Long facultyId) {
        setFacultyId(facultyId);
        return this;
    }

    public LecturerDTO managementClassId(Long managementClassId) {
        setManagementClassId(managementClassId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LecturerDTO)) {
            return false;
        }
        LecturerDTO lecturerDTO = (LecturerDTO) o;
        return Objects.equals(id, lecturerDTO.id) && Objects.equals(firstName, lecturerDTO.firstName) && Objects.equals(lastName, lecturerDTO.lastName) && Objects.equals(email, lecturerDTO.email) && Objects.equals(phoneNumber, lecturerDTO.phoneNumber) && Objects.equals(address, lecturerDTO.address) && Objects.equals(gender, lecturerDTO.gender) && Objects.equals(dateOfBirth, lecturerDTO.dateOfBirth) && Objects.equals(facultyId, lecturerDTO.facultyId) && Objects.equals(managementClassId, lecturerDTO.managementClassId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber, address, gender, dateOfBirth, facultyId, managementClassId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", address='" + getAddress() + "'" +
            ", gender='" + getGender() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", facultyId='" + getFacultyId() + "'" +
            ", managementClassId='" + getManagementClassId() + "'" +
            "}";
    }
    
}
