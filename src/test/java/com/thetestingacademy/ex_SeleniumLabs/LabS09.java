package com.thetestingacademy.ex_SeleniumLabs;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LabS09 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    //One method of using explicit wait using WebElement and By class while calling webdriverwait method
    @Test
    public void alertsMethod1() {
        By titlelocator = By.xpath("//div//h3[text()='JavaScript Alerts']");
        explicitWaitVEOL(driver, titlelocator); //first wait explicitly for sometime after which u can locate and the print the title
        WebElement title = driver.findElement(titlelocator);
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"JavaScript Alerts");

        WebElement jsAlertbtn=driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        System.out.println("first button text: "+jsAlertbtn.getText());
        Assert.assertEquals(jsAlertbtn.getText(),"Click for JS Alert");
        jsAlertbtn.click();

        //now wait for the alert popup to appear after button click
        waitForAlertPopup(driver);
        Alert alert= driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();
    }

    @Test
    public void alertsMethod2(){
        WebElement jsConfirmbtn = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        System.out.println("second button name is: "+jsConfirmbtn.getText());
        Assert.assertEquals(jsConfirmbtn.getText(),"Click for JS Confirm");
        jsConfirmbtn.click();

        waitForAlertPopup(driver);
        Alert alert= driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.accept();
    }

    @Test
    public void alertsMethod3(){
        WebElement jsConfirmbtn = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        System.out.println("second button name is: "+jsConfirmbtn.getText());
        Assert.assertEquals(jsConfirmbtn.getText(),"Click for JS Confirm");
        jsConfirmbtn.click();

        waitForAlertPopup(driver);
        Alert alert= driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss();
    }

    @Test
    public void alertsMethod4(){
        WebElement jsPromptBtn= driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        System.out.println("third button name is: "+jsPromptBtn.getText());
        Assert.assertEquals(jsPromptBtn.getText(),"Click for JS Prompt");
        jsPromptBtn.click();

        waitForAlertPopup(driver);
        Alert alert= driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(),"I am a JS prompt");
        alert.sendKeys("dasdadsadad");
        alert.accept();

       WebElement wordToBeSearched= driver.findElement(By.xpath("//p[@id='result' and contains(text(),'You')]"));
        System.out.println(wordToBeSearched.getText());
        Assert.assertEquals(wordToBeSearched.getText().replaceAll("You entered: ",""),"Ritesh testing popup");
    }

    public void explicitWaitVEOL(WebDriver driver, By element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForAlertPopup(WebDriver driver){
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
