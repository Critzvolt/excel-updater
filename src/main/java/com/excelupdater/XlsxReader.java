package com.excelupdater;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxReader {

    public static List<Substance> getFileContents(String filePath)
    {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet is used

            List<Substance> substances = new ArrayList<>();

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Skip header row
                if (row.getRowNum() < 7) {
                    continue;
                }

                String indexNo = row.getCell(0).getStringCellValue();
                String ICE = row.getCell(1).getStringCellValue();
                String ecNo = row.getCell(2).getStringCellValue();
                String casNo = row.getCell(3).getStringCellValue();
                String HSC = row.getCell(5).getStringCellValue();

                Substance substance = new Substance(indexNo, ICE, ecNo, casNo, HSC);
                substances.add(substance);
            }

            return substances;

            // Do something with the employees list
            /*for (Substance substance : substances) {
                System.out.println(substance);
            }*/

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}