package com.tests.day16;

import com.pages.KoalaResortLoginPage;
import com.utilities.TestBase;
import org.testng.annotations.Test;

public class C3_KoalaNegatifLoginTesti extends TestBase {

    @Test
    public void negatifTest(){

        /*
        1 ) Bir Class olustur : NegativeTest
        2) Bir test method olustur NegativeLoginTest()
         http://qa-environment.koalaresorthotels.com adresine git
         login butonuna bas
         test data username: manager1 ,
         test data password : manager1!
         Degerleri girildiginde sayfaya girilemedigini test et
         */

        driver.get("http://qa-environment.koalaresorthotels.com ");
        KoalaResortLoginPage koalaResortLoginPage=new KoalaResortLoginPage(driver);
        koalaResortLoginPage.ilkLoginLinki.click();
        koalaResortLoginPage.kullaniciAdiTextBox.sendKeys("manager1");
        koalaResortLoginPage.passwordTexBox.sendKeys("manager1!");
        koalaResortLoginPage.loginButonu.click();

    }

}
