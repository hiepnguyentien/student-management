package com.example.student_management.model;

public enum Grade {
    A("A"),
    B("B"), B_PLUS("B+"),
    C("C"), C_PLUS("C+"),
    D("D"), D_PLUS("D+"),
    F("F");

    private String grade;

    Grade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return this.grade;
    }

    public static String fromScore(Float score) {
        if(score >= 8.5f) {
            return A.toString();
        } else if(score >= 8.0f) {
            return B_PLUS.toString();
        } else if(score >= 7.0f) {
            return B.toString();
        } else if(score >= 6.5f) {
            return C_PLUS.toString();
        } else if(score >= 5.5f) {
            return C.toString();
        } else if(score >= 5.0f) {
            return D_PLUS.toString();
        } else if(score >= 4.0f) {
            return D.toString();
        } else {
            return F.toString();
        }
    }
}
