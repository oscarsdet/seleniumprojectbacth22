package com.cybertek.tests.group_21_practice.vtruck;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ac1 {
    WebDriver driver = Driver.getDriver();

        @Test
        public void export_grid_dropdown_left () {

            //Go to Vytrack login page
            driver.get("https://qa3.vytrack.com/user/login");

                    //Enter the username and password
                    driver.findElement(By.id("prependedInput")).sendKeys("user159");
            WebElement password = driver.findElement(By.id("prependedInput2"));
            password.sendKeys("UserUser123" + Keys.ENTER);

            //Go to Fleet-Vehicle and click
            driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();
            BrowserUtils.sleep(2);
            WebElement vehicles = driver.findElement(By.xpath("//span[.='Vehicles']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(vehicles).perform();
            BrowserUtils.sleep(1);
            vehicles.click();

            //Verify that Export Grid Dropdown is left side of the page
            //first get the width of the browser window
            int winWidth = driver.manage().window().getSize().getWidth();
            BrowserUtils.sleep(1);
            System.out.println(winWidth);

            //second get the position and size of the Export Grid Dropdown
            WebElement export_grid_dropdown = driver.findElement(By.xpath("//a[starts-with(@title,'With this')]"));
            int xPos = export_grid_dropdown.getLocation().getX();
            int gridWidth = export_grid_dropdown.getSize().getWidth();
            BrowserUtils.sleep(1);

            //finally check if the sum of Export Grid button position and
            //width is less than half of the browser window width
            Assert.assertTrue((xPos + gridWidth) <= winWidth/2,
                    "Grid is not  left side");

        }
    }

