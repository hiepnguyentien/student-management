package com.example.student_management.DTO;
import java.time.LocalDate;
import java.util.Objects;

import com.example.student_management.model.ManagementClass;

public class StudentDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String gender;
    private LocalDate dateOfBirth;
    private ManagementClass managementClass;


    public StudentDTO() {
    }

    public StudentDTO(String firstName, String lastName, String email, String phoneNumber, String address, String gender, LocalDate dateOfBirth, ManagementClass managementClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.managementClass = managementClass;
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

    public ManagementClass getManagementClass() {
        return this.managementClass;
    }

    public void setManagementClass(ManagementClass managementClass) {
        this.managementClass = managementClass;
    }

    public StudentDTO firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public StudentDTO lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public StudentDTO email(String email) {
        setEmail(email);
        return this;
    }

    public StudentDTO phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public StudentDTO address(String address) {
        setAddress(address);
        return this;
    }

    public StudentDTO gender(String gender) {
        setGender(gender);
        return this;
    }

    public StudentDTO dateOfBirth(LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    public StudentDTO managementClass(ManagementClass managementClass) {
        setManagementClass(managementClass);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StudentDTO)) {
            return false;
        }
        StudentDTO studentDTO = (StudentDTO) o;
        return Objects.equals(firstName, studentDTO.firstName) && Objects.equals(lastName, studentDTO.lastName) && Objects.equals(email, studentDTO.email) && Objects.equals(phoneNumber, studentDTO.phoneNumber) && Objects.equals(address, studentDTO.address) && Objects.equals(gender, studentDTO.gender) && Objects.equals(dateOfBirth, studentDTO.dateOfBirth) && Objects.equals(managementClass, studentDTO.managementClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber, address, gender, dateOfBirth, managementClass);
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
            ", managementClass='" + getManagementClass() + "'" +
            "}";
    }

}
