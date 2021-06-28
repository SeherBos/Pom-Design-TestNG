package com.smokeTest;

import com.github.javafaker.Faker;
import com.pages.KoalaResortPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class E2E_CrystalKeyHotel_HotelCreation {

    KoalaResortPage koalaResortPage = new KoalaResortPage();

    @Test
    public void hotelCreation() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));


//        crystalKeyHotel.advancedButton.click();
//        crystalKeyHotel.proceedButton.click();
        koalaResortPage.login.click();
        koalaResortPage.username.
                sendKeys(ConfigReader.getProperty("kr_valid_username"));
        koalaResortPage.password.
                sendKeys(ConfigReader.getProperty("kr_valid_password"));
        koalaResortPage.submit.click();

  // ______________________________________________________________________________________

        koalaResortPage.hotelManagement.click();
        koalaResortPage.hotelList.click();
        koalaResortPage.addHotel.click();

       Faker faker = new Faker();
        koalaResortPage.code.
                sendKeys(faker.number().digits(5));
        koalaResortPage.name.
                sendKeys(faker.name().fullName());
        koalaResortPage.address.
                sendKeys(faker.address().city() + " - " +
                                                  faker.address().country());
        koalaResortPage.phone.
                sendKeys(faker.number().digits(10));
        koalaResortPage.email.
                sendKeys(faker.internet().emailAddress());

        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ARROW_DOWN).build().perform();
        koalaResortPage.dropDown.submit();

        Select select = new Select(koalaResortPage.dropDown);
        select.selectByIndex(1);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);

        wait.until(ExpectedConditions.elementToBeClickable(koalaResortPage.saveButton));
      //  Thread.sleep(3000);
        koalaResortPage.saveButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(koalaResortPage.okButton));

      //  Thread.sleep(5000);
        Assert.assertEquals(koalaResortPage.confirmation.getText(),ConfigReader.getProperty("expected_confirmation"));

        koalaResortPage.okButton.click();







    }


}
