package com.tests.day19ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelPractice {

    @Test
    public void excel() throws IOException {

        String excelPath="src/test/Resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelPath);

        Workbook workBook = WorkbookFactory.create(fileInputStream);

        Sheet sheet=workBook.getSheet("Sayfa1");

        Row row = sheet.getRow(174);
        Cell cell = row.getCell(1);

        System.out.println(cell);

        int lastRow = sheet.getLastRowNum();
        System.out.println(lastRow); //190

        int physicalNumberofRows = sheet.getPhysicalNumberOfRows();
        System.out.println(physicalNumberofRows); //191

        int lastCellOfRow = row.getPhysicalNumberOfCells();

//        System.out.println(lastCellOfRow);

        int countryColumn = 0;
        int capitalColumn = 1;

        Map<String, String> countryCapital = new HashMap<>();

        for (int rowNumber=1 ; rowNumber < lastRow; rowNumber++){

//            System.out.println("Country : " + sheet.getRow(rowNumber).getCell(countryColumn) + " "
//                                            +sheet.getRow(rowNumber).getCell(capitalColumn) );
//            System.out.println("Capital : " + sheet.getRow(rowNumber).getCell(capitalColumn));

            String country = sheet.getRow(rowNumber).getCell(countryColumn).toString();
            String capital = sheet.getRow(rowNumber).getCell(capitalColumn).toString();

            countryCapital.put(country,capital);
        }
            System.out.println(countryCapital);


        // Excel'deki tum datalari Class'imiza almak istersek
        // Bunun icin datalari bir java objesine eklememiz gerekir
        // boyle bir bilgiyi depolayabileyecegimiz java objesi map olabilir
        // Map'e depolamak icin sutunlardan birini key
        // digerlerini virgulle birbirine ekleyerek olusturacagim String'i ise value yapabilirim
        Map<String,String> ulkelerMap = new HashMap<>();
        String key="";
        String value="";
        for (int index=1 ; index<=lastRow ; index++){
            key=workBook.getSheetAt(0).getRow(index).getCell(0).toString();
            value= workBook.getSheetAt(0).getRow(index).getCell(1).toString() + ", "+
                    workBook.getSheetAt(0).getRow(index).getCell(2).toString() + ", "+
                    workBook.getSheetAt(0).getRow(index).getCell(3).toString();
            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap);
    }


}
