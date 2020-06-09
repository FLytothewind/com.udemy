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
    public void loginWithCookies() {

        homePage.openHomePage();
        Assert.assertEquals(loginPopup.checkLogInBtn(), utils.getLoginBtnText());

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();


        homePage.navigateToProfileName();

        Assert.assertEquals(loginPopup.checkUserName(), utils.getLoginUserNameText());
        homePage.clickLogout();





    }
}
