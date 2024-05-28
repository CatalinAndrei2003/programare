package org.example;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 class CreateExcelWithApachePOI {

    public static void main(String[] args) {
        Map<String, Object[]> data = new TreeMap<>();
        data.put("2", new Object[] {"Amit", "Shukla", 9, 8, 7, 5});
        data.put("3", new Object[] {"Lokesh", "Gupta", 8, 9, 6, 7});
        data.put("4", new Object[] {"John", "Adwards", 8, 8, 7, 6});
        data.put("5", new Object[] {"Brian", "Schultz", 7, 6, 8, 9});

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            int rowNum = 0;
            for (Map.Entry<String, Object[]> entry : data.entrySet()) {
                Row row = sheet.createRow(rowNum++);
                Object[] objArr = entry.getValue();
                int cellNum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellNum++);
                    if (rowNum == 1) {
                        cell.setCellStyle(headerCellStyle);
                    }
                    if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Integer) {
                        cell.setCellValue((Integer) obj);
                    }
                }
            }

            for (int i = 0; i < data.get("2").length; i++) {
                sheet.autoSizeColumn(i);
            }

            Row lastRow = sheet.getRow(sheet.getLastRowNum());
            int totalColumns = lastRow.getLastCellNum();
            Row summaryRow = sheet.createRow(sheet.getLastRowNum() + 2);
            CellStyle summaryCellStyle = workbook.createCellStyle();
            summaryCellStyle.setFont(headerFont);

            for (int col = 2; col < totalColumns; col++) {
                int sum = 0;
                int max = Integer.MIN_VALUE;
                for (Row row : sheet) {
                    if (row.getRowNum() != 0 && row.getRowNum() != sheet.getLastRowNum() && row.getCell(col) != null) {
                        sum += (int) row.getCell(col).getNumericCellValue();
                        max = Math.max(max, (int) row.getCell(col).getNumericCellValue());
                    }
                }
                double avg = (double) sum / (sheet.getLastRowNum() - 1);
                Cell summaryCell = summaryRow.createCell(col);
                summaryCell.setCellValue("Max: " + max + ", Avg: " + avg);
                summaryCell.setCellStyle(summaryCellStyle);
            }

            try (FileOutputStream fileOut = new FileOutputStream("output.xlsx")) {
                workbook.write(fileOut);
                System.out.println("Fișierul 'output.xlsx' a fost creat cu succes!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

