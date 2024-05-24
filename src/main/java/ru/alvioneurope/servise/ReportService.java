package ru.alvioneurope.servise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.alvioneurope.repository.CourseCompletionRepository;
import ru.alvioneurope.repository.ProfessorRepository;
import ru.alvioneurope.repository.StudentRepository;

@RequiredArgsConstructor
@Service
public class ReportService {
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final CourseCompletionRepository courseCompletionRepository;

    //TODO
    //Застрял на этом месте
    // из зи того что получаю затроенные данные необходимые для вычисления средней оценки

//    public DataReport creatData(Long professorId){
//        DataReport dataReport = new DataReport(
//                professorRepository.findById(professorId).get().getName(),
//                courseCompletionRepository.findAll
//        )
//    }
}
