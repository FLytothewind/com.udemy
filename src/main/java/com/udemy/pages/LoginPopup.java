package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPopup {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPopup(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    By logInBtnLocator = By.xpath("//*[@data-purpose='header-login' or @class='udlite-btn udlite-btn-small udlite-btn-secondary udlite-heading-sm']");
    By userNameLocator = By.xpath("//*[@class='text-midnight ellipsis']");

    public String checkLogInBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logInBtnLocator));
        WebElement loginBtn = driver.findElement(logInBtnLocator);
        return loginBtn.getText();
    }

    public String checkUserName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameLocator));
        WebElement userName = driver.findElement(userNameLocator);
        return userName.getText();
    }



}
