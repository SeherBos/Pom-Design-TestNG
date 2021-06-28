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


public class E2E_CrystalKeyHotel_RoomCreation {

    /*
        2. Bir metod olusturun: RoomCreateTest()
        3. http://qa-environment.crystalkeyhotels.com adresine gidin.
        4. Username textbox ve password metin kutularını locate edin ve aşağıdaki
        verileri girin.
        a. Username : manager b. Password : Manager2!
        5. Login butonuna tıklayın.
        6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        8. Save butonuna basin.
        9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        10. OK butonuna tıklayın.
        11. Hotel rooms linkine tıklayın.
        12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
 */

//    KoalaResortPage crystalKeyHotel = new KoalaResortPage();


    @Test
    public void roomCreation () throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        KoalaResortPage koalaResortPage = new KoalaResortPage();

        koalaResortPage.koalaResortLogin();

        koalaResortPage.hotelManagement.click();
        koalaResortPage.hotelRooms.click();
        koalaResortPage.addHotelRoom.click();

        Select select = new Select(koalaResortPage.idHotelDropdown);
        select.selectByIndex(Integer.parseInt(ConfigReader.getProperty("kr_hotel_room_index")));

        Faker faker = new Faker();
        Actions action = new Actions(Driver.getDriver());

        action.click(koalaResortPage.code).
                sendKeys(faker.number().digits(5)).
                sendKeys(Keys.TAB).sendKeys(faker.name().fullName()).
                sendKeys(Keys.TAB).sendKeys(faker.address().city()).
                sendKeys(Keys.PAGE_DOWN).
                perform();

        koalaResortPage.roomTextBox.sendKeys(ConfigReader.getProperty("kr_room_text"));

        action.dragAndDrop(koalaResortPage.price,koalaResortPage.priceTextBox).
                sendKeys(Keys.PAGE_DOWN).perform();

        Select select1 = new Select(koalaResortPage.roomTypeDropdown);
        koalaResortPage.maxAdultCount.sendKeys(ConfigReader.getProperty("kr_adult_count"));
        koalaResortPage.maxChildCount.sendKeys(ConfigReader.getProperty("kr_child_count"));
        koalaResortPage.saveButton.click();
        Thread.sleep(10000);

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5000);
//        wait.until(ExpectedConditions.elementToBeClickable(koalaResortPage.roomCreatedElement));

        Assert.assertTrue(koalaResortPage.roomCreatedElement.isDisplayed());

        koalaResortPage.roomCreateOK.click();
        action.sendKeys(Keys.HOME).perform();

        koalaResortPage.hotelRooms.click();

        Assert.assertTrue(koalaResortPage.hotelRoomListText.isDisplayed());





    }


}
