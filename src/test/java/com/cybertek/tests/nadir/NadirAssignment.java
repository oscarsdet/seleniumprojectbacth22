package com.cybertek.tests.nadir;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NadirAssignment {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup(); //Setting up the driver. Step 1;
        WebDriver driver = new ChromeDriver(); //Initializing the driver Step 2;
        driver.manage().window().maximize(); // Full screeen.


        /**
         ACCEPTANCE CRITERIA - 1
         */

        driver.get("https://qa3.vytrack.com/user/login"); //Step 3, get to the webpage.

        Thread.sleep(3000);

        driver.findElement(By.id("prependedInput")).sendKeys("user159");

        Thread.sleep(3000);

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        Thread.sleep(3000);

        driver.findElement(By.id("_submit")).click();

        String expectedTitle = "Dashboard";

        Thread.sleep(3000);

        String actualTitle = driver.getTitle();

        System.out.println("actualTitle = " + actualTitle);

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("PASS!");
        } else {
            System.out.println("FAIL!");
        }

        driver.quit(); //Closes all tabs.



    }
}

