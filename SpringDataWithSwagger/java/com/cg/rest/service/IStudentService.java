package com.cg.rest.service;

import java.util.List;

import com.cg.rest.entities.Student;

public interface IStudentService {

	Student findById(Integer id);

	List<Student> findAll();

	Student register(Student student);

	List<Student> findByName(String name);

	List<Student> findByFullName(String fname, String lname);

	List<Student> findByFirstNameAndLastName(String fname, String lname);

}
