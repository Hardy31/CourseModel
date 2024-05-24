package ru.alvioneurope.report;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;


@Data
@NoArgsConstructor

public class CreaterProfessorReport {

    private XSSFWorkbook workbook = new XSSFWorkbook();
    private XSSFSheet sheet;
    private List<DataReport> listUsers;


    CellStyle headerStyle, dataStale;
    XSSFFont headerFont, dataFont;

    private void initStyle() {
        headerStyle = workbook.createCellStyle();
        headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeight(24);
        headerStyle.setFont(headerFont);

        dataStale = workbook.createCellStyle();
        dataFont = workbook.createFont();
        dataFont.setBold(true);
        dataFont.setFontHeight(14);
        dataStale.setFont(dataFont);
    }

    private void writeHeader() {
        sheet = workbook.createSheet("Report on the workload of teaching staff.");
        Row row = sheet.createRow(0);
        initStyle();
        createCell(row, 0, "ФИО профессора", headerStyle);
        createCell(row, 1, "Колличество студентов", headerStyle);
        createCell(row, 2, "Средняя успеваемость", headerStyle);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(dataStale);
    }

    private void writeDataLines() {
        int rowCount = 1;

        listUsers.add(new DataReport("Проф1", "50", "3.7"));
        listUsers.add(new DataReport("Проф2", "100", "4.2"));
        listUsers.add(new DataReport("Проф3", "150", "4.1"));

        for (DataReport user : listUsers) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, user.getProfessorName(), dataStale);
            createCell(row, columnCount++, user.getNumberStudents(), dataStale);
            createCell(row, columnCount++, user.getAverageRating(), dataStale);
        }

    }

    public void export(HttpServletResponse response) throws IOException {
        initStyle();
        writeHeader();
        writeDataLines();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
