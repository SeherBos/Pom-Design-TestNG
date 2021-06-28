package com.tests;

import com.pages.GroupFbLoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

// FacebookLoginPage clas'inda bulup tanimladigim Web elementlerine  bu class icinde ulasmak icin
// obje olusturmaliyiz



public class LoginTest {


    GroupFbLoginPage facebookLoginPage = new GroupFbLoginPage();

    @Test
    public void loginTest(){

    Driver.getDriver().get(ConfigReader.getProperty("facebook"));
    Driver.getDriver().findElement(By.id("email")).sendKeys(ConfigReader.getProperty("email"));



facebookLoginPage.email.sendKeys(ConfigReader.getProperty("email"));
facebookLoginPage.password.sendKeys(ConfigReader.getProperty("password"));
facebookLoginPage.loginButton.click();

Driver.getDriver().get(ConfigReader.getProperty("google"));




    }



}
