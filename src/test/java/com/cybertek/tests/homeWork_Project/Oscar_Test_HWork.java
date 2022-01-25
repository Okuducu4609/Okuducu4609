package com.cybertek.tests.homeWork_Project;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class Oscar_Test_HWork {
    /*
    Task1:
            1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
            2. Click on "Click me, to Open an alert after 5 seconds"
            3. Explicitly wait until alert is present
            4. Then handle the Javascript alert
    Task2:
            1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
            2. Click on "Enable button after 10 seconds"
            3. Explicitly wait until the button is enabled
             4. Then verify the button is enabled
    Task3:
            1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
            2. Login with username: Tester, password: test
            3. Click  Order button
             4. Verify under Product Information, selected option is “MyMoney”
            5. Then select FamilyAlbum, make quantity 2, and click Calculate,
            6. Then verify Total is equal to Quantity*PricePerUnit
            */

    WebDriver driver;

    @BeforeMethod

    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void quit() {

        driver.quit();
    }

    @Test
    public void Task1() throws InterruptedException {
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        WebElement clickMe = driver.findElement(By.id("alert"));
        clickMe.click();

        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);

        //Then handle the Javascript alert
        driver.switchTo().alert().accept();
    }

    @Test
    public void Task2() {
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        WebElement button10Second = driver.findElement(By.id("enable-button"));
        button10Second.click();
        WebDriverWait wait = new WebDriverWait(driver, 11);
        wait.until(ExpectedConditions.visibilityOf(button10Second));

        WebElement getTextActualElement = driver.findElement(By.id("disable"));

        getTextActualElement.isEnabled();
    }

    @Test
    public void Task3() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Tester");
        driver.findElement(By.cssSelector("[type='password']")).sendKeys("test");

        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.findElement(By.linkText("Order")).click();

        // 4. Verify under Product Information, selected option is “MyMoney”

        WebElement order = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));

        Select productInformation = new Select(order);
        String actuelProduct = productInformation.getFirstSelectedOption().getText();
        Assert.assertEquals(actuelProduct, "MyMoney");

        //5. Then select FamilyAlbum, make quantity 2, and click Calculate,

        productInformation.selectByValue("FamilyAlbum");
        WebElement quantit = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantit.clear();
        quantit.sendKeys("2");
        driver.findElement(By.cssSelector("[type='submit']")).click();


        //   Then verify Total is equal to Quantity*PricePerUnit


        WebElement totalPrice = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));

        WebElement priceperUnit = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));

        String priceUnit = priceperUnit.getAttribute("value");
        String quantity2 = quantit.getAttribute("value");
        String total = totalPrice.getAttribute("value");

        //String values
        System.out.println("String_priceUnit = " + priceUnit);
        System.out.println("String_quantity2 = " + quantity2);
        System.out.println("String_total = " + total);

        //Integer values
        int unitPriceInt = Integer.parseInt(priceUnit);
        int quant2 = Integer.parseInt(quantity2);
        int totalActuel = Integer.parseInt(total);

        int totalExpected = unitPriceInt * quant2;

        System.out.println("totalActuel = " + totalActuel);
        System.out.println("totalExpected = " + unitPriceInt * quant2);

        Assert.assertEquals(totalActuel, totalExpected);


    }


}







