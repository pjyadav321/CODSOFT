package com.studentsystem.service;

import com.studentsystem.model.Student;
import com.studentsystem.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService
{

    IStudentRepository iStudentRepository;

    public StudentService(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    public Optional<Student> searchStudent(String rollNumber)
    {
        try {
            return iStudentRepository.findById(rollNumber);
        }
        catch (Exception ex){
            return null;
        }

    }

    public List<Student> getAllStudents()
    {
        try {
            return iStudentRepository.findAll();
            }
        catch (Exception ex){
            return null;
        }
    }

    public String createStudent(Student student)
    {
        try {
            iStudentRepository.save(student);
            return "New Student details created successfully!!";
        }
        catch (Exception ex){
            return ex.getMessage();
        }

    }

    public String updateStudent(Student student)
    {
        try {
            if (iStudentRepository.existsById(student.getRollNumber())) {
                iStudentRepository.save(student);
                return "Student detail updated successfully!!";
            } else {
                return "Student detail not found";
            }
        }
        catch(Exception ex)
        {
            return "Error updating Student detail!! " + ex.getMessage();
        }

    }

    public String deleteStudent(String rollNumber)
    {
        try {
            if (iStudentRepository.existsById(rollNumber))
            {
                iStudentRepository.deleteById(rollNumber);
                return "Student detail deleted successfully!!";
            }
            else {
                return "Student detail not found";
            }
        }
        catch (Exception ex)
        {
            return "Error Deleting Student detail!! " + ex.getMessage();
        }
    }
}
