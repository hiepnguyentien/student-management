package com.example.student_management.exception;

import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.Locale;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "uncategorized.exception", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(9001, "invalid.key", HttpStatus.BAD_REQUEST),

    EMAIL_EXISTED(1001, "email.existed", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(1002, "invalid.email", HttpStatus.BAD_REQUEST),
    PHONE_NUMBER_ALREADY_EXISTS(1003, "phone.number.already.exists", HttpStatus.BAD_REQUEST),
    INVALID_PHONE_NUMBER(1004, "invalid.phone.number", HttpStatus.BAD_REQUEST),
    NAME_BLANK(1005, "name.blank", HttpStatus.BAD_REQUEST),
    DATE_OF_BIRTH_BLANK(1006, "date.of.birth.blank", HttpStatus.BAD_REQUEST),
    DATE_OF_BIRTH_IS_AFTER_NOW(1007, "date.of.birth.is.after.now", HttpStatus.BAD_REQUEST),
    USER_NAME_BLANK(1008, "user.name.blank", HttpStatus.BAD_REQUEST),
    PASSWORD_BLANK(1009, "password.blank", HttpStatus.BAD_REQUEST),

    STUDENT_NOT_FOUND(2001, "student.not.found", HttpStatus.NOT_FOUND),

    MANAGEMENT_CLASS_NOT_FOUND(3001, "management.class.not.found", HttpStatus.NOT_FOUND),
    ANOTHER_LECTURER_IN_MANAGEMENT_CLASS(3002, "another.lecturer.in.management.class", HttpStatus.NOT_FOUND),
    CLASS_NAME_BLANK(3003, "class.name.blank", HttpStatus.BAD_REQUEST),

    SUBJECT_NOT_FOUND(4001, "subject.not.found", HttpStatus.NOT_FOUND),

    LECTURER_NOT_FOUND(5001, "lecturer.not.found", HttpStatus.NOT_FOUND),
    LECTURER_BLANK(5002, "lecturer.blank", HttpStatus.BAD_REQUEST),

    FACULTY_NOT_FOUND(6001, "faculty.not.found", HttpStatus.NOT_FOUND),
    FACULTY_BLANK(6002, "faculty.blank", HttpStatus.BAD_REQUEST),

    SUBJECT_CLASS_NOT_FOUND(7001, "subject.class.not.found", HttpStatus.NOT_FOUND),

    SCORE_DOES_NOT_EXIST(8001, "score.does.not.exist", HttpStatus.NOT_FOUND),
    SCORE_FOUND(8002, "score.found", HttpStatus.NOT_FOUND),
    INVALID_SCORE(8003, "invalid.score", HttpStatus.BAD_REQUEST),
    INVALID_SEMESTER(8004, "invalid.semester", HttpStatus.BAD_REQUEST),

    UNAUTHORIZED(9001, "unauthorized", HttpStatus.FORBIDDEN),
    UNAUTHENTICATED(9002, "unauthenticated", HttpStatus.UNAUTHORIZED),;

    private final int code;
    private final String message;
    private HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
