package com.thetestingacademy.ex_SeleniumLabs;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LabS07 {
    public static void main(String[] args) {
        ChromeOptions co = new ChromeOptions();
//        co.setPageLoadStrategy(PageLoadStrategy.EAGER); //5054
//        co.setPageLoadStrategy(PageLoadStrategy.NONE); //4779
//        co.setPageLoadStrategy(PageLoadStrategy.NORMAL); //7569

        Long startTime=System.currentTimeMillis();
        WebDriver driver= new ChromeDriver(co);
        driver.get("https://www.amazon.com");
        driver.manage().deleteAllCookies();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);

        driver.quit();

    }
}
