package com.cg.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.rest.dao.IStudentDao;
import com.cg.rest.entities.Student;
import com.cg.rest.exception.StudentAlreadyExistsException;
import com.cg.rest.exception.StudentNotFoundException;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentDao dao;

	@Override
	public List<Student> findByName(String name) {
		System.out.println("name: " + name);
		List<Student> list = dao.findByFirstName(name);
		return list;
	}
	@Override
	public List<Student> findByFullName(String fname, String lname) {
		List<Student> list = dao.findByFullName(fname, lname);
		return list;
	}
	@Override
	public List<Student> findByFirstNameAndLastName(String fname, String lname) {
		List<Student> list = dao.findByFirstNameAndLastName(fname, lname);
		return list;
	}
	@Override
	public Student findById(Integer id) {
		System.out.println("id: "+id);
        Optional<Student> optional = dao.findById(id);
        if(!optional.isPresent()){
        	System.out.println("***error***");
            throw new StudentNotFoundException("student not found for id="+id);
        }
        Student student=optional.get();
        System.out.println("stud: "+ student);
        return student;
	}


	@Override
	public Student register(Student student) {
		boolean exists=student.getId()!=null && dao.existsById(student.getId());
        if(exists){
            throw new StudentAlreadyExistsException("student already exists for id="+student.getId());
        }
        student = dao.save(student);
        System.out.println("returning saved stud: " + student);
        return student;
	}

	
	
	@Override
	public List<Student> findAll() {
		System.out.println(dao.getClass().getName());
		List<Student> list = dao.findAll();
        return list;
	}


}
