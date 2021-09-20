package com.cg.rest.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.cg.rest.dto.CourseDetails;
import com.cg.rest.dto.StudentDetails;
import com.cg.rest.entities.Course;
import com.cg.rest.entities.Student;

@Component
public class StudentUtil {
	public StudentDetails toDetails(Student student) {
		Set<Course> courses = student.getCourses();
		Set<CourseDetails> details = new HashSet<>();
		// to prevent cyclic reference to student in course when json is created
		for (Course course : courses) {
			details.add(new CourseDetails(course));
		}
		return new StudentDetails(student.getId(), student.getFirstName(), 
        				student.getLastName(), student.getAge(), details);
    }
	public List<StudentDetails> toDetails(Collection<Student> students) {
        List<StudentDetails> detailList = new ArrayList<>();
        for (Student student : students) {
            StudentDetails details = toDetails(student);
            System.out.println(details);
            detailList.add(details);
        }
        return detailList;
    }
}
