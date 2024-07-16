package com.thetestingacademy.Homework13July.Homework_13_july_1;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab02_negative {

    @Test
    public void NegativeSigninVWO(){

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://app.vwo.com/#/login");

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("veyad77011@admin.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Australia@123");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Sign in')]"));
        submitBtn.click();

        WebDriverWait webDriverWait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = webDriverWait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-qa='rixawilomi']")));


//        WebElement errorMsg= driver.findElement(By.xpath("//div[@data-qa='rixawilomi']"));

        Assert.assertEquals(errorMsg.getText(),"Your email, password, IP address or location did not match");
        System.out.println(errorMsg.getText());

        driver.quit();
    }
}
