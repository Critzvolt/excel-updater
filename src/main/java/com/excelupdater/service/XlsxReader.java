package com.excelupdater.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.excelupdater.entity.Substance;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxReader {

    //public static List<Substance> getFileContents(String filePath)
    public static List<Substance> getFileContents(InputStream fis)
    {
        //try (FileInputStream fis = new FileInputStream(filePath);
        try (Workbook workbook = new XSSFWorkbook(fis)) { //czy tu sie XSSFWorkbook popierdoli z InputStream zamiast FileInputStream?

            Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet is used

            List<Substance> substances = new ArrayList<>();

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Skip header row
                if (row.getRowNum() < 7) {
                    continue;
                }

                Integer id = row.getRowNum() - 7;
                String index = row.getCell(0).getStringCellValue();
                String ice = row.getCell(1).getStringCellValue();
                String ec = row.getCell(2).getStringCellValue();
                String cas = row.getCell(3).getStringCellValue();
                String hsc = row.getCell(5).getStringCellValue();

                Substance substance = new Substance(id, index, ice, ec, cas, hsc);
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