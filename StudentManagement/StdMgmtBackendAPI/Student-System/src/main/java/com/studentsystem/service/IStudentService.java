package com.studentsystem.service;

import com.studentsystem.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService
{
    public Optional<Student> searchStudent(String rollNumber);

    public List<Student> getAllStudents();

    String createStudent(Student student);

    String updateStudent(Student student);

    String deleteStudent(String rollNumber);
}
