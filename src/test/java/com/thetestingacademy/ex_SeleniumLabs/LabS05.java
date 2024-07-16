package com.thetestingacademy.ex_SeleniumLabs;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LabS05 {

    @Test
    public void googleOpen(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.quit();
    }
}
