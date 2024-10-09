package org.NagaEd.controller;

import org.NagaEd.entity.Course;
import org.NagaEd.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //Create Course
    @PostMapping("/createCourse")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        Course savedCourse=courseService.createCourse(course);
        return ResponseEntity.ok(savedCourse);
    }

    // Get Course
    @GetMapping("/getCourseById/{id}")
    public ResponseEntity<Course> selectCourseById(@PathVariable Long id){
        Optional<Course> course = courseService.selectCourseById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get All Course
    @GetMapping("/getAllCourse")
    public ResponseEntity<List<Course>> selectAllCourse(){
        List<Course> selectedAllCourse=courseService.selectAllCourse();
        return ResponseEntity.ok(selectedAllCourse);
    }

    // Update Course
    @PutMapping("/updateCourseById/{id}")
    public ResponseEntity<Course> updateCourseById(@PathVariable Long id,@RequestBody Course c1){
        try {
            Course course = courseService.updateCourseById(id, c1);
            return ResponseEntity.ok(course);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Course
    @DeleteMapping("/deleteCourseById/{id}")
    public ResponseEntity<Boolean> deleteCourseById(@PathVariable Long id){
        Boolean isDeleted = courseService.deleteCourseById(id);
        if (isDeleted){
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(404).body(false);
        }
    }

}
