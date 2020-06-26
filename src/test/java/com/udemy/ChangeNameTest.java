package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeNameTest extends TestBase {
    @Test(description = "Login With Cookies and than Change Name")
    public void loginWithCookies() {

        homePage.openHomePage();


        driver.manage().addCookie(cookie);
        driver.navigate().refresh();


        homePage.clickOnProfileBtn();
        profilePage.enterUserProfileName(utils.getNewProfileName());
        profilePage.enterUserProfileSurname(utils.getNewProfileSurname());
        profilePage.clickProfileSaveBtn();
        Assert.assertTrue(profilePage.checkProfileNotification().contains(utils.getNotificationText()));
        homePage.navigateToProfileName();
        Assert.assertTrue(profilePage.checkChangedUserName().contains(utils.getChangedProfileName()));






    }
}