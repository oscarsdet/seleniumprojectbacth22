package com.cybertek.tests.group_21_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class youtubeSongSearchAndPlay {

    public static void main(String[] args) throws InterruptedException {
        //1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2.Go to https://www.youtube.com/
        WebElement searchBar;
        driver.get("https://www.youtube.com");

                //3.Locate Youtube search bar by xpath
        searchBar = driver.findElement(By.xpath("//input[@id='search']"));
        searchBar.sendKeys("Blue - One Love");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer']")).click();
    }


}