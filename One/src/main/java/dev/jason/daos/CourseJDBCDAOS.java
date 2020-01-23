package dev.jason.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.jason.entities.Course;
import dev.jason.utilities.ConnectionUtil;

public class CourseJDBCDAOS implements CourseDAOS{

	public Course getCoursebyID(int c_id) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM course WHERE c_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c_id);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			rs.next();
			
			Course course = new Course();
			course.setC_id(rs.getInt("c_id"));
			course.setName(rs.getString("name"));
			course.setCost(rs.getInt("cost"));
			return course;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ID: " + c_id + " was not found.");
		return null;
	}

	public List<Course> getCourses() {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM course";
		List<Course> courses = new ArrayList<Course>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Course course;
			while (rs.next()) {
				course = new Course();
				course.setC_id(rs.getInt("c_id"));
				course.setName(rs.getString("name"));
				course.setCost(rs.getInt("cost"));
				courses.add(course);
			}
			if (courses.size() == 0) {
				System.out.println("There are no courses in the data base.");
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Course updateCourse(Course course) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "UPDATE course SET name=?, cost=? WHERE c_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, course.getName());
			ps.setInt(2, course.getCost());
			ps.setInt(3, course.getC_id());
			ps.execute();
			return course;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("That c_id was not found.");
		return null;
	}

}
