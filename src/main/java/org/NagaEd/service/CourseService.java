package org.NagaEd.service;

import org.NagaEd.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course createCourse(Course course);

    Optional<Course> selectCourseById(Long id);

    List<Course> selectAllCourse();

    Course updateCourseById(Long id,Course course);;

    Boolean deleteCourseById(Long id);

}
