package ru.alvioneurope.servise;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.alvioneurope.entity.Course;
import ru.alvioneurope.repository.CourseRepository;
import ru.alvioneurope.repository.ProfessorRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final ProfessorRepository professorRepository;

    public Course getById(Long id) {
        return courseRepository.findById(id).get();
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course create(Course newCourse) {
        Course createdCourse = courseRepository.save(newCourse);
        return createdCourse;
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    public Course update(Long id, Course changedCourse) {
        Course notRelevantCourse = courseRepository.getById(id);
        BeanUtils.copyProperties(changedCourse, notRelevantCourse, "id");
        return courseRepository.save(notRelevantCourse);
    }

    public List<Course> getAllCoursesByProfessorId(Long professorId) {
        return courseRepository.getAllCoursesByProfessorId(professorId);
    }

}

