package com.jbk.student.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.student.domain.Student;
import com.jbk.student.repository.StudentRepository;
import com.jbk.student.service.StudentService;

@Service
public class StudentServiceIMPL implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.saveStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.getAllStudents();
	}

	@Override
	public Student getStudentById(long studentById) {
		Student student = studentRepository.getStudentById(studentById);
		return student;
	}

	@Override
	public String updateStudentById(long studentById) {
		String updateStudent = studentRepository.updateStudentById(studentById);
		return updateStudent;
	}

	@Override
	public String deleteStudent(long id) {
		String deleteStudent = studentRepository.deleteStudent(id);
		return deleteStudent;
	}
}
