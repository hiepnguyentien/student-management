package com.example.student_management.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized exception"),
    INVALID_KEY(9001, "Invalid message key"),

    EMAIL_EXISTED(1001, "Email đã tồn tại"),
    PHONE_NUMBER_EXISTED(1002, "Số điện thoại đã tồn tại"),
    INVALID_PHONE_NUMBER(1003, "Số điện thoại không hợp lệ"),
    NAME_BLANK(1005, "Phần tên không được để trống"),

    STUDENT_NOT_FOUND(2001, "Không tìm thấy sinh viên"),

    MANAGEMENT_CLASS_NOT_FOUND(3001, "Không tìm thấy lớp học"),
    ANOTHER_LECTURER_IN_MANAGEMENT_CLASS(3002, "Lớp học đã có giảng viên khác"),

    SUBJECT_NOT_FOUND(4001, "Không tìm thấy môn học"),
    
    LECTURER_NOT_FOUND(5001, "Không tìm thấy giảng viên"),

    FACULTY_NOT_FOUND(6001, "Không tìm thấy khoa"),
    
    SUBJECT_CLASS_NOT_FOUND(7001, "Không tìm thấy lớp môn học"),
    
    SCORE_DOES_NOT_EXIST(8001, "Sinh viên chưa có điểm của môn học này"),
    SCORE_FOUND(8002, "Sinh viên đã có điểm của môn này"),
    INVALID_SCORE(8003, "Điểm phải nằm trong khoảng từ 0 đến 10"),
    INVALID_SEMESTER(8004, "Học kỳ phải nằm trong khoảng từ 1 đến 3"),;

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
