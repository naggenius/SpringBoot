package com.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.Student;

@Repository
public class StudentDao {

	private static Map<Integer, Student> students;

	static {
		students = new HashMap<Integer, Student>() {
			{
				put(1, new Student(1, "Nag", "EIE"));
				put(2, new Student(2, "Sam", "ECE"));
				put(3, new Student(3, "Sid", "EEE"));
			}
		};
	}

	public Collection<Student> getAllStudents() {
		return this.students.values();

	}

	public Student getStudentById(int id) {
		return this.students.get(id);
	}

	public void removeStudentById(int id) {
		this.students.remove(id);		
	}
	
	public void updateStudentById(Student student) {
		Student s = students.get(student.getId());
		s.setCourse(student.getCourse());
		s.setName(student.getName());
		students.put(student.getId(), student);
	}

	public void insertStudent(Student student) {
		students.put(student.getId(), student);
		
	}
	
}
