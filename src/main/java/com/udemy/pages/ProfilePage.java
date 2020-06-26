package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProfilePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='id_name']")
            private WebElement userProfileNameFld;
    @FindBy(xpath = "//*[@id='id_surname']")
            private  WebElement userProfileSurnameFld;
    @FindBy(xpath = "//*[@class='btn btn-primary ']")
            private  WebElement userProfileSaveBtn;
    @FindBy(xpath = "//*[@class='feedbacks-bar--message--3Na3Q']")
            private WebElement userProfileNotification;
    @FindBy(xpath = "//*[@class='text-midnight ellipsis' or @class='user-profile-dropdown--user-details--t_plO']")
            private WebElement userProfileChangedName;




    By userProfileNameFldLocator = By.xpath("//*[@id='id_name']");
    By userProfileSurnameFldLocator = By.xpath("//*[@id='id_surname']");
    By userProfileSaveBtnLocator = By.xpath("//*[@class='btn btn-primary ']");
    By userProfileNotificationLocator = By.xpath("//*[@class='feedbacks-bar--message--3Na3Q']");
    By userProfileChangedNameLocator = By.xpath("//*[@class='text-midnight ellipsis' or @class='user-profile-dropdown--user-details--t_plO']");

    public void enterUserProfileName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileNameFldLocator));
        userProfileNameFld.clear();
        userProfileNameFld.sendKeys(name);
    }

    public void enterUserProfileSurname(String surname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileSurnameFldLocator));
        userProfileSurnameFld.clear();
        userProfileSurnameFld.sendKeys(surname);
    }

    public void clickProfileSaveBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileSaveBtnLocator));
        userProfileSaveBtn.click();
    }

    public String checkProfileNotification() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileNotificationLocator));
        return userProfileNotification.getText();
    }

    public String checkChangedUserName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileChangedNameLocator));
        return userProfileChangedName.getText();
    }



}
