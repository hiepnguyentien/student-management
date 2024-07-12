package com.example.student_management.dto.lecturer;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

public class AddLecturerDTO {
    @NotNull(message = "NAME_BLANK")
    public String firstName;
    @NotNull(message = "NAME_BLANK")
    public String lastName;
    @Email(message = "email không hợp lệ")
    public String email;
    @Size(min = 10, message = "INVALID_PHONE_NUMBER")
    @Size(max = 10, message = "INVALID_PHONE_NUMBER")
    public String phoneNumber;
    public String address;
    public String gender;
    public LocalDate dateOfBirth;
    public Long facultyId;
    public Long managementClassId;

    public AddLecturerDTO() {
    }

    public AddLecturerDTO(String firstName, String lastName, String email, String phoneNumber, String address, String gender, LocalDate dateOfBirth, Long facultyId, Long managementClassId) {
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

    public AddLecturerDTO firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public AddLecturerDTO lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public AddLecturerDTO email(String email) {
        setEmail(email);
        return this;
    }

    public AddLecturerDTO phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public AddLecturerDTO address(String address) {
        setAddress(address);
        return this;
    }

    public AddLecturerDTO gender(String gender) {
        setGender(gender);
        return this;
    }

    public AddLecturerDTO dateOfBirth(LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    public AddLecturerDTO facultyId(Long facultyId) {
        setFacultyId(facultyId);
        return this;
    }

    public AddLecturerDTO managementClassId(Long managementClassId) {
        setManagementClassId(managementClassId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AddLecturerDTO)) {
            return false;
        }
        AddLecturerDTO addLecturerDTO = (AddLecturerDTO) o;
        return Objects.equals(firstName, addLecturerDTO.firstName) && Objects.equals(lastName, addLecturerDTO.lastName) && Objects.equals(email, addLecturerDTO.email) && Objects.equals(phoneNumber, addLecturerDTO.phoneNumber) && Objects.equals(address, addLecturerDTO.address) && Objects.equals(gender, addLecturerDTO.gender) && Objects.equals(dateOfBirth, addLecturerDTO.dateOfBirth) && Objects.equals(facultyId, addLecturerDTO.facultyId) && Objects.equals(managementClassId, addLecturerDTO.managementClassId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber, address, gender, dateOfBirth, facultyId, managementClassId);
    }

    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
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
