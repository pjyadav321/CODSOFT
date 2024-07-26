package com.studentsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student
{

    @Id
    String rollNumber;
    String name;
    String studClass;
    String stream;
    String grade;

    public Student()
    {
    }

    public Student(String rollNumber, String name, String studClass, String stream, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.studClass = studClass;
        this.stream = stream;
        this.grade = grade;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudClass() {
        return studClass;
    }

    public void setStudClass(String studClass) {
        this.studClass = studClass;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
