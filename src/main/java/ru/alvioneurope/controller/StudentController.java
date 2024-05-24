package ru.alvioneurope.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alvioneurope.entity.Student;
import ru.alvioneurope.servise.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/students")
public class StudentController {
    private final StudentService studentService;

    /**
     * http://localhost:8080/v1/students/1
     */
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        log.info("APP StudentController.getById( id = {})", id);
        return studentService.getById(id);
    }

    /**
     * http://localhost:8080/v1/students
     */
    @GetMapping("")
    public List<Student> getAll(){
        log.info("APP StudentController.getAll");
        return studentService.getAll();
    }

    /**
     * http://localhost:8080/v1/students
     */
    @PostMapping("")
    public Student create(@RequestBody Student newStudent) {
        log.info("APP StudentController.create(newStudent = {})", newStudent);
        return studentService.create(newStudent);
    }

    /**
     * http://localhost:8080/v1/students/4
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("APP StudentController.deleteById(id = {})", id);
        studentService.delete(id);
    }

    /**
     * http://localhost:8080/v1/students/5
     */
    @PutMapping("/{id}")
    public Student Update(@PathVariable Long id, @RequestBody Student  changedStudent) {
        log.info("APP StudentController.Update(id = {},  Student = {})", id, changedStudent);
        return studentService.update(id, changedStudent);
    }


    /**
     * http://localhost:8080/v1/students/courses/{courseId}
     */
    @GetMapping("/courses/{courseId}")
    public List<Student> getAllStudentsByCourseId(@PathVariable Long courseId){
        log.info("APP StudentController.getAllStudentsByCourseId( studentId = {})", courseId);
        return studentService.getAllStudentsByCourseId(courseId);
    }

    /**
     * http://localhost:8080/v1/students/professors/{professorId}
     */
    @GetMapping("/professors/{professorId}")
    public List<Student> getAllStudentsByProfessorId(@PathVariable Long professorId){
        log.info("APP StudentController.getAllStudentsByProfessorId( professorId = {})", professorId);
        return studentService.getAllStudentsByProfessorId(professorId);
    }

    /**
     * http://localhost:8080/v1/students/{studentId}/grades
     */
    @GetMapping("/{studentId}/grades")
    public List<Integer> findAllGradesByStudentId(@PathVariable Long studentId){
        log.info("APP StudentController.getAllStudntsByStudentId( studentId = {})", studentId);
        return studentService.getAllGradesByStudentId(studentId);
    }

    /**
     * http://localhost:8080/v1/students/{studentId}/courses/{courseId}/grades
     */
    @GetMapping("/{studentId}/courses/{courseId}/grades")
    public List<Integer> getAllGradesByStudentIdAndCourseId(@PathVariable Long studentId, @PathVariable Long courseId){
        log.info("APP StudentController.getAllStudentsByStudentId( studentId = {}, courseId = {})", studentId, courseId);
        return studentService.getAllGradesByStudentIdAndCourseId(studentId, courseId);
    }


    /**
     * добавление студента с курс
     * http://localhost:8080/v1/students/{std_id}/courses/{crs_id}/add
     */
    @GetMapping("/{std_id}/courses/{crs_id}/add")
    public void studentRegistrationOnCourse(@PathVariable(name="std_id") Long studentId,
                                            @PathVariable(name="crs_id") Long courseId){
        log.info("APP StudentController.studentRegistrationOnCourse( studentId = {}, courseId = {})", studentId, courseId);
        studentService.studentRegistrationOnCourse(studentId, courseId);
    }

    /**
     * Удаление студента с курс
     * http://localhost:8080/v1/students/{studentId}/courses/{courseId}/delete
     */
    @GetMapping("/{std_id}/courses/{crs_id}/delete")
    public void deleteStudentFromCourse(@PathVariable(name="std_id") Long studentId,
                                        @PathVariable(name="crs_id") Long courseId){
        log.info("APP CourseCompletionControllers.deleteStudentFromCourse( studentId = {}, courseId = {})", studentId, courseId);
        studentService.deleteStudentFromCourse(studentId, courseId);
    }


}
