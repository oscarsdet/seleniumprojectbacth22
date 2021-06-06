package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {

    WebDriver driver;
    //String str1;

    /*
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/dropdown
     */
    @BeforeClass
    public void setupClass(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

        //str1 = "something";
    }

    @Test
    public void tc1_simple_dropdown_test(){
        ///str1.substring(1,5);

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();

        String actualTextOfCurrentOption = currentlySelectedOption.getText();
        String expectedText = "Please select an option";

        //Assert.assertTrue(actualTextOfCurrentOption.equals(expectedText));
        Assert.assertEquals(actualTextOfCurrentOption, expectedText);

        //Doing everything in one line: get currently selected option, get the text and compare against expected
        //Assert.assertEquals(simpleDropdown.getFirstSelectedOption().getText(), "Please select an option");

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //Select stateDropdown = new Select(driver.findElement(By.id("state")));

        String actualStateDropdownText = stateDropdown.getFirstSelectedOption().getText();
        String expectedStateDropdownText = "Select a State";

        Assert.assertEquals(actualStateDropdownText, expectedStateDropdownText);


    }

    @Test
    public void tc2_state_dropdown_test() throws InterruptedException {

        //LOCATING STATE DROPDOWN
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");

        //5. Select California
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);
        //stateDropdown.selectByVisibleText("California");


        //6. Verify final selected option is California.
        //Use all Select options. (visible text, value, index)

        String expectedOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionText, expectedOptionText);

    }



    @AfterClass
    public void teardownClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }




}