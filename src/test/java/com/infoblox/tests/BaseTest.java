package com.infoblox.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    public static WebDriver driver;
    Actions actions;
    @BeforeSuite
    public void setup() {
        driver = new ChromeDriver();
        actions = new Actions(driver); // Initialize after driver
        driver.manage().window().maximize();
        System.out.println("Browser Setup Complete");
        driver.get("https://www.infoblox.com/");
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        //com.infoblox.utils.ExcelUtil.saveExcel();
    }
}