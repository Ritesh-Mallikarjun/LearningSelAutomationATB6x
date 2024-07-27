package com.thetestingacademy.ex_SeleniumLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LabS10 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    public void tableCheckup() {
//        String dynamicPath = //table[@id='table1']//tbody//tr[1]//td[1] , it will give you string data which is present in the cell r1,c1 data

        String firstRowPath = "//table[@id='table1']//tbody//tr[";
        String secondRowPath = "]//td[";
        String thirdRowPath = "]";
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
        System.out.println(elements.size()); //4
        List<WebElement> colsize = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[1]//td"));
        System.out.println(colsize.size()); //6

        int RowNum = 0;
        for (int i = 1; i <= elements.size(); i++)  // 1 to 4
        {
            for (int j = 1; j <= colsize.size(); j++) // 1 to 6
            {
                String dynamicPath = firstRowPath + i + secondRowPath + j + thirdRowPath;
                String tableData = driver.findElement(By.xpath(dynamicPath)).getText();
                System.out.println(tableData);
                if (tableData.equals("Jason")) {
                    System.out.println("===============================");
                    System.out.println("FirstName is: " + tableData);
                    String precedingsib = driver.findElement(By.xpath(dynamicPath + "//preceding-sibling::td")).getText();
                    System.out.println("LastName is: " + precedingsib);
                    String followingSibling = driver.findElement(By.xpath(dynamicPath + "//following-sibling::td")).getText();
                    System.out.println("Email id is: " + followingSibling);
                    System.out.println("===============================");
                    RowNum = i;
                }

                if (RowNum == i && tableData.contains("edit")) {
                    //table[@id='table1']//tbody//tr[3]//td[6]//a[text()='edit']
                    String editpath = dynamicPath + "//a[text()='edit']";
                    driver.findElement(By.xpath(editpath)).click();
                    System.out.println(driver.getCurrentUrl());
                    Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/tables#edit");
                }

                if (RowNum == i && tableData.contains("delete")) {
                    String deletePath = dynamicPath + "//a[text()='delete']";
                    driver.findElement(By.xpath(deletePath)).click();
                    System.out.println(driver.getCurrentUrl());
                    Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/tables#delete");
                }
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
