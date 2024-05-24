package ru.alvioneurope.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.alvioneurope.entity.Professor;
import ru.alvioneurope.servise.ProfessorService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/professors")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    /**
     * http://localhost:8080/v1/professors/1
     */
    @GetMapping("/{id}")
    public Professor getById(@PathVariable Long id) {
        log.info("APP ProfessorController.getById( id = {})", id);
        return professorService.getById(id);
    }

    /**
     * http://localhost:8080/v1/professors
     */
    @GetMapping("")
    public List<Professor> getAll() {
        log.info("APP ProfessorController.getal()");
        return professorService.getAll();
    }

    /**
     * http://localhost:8080/v1/professors
     */
    @PostMapping("")
    public Professor create(@RequestBody Professor newProfessor) {
        log.info("APP ProfessorController.create( newProfessor = {})", newProfessor);
        Professor createdProfessor = professorService.create(newProfessor);
        return createdProfessor;
    }

    /**
     * http://localhost:8080/v1/professors/1
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("APP ProfessorController.deleteById( id = {})", id);
        professorService.delete(id);
    }

    /**
     * http://localhost:8080/v1/professors/5
     */
    @PutMapping("/{id}")
    public Professor update(@PathVariable Long id, @RequestBody Professor changedProfessor) {
        log.info("APP ProfessorController.edit( id = {},  Professor = {})", id, changedProfessor);
        return professorService.update(id, changedProfessor);
    }


}
