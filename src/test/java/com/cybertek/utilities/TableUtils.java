package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/*
Create a method named verifyOrder in TableUtils class.
• Method takes WebDriver object and String(name).
• Method should verify if given name exists in orders.
• This method should simply accepts a name(String), and assert whether
given name is in the list or not.
• Create a new TestNG test to test if the method is working as expected.
 */
public class TableUtils {

    //PRACTICE #4: Method: verifyOrder
    //• Create a method named verifyOrder in TableUtils class.
    //• Method takes WebDriver object and String(name).
    //• Method should verify if given name exists in orders.
    //• This method should simply accepts a name(String), and assert whether
    //given name is in the list or not.
    //• Create a new TestNG test to test if the method is working as expected.

    public static void verifyOrder(WebDriver driver, String name){

        //Locate all the names from table and store them in a List of WebElements
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='table1']//tr/td[2]"));

        //to introduce local variable
        //mac: option+enter
        //windows : alt+enter

        for (WebElement each : allNames) {
            if (each.getText().equals(name)){

                Assert.assertTrue(true);
                return;

            }
        }

        //Assert.fail("this line will fail the code");

        Assert.assertTrue(false, "Name does not exist in the list.");
    }

    //task 5 - create new method to print out names and emails
    public static void printNamesAndEmails(WebDriver driver){

        //Create a locator that returns all the names in the table
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='table1']//tr/td[2]"));

        //Create a locator that returns all the emails in the list
        List<WebElement> allEmails = driver.findElements(By.xpath("//table[@id='table1']//tr/td[3]"));

        for (int i = 0; i < allNames.size(); i++) {

            System.out.println("Name \t: " + allNames.get(i).getText());
            System.out.println("Email \t: " + allEmails.get(i).getText());
            //System.out.println("Name " + i + ": " + allNames.get(i) + ". Email " + i + ": " + allEmails.get(i));
        }


    }


}