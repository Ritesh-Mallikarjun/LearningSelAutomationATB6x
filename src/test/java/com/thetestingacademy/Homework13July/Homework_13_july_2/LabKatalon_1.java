package com.thetestingacademy.Homework13July.Homework_13_july_2;

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

public class LabKatalon_1 {

    @Test
    public void katalonTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        System.out.println("Landing page title: "+driver.getTitle());
        System.out.println("Landing page current url: "+driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(), "CURA Healthcare Service");
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");

        //Make Appointment button click
        WebElement appointmentBtn = driver.findElement(By.xpath("//a[text()='Make Appointment']"));
        System.out.println("Appointment button text is: "+appointmentBtn.getText());
        Assert.assertEquals(appointmentBtn.getText(),"Make Appointment");
        appointmentBtn.click();

        System.out.println("Login page URL: "+driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");
        Thread.sleep(3000);

        WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginbtn= driver.findElement(By.xpath("//button[text()='Login']"));
        loginbtn.click();

        System.out.println("Home page URL: "+driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        Thread.sleep(2000);

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement homepageTitle = webDriverWait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@method='post']//preceding-sibling::div//h2[contains(text(),'Make Appointment')]")));
        System.out.println("home page title: "+homepageTitle.getText());
        Assert.assertEquals(homepageTitle.getText(),"Make Appointment");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

}
