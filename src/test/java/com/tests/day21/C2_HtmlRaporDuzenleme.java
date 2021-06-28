package com.tests.day21;

import com.pages.KoalaResortLoginPage;
import com.pages.KoalaResortPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import com.utilities.TestBaseRapor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C2_HtmlRaporDuzenleme extends TestBaseRapor {


    // 1- Test class'ini extends ile TestBaseRapor Class'ina child yapalim
    // 2- extentTest=extentReports.createTest("Test ismi", "Tanim");  rapor olusturalim
    // 3- Gerekli/istedigimiz satirlara extentTest.info("Aciklama") ekleyelim
    // 4- Assert olan satirda aciklamayi extentTest.pass ile yapabiliriz


    @Test
    public void positiveLoginTest() {

        extentTest=extentReports.createTest("Smoke","Login with valid credentials");

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        extentTest.info("Koala resort hotels sayfasina gidildi");
        KoalaResortPage koalaResortPage = new KoalaResortPage();
        koalaResortPage.login.click();
        extentTest.info("click on Login");

        koalaResortPage.username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        extentTest.info("Tested with valid username");

        koalaResortPage.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        extentTest.info("Tested with valid password");

        koalaResortPage.submit.click();
        extentTest.info("Login butonuna basildi");

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigReader.getProperty("kr_successful_login_url"));
        extentTest.pass("Basarili giris yapildigi test edildi");

    }

    @Test
    public void yanlisSifreVeKullaniciAdiTest(){

        extentTest=extentReports.createTest("Smoke","Yanlis bilgilerle giris yapilmaz");
        // http://qa-environment.koalaresorthotels.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        //		login butonuna bas

        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.login.click();
        extentTest.info("Login linkine basildi");

        //test data username: manager ,
        koalaResortPage.username.sendKeys(ConfigReader.getProperty("kr_wrong_username"));

        //test data yanlis password : manager1!

        koalaResortPage.password.sendKeys(ConfigReader.getProperty("kr_wrong_password"));
        extentTest.info("Gecersiz sifre yazildi");

        //Degerleri girildiginde hata verdigini test et
        koalaResortPage.submit.click();

        Assert.assertFalse(koalaResortPage.noAccess.isDisplayed());
        extentTest.pass("Basarili giris yapilamadigi test edildi");

        Driver.closeDriver();
    }
}