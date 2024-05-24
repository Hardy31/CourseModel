package ru.alvioneurope.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@ToString(exclude = {"likes"})

@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    @Column(nullable = false)
    private String title;
    //    @Column(nullable = false)
    private Integer number;
    //    @Column(nullable = false)
    private Float cost;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<ProfessorCourse> courseProfessors = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<CourseCompletion> courseStudents = new ArrayList<>();

}
