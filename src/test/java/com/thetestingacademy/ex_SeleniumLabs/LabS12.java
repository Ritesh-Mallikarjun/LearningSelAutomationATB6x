package com.thetestingacademy.ex_SeleniumLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.transform.sax.SAXResult;
import java.time.Duration;
import java.util.List;

public class LabS12 {

    WebDriver driver;
    @BeforeMethod
    public  void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");
    }

    @Test
    public void amchartsSvnIndiaMap(){
        By xpathByClass = By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']");
        List<WebElement> listsvnMap=driver.findElements(xpathByClass);
        System.out.println(listsvnMap.size());
        for (WebElement element :listsvnMap) {
            String stateName=element.getAttribute("aria-label");
            if(stateName.contains("Karnataka")){
                new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
                element.click();
            }
        }
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
