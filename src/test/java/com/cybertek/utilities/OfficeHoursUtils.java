package com.cybertek.utilities;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfficeHoursUtils {

    static String userName = new Faker().name().firstName()+"123";
    static String password = "oscar123";
    public static WebElement userNameBox (WebDriver driver){
        return driver.findElement(By.name("username"));
    }
    public static WebElement passwordBox(WebDriver driver){
        return driver.findElement(By.name("password"));
    }

    public static int productAdder(WebDriver driver, String category, String product){
        driver.findElement(By.xpath("//a[.='"+category+"']")).click();
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("//a[.='"+product+"']")).click();
        BrowserUtils.sleep(1);

        String amountString = driver.findElement(By.xpath("//h3[@class='price-container']")).getText();
        String[] arrayAmount = amountString.split(" ");
        int amount = Integer.parseInt(arrayAmount[0].substring(1));

        driver.findElement(By.xpath("//a[.='Add to cart']")).click();
        BrowserUtils.sleep(1);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("(//a[@class='nav-link'])[1]")).click();

        return amount;
    }

    public static int productRemover(WebDriver driver, String product){
        //     //tbody//tr//td[.='Apple monitor 24']/..//td[.='Delete']/a
        driver.findElement(By.xpath("//a[.='Cart']")).click();
        BrowserUtils.sleep(1);
        int amount = Integer.parseInt(driver.findElement(By.xpath("//tbody//tr//td[.='"+product+"']/..//td[3]")).getText());
        driver.findElement(By.xpath("//tbody//tr//td[.='"+product+"']/..//td[.='Delete']/a")).click();
        BrowserUtils.sleep(3);

        return amount;
    }

    public static void addUserTest(WebDriver driver, String url){
        driver.get(url);
        userNameBox(driver).sendKeys(userName);
        passwordBox(driver).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='FormsButton2']")).click();
    }

    public static boolean positiveLoginTest (WebDriver driver, String url){
        driver.get(url);
        userNameBox(driver).sendKeys(userName);
        passwordBox(driver).sendKeys(password);
        driver.findElement(By.xpath("//input [@value='Test Login']")).click();
        WebElement successMessage = driver.findElement(By.xpath("//b[.='**Successful Login**']"));
        return successMessage.isDisplayed();
    }

    public static boolean negativeLoginTest (WebDriver driver, String url){
        driver.get(url);
        userNameBox(driver).sendKeys(userName);
        passwordBox(driver).sendKeys(password.substring(1));
        driver.findElement(By.xpath("//input [@value='Test Login']")).click();
        WebElement failMessage = driver.findElement(By.xpath("//b[.='**Failed Login**']"));
        return failMessage.isDisplayed();
    }

    public static double priceConverter (String price){
        String temp = "";
        for (int i = 0; i < price.length(); i++) {
            if(Character.isDigit(price.charAt(i))){
                temp+= ""+price.charAt(i);
            }
            if (price.charAt(i) == '.'){
                temp+=price.charAt(i);
            }
        }
        return Double.parseDouble(temp);
    }
}