package ru.alvioneurope.report;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataReport {
    private String professorName;
    private String numberStudents;
    private String averageRating;
}
