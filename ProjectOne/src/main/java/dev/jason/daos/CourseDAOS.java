package dev.jason.daos;

import java.util.List;

import dev.jason.entities.Course;

public interface CourseDAOS {

	// CRUD
	// CREATE is not required for the program

	// READ
	/***
	 * This will get the item based off the c_id
	 * 
	 * @param c_id - the primary key being searched for on the database
	 * @return - the item that was searched for. Will return NULL if the item was
	 *         not found
	 */
	public Course getCoursebyID(int c_id);

	/***
	 * Will get all the items in a List.
	 * 
	 * @return - The list of all items in the database. Will return NULL if the
	 *         database is empty
	 */
	public List<Course> getCourses();

	// UPDATE
	/***
	 * The course will be found by ID and will update ALL information will be
	 * updated in the database
	 * 
	 * @param course - The course to be updated by ID and fields to be updated
	 * @return The course being searched for. Will return NULL if the item was not
	 *         found by c_id
	 */
	public Course updateCourse(Course course);

	// There is no DELETE for Courses
}
