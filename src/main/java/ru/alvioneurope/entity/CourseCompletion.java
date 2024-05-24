package ru.alvioneurope.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course_completion")
public class CourseCompletion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer score;
    @ElementCollection(targetClass = Integer.class)
    @Column(name = "grades")
    private List<Integer> grades; // оценки по курсу
    private Integer finalScore; //финальная оценка, в случае завершения курса


    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @JsonBackReference
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
}
