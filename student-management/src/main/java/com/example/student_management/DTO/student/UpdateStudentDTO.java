package com.example.student_management.dto.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

public class UpdateStudentDTO {
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
    public Long managementClassId;


    public UpdateStudentDTO() {
    }

    public UpdateStudentDTO(Long id, String firstName, String lastName, String email, String phoneNumber, String address, String gender, LocalDate dateOfBirth, Long managementClassId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
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

    public Long getManagementClassId() {
        return this.managementClassId;
    }

    public void setManagementClassId(Long managementClassId) {
        this.managementClassId = managementClassId;
    }

    public UpdateStudentDTO id(Long id) {
        setId(id);
        return this;
    }

    public UpdateStudentDTO firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public UpdateStudentDTO lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public UpdateStudentDTO email(String email) {
        setEmail(email);
        return this;
    }

    public UpdateStudentDTO phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public UpdateStudentDTO address(String address) {
        setAddress(address);
        return this;
    }

    public UpdateStudentDTO gender(String gender) {
        setGender(gender);
        return this;
    }

    public UpdateStudentDTO dateOfBirth(LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    public UpdateStudentDTO managementClassId(Long managementClassId) {
        setManagementClassId(managementClassId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateStudentDTO)) {
            return false;
        }
        UpdateStudentDTO updateStudentDTO = (UpdateStudentDTO) o;
        return Objects.equals(id, updateStudentDTO.id) && Objects.equals(firstName, updateStudentDTO.firstName) && Objects.equals(lastName, updateStudentDTO.lastName) && Objects.equals(email, updateStudentDTO.email) && Objects.equals(phoneNumber, updateStudentDTO.phoneNumber) && Objects.equals(address, updateStudentDTO.address) && Objects.equals(gender, updateStudentDTO.gender) && Objects.equals(dateOfBirth, updateStudentDTO.dateOfBirth) && Objects.equals(managementClassId, updateStudentDTO.managementClassId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber, address, gender, dateOfBirth, managementClassId);
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
            ", managementClassId='" + getManagementClassId() + "'" +
            "}";
    }

}
