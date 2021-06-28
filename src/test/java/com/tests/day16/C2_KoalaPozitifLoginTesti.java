package com.tests.day16;

import com.pages.KoalaResortLoginPage;
import com.utilities.TestBase;
import org.testng.annotations.Test;

public class C2_KoalaPozitifLoginTesti extends TestBase {

    /*
    1 ) Bir Class olustur : PositiveTest
    2) Bir test method olustur positiveLoginTest()
     http://qa-environment.koalaresorthotels.com adresine git
     login butonuna bas
     test data username: manager ,
     test data password : Manager1!
     Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */


    @Test
    public void pozitifLoginTesi(){
        driver.get("http://qa-environment.koalaresorthotels.com");
        KoalaResortLoginPage koalaResortLoginPage=new KoalaResortLoginPage(driver);
        koalaResortLoginPage.ilkLoginLinki.click();
        koalaResortLoginPage.kullaniciAdiTextBox.sendKeys("manager");
        koalaResortLoginPage.passwordTexBox.sendKeys("Manager1!");
        koalaResortLoginPage.loginButonu.click();
    }




}
