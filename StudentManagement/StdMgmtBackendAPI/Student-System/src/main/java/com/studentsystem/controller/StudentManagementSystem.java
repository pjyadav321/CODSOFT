package com.studentsystem.controller;

import com.studentsystem.model.Student;
import com.studentsystem.service.IStudentService;
import com.studentsystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentManagementSystem
{
    IStudentService studentService;

    public StudentManagementSystem(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{rollNumber}")
    public Optional<Student> searchStudent(@PathVariable String rollNumber)
    {
        return studentService.searchStudent(rollNumber);
    }

    @GetMapping
    public List<Student> getAllStudent()
    {
        return studentService.getAllStudents();
    }

    @PostMapping
    public String createStudent(@RequestBody Student student)
    {
        return studentService.createStudent(student);
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student)
    {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{rollNumber}")
    public String deleteStudent(@PathVariable String rollNumber)
    {
        return studentService.deleteStudent(rollNumber);
    }

}
