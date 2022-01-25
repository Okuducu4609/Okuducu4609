package com.cybertek.tests.reviews.Deneme_package;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NoDropDwn_SelectDropDown {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void test() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownMenuLink = driver.findElement(By.id("dropdownMenuLink"));
        dropdownMenuLink.click();

        List<WebElement> elements = driver.findElements(By.cssSelector(".dropdown-item"));
        System.out.println("elements = " + elements.size());
        Assert.assertEquals(elements.size(),5);
        for (WebElement element : elements) {

            System.out.println("element = " + element.getText());

        }
        elements.get(4).click();


    }
    @Test
    public void test_SelectDropDown() {
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement state = driver.findElement(By.id("state"));

        Select stateElement=new Select(state);

        List<WebElement> stateElementOptions = stateElement.getOptions();
        System.out.println("stateElementOptions = " + stateElementOptions.size());

        for (WebElement stateElementOption : stateElementOptions) {

            System.out.println("stateElementOption = " + stateElementOption.getText());

        }
       // System.out.println("stateElementOptions = " +  stateElementOptions.get(0).getText());
        System.out.println("stateElementOptions = " +  stateElement.getFirstSelectedOption().getText());

        Assert.assertEquals(stateElementOptions.get(0).getText(),"Select a State");

        //SELECT ANY ONE STATE
//1
        stateElement.selectByVisibleText("Florida");
        System.out.println(stateElement.getFirstSelectedOption().getText());

        Assert.assertEquals(stateElement.getFirstSelectedOption().getText(),"Florida");



//2
        stateElement.selectByValue("FL");
        Assert.assertEquals(stateElement.getFirstSelectedOption().getText(),"Florida");
//3
        stateElement.selectByIndex(30);
        System.out.println(stateElement.getFirstSelectedOption().getText());


    }

}
