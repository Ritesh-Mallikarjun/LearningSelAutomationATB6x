package com.thetestingacademy.ex_SeleniumLabs;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LabS04 {

    @Test
    @Description
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        driver.navigate().to("https://www.nic.com");
        driver.navigate().to("https://www.dictionary.com/browse/snick");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        // navigate.to() and get() methods both are same commands , which are exactly the same


    }
}
