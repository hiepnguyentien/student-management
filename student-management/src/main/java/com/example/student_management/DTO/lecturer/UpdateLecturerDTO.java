package com.example.student_management.dto.lecturer;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

public class UpdateLecturerDTO {
    public Long id;
    @NotNull(message = "Tên không được để trống")
    public String firstName;
    @NotNull(message = "Tên không được để trống")
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

    public UpdateLecturerDTO() {
    }

    public UpdateLecturerDTO(Long id, String firstName, String lastName, String email, String phoneNumber, String address, String gender, LocalDate dateOfBirth, Long facultyId, Long managementClassId) {
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

    public UpdateLecturerDTO id(Long id) {
        setId(id);
        return this;
    }

    public UpdateLecturerDTO firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public UpdateLecturerDTO lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public UpdateLecturerDTO email(String email) {
        setEmail(email);
        return this;
    }

    public UpdateLecturerDTO phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public UpdateLecturerDTO address(String address) {
        setAddress(address);
        return this;
    }

    public UpdateLecturerDTO gender(String gender) {
        setGender(gender);
        return this;
    }

    public UpdateLecturerDTO dateOfBirth(LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    public UpdateLecturerDTO facultyId(Long facultyId) {
        setFacultyId(facultyId);
        return this;
    }

    public UpdateLecturerDTO managementClassId(Long managementClassId) {
        setManagementClassId(managementClassId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateLecturerDTO)) {
            return false;
        }
        UpdateLecturerDTO updateLecturerDTO = (UpdateLecturerDTO) o;
        return Objects.equals(id, updateLecturerDTO.id) && Objects.equals(firstName, updateLecturerDTO.firstName) && Objects.equals(lastName, updateLecturerDTO.lastName) && Objects.equals(email, updateLecturerDTO.email) && Objects.equals(phoneNumber, updateLecturerDTO.phoneNumber) && Objects.equals(address, updateLecturerDTO.address) && Objects.equals(gender, updateLecturerDTO.gender) && Objects.equals(dateOfBirth, updateLecturerDTO.dateOfBirth) && Objects.equals(facultyId, updateLecturerDTO.facultyId) && Objects.equals(managementClassId, updateLecturerDTO.managementClassId);
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
