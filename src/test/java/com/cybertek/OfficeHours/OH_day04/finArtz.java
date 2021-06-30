package com.cybertek.OfficeHours.OH_day04;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.OfficeHoursUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class finArtz {
    WebDriver driver;
    String browser = ConfigurationReader.getProperty("browser");
    String addUserUrl = ConfigurationReader.getProperty("finartzAddUserUrl");
    String loginUrl = ConfigurationReader.getProperty("finartLoginUrl");

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void loginTests(){
        // Adding user test
        OfficeHoursUtils.addUserTest(driver,addUserUrl);
        BrowserUtils.sleep(5);

        // Positive Login Test
        Assert.assertTrue(OfficeHoursUtils.positiveLoginTest(driver,loginUrl));
        BrowserUtils.sleep(1);
        // Negative Login test

        Assert.assertTrue(OfficeHoursUtils.negativeLoginTest(driver,loginUrl));




    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(3);
        driver.close();
    }

}