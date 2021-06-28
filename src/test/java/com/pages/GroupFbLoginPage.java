package com.pages;


import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupFbLoginPage {

//     her sinifin bir constructor'i olur
//     Constructor'in return type'i olmaz, eger yazarsaniz NullPointerException verir

    public GroupFbLoginPage(){

//        Bu constructor page object model'e deger atamak icin kullanilir.
//        In Page Factory, testers use @FindBy annotation.
//        The initElements() method is used to initialize web elements.
//        @FindBy: An annotation used in Page Factory to locate and declare web elements using different locators.

        PageFactory.initElements(Driver.getDriver(),this);

    }
//        Simdiye kadar WebElement araciligiyla locate ediyorduk
//        WebElement email = Driver.getDriver().findElement(By.id("email"));


//  *** Buldugumuz WebElementlerinin Test class'indan ulasilmasi icin access modifier yazmamiz gerekiyor.



        @FindBy (id ="email")
        public WebElement email; // bu bulunacak elemnete bir degisken ismi ataniyor

        @FindBy (xpath="//input[@id='pass']")
        public WebElement password;

        @FindBy (xpath = "//button[@name='login']")
        public WebElement loginButton;



}
