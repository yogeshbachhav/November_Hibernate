package com.jbk.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.student.domain.Student;
import com.jbk.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/saveProduct")
	public Student saveStudent(@RequestBody Student student) {
		Student saveStudent = studentService.saveStudent(student);
		return saveStudent;
	}

	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() {
		List<Student> allStudents = studentService.getAllStudents();
		return allStudents;
	}

	@GetMapping("/getStudentById/{productId}")
	public Student getStudentById(@PathVariable("productId") long productId) {
		Student studentById = studentService.getStudentById(productId);
		return studentById;
	}

	@PutMapping("/updateStudent/{updateId}")
	public String updateStudentById(@PathVariable("updateId") long updateId) {
		String updateStudentById = studentService.updateStudentById(updateId);
		return updateStudentById;
	}

	@DeleteMapping("/deleteStudent/{deleteId}")
	public String deleteStudent(@PathVariable("deleteId") long id) {
		String deleteStudent = studentService.deleteStudent(id);
		return deleteStudent;
	}
}
