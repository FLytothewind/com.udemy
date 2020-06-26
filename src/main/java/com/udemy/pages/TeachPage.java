package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class TeachPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public  TeachPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='header--gap-sm--2PR4A header--instructor--xNBHM popover--popover--t3rNO popover--popover-hover--14ngr' or @class='dropdown--open-on-hover dropdown--instructor zero-state dropdown--open-on-hover dropdown']")
            private WebElement teachLink;
    @FindBy(xpath = "//*[@class='text-shadow']")
            private WebElement teachText;




    By teachLinkLocator = By.xpath("//*[@class='header--gap-sm--2PR4A header--instructor--xNBHM popover--popover--t3rNO popover--popover-hover--14ngr' or @class='dropdown--open-on-hover dropdown--instructor zero-state dropdown--open-on-hover dropdown']");
    By teachTextLocator = By.xpath("//*[@class='text-shadow']");

    public void clickTeachLink() {
        ArrayList<String> tabs_windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(1));
        driver.close();
            driver.switchTo().window(tabs_windows.get(0));
            wait.until(ExpectedConditions.visibilityOfElementLocated(teachLinkLocator));
            teachLink.click();

    }

        public String checkTeachText(){
            wait.until(ExpectedConditions.visibilityOfElementLocated(teachTextLocator));
            return teachText.getText();
        }
}

