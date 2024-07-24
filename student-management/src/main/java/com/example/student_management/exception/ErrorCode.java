package com.example.student_management.exception;

import org.springframework.context.MessageSource;

import java.util.Locale;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "uncategorized.exception"),
    INVALID_KEY(9001, "invalid.key"),

    EMAIL_EXISTED(1001, "email.existed"),
    INVALID_EMAIL(1002, "invalid.email"),
    PHONE_NUMBER_ALREADY_EXISTS(1003, "phone.number.already.exists"),
    INVALID_PHONE_NUMBER(1004, "invalid.phone.number"),
    NAME_BLANK(1005, "name.blank"),
    DATE_OF_BIRTH_BLANK(1006, "date.of.birth.blank"),
    DATE_OF_BIRTH_IS_AFTER_NOW(1007, "date.of.birth.is.after.now"),
    USER_NAME_BLANK(1008, "user.name.blank"),
    PASSWORD_BLANK(1009, "password.blank"),

    STUDENT_NOT_FOUND(2001, "student.not.found"),

    MANAGEMENT_CLASS_NOT_FOUND(3001, "management.class.not.found"),
    ANOTHER_LECTURER_IN_MANAGEMENT_CLASS(3002, "another.lecturer.in.management.class"),
    CLASS_NAME_BLANK(3003, "class.name.blank"),

    SUBJECT_NOT_FOUND(4001, "subject.not.found"),

    LECTURER_NOT_FOUND(5001, "lecturer.not.found"),
    LECTURER_BLANK(5002, "lecturer.blank"),

    FACULTY_NOT_FOUND(6001, "faculty.not.found"),
    FACULTY_BLANK(6002, "faculty.blank"),

    SUBJECT_CLASS_NOT_FOUND(7001, "subject.class.not.found"),

    SCORE_DOES_NOT_EXIST(8001, "score.does.not.exist"),
    SCORE_FOUND(8002, "score.found"),
    INVALID_SCORE(8003, "invalid.score"),
    INVALID_SEMESTER(8004, "invalid.semester"),

    UNAUTHORIZED(9001, "unauthorized"),
    UNAUTHENTICATED(9002, "unauthenticated");

    private final int code;
    private final String messageKey;

    ErrorCode(int code, String messageKey) {
        this.code = code;
        this.messageKey = messageKey;
    }

    public int getCode() {
        return code;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public String getMessage(MessageSource messageSource, Object[] args, Locale locale) {
        return messageSource.getMessage(messageKey, args, locale);
    }
}
