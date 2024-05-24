package ru.alvioneurope.servise;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.alvioneurope.entity.Student;
import ru.alvioneurope.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;


    public Student getById(Long id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    //    @Transactional
    public Student create(Student newStudent) {
        Student createdStudent = studentRepository.save(newStudent);
        return createdStudent;
    }

    //    @Transactional
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public Student update(Long id, Student changedStudent) {
        Student notRelevantStudent = studentRepository.getById(id);
        BeanUtils.copyProperties(changedStudent, notRelevantStudent, "id");
        return studentRepository.save(notRelevantStudent);
    }

    public List<Student> getAllStudentsByCourseId(Long courseId) {
        return studentRepository.findAllByCourseId(courseId);
    }

    public List<Student> getAllStudentsByProfessorId(Long professorId) {
        return studentRepository.findAllByCourseId(professorId);
    }

    public List<Integer> getAllGradesByStudentId(Long studentId) {
        log.info("APP StudentService.getAllGradesByStudentId( studentId = {})", studentId);
        return studentRepository.findAllGradesByStudentId(studentId);
    }

    public List<Integer> getAllGradesByStudentIdAndCourseId(Long studentId, Long courseId) {
        log.info("APP StudentService.getAllGradesByStudentId( studentId = {}, courseId ={})", studentId, courseId);
        return studentRepository.findAllGradesByStudentIdAndCourseId(studentId, courseId);
    }

    public void studentRegistrationOnCourse(Long studentId, Long courseId) {
        log.info("APP StudentService.studentRegistrationOnCourse( studentId = {}, courseId ={})", studentId, courseId);
        studentRepository.studentRegistrationOnCourse(studentId, courseId);
    }

    public void deleteStudentFromCourse(Long studentId, Long courseId) {
        studentRepository.deleteStudentFromCourse(studentId, courseId);
    }

}




