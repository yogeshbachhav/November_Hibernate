package com.jbk.student.service;

import java.util.List;

import com.jbk.student.domain.Student;

public interface StudentService {

	public Student saveStudent(Student student);

	public List<Student> getAllStudents();

	public Student getStudentById(long studentByid);

	public String updateStudentById(long studentById);

	public String deleteStudent(long id);
}
