package ru.alvioneurope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ru.alvioneurope.entity.Student;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {

    //Поиск всех студентов по курсу ID
    @Query(value = "SELECT student.* FROM student\n" +
            "inner join course_completion on student.id = course_completion.student_id\n" +
            "inner join course on course_completion.course_id = :course_Id", nativeQuery = true)
    List<Student> findAllByCourseId(@Param("course_Id") Long courseId);


    //Поиск всех студентов обучающихся по Профессору Id
    @Query(value = "SELECT student.* FROM student\n" +
            "inner join course_completion on student.id = course_completion.students_id\n" +
            "inner join course on course_completion.course_id = :course.id\n" +
            "inner join professor_course on course.id = professor_course.course_id\n" +
            "inner join professor on professor_course.professor_id = :professor_Id", nativeQuery = true)
    List<Student> findAllByProfessorId(@Param("professor_Id") Long professorId);


    //Вернет список оценок конкретного студента по всем курсам
    @Query(value = "SELECT coursecompletion_grades.grades FROM coursecompletion_grades\n" +
            "inner join course_completion on course_completion.id=  coursecompletion_grades.coursecompletion_id\n" +
            "inner join student on course_completion.student_id= :student_Id", nativeQuery = true)
    List<Integer> findAllGradesByStudentId(@Param("student_Id") Long studentId);


    //Вернет список оценок конкретного студента по конкретнолму курсу
    @Query(value = "SELECT coursecompletion_grades.grades FROM coursecompletion_grades\n" +
            "inner join course_completion on course_completion.id=  coursecompletion_grades.coursecompletion_id\n" +
            "inner join student on course_completion.student_id = :student_id\n" +
            "WHERE course_completion.course_id = :course_id", nativeQuery = true)
    List<Integer> findAllGradesByStudentIdAndCourseId(@Param("student_id") Long studentId, @Param("course_id") Long courseId);

    //запись студента (studentId) на курс (courseId)
    @Modifying
    @Query(value = "insert into course_completion (student_id, course_id) values ( :student_id," +
            " :course_id)", nativeQuery = true)
    void studentRegistrationOnCourse(@Param("student_id") Long studentId, @Param("course_id") Long courseId);

    //Удаление студента из курса
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from  course_completion" +
            " where course_completion.student_id= :student_id and course_completion.course_id= " +
            ":course_id", nativeQuery = true)
    void deleteStudentFromCourse(@Param("student_id") Long studentId, @Param("course_id") Long courseId);

}
