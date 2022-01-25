package com.cybertek.tests.reviews.Deneme_package;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.WebElement.*;

public class WebElementList {


    WebDriver driver;

@BeforeMethod
public void setup() {
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}
@Test
    public void test() {

    driver.get("http://practice.cybertekschool.com/multiple_buttons");

    List<WebElement> elements = driver.findElements(By.xpath("//button"));


    System.out.println("anasayfa elemansayisi=" + elements.size());
    Assert.assertEquals(elements.size(),6);

    for (WebElement each : elements) {

        System.out.println(each.getText());
        Assert.assertTrue(each.isDisplayed());


    }
    System.out.println(elements.get(1).getText()); //Button2
    elements.get(2).click();



}
}

