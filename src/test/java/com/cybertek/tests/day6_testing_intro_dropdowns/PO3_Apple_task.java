package com.cybertek.tests.day6_testing_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PO3_Apple_task {
    public static void main(String[] args) throws InterruptedException {

        //TC #03: FINDELEMENTS_APPLE
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://www.apple.com
        driver.get("https://www.apple.com");
        // todo review

        //3. Click to all of the headers one by one
        //  apple Logo
        //  Mac,
        //  iPad,
        //  iPhone,
        //  Watch,
        //  TV,
        //  Music,
        //  Support
        //  search box

        // Storing 9 web elements including "apple" logo, and search box
        List<WebElement> headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));

        for (int eachLink = 1; eachLink < headerLinks.size() - 1; eachLink++) {

            //System.out.println(headerLinks.get(eachLink).getText());

            headerLinks.get(eachLink).click();
            Thread.sleep(1000);
            headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));

            //4. Print out the titles of the each page
            System.out.println("Current title in the page:" + driver.getTitle());

            //5. Print out total number of links in each page
            List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

            System.out.println("Number of links in current page: " + allLinks.size());

            int linksWithNoText = 0;
            int linksWithText = 0;

            for (WebElement each : allLinks) {
                if (each.getText().isEmpty()) {
                    linksWithNoText++;
                } else {
                    linksWithText++;

                }
            }

            //6. While in each page:
            // a. Print out how many link is missing text TOTAL
            System.out.println("--> Current page links with no text: " + linksWithNoText);

            // b. Print out how many link has text TOTAL
            System.out.println("--> current page links with text: " + linksWithText);
        }
    }
}