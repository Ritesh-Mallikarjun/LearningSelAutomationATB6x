package com.thetestingacademy.Homework13July.Homework_13_july_1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Lab01_positive {

    @Test
    public void PositiveSigninVWO() throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://app.vwo.com/#/login");

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("veyad77011@modotso.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("India@123");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Sign in')]"));
        submitBtn.click();

        //span[contains(text(),'Ved modo')]
        //div[contains(@class,'Fxg(1)')]//p//span[contains(text(),'Ved modo')]

       WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement dashboardName = webDriverWait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Ved modo')]")));

//        WebElement dashboardName=driver.findElement(By.xpath("//span[contains(text(),'Ved modo')]"));
        Assert.assertEquals(dashboardName.getText(), "Ved modo");
        System.out.println(dashboardName.getText());

        File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotAs, new File("src/test/java/com/thetestingacademy/Homework_13_july_1/VWO_Positive_Vedmodo.png"));

        Thread.sleep(3000);

        driver.quit();


    }
}
