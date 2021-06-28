package com.tests.day15;

import com.utilities.TestBase;
import org.testng.annotations.Test;

public class FirstPomClass extends TestBase {
    /*
    1 - https://www.facebook.com/ adresine gidin
    2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
    3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
    4- Basarili giris yapilamadigini test edin
     */


    @Test
    public void test(){

        driver.get("https://www.facebook.com/");

    }


}
