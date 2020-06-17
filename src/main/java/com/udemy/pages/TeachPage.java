package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class TeachPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public  TeachPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    By teachLinkLocator = By.xpath("//*[@class='header--gap-sm--2PR4A header--instructor--xNBHM popover--popover--t3rNO popover--popover-hover--14ngr' or @class='dropdown--open-on-hover dropdown--instructor zero-state dropdown--open-on-hover dropdown']");

        public void clickTeachLink() {
        ArrayList<String> tabs_windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(1));
        driver.close();
            driver.switchTo().window(tabs_windows.get(0));
            wait.until(ExpectedConditions.visibilityOfElementLocated(teachLinkLocator));
            WebElement teachLink = driver.findElement(teachLinkLocator);
            teachLink.click();

    }
}

