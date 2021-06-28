package com.smokeTest;

import com.pages.KoalaResortPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest {

    @Test
    public void invalidPassword(){
        // http://qa-environment.koalaresorthotels.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        //		login butonuna bas

        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.login.click();

        //test data username: manager ,
        koalaResortPage.username.sendKeys(ConfigReader.getProperty("kr_valid_username"));

        //test data yanlis password : manager1!

        koalaResortPage.password.sendKeys(ConfigReader.getProperty("kr_wrong_password"));

        //Degerleri girildiginde hata verdigini test et
        koalaResortPage.submit.click();

        Assert.assertTrue(koalaResortPage.noAccess.isDisplayed());

        Driver.closeDriver();
    }
    @Test
    public void invalidUserName(){
        // http://qa-environment.koalaresorthotels.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        //		login butonuna bas

        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.login.click();

        //test data username: manager ,
        koalaResortPage.username.sendKeys(ConfigReader.getProperty("kr_wrong_username"));

        //test data yanlis password : manager1!

        koalaResortPage.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));

        //Degerleri girildiginde hata verdigini test et
        koalaResortPage.submit.click();

        Assert.assertTrue(koalaResortPage.noAccess.isDisplayed());

        Driver.closeDriver();
    }
    @Test
    public void invalidUserNamePassword(){
        // http://qa-environment.koalaresorthotels.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        //		login butonuna bas

        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.login.click();

        //test data username: manager ,
        koalaResortPage.username.sendKeys(ConfigReader.getProperty("kr_wrong_username"));

        //test data yanlis password : manager1!

        koalaResortPage.password.sendKeys(ConfigReader.getProperty("kr_wrong_password"));

        //Degerleri girildiginde hata verdigini test et
        koalaResortPage.submit.click();

        Assert.assertTrue(koalaResortPage.noAccess.isDisplayed());

        Driver.closeDriver();
    }
}
