package com.example.student_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
public abstract class Person {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    public Person() {}

    public Person(String firstName, String lastName, String address, String email, String phoneNumber, String gender, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Person lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Person address(String address) {
        setAddress(address);
        return this;
    }

    public Person email(String email) {
        setEmail(email);
        return this;
    }

    public Person phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public Person gender(String gender) {
        setGender(gender);
        return this;
    }

    public Person dateOfBirth(LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    public Person(String firstName, String lastName, String address, String email, String phoneNumber, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(address, person.address) &&
                Objects.equals(email, person.email) &&
                Objects.equals(phoneNumber, person.phoneNumber) &&
                Objects.equals(dateOfBirth, person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, email, phoneNumber, dateOfBirth);
    }

    @Override
    public String toString() {
        return "{" +
                " firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", address='" + getAddress() + "'" +
                ", email='" + getEmail() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                ", dateOfBirth='" + getDateOfBirth() + "'" +
                "}";
    }
}
