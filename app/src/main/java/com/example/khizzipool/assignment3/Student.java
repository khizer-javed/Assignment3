package com.example.khizzipool.assignment3;

public class Student {
    private String studentName;
    private String studentClass;
    private String studentReg;
    private String id;

    public Student()
    {}

    public Student(String studentName, String studentClass, String studentReg, String id) {
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentReg = studentReg;
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public String getStudentReg() {
        return studentReg;
    }

    public String getId() {
        return id;
    }
}
