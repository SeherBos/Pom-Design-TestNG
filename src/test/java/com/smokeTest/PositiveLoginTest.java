package com.smokeTest;


import com.pages.KoalaResortPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PositiveLoginTest {

    // http://qa-environment.koalaresorthotels.com adresine git
    //      login butonuna bas
    //test data username: manager ,
    //test data password : Manager1!
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et


    @Test
    public void positiveLoginTest(){
        // http://qa-environment.koalaresorthotels.com adresine git


        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        //      login butonuna bas
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.login.click();

        //test data username: manager ,
        koalaResortPage.username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        //test data password : Manager1!
        koalaResortPage.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        koalaResortPage.login.click();

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigReader.getProperty("kr_successful_login_url"));
        Driver.closeDriver();

    }
}

