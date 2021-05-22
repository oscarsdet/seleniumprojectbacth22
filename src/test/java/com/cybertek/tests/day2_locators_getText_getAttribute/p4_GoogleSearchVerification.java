package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class p4_GoogleSearchVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        TC #4:	Google	search
//        1- Open	a	chrome	browser
//        2- Go	to:	https://google.com
        driver.get("https:/www.google.com");
//        3- Write	“apple”	in	search	box
        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
//        4- Click	google	search	button
//        5- Verify	title:
        String expectedInTitle = "apple";
        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith("expectedTirle")) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");

//        Expected:	Title	should	start	with	“apple”	word
        }
    }
}
