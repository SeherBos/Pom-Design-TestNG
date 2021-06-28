package com.tests.day19ExcelAutomation;

import com.utilities.ConfigReader;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void readExcel1() throws IOException {
        String excelPath="src/test/Resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelPath);


        // excel oldugu icin workBook olusturmamiz gerekiyor
        Workbook workBook = WorkbookFactory.create(fileInputStream);


        // excel'in yapisi geregi workbook icinde sheet secmeliyiz
        Sheet sheet=workBook.getSheet("Sayfa1");


        // sayfadan sonra satira ulasmaliyiz
        // satir icin index girmeliyiz, index 0'dan baslar
        // ornegin 5.satira gitmek istiyorsak index: 4 olur
        Row row = sheet.getRow(4);

        // satirdan sonra cell secmemiz lazim
        // cell icin index girmeliyiz, index 0'dan baslar
        // ornegin 4. cell'e gitmek istiyorsak index: 3 olur
        Cell cell=row.getCell(3);



        // suanda cell variable'inin icinde workbook/ Sayfa1 / 5.satir / 4.cell bilgisi var
        // indexler 0'dan baslar

        System.out.println(cell);
    }


    @Test
    public void readExcel2() throws IOException {

        /*
            1. method'da cell'e ulasmak icin fis , sheet, row, cell olusturduk.
            ama cell'e ulasmak icin daha kisa bir yol olarak
            fis ve workbook olusturduktan sonra
            Cell cell= workbook.getsheet(sayfaAdi).getRow(RowIndexi).getCell(CellIndex) yazilir
         */

        FileInputStream fileInputStream = new FileInputStream(ConfigReader.getProperty("excel_path"));

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Cell cell =workbook.
                getSheet(ConfigReader.getProperty("excel_page")).
                getRow(Integer.parseInt(ConfigReader.getProperty("excel_row_index"))).
                getCell(Integer.parseInt(ConfigReader.getProperty("cell_index")));

        System.out.println(cell);

        // Cell'de ki bilginin ilk harfini yazdiralim
        System.out.println(cell.toString().substring(0, 1));


        // Eger cell'deki bilgiyi sadece yazdirmak istersek sout(cell) yazabiliriz
        // ama cell'de ki bilgi uzerinde manipulation yapmak istersek oncelikle
                   // toString() methodu ile Cell String'e dataCasting yapmaliyiz.

        // excel sayfa1'deki satir sayisini bulunuz  => 190
        System.out.println( workbook.getSheet(ConfigReader.getProperty("excel_page")).getLastRowNum());

        // getPhysicalNumberOfRows() excel de olan dolu satirlarin sayisini verir. => 191
        System.out.println( workbook.getSheet(ConfigReader.getProperty("excel_page")).getPhysicalNumberOfRows());
        // getPhysicalNumberOfRows() ise aktif olarak bilgi iceren satir sayisini verir
        // 0'dan baslamaz, sayma sayilarini kullanir

        // Excelin 2.sayfasinda bazi satirlari kullanip, bazilarini kullanmadik
        // bu durumda sonSatirIndex'i ve fizikiKullanilanSatirSayisi degerlerini bulalim
        System.out.println("2.sayfa son satir index i : " + workbook.getSheetAt(1).getLastRowNum());
        System.out.println("2.sayfa fiziki kullanilan satir sayisi : " + workbook.getSheetAt(1).getPhysicalNumberOfRows());

        // excel'de bulunan tum ulkelerin turkce isimlerini yazdirin
        // yani her satirdaki 2.index'deki bilgi isteniyor


        for (int index=0 ; index<=workbook.getSheetAt(0).getLastRowNum();index++){
            System.out.println(workbook.getSheetAt(0).getRow(index).getCell(2));
        }

        // Excel'deki tum datalari Class'imiza almak istersek



    }






}
