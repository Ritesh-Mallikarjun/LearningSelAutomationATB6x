package com.thetestingacademy.ex_SeleniumLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LabS11 {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://awesomeqa.com/webtable1.html");
    }

    @Test
    public void dynamicWebTableCheckup() {

        WebElement table=driver.findElement(By.xpath("//table[@class='tsc_table_s13']"));
//        List<WebElement> rows=table.findElements(By.tagName("tr"));
        List<WebElement> rows=table.findElements(By.xpath("//table//tbody//tr"));
        System.out.println(rows.size()); // totally they are 6 rows only, out of which they are 4 rows in tbody element
        for (WebElement row : rows) {
            List<WebElement> cols=row.findElements(By.tagName("td")); //each row contains only 6 columns
            for (WebElement column :cols) {
                System.out.println(column.getText());
            }
        }

        String specificCell1=rows.get(0).findElements(By.tagName("td")).get(0).getText();
        String specificCell2=rows.get(0).findElements(By.tagName("td")).get(1).getText();
        String specificCell3=rows.get(0).findElements(By.tagName("td")).get(2).getText();
        String specificCell4=rows.get(0).findElements(By.tagName("td")).get(3).getText();
        System.out.println(specificCell4);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
