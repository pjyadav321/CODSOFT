package StudentManagementSystem;

import java.util.Scanner;

public class StudentDetail
{
    private String rollNumber;
    private String name;
    private String grade;
    private String stream;
    private String studClass;

    public StudentDetail() {
    }

    public StudentDetail(String rollNumber, String name, String grade, String stream, String studClass) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        this.stream = stream;
        this.studClass = studClass;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getStudClass() {
        return studClass;
    }

    public void setStudClass(String studClass) {
        this.studClass = studClass;
    }

    @Override
    public String toString()
    {
        return " Student Details:\n" +
                "Roll Number:" + rollNumber +"\n" +
                "Name:" +name +"\n"+
                "Grade:" + grade +"\n" +
                "Stream:" + stream + "\n" +
                "Student Class:" + studClass;
    }
}
