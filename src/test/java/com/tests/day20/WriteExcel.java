package com.tests.day20;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void writeExcel() throws IOException {
        String excelPath="src/test/Resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelPath);

        Workbook workBook = WorkbookFactory.create(fileInputStream);

        workBook.getSheetAt(0).getRow(0).createCell(4).setCellValue("Population");
        workBook.getSheetAt(0).getRow(4).createCell(4).setCellValue("100000");
        workBook.getSheetAt(0).getRow(5).createCell(4).setCellValue("10000");
        workBook.getSheetAt(0).getRow(9).createCell(4).setCellValue("2100000");

        FileOutputStream fileOutputStream = new FileOutputStream(excelPath);

        workBook.write(fileOutputStream);


    }
}
