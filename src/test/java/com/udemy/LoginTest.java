package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTest extends TestBase {

    @Test(description = "Login With Cookies")
    public void LoginWithCookies() {

        By logInBtnLocator = By.xpath("//*[@data-purpose='header-login']");
        By userProfileLocator = By.xpath("//*[@data-purpose='user-dropdown']");
        By userNameLocator = By.xpath("//*[@class='text-midnight ellipsis']");
        By logoutBtnLocator = By.xpath("//*[@data-purpose='do-logout']");


        driver.get("https://www.udemy.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(logInBtnLocator));
        WebElement loginBtn = driver.findElement(logInBtnLocator);
        Assert.assertEquals(loginBtn.getText(), "Log In");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        wait.until(ExpectedConditions.elementToBeClickable(userProfileLocator));
        Actions builder = new Actions(driver);
        WebElement userProfile = driver.findElement(userProfileLocator);
        builder.moveToElement(userProfile).build().perform();

        WebElement userName = driver.findElement(userNameLocator);
        Assert.assertEquals(userName.getText(), "Jordano");

        WebElement logoutBtn = driver.findElement(logoutBtnLocator);
        Assert.assertEquals(logoutBtn.getText(), "Log out");
        logoutBtn.click();



    }
}
