package com.example.student_management.dto.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.validator.constraints.UniqueElements;

public class AddStudentDTO {
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
    public Long managementClassId;

    public AddStudentDTO() {
    }

    public AddStudentDTO(String firstName, String lastName, String email, String phoneNumber, String address, String gender, LocalDate dateOfBirth, Long managementClassId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
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

    public Long getManagementClassId() {
        return this.managementClassId;
    }

    public void setManagementClassId(Long managementClassId) {
        this.managementClassId = managementClassId;
    }

    public AddStudentDTO firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public AddStudentDTO lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public AddStudentDTO email(String email) {
        setEmail(email);
        return this;
    }

    public AddStudentDTO phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public AddStudentDTO address(String address) {
        setAddress(address);
        return this;
    }

    public AddStudentDTO gender(String gender) {
        setGender(gender);
        return this;
    }

    public AddStudentDTO dateOfBirth(LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    public AddStudentDTO managementClassId(Long managementClassId) {
        setManagementClassId(managementClassId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AddStudentDTO)) {
            return false;
        }
        AddStudentDTO addStudentDTO = (AddStudentDTO) o;
        return Objects.equals(firstName, addStudentDTO.firstName) && Objects.equals(lastName, addStudentDTO.lastName) && Objects.equals(email, addStudentDTO.email) && Objects.equals(phoneNumber, addStudentDTO.phoneNumber) && Objects.equals(address, addStudentDTO.address) && Objects.equals(gender, addStudentDTO.gender) && Objects.equals(dateOfBirth, addStudentDTO.dateOfBirth) && Objects.equals(managementClassId, addStudentDTO.managementClassId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber, address, gender, dateOfBirth, managementClassId);
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
            ", managementClassId='" + getManagementClassId() + "'" +
            "}";
    }

}
