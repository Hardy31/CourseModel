package ru.alvioneurope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.alvioneurope.entity.Course;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course, Long> {


    @PostConstruct
    private  void init(){ System.out.println("init Course repository");}

    //Поиск всех курсов  по профессор ID
    @Query(value = "SELECT course.* FROM course\n" +
            "inner join professor_course on course.id = professor_course.course_id\n" +
            "inner join professor on professor_course.professor_id = :id",nativeQuery = true)
    List<Course> getAllCoursesByProfessorId(@Param("id") Long id);


}
