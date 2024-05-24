package ru.alvioneurope.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = "studentCourses")
@EqualsAndHashCode(of = {"id", "name", "recordBook"})
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    //    @Column(nullable = false, unique = true)
    private Integer recordBook; //номер зачетной книжки
    private Float averageScore; //средний балл


    @JsonManagedReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CourseCompletion> studentCourses = new ArrayList<>();

}
