package ru.alvioneurope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alvioneurope.entity.CourseCompletion;

@Repository
public interface CourseCompletionRepository extends JpaRepository<CourseCompletion, Long> {
}
