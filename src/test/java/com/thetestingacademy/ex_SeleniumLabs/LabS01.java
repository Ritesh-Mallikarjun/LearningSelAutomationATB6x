package com.thetestingacademy.ex_SeleniumLabs;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LabS01 {
    public static void main(String[] args) {
        //Usage of dyanmic dispatch concept
        //usage of inheritance

        WebDriver driver= new EdgeDriver();
        WebDriver driver1= new ChromeDriver();
        WebDriver driver2= new FirefoxDriver();
        WebDriver driver4= new InternetExplorerDriver();
        WebDriver driver5= new SafariDriver();

        //opera is not there as its removed

//        SearchContext(I) -- 2 methods
//        WebDriver(I) -- 10 methods
//        RemoteWebDriver(C) -- 15 methods
//        ChromiumDriver(C) -- 25 methods
//        EdgeDriver(C) -- 45 methods

//        SearchContext
//        WebDriver
//        RemoteWebDriver
//        ChromiumDriver
//        ChromeDriver

        //selenium concepts where API request is used from server(driver) to browser to execute the commands
//        1) create a session id;\
//        2) use session id to post a request to open the url;
//        3) when u run a command , the instruct a webdriver server to instruct browser to open;
//        4) after opening the browser , open the url
//        5) then after which end the session using quit() command





    }
}
