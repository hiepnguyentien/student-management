package com.example.student_management.dto.student;
import java.time.LocalDate;
import java.util.Objects;

public class StudentDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String address;
    public String gender;
    public LocalDate dateOfBirth;
    public String managementClassName;


    public StudentDTO() {
    }

    public StudentDTO(Long id, String firstName, String lastName, String email, String phoneNumber, String address, String gender, LocalDate dateOfBirth, String managementClassName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.managementClassName = managementClassName;
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

    public String getManagementClassName() {
        return this.managementClassName;
    }

    public void setManagementClassName(String managementClassName) {
        this.managementClassName = managementClassName;
    }

    public StudentDTO id(Long id) {
        setId(id);
        return this;
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

    public StudentDTO managementClassName(String managementClassName) {
        setManagementClassName(managementClassName);
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
        return Objects.equals(id, studentDTO.id) && Objects.equals(firstName, studentDTO.firstName) && Objects.equals(lastName, studentDTO.lastName) && Objects.equals(email, studentDTO.email) && Objects.equals(phoneNumber, studentDTO.phoneNumber) && Objects.equals(address, studentDTO.address) && Objects.equals(gender, studentDTO.gender) && Objects.equals(dateOfBirth, studentDTO.dateOfBirth) && Objects.equals(managementClassName, studentDTO.managementClassName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber, address, gender, dateOfBirth, managementClassName);
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
            ", managementClassName='" + getManagementClassName() + "'" +
            "}";
    }

}
