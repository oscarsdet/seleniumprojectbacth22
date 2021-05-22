package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_ZeroBAnkHeaderTextVerification {
    public static void main(String[] args) {

        //TC #1: Zero Bank header verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //Expected: “Log in to ZeroBank”
        String expectedHeader = "Log in to ZeroBank";

        // 1- locate the web element
        // 2- get the text of it using getText() method

       String actualHeader = driver.findElement(By.tagName("h3")).getText();

        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header Verification PASSED!");
        }else{
            System.out.println("Header Verification FAILED!!");
        }



    }

}