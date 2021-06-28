package com.tests.day19;

import com.pages.KoalaResortPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C3_WebTableHomework2 {


    @Test
    public void printDataTest(){


        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.koalaResortLogin();
        int istenenSatir=Integer.parseInt(ConfigReader.getProperty("webTableRowNo"));
        int istenenSutun=Integer.parseInt(ConfigReader.getProperty("webTableColumnNo"));

        String istenenDataOkunan=koalaResortPage.findData(istenenSatir,istenenSutun);
        Assert.assertEquals(ConfigReader.getProperty("webTableExpectedData"),istenenDataOkunan);

        Driver.closeDriver();

    }
}
