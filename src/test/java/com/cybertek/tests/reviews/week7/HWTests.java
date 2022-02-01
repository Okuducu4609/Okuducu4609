package com.cybertek.tests.reviews.week7;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
            Test case #1
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that page subtitle "Options" is displayed   */

public class HWTests extends TestBaseForHW {

    @Test
    public void verifyOptionsTest() {
        extentLogger = report.createTest("Verify Options Link");
        extentLogger.info("Preconditions Loaded");
        extentLogger.info("Verify that Options Link is Displayed");
        Assert.assertTrue(page.optionsLink.isDisplayed(), "Link is NOT Displayed");
        extentLogger.pass("Options is Displayed");
        //  System.out.println("OptionMenu = " +  page.optionsLink.getText()); //calisti as Option
    }
/*
Test case #2
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that page number is equals to "1"
 */
        @Test
        public void verifyPageNumber () {
            extentLogger = report.createTest("Verify Page Number");
            int pageNumber = Integer.parseInt(page.pageNumber.getAttribute("value"));
            extentLogger.info("verify page number");
            Assert.assertEquals(pageNumber, 1, "Page Number is NOT equal to 1");
            extentLogger.pass("page number verified");

        }
/*
Test case #3
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that view per page number is equals to
"25"
 */
    @Test
    public void verifyViewPerPageTest () {
        extentLogger = report.createTest("Verify View Per Page Test");
            wait.until(ExpectedConditions.visibilityOf(page.viewPerPage));
        System.out.println("page.viewPerPage.getText() = " + page.viewPerPage.getText());
        int viewPerPage = Integer.parseInt(page.viewPerPage.getText().trim());
        extentLogger.info("Verify View Per Page is 25");
        Assert.assertEquals(viewPerPage,25,"View Per Page is NOT equal to 25 ");
        extentLogger.pass("Test PASSED");





    }

    }


