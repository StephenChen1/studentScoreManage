package dao;

import java.util.List;

import entity.Course;

public interface CourseDao {
	
	/**
	 * 返回所有课程
	 * @return
	 */
	List<Course> getAllCourses();
}
