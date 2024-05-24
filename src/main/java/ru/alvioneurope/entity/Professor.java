package ru.alvioneurope.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = "courses")
@EqualsAndHashCode(of = "name")
@Builder
@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Float payment;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private List<ProfessorCourse> orifessorCourses = new ArrayList<>();
}
