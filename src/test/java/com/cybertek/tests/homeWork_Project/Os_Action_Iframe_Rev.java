package com.cybertek.tests.homeWork_Project;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Os_Action_Iframe_Rev {
    /*
    Actions and Iframe Example
 1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
 2. Switch to iframe.
 3. Double click on the text “Double-click me to change my text color.”
 4. Assert: Text’s “style” attribute value contains “red”.

Adidas Company QA Test
You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
• Customer navigation through product categories: Phones, Laptops and Monitors
• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
• Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
• Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
• Click on "Place order".
• Fill in all web form fields.
• Click on "Purchase"
• Capture and log purchase Id and Amount.
• Assert purchase amount equals expected.
• Click on "Ok"
     */


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    //   driver.quit();
   }

    @Test
    public void Test1(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        driver.findElement(By.cssSelector("#accept-choices")).click();


        driver.switchTo().frame(("iframeResult"));

    WebElement demo = driver.findElement(By.xpath("(//*[contains(.,'Double-click me to change my text color.')])/body/p[1]"));

       Actions action=new Actions(driver);
       action.doubleClick(demo).perform();
        System.out.println("demo = " + demo.getText());

        String expectedTextStyle="red";
        String actualTextStyle=driver.findElement(By.cssSelector("[style='color: red;']")).getAttribute("style");
        System.out.println("e = " + actualTextStyle);

       Assert.assertTrue(actualTextStyle.contains(expectedTextStyle));


    }
    @Test
    public void Test2() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(By.xpath("//*[.='CATEGORIES']")).click();

        Thread.sleep(2000);

       // JavascriptExecutor jse= (JavascriptExecutor) driver;
       // jse.executeScript("window.scrollBy(0,250)");

        driver.findElement(By.xpath("(//img)[12]")).click();
        driver.findElement(By.cssSelector("[onclick='addToCart(8)']")).click();
Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        alert.accept();

        driver.navigate().to("https://www.demoblaze.com/index.html");
        Thread.sleep(2000);

driver.findElement(By.xpath("//*[.='Laptops']")).click();

driver.findElement(By.xpath("(//*[@src='imgs/dell.jpg'])[1]")).click();

        driver.findElement(By.cssSelector("[onclick='addToCart(12)']")).click();
        Thread.sleep(2000);
        alert.accept();

        driver.navigate().to("https://www.demoblaze.com/index.html");

driver.findElement(By.cssSelector("#cartur")).click();

        driver.findElement(By.xpath("(//a[.='Delete'])[1]")).click();
        Thread.sleep(2000);
driver.findElement(By.xpath("//*[.='Place Order']")).click();




    }
}
