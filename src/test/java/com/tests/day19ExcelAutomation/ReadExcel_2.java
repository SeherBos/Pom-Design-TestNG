package com.tests.day19ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel_2 {
    @Test
    public void readExcel1() throws IOException {

        String excelPath = "src/test/Resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelPath);

        Workbook workBook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workBook.getSheet("Sayfa2");

        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell); // 1.0 ???

        int rowNum = sheet.getLastRowNum(); //23
        System.out.println(rowNum);

        int physicalRow = sheet.getPhysicalNumberOfRows();
        System.out.println(physicalRow); // 7

        int all = sheet.getColumnOutlineLevel(2);


        System.out.println("all = " + all);

        String cell1 = sheet.getRow(2).getCell(3).toString();

//        System.out.println(cell1); // NullPointerException


    }
}
