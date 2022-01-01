package com.cybertek.tests.reviews.Deneme_package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium_Example {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get(" https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Ahmet");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(" Guzel");
        WebElement genderMale = driver.findElement(By.id("sex-0"));
        genderMale.click();
        driver.findElement(By.cssSelector("#exp-1")).click(); //years botton

        driver.findElement(By.id("datepicker")).sendKeys("28/12/20221");

        Thread.sleep(2000);


//    driver.findElement(By.id("profession-1")).click();

//    // driver.findElement(By.id("profession-0")).click(); //Manually

// driver.findElement(By.id("tool-2")).click();  //WebDriverSelenium

// driver.findElement(By.id("continents")).click();
// driver.findElement(By.xpath("//*[.='Browser Commands']")).click();

// //driver.findElement(By.linkText("Europe")).click();
// driver.findElement(By.xpath("//option[.='Europe']")).click();


// Select Automation Tool
        driver.findElement(By.id("profession-1")).click(); //Automation

        driver.findElement(By.id("tool-2")).click();

        // Select Continent
        driver.findElement(By.id("continents")).click();
        WebElement dropdown = driver.findElement(By.id("continents"));
        dropdown.findElement(By.xpath("//option[. = 'Europe']")).click();

        // Select Command
        WebElement dropdow = driver.findElement(By.id("selenium_commands"));
        dropdow.findElement(By.xpath("//option[. = 'Browser Commands']")).click();


        // Click Submit
        driver.findElement(By.id("submit")).click();

        //Exception in thread "main" org.openqa.selenium.ElementClickInterceptedException: element click intercepted:

    }





}
