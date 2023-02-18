package com.jbk.student.repository;

import java.util.List;

import com.jbk.student.domain.Student;

public interface StudentRepository {

	public Student saveStudent(Student student);

	public List<Student> getAllStudents();

	public Student getStudentById(long studentById);

	public String updateStudentById(long studentById);

	public String deleteStudent(long id);
}
