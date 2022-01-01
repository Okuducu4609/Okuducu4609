package com.cybertek.tests.reviews.Deneme_package;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
    public static void main(String[] args)  {
/*
        Verify confirmatimessage
                open chrome browse r
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
                enter any email:sasa@vdsv.com
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!'   */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

       // WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement anyMail=driver.findElement(By.name("email"));
        anyMail.sendKeys("sasa@vdsv.com");
        //driver.findElement(By.name("email")).sendKeys("sasa@vdsv.com");

        String expectedlMail="sasa@vdsv.com";


        String actualMail=anyMail.getAttribute("value");
        if(expectedlMail.equals(actualMail)){
            System.out.println("PASS");
        }
        else {
            System.out.println("Failed");

            System.out.println(expectedlMail);
            System.out.println(actualMail);
        }
        WebElement clickPW=driver.findElement(By.id("form_submit"));
        clickPW.click();

        String expectedMesage="Your e-mail's been sent!";

        WebElement ConM=driver.findElement(By.name("confirmation_message"));
        String  actualMessage=ConM.getText();

        if(expectedMesage.equals(actualMessage)){
            System.out.println("pass");
        }
        else {
            System.out.println("failed");
        }
        System.out.println(expectedMesage);
        System.out.println(actualMessage);





    }


    }
