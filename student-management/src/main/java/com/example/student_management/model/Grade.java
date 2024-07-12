package com.example.student_management.model;

public enum Grade {
    A("A"),
    B("B"),B_PLUS("B+"),
    C("C"),C_PLUS("C+"),
    D("D"),D_PLUS("D+"),
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

    public static Grade fromScore(Float score) {
        if(score >= 8.5f) {
            return A;
        } else if(score >= 8.0f) {
            return B_PLUS;
        } else if(score >= 7.0f) {
            return B;
        } else if(score >= 6.5f) {
            return C_PLUS;
        } else if(score >= 5.5f) {
            return C;
        } else if(score >= 5.0f) {
            return D_PLUS;
        } else if(score >= 4.0f) {
            return D;
        } else {
            return F;
        }
    }

}
