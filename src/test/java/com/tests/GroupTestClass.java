package com.tests;

import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class GroupTestClass {

    @Test
    public void test(){
       // Driver.getDriver().get("https://www.google.com"); // geleneksel yontem

        Driver.getDriver().get(ConfigReader.getProperty("amazon"));
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).
                                        sendKeys("coffee table" + Keys.ENTER);



    }
}
