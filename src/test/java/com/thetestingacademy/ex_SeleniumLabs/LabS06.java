package com.thetestingacademy.ex_SeleniumLabs;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LabS06 {
    public static void main(String[] args) {
        ChromeOptions co = new ChromeOptions();
//        co.addArguments("--headless=new");
//        co.addArguments("--start-maximized");
        co.addArguments("--window-size=750,600");
//        co.addArguments("--guest"); // it handles the popup and will not let u show it again

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("202.179.95.134:1088");
        co.setCapability("proxy",proxy);

        WebDriver driver= new ChromeDriver(co);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
//        driver.quit();

    }
}
