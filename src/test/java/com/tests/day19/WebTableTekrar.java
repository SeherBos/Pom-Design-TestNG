package com.tests.day19;

import com.pages.KoalaResortPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTekrar {


/*
WebTables class'ini kullanin.
1. Bir metod oluşturun : printData(int row, int column);
    a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu    hücredeki(cell) veriyi yazdırmalıdır.
2. Baska bir Test metodu oluşturun: printDataTest();
    a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
    b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
    c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
 */

    @Test
            public void test01() {
        KoalaResortPage koalaResortPage = new KoalaResortPage();
        koalaResortPage.koalaResortLogin();

        // istedigimiz satir ve sutun sayisini yazdigimizda
        // bize o hucrede ki yaziyi getiren metodu calistiralim

        koalaResortPage.printDesiredCell(3,6);

        // 5. satir 4. sutunda ki bilginin Lucio McKenzie MD oldugunu test edin
        //    //tbody//tr[5]//td[4]
    String actualCellText =koalaResortPage.findData(5,4);
        Assert.assertEquals(actualCellText,ConfigReader.getProperty("webTableExpectedData"));

    }
}
