package com.jbk.student.repositoryIMPL;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.student.domain.Student;
import com.jbk.student.repository.StudentRepository;

@Repository
public class StudentRepositoryIMPL implements StudentRepository {

	@Autowired
	SessionFactory sessionFactory;

	List<Student> list = new ArrayList<Student>();

	public StudentRepositoryIMPL() {
		list.add(new Student(1, 57, "Sharukh", "Khan", "khan8729@gmail.com", "Male", "Mumbai", "Mannat"));
		list.add(new Student(2, 24, "Yogesh", "Bachhav", "yo9765258700@gmail.com", "Male", "Jalgaon", "Ram Nagar"));
		list.add(new Student(3, 23, "Ram", "Biyani", "ram78687@gmail.com", "Male", "Philand", "Metro Manila"));
		list.add(new Student(4, 23, "Rohit", "Amurthkar", "rohit75496@gmail.com", "Male", "Jalgaon", "Swami Samarth"));
		list.add(new Student(5, 24, "Shubham", "Rote", "shubham90879@gmail.com", "Male", "Pune", "Hinjewadi"));
		list.add(new Student(6, 24, "Mayur", "Chaudhari", "mayur887057@gmail.com", "Male", "Jalgaon", "Ram Nagar"));
		list.add(new Student(7, 30, "hjsd", "jef;", "sihlk", "ujsjikl", "ksdj", "lksjdj"));
		list.add(new Student(8, 68, "hjsd", "jef;", "sihlk", "ujsjikl", "ksdj", "lksjdj"));
		list.add(new Student(9, 95, "kxnjcvn", "kjvkl;", "l.kh lal", "jhfjj h", "ksdj", "lfhjsj"));
	}

	@Override
	public Student saveStudent(Student student) {
		list.add(student);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		list.containsAll(list);
		return list;
	}

	@Override
	public Student getStudentById(long studentById) {
		Student student = list.stream().filter(filterd -> filterd.getId() == studentById).findFirst().orElse(null);
		return student;
	}

	@Override
	public String updateStudentById(long studentById) {
		Session session = sessionFactory.openSession();
		Student student = session.load(Student.class, 4);
		try {
			session.update(student);
			session.beginTransaction().commit();
			list.set(4, new Student(5, 47, "Tobey", "Maguire", "tobey98467@gmail.com", "Male", "California",
					"Santa Monica"));
			list.set(5, new Student(6, 39, "Andrew", "Garfield", "andrew97068@gmail.com", "Male", "Los Angeles",
					"Califonia"));
			list.add(6, new Student(7, 53, "Jennifer", "Lopez", "lopez9999@gmail.com", "Female", "New York City",
					"8581 Santa Monica Boulevard"));
			return "data updated";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return "Student doesn't exists";
	}

	@Override
	public String deleteStudent(long id) {
		Session session = sessionFactory.openSession();
		Student student = session.load(Student.class, 8);
		try {
			list.remove(8);
			session.delete(student);
			session.beginTransaction().commit();
			return "Student deleted";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return "Student doesn't exists";

//		if (student != null) {
//			list.remove(1);
//			session.delete(student);
//			session.beginTransaction().commit();
//			return "Student deleted";
//		} else {
//			return "Student doesn't exists";
//		}
	}
}
