package com.cybertek.tests.day_findElenets_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PO_findElements_Practice {
    public static void main(String[] args) {

        //TC #0: FINDELEMENTS
        //1. Open Chrome browser

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // If a web element is not found, this will wait UP TO given seconds
        // If web element is located before 15 seconds, it will move on
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        //2. Go to http://practice.cybertekschool.com/forgot_password

// we need to create a locator that returns us all the links on the page
        //body// a--> This locator will return all of the links on the page

        //we are storing all of the links that are returned by findElements methods
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        //3. Print out the texts of all links
        for (WebElement each : listOfLinks){

            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));
        }
//iter +tab ===> shortcut for  foreach loop
        // fori + tab ====> shortcut for regular for loop

        //4. Print out how many total link
        System.out.println("listOfLinks = " + listOfLinks);;
    }

}