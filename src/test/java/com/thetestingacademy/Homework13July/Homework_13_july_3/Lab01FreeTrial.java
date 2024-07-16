package com.thetestingacademy.Homework13July.Homework_13_july_3;

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
import java.util.concurrent.TimeUnit;

public class Lab01FreeTrial {

    @Test
    public void posLoginTrialCheck() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://www.idrive360.com/enterprise/login");
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("augtest_040823@idrive.com");

        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("123456");

        WebElement loginBtn= driver.findElement(By.id("frm-btn"));
        loginBtn.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement freetrialExpired = webDriverWait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='upgrade']//span[text()='Your free trial has expired']")));
        System.out.println(freetrialExpired.getText());
        if(freetrialExpired.getText().equals("Your free trial has expired")){
            System.out.println("The free trial has expired and the account has to be upgraded");
        }
        else{
            System.out.println("The free trial has not expired, and account is under usage");
        }

        System.out.println("Homepage URL: "+driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.idrive360.com/enterprise/account?upgradenow=true");

        System.out.println("Homepage title: "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"IDrive 360 account details");

        driver.quit();

    }
}
