package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    /**
     * TASK
     * go to amazon.com
     * search for selenium
     * click search button
     * verify 1-48 of 304 results for "Java"
     *
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement searchBottom= driver.findElement(By.id("twotabsearchtextbox"));
        searchBottom.sendKeys("Selenium" + Keys.ENTER);
        Thread.sleep(3000);

       // WebElement clickBottom=driver.findElement(By.id("nav-search-submit-button"));
     //   clickBottom.click();

        //verify 1-48 of 304 results for "selenium"

        WebElement searchResult=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualresult= searchResult.getText();
       // String actualresult= searchResult.getText()+" "+driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();

        String expectedresult= "1-48 of 191 results for selenium";
        if(expectedresult.equals(actualresult)){
            System.out.println("PASS");

        }
        else {
            System.out.println("FAIL");
        }
            System.out.println(expectedresult);
            System.out.println(actualresult);

         //   driver.quit();

        /*
           WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        searchBox.sendKeys("Java");

        //click search button
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));

        String resultText = result.getText();

        System.out.println("resultText = " + resultText);

        String expectedResult = "1-48 of over 5,000 results for";

        if(expectedResult.equals(resultText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("resultText = " + resultText);
        }

        driver.quit();
         */


    }

}
