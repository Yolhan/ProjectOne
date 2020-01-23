package dev.jason.daostest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dev.jason.daos.CourseDAOS;
import dev.jason.daos.CourseJDBCDAOS;
import dev.jason.entities.Course;
import junit.framework.Assert;

public class CourseTest {

	@Test
	public void getCourseByIDTest() {
		// Item creation
		CourseDAOS cd = new CourseJDBCDAOS();
		Course course = new Course();
		
		// Testing positive test case
		course.setC_id(1);
		course = cd.getCoursebyID(course.getC_id());
		Assert.assertEquals("Stellar Cartography", course.getName());
		System.out.println(course);
		
		// Testing negative test case
		course.setC_id(22);
		course = cd.getCoursebyID(course.getC_id());
		Assert.assertNull(course);
	}
	
	@Test
	public void getEmployeesTest() {
		CourseDAOS cd = new CourseJDBCDAOS();
		Course course = new Course();
		
		List<Course> courses = new ArrayList<Course>(cd.getCourses());
		for (Course course2 : courses) {
			System.out.println(course2);
		}
	}
	
	@Test
	public void updateEmployeeTest() {
		CourseDAOS cd = new CourseJDBCDAOS();
		Course course = new Course(9, "Test Cloning Class", 1500);
		Course course2 = new Course();
		
		course2 = cd.updateCourse(course);
		Assert.assertNotNull(course2);
		
		System.out.println(course);
		System.out.println(course2);
	}
}
