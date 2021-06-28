package com.tests.day17;

import com.utilities.Driver;
import org.testng.annotations.Test;

public class C1_DriverFirstClass {


    @Test
    public void test(){

        // eskiden kullandigimiz driver yerine Driver.getDriver() bunu kullanacagiz

        Driver.getDriver().get("https://www.youtube.com");
        Driver.getDriver().get("https://www.google.com");
        Driver.getDriver().get("https://www.amazon.com");

        Driver.closeDriver();

    }
}
