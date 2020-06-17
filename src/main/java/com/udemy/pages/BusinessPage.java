package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BusinessPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public  BusinessPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By businessMainTextLocator = By.xpath("//*[@class='mb-12 invisible sm:visible']");

    public String checkBusinessMainText() {
        ArrayList<String> tabs_windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(businessMainTextLocator));
        WebElement mainText = driver.findElement(businessMainTextLocator);
        return mainText.getText();
    }


}
