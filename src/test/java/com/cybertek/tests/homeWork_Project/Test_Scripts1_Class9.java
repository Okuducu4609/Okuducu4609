package com.cybertek.tests.homeWork_Project;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

/*Test case #1
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter “wrong_dob” into date of birth input box.
Step 4. Verify that warning message is displayed: “The date of birth is not valid”
*/


public class Test_Scripts1_Class9 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod

    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void tearDown() {
        //  driver.quit();
    }

    @Test
    public void testCase_1() {

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        WebElement birtDay = driver.findElement(By.cssSelector("[name='birthday']"));
        birtDay.sendKeys("wrong_dob");
        WebElement notValidMessage = driver.findElement(By.cssSelector("[data-bv-result='INVALID']"));

//Step 4. Verify that warning message is displayed:
        String ActuelMessage = notValidMessage.getText();
        System.out.println("ActuelMessage = " + ActuelMessage);
        String expectedMessage = "The date of birth is not valid";
        assertEquals(ActuelMessage, expectedMessage, "the warning message is displayed");

    }

    /*
    Test case #2
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
     */

    @Test
    public void testCase_2() {
        //String abc = "#inlineCheckbox"+i;
        // ("#inlineCheckbox["+i+"]")

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
/*
            WebElement jPluselements = driver.findElement(By.xpath("//*[.='JavaScript'])"));

        WebElement javaelements = driver.findElement(By.xpath("//*[@for='inlineCheckbox2'])"));
        WebElement javaScriptelements = driver.findElement(By.xpath("//*[@for='inlineCheckbox3'])"));

            String cplus=jPluselements.getAttribute("value");
            String java=javaelements.getAttribute("value");
            String javaScript=javaScriptelements.getAttribute("value");

        System.out.println("javaScript = " + javaScript);

        Assert.assertEquals(cplus,"cplusplus");
        Assert.assertEquals(java,"java");
        Assert.assertEquals(javaScript,"javaScript");
*/
//Orhan abi

        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".form-check-label"));
        System.out.println("buttons.size() = " + checkboxes.size());
        //verify button size
        assertEquals(checkboxes.size(), 3, "verify buttons size");
        for (WebElement checkbox : checkboxes) {
            String language = checkbox.getText();
            assertTrue(checkbox.isDisplayed(), "verify" + language + " is displayed");
            System.out.println("verify" + language + " is displayed");

////*[@class='form-check form-check-inline']/label
        }


    }

    @Test
    public void testCase_3() {
   /*     Test case #3
        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter only one alphabetic character into firs name input box.
        Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
       */

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("A");

        WebElement warningA = driver.findElement(By.xpath("//*[.='first name must be more than 2 and less than 64 characters long']"));
        String warningElement = warningA.getText();
        System.out.println("warningElement = " + warningElement);


        if (warningA.isDisplayed()) {
            System.out.println(warningElement + " is displayed");
        } else {
            System.out.println(warningElement + " is not displayed");

        }
        //assertTrue(warningA.isDisplayed());
    }


    @Test
    public void testCase_4() {
/*
        Test case #4
        Step 1. Go to https://practicecybertekschool.herokuapp.com
        Step 2. Click on “Registration Form”
        Step 3. Enter only one alphabetic character into last name input box.
        Step 4. Verify that warning message is displayed:“The last name must be more than 2 and less than 64 characters long”
*/
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        driver.findElement(By.name("lastname")).sendKeys("B");
        // WebElement lastNameelement = driver.findElement(By.xpath("//*[.='The last name must be more than 2 and less than 64 characters long']"));

        WebElement last = driver.findElement(By.xpath("(//*[contains(text(),' last name must be more than 2 and less than 64 characters long')])[1]"));

        System.out.println("lastNameelement = " + last.getText());
        System.out.println("lastNameMessage is displayed as  " + last.isDisplayed());

        assertTrue(last.isDisplayed());

    }

    @Test
    public void testCase_5() {
    /* Test case #5
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter any valid first name.
Step 4. Enter any valid last name.
Step 5. Enter any valid user name.
Step 6. Enter any valid password.
Step 7. Enter any valid phone number.
Step 8. Select gender.
Step 9. Enter any valid date of birth.
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language.
Step 13. Click Sign up.
Step 14. Verify that following success message is
displayed: “You've successfully completed
registration!” */


        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.name("firstname")).sendKeys("Michail");
        driver.findElement(By.name("lastname")).sendKeys("Buchen");

        driver.findElement(By.name("username")).sendKeys("MichailUsename");
        driver.findElement(By.name("email")).sendKeys("emailmichail@email.com");

        driver.findElement(By.cssSelector("[type='password']")).sendKeys("123456ABc");
        driver.findElement(By.cssSelector("[data-bv-field='phone']")).sendKeys("582-635-9187");
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("01/05/1985");
//10. Select any department.
        WebElement department = driver.findElement(By.name("department"));
        Select depart = new Select(department);
        depart.selectByVisibleText("MCR");
        System.out.println(depart.getFirstSelectedOption().getText());

        WebElement JopName = driver.findElement(By.name("job_title"));
        Select jobTile = new Select(JopName);
        jobTile.selectByIndex(4);
        System.out.println("jobTile = " + jobTile.getFirstSelectedOption().getText());

        driver.findElement(By.cssSelector("[value='java']")).click();

        driver.findElement(By.cssSelector("#wooden_spoon")).click();
        WebElement message = driver.findElement(By.tagName("p"));

        assertTrue(message.isDisplayed());
        System.out.println("message is displayed = " + message.getText());


    }

    @Test
    public void testCase_9() throws InterruptedException {

    /*Test case #9
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “200”.
Step 4. Verify that following message is displayed:
“This page returned a 200 status code”
Test case*/


        //  sayfayi asagiya kaydirma

        //  for (int i = 0; i < 10; i++) {  boylede daha yavas calisiyor
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-250)");

        //  }
        WebElement statusCodes = driver.findElement(By.linkText("Status Codes"));
        statusCodes.click();

        /*
        driver.get("https://www.amazon.com/");
        WebElement eng = driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",eng);     */

//Verify that.200...
        driver.findElement(By.partialLinkText("200")).click();
        assertTrue(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println("200 status message is =" + driver.findElement(By.tagName("p")).getText());
    }


        @Test
        //yukaridaki ile ayni

        public void test9() {
            driver.findElement(By.linkText("Status Codes")).click();
            driver.findElement(By.linkText("200")).click();
            String msg = driver.findElement(By.tagName("p")).getText();
            boolean contains = msg.contains("This page returned a 200 status code");
            Assert.assertTrue(contains);


        }



    /*Test case #8
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 2. And click on “Autocomplete”.
Step 3. Enter “United States of America” into
country input box.
Step 4. Verify that following message is displayed:
“You selected: United States of America”   */


    @Test
    public void testCase_8(){

        driver.findElement(By.linkText("Autocomplete")).click();
driver.findElement(By.id("myCountry")).sendKeys("United States of America");
driver.findElement(By.cssSelector("[value='Submit']")).click();
        WebElement result = driver.findElement(By.id("result"));
assertTrue(result.isDisplayed());
        System.out.println("result is didplayed as = " + result.getText());

    }


}




