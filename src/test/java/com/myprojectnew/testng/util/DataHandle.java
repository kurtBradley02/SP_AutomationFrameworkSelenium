package com.myprojectnew.testng.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataHandle {

    private Workbook workbook;

    public DataHandle(String path) throws IOException {
        try (FileInputStream file = new FileInputStream(path)) {
            this.workbook = new XSSFWorkbook(file);
        }
    }

    // Returns all non-empty values from a specific column in the given sheet
    public List<String> getAllValuesInColumn(int sheetIndex, int colIndex) {
        List<String> values = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        if (sheet == null) return values;

        DataFormatter formatter = new DataFormatter();

        for (Row row : sheet) {
            Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String value = formatter.formatCellValue(cell).trim();
            if (!value.isEmpty()) {
                values.add(value);
            }
        }
        return values;
    }

    // Returns each row's selected columns as a String array
    public List<String[]> getAllValuesInColumns(int sheetIndex, int[] colIndices) {
        List<String[]> rows = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        if (sheet == null) return rows;

        DataFormatter formatter = new DataFormatter();

        for (Row row : sheet) {
            String[] rowValues = new String[colIndices.length];
            boolean hasNonEmpty = false;

            for (int i = 0; i < colIndices.length; i++) {
                Cell cell = row.getCell(colIndices[i], Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                String value = formatter.formatCellValue(cell).trim();
                rowValues[i] = value;
                if (!value.isEmpty()) hasNonEmpty = true;
            }

            // Add the row only if at least one cell is not empty
            if (hasNonEmpty) {
                rows.add(rowValues);
            }
        }
        return rows;
    }

    // Optional: Release resources if needed (for very large files)
    public void close() throws IOException {
        if (workbook != null) workbook.close();
    }

}
