package org.NagaEd.service;

import org.NagaEd.entity.Course;
import org.NagaEd.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public Course createCourse(Course course){
        return courseRepo.save(course);
    }

    @Override
    public Optional<Course> selectCourseById(Long id){
        return courseRepo.findById(id);
    }

    @Override
    public List<Course> selectAllCourse() {
        return courseRepo.findAll();
    }

    @Override
    public Course updateCourseById(Long id,Course c1) {
        return courseRepo.findById(id).map(course -> {
            course.setTitle(c1.getTitle());
            course.setDescription(c1.getDescription());
            course.setDuration(c1.getDuration());
            return courseRepo.save(course);
        }).orElseThrow(() -> new RuntimeException("Course not found with id " + id));
    }

    @Override
    public Boolean deleteCourseById(Long id) {
        Optional<Course> Course = courseRepo.findById(id);
        if (Course.isPresent()) {
            courseRepo.deleteById(id);
            return true;
        }
        return false;
    }


}
