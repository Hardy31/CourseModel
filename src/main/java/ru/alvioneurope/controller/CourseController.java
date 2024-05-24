package ru.alvioneurope.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.alvioneurope.entity.Course;
import ru.alvioneurope.servise.CourseService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    /**
     * http://localhost:8080/v1/courses/1
     */
    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) {
        log.info("APP CourseController.getById( id = {})", id);
        return courseService.getById(id);
    }

    /**
     * http://localhost:8080/v1/courses
     */
    @GetMapping("")
    public List<Course> getAll() {
        log.info("APP CourseController.getall()");
        return courseService.getAll();
    }

    /**
     * http://localhost:8080/v1/courses
     */
    @PostMapping("")
    public Course create(@RequestBody Course newCourse) {
        log.info("APP CourseController.create( newCourse = {})", newCourse);
        Course createdCourse = courseService.create(newCourse);
        return createdCourse;
    }

    /**
     * http://localhost:8080/v1/courses/4
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("APP CourseController.deleteById( id = {})", id);
        courseService.delete(id);
    }

    /**
     * http://localhost:8080/v1/courses/5
     */
    @PutMapping("/{id}")
    public Course edit(@PathVariable Long id, @RequestBody Course changedCourse) {
        log.info("APP CourseController.edit( id = {},  Course = {})", id, changedCourse);
        return courseService.update(id, changedCourse);
    }

    /**
     * http://localhost:8080/v1/courses/5
     */
    @GetMapping("/professor/{id}")
    public List<Course> getAllCoursesByProfessorId(@PathVariable Long professorId) {
        log.info("APP CourseController.getAllCoursesByProfessorId( professorId = {})", professorId);
        return courseService.getAllCoursesByProfessorId(professorId);
    }


}


