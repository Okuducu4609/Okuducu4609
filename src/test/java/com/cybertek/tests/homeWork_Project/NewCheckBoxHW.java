package com.cybertek.tests.homeWork_Project;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NewCheckBoxHW {
    /*Test Case Verify CheckBox CheckAll and UncheckAll Buttons
1. Go to
http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
2. Login with-----Username: Tester, password: test
3. Click on check all button verify all the checkboxes are checked
4. Click on uncheck all button verify that all the checkboxes are unchecked
5. Select one of the checkbox and delete one person
6. Then verify that deleted item is no longer exists  */

    @Test

    public void Test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.manage().window().maximize();
        WebElement userNameBox = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        //WebElement userNameBox=driver.findElement(By.xpath("//input[@type='text']"));

        userNameBox.sendKeys("Tester");
        WebElement PasswordBox = driver.findElement(By.xpath("//*[@name='ctl00$MainContent$password']"));
        PasswordBox.sendKeys("test");
        WebElement Login = driver.findElement(By.cssSelector("input[value='Login']"));
        Thread.sleep(3000);
        Login.click();

            //Click on check all button verify all the checkboxes are checked
            WebElement checkAllButton = driver.findElement(By.cssSelector("#ctl00_MainContent_btnCheckAll"));
            checkAllButton.click();

       for(int i=2;i<10;i++){
           WebElement firstRadioButton=driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl0"+i+"_OrderSelector"));

           Assert.assertTrue(firstRadioButton.isSelected(),"All button are selected");
           System.out.println("firstRadioButton "+i+ " selected "+ firstRadioButton.isSelected());

       }
        //Click on uncheck all button verify that all the checkboxes are unchecked
        Thread.sleep(3000);
        driver.findElement(By.linkText("Uncheck All")).click();
        Thread.sleep(2000);

       // for(int i=2;i<10;i++){

        //    WebElement unCheckAllButton=driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl0"+i+"_OrderSelector"));
      // Assert.assertFalse(unCheckAllButton.isSelected(),"AllcheckButton are unselected");
         //   System.out.println("unCheckAllButton "+i+" selected " + unCheckAllButton.isSelected());

        List<WebElement>unCheckAllButton=driver.findElements(By.xpath("unCheckAllButton"));
        System.out.println(unCheckAllButton.size());

        for(WebElement value: unCheckAllButton){

            value.click();
            System.out.println(unCheckAllButton);
            Assert.assertFalse(value.isSelected());



        }

        //Select one of the checkbox and delete one person

       WebElement selectDeleteCheckbox= driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
       selectDeleteCheckbox.click();
       WebElement deletedname_Paul=driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[2]"));

       String actualName=deletedname_Paul.getText();
        Thread.sleep(2000);

        WebElement expectedName=driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete"));
        expectedName.click();
        Thread.sleep(2000);
        WebElement afterdeletedname_Paul=driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[2]"));
        String aftername=afterdeletedname_Paul.getText();
        //Then verify that deleted item is no longer exists

        Assert.assertFalse(aftername.equals(actualName),"Name verify selected is deleted");

        driver.quit();


    }



}
