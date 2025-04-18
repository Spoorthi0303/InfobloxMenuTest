package com.infoblox.pages;

import com.infoblox.constants.MenuXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public List<String> getDropdownItems(MenuXpath menu) {
        List<String> items = new ArrayList<>();
        try {
            WebElement menuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menu.getMenuXpath())));
            Actions actions = new Actions(driver);
            actions.moveToElement(menuElement).perform();

            // wait for dropdown items to load
            List<WebElement> dropdownElements = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(menu.getDropdownXpath()))
            );
            for (WebElement element : dropdownElements) {
                items.add(element.getText().trim());
            }
        } catch (Exception e) {
            System.out.println("Error extracting dropdown for: " + menu.name());
            e.printStackTrace();
        }
        return items;
    }
}
