package com.example.student_management.exception;

import java.util.concurrent.Phaser;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized exception"),
    INVALID_KEY(9004, "Invalid message key"),

    EMAIL_EXISTED(1001, "Email đã tồn tại"),
    PHONE_NUMBER_EXISTED(1002, "Số điện thoại đã tồn tại"),
    INVALID_PHONE_NUMBER(1003, "Số điện thoại không hợp lệ"),
    NAME_BLANK(1005, "Phần tên không được để trống"),

    STUDENT_NOTFOUND(2001, "Không tìm thấy sinh viên"),

    MANAGEMENT_CLASS_NOTFOUND(3001, "Không tìm thấy lớp học"),

    SUBJECT_NOTFOUND(4001, "Không tìm thấy môn học");

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
