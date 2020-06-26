package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPopup {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPopup(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@data-purpose='header-login' or @class='udlite-btn udlite-btn-small udlite-btn-secondary udlite-heading-sm']")
            private WebElement loginBtn;
    @FindBy(xpath = "//*[@class='text-midnight ellipsis']")
            private WebElement userName;

    By logInBtnLocator = By.xpath("//*[@data-purpose='header-login' or @class='udlite-btn udlite-btn-small udlite-btn-secondary udlite-heading-sm']");
    By userNameLocator = By.xpath("//*[@class='text-midnight ellipsis']");

    public String checkLogInBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logInBtnLocator));
        return loginBtn.getText();
    }

    public String checkUserName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameLocator));
        return userName.getText();
    }



}
