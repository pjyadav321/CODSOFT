package com.studentsystem.repository;

import com.studentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, String>
{
}
