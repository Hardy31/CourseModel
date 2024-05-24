package ru.alvioneurope.servise;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.alvioneurope.entity.Professor;
import ru.alvioneurope.repository.ProfessorRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public Professor getById(Long id) {
        return professorRepository.findById(id).get();
    }

    public List<Professor> getAll() {
        return professorRepository.findAll();
    }

    public Professor create(Professor newProfessor) {
        Professor createdProfessor = professorRepository.save(newProfessor);
        return createdProfessor;
    }

    public void delete(Long id) {
        professorRepository.deleteById(id);
    }

    public Professor update(Long id, Professor updatedProfessor) {
        Professor notRelevantProfessor = professorRepository.getById(id);
        BeanUtils.copyProperties(updatedProfessor, notRelevantProfessor, "id");
        return professorRepository.save(notRelevantProfessor);
    }

}
