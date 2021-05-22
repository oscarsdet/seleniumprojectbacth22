package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        //1- setup the browser driver
       WebDriverManager.chromedriver().setup();


        // 2- create instance of selenium web driver
        WebDriver driver = new ChromeDriver();

        // this line will basically maximaze the browser size
        driver.manage().window().maximize();

        // will work for mac only , will not work in windows
       // driver.manage().window().maximize().fullscreen();



        //3- get the page for Tesla.com

        driver.get("https://www.tesla.com");
        System.out.println( "current title: "  + driver.getTitle());


       String currentUrl =  driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);


        // putting 3 seconds  os wait/ stops the code for 3 sec
        Thread.sleep(3000);

        // Going back using navigations
        driver.navigate().back();

        //Going forward using navigations
        driver.navigate().forward();

        // putting 3 seconds  os wait/ stops the code for 3 sec
        Thread.sleep(3000);

        // refreshing the page using navigations
        driver.navigate().refresh();

        // putting 3 seconds  os wait/ stops the code for 3 sec
        Thread.sleep(3000);


        // going to another url using .to() method
        driver.navigate().to("https://www.google.com");


        driver.getTitle();
        System.out.println( "current title: "  + driver.getTitle());

        currentUrl = driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);


        // this method will close the currently opened browser
        // it will only close 1 browser or 1 tab
        driver.close();

       // driver.quit();








    }
}
