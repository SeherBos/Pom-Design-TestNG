package com.pages;

import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KoalaResortPage {

    public KoalaResortPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id ="details-button")
    public WebElement advancedButton;

    @FindBy (id ="proceed-link")
    public WebElement proceedButton;

    @FindBy(linkText = "Log in")
    public WebElement login;

    @FindBy(id = "UserName")
    public WebElement username;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement submit;

    @FindBy (xpath ="(//span[@class='title'])[3]")
    public WebElement hotelManagement;

    @FindBy (partialLinkText ="Hotel List")
    public WebElement hotelList;

    @FindBy (xpath = "//span[contains(text(),'Add Hotel')]")
    public WebElement addHotel;

    @FindBy (id = "Code")
    public WebElement code;

    @FindBy (id = "Name")
    public WebElement name;

    @FindBy (id = "Address")
    public WebElement address;

    @FindBy (id = "Phone")
    public WebElement phone;

    @FindBy (id = "Email")
    public WebElement email;

    @FindBy (id = "IDGroup")
    public WebElement dropDown;

    @FindBy (id = "btnSubmit")
    public WebElement saveButton;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div")
    public WebElement confirmation;

    @FindBy (xpath = "(//button[@type='button'])[6]")
    public WebElement okButton;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRooms;

    @FindBy(xpath = "//*[text()='Add Hotelroom ']")
    public WebElement addHotelRoom;

    @FindBy(id = "IDHotel")
    public WebElement idHotelDropdown;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement roomTextBox;

    @FindBy(linkText = "500")
    public WebElement price;

    @FindBy(id = "Price")
    public WebElement priceTextBox;

    @FindBy(id = "IDGroupRoomType")
    public WebElement roomTypeDropdown;

    @FindBy(id = "MaxAdultCount")
    public WebElement maxAdultCount;

    @FindBy(id = "MaxChildCount")
    public WebElement maxChildCount;

    @FindBy(xpath = "//*[text()='HotelRoom was inserted successfully']")
    public WebElement roomCreatedElement;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement roomCreateOK;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsButton;

    @FindBy(xpath = "(//*[text()='List Of Hotelrooms'])[2]")
    public WebElement hotelRoomListText;

    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> firstRowDatas;

    @FindBy(xpath = "//thead//tr[1]//th")
    public List<WebElement> columnHeaders;

    @FindBy(xpath = "//tbody")
    public WebElement tbodyWebElement;

    @FindBy(xpath = "//tbody//td")
    public List<WebElement> allBodyDatas;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> rowLists;

    @FindBy(xpath = "//*[text()='Try again please']")
    public WebElement noAccess;

    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> birinciSatirDatalar;


    @FindBy(xpath = "//thead//tr[1]//th")
    public List<WebElement> sutunBasliklari;

    @FindBy(xpath = "//tbody//td")
    public List<WebElement> bodydekiTumDataListesi;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;


    public void koalaResortLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        login.click();
        username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        submit.click();
    }

    public void printDesiredRow(int rowNo){

        // =====  //tbody//tr[3]

        String rowXPath="//tbody//tr[" + (rowNo-1) + "]";

        System.out.println(Driver.getDriver().findElement(By.xpath(rowXPath)).getText());

    }

    public void sutunYazdir(int sutunNo){
        // ornek : her hangi bir satirdaki 2.sutunu bulmak istersek //tbody//tr//td[2] yazabiliriz

        String sutunPath= "//tbody//tr//td["+sutunNo+"]";


        WebElement sutunBasligi=Driver.getDriver().findElement(By.xpath("//thead//th[" + sutunNo + "]"));
        System.out.println(sutunBasligi.getText());

        List<WebElement> istenenSutunListeOlarak=Driver.getDriver().findElements(By.xpath(sutunPath));

        for (WebElement each: istenenSutunListeOlarak
        ) {
            System.out.println(each.getText());
        }


    }

    public String findData(int row, int column){
        // ornek : her 3. satirdaki 2.sutunu bulmak istersek //tbody//tr[3]//td[2] yazabiliriz

        String dataPath="//tbody//tr["+ row +"]//td["+column+"]";
        System.out.println(dataPath);

        return Driver.getDriver().findElement(By.xpath(dataPath)).getText();
    }
    public WebElement findWebElementData(int row, int column) {
        // ornek : her 3. satirdaki 2.sutunu bulmak istersek //tbody//tr[3]//td[2] yazabiliriz

        String dataPath = "//tbody//tr[" + row + "]//td[" + column + "]";
        System.out.println(dataPath);

        return Driver.getDriver().findElement(By.xpath(dataPath));
    }
    public void printDesiredCell(int row, int column){
        // 3 satir 5. sutunu yazdir
        String cellXPath = "//tbody//tr["+row+"]//td["+column+"]";

        WebElement desiredDataElement = Driver.getDriver().findElement(By.xpath(cellXPath));

        System.out.println(desiredDataElement.getText());
    }


}

