package com.cybertek.OfficeHours.OH_day03;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.OfficeHoursUtils;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AdidasPractice {


    WebDriver driver;
    int expectedOrderAmmount = 0;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");
    }


    @Test
    public void adidasTest(){
        // Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart" and adding the price to order amount
        expectedOrderAmmount+= OfficeHoursUtils.productAdder(driver,"Laptops","Sony vaio i5");
        // Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart" and adding the price to order amount
        expectedOrderAmmount+=OfficeHoursUtils.productAdder(driver,"Phones","Samsung galaxy s6");
        // Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart" and adding the price to order amount
        expectedOrderAmmount+=OfficeHoursUtils.productAdder(driver,"Monitors","Apple monitor 24");

        // Remove  Apple monitor 24
        expectedOrderAmmount-=OfficeHoursUtils.productRemover(driver,"Apple monitor 24");

        driver.findElement(By.xpath("//button[.='Place Order']")).click();

        Faker faker = new Faker();
        driver.findElement(By.id("name")).sendKeys(faker.name().fullName());
        driver.findElement(By.id("country")).sendKeys(faker.country().name());
        driver.findElement(By.id("city")).sendKeys(faker.country().capital());
        driver.findElement(By.id("card")).sendKeys(faker.finance().creditCard());
        driver.findElement(By.id("month")).sendKeys(String.valueOf(faker.number().numberBetween(1,12)));
        driver.findElement(By.id("year")).sendKeys(String.valueOf(faker.number().numberBetween(2022,2030)));
        driver.findElement(By.xpath("//button[.='Purchase']")).click();
        BrowserUtils.sleep(1);
        String confirmation = driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
        System.out.println("confirmation = " + confirmation);

        String[] confirmationArray = confirmation.split("\n");
        String orderID = confirmationArray[0];
        System.out.println("orderID = " + orderID);
        int actualAmmount = Integer.parseInt(confirmationArray[1].split(" ")[1]);
        System.out.println("actualAmmount = " + actualAmmount);
        System.out.println("expectedOrderAmmount = " + expectedOrderAmmount);

        Assert.assertEquals(actualAmmount,expectedOrderAmmount);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}

