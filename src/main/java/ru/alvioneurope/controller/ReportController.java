package ru.alvioneurope.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alvioneurope.report.CreaterProfessorReport;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


@Slf4j
//@RestController
@Controller
@RequestMapping("/v1/report")
@RequiredArgsConstructor
public class ReportController {



    //TODO - отчет формируется фэйковыми данными.
    @GetMapping("")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        log.info(" App ReportController.exportToExcel - Формирование отчета");
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=report.xlsx";    //задаем форматформат
        response.setHeader(headerKey, headerValue);
        CreaterProfessorReport excelExporter = new CreaterProfessorReport();
        excelExporter.export(response);
    }
}
