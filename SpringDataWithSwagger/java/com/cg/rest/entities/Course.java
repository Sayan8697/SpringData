package com.cg.rest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double fee;
	@ManyToOne
	@JoinColumn(name="stud_id")
	private Student student;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course() {
	}
	public Course(int id, String name, double fee) {
		this.id = id;
		this.name = name;
		this.fee = fee;
	}
	@Override
	public String toString() {
		// don't include student to avoid cyclic call
		return "Course [id=" + id + ", name=" + name + ", fee=" + fee + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	
}
