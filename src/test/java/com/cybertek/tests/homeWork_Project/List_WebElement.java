package com.cybertek.tests.homeWork_Project;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class List_WebElement {
    public static void main(String[] args) {


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        List<WebElement> anasayfaElementleri=driver.findElements(By.xpath("//a"));

        //a- buradaki -a tagi  -web linki olantextleri verir, birden fazla oldugundan List olarak atanir.

        System.out.println("anasayfaElementleri.size() = " + anasayfaElementleri.size());

        for(WebElement each: anasayfaElementleri){
          

            System.out.println( each.getText());
        }







    }
}
