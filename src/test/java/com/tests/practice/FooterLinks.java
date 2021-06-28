package com.tests.practice;

import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FooterLinks {

    @Test
    public void footerLink() throws InterruptedException {
        Driver.getDriver().get("https://www.amazon.com/");

        /*WebElement footer = Driver.getDriver().findElement(By.cssSelector("#navFooter"));
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
        System.out.println(footerLinks.size());
        System.out.println(Driver.getDriver().findElements(By.xpath("//div[@id='navFooter']//a")).size());*/


        List<WebElement> list = Driver.getDriver().findElements(By.xpath("(//div[@class='navFooterLinkCol navAccessibility'])[1]//a"));
        for (int i = 0; i < list.size(); i++) {
            String chord = Keys.chord(Keys.COMMAND, Keys.ENTER);
            list.get(i).sendKeys(chord);
            Thread.sleep(2000);
            List<String> windowsHandle = new ArrayList<>(Driver.getDriver().getWindowHandles());
            Driver.getDriver().switchTo().window(windowsHandle.get(i + 1));
            System.out.println(Driver.getDriver().getTitle());
            Driver.getDriver().switchTo().window(windowsHandle.get(0));
        }
    }
}
