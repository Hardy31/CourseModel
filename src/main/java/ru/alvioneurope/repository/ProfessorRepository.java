package ru.alvioneurope.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alvioneurope.entity.Professor;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Repository
@Transactional

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @PostConstruct
    private void init() {
        System.out.println("init ProfessorRepository");
    }


}