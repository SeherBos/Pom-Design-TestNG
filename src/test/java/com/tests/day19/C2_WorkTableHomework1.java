package com.tests.day19;

import com.pages.KoalaResortPage;
import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class C2_WorkTableHomework1 {
    //● table() metodu oluşturun
    //	○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    //	○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    //● printRows() metodu oluşturun //tr
    //	○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    //	○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //	○ 4.satirdaki(row) elementleri konsolda yazdırın.
    //● printCells() metodu oluşturun //td
    //	○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
    //	○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
    //● printColumns() metodu oluşturun
    //	○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
    //	○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
    //	○ 5.column daki elementleri konsolda yazdırın.

    @Test
    public void table(){

        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.koalaResortLogin();
        //● printCells() metodu oluşturun //td
        //	○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.

        System.out.println("tablodaki hucre sayisi : " + koalaResortPage.allBodyDatas.size());
        //	○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.

        for (WebElement each: koalaResortPage.allBodyDatas
        ) {
            System.out.println(each.getText());
        }
        Driver.closeDriver();
    }

    @Test
    public void printColumns(){
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.koalaResortLogin();
        //	○ table body’sinde bulunan toplam sutun(column) sayısını bulun.

        System.out.println("tablodaki sutun sayisi : " + koalaResortPage.sutunBasliklari.size());


        //	○ 5.column daki elementleri konsolda yazdırın.
        koalaResortPage.sutunYazdir(5);

        //	○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        for ( int i=1; i<=koalaResortPage.sutunBasliklari.size(); i++){
            koalaResortPage.sutunYazdir(i);
        }
    }
}
