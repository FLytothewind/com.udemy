package com.udemy;

import com.udemy.pages.HomePage;
import com.udemy.pages.RegisterPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

import java.io.File;


public class RegistrationTest extends TestBase{



    @Test(description = "Registration With Valid Credentials")
    public void registrationWithValidCredentials() {

        homePage.openHomePage();
        registerPopup.openRegisterPopup();
        Assert.assertEquals(registerPopup.checkRegisterHeader(), "Sign Up and Start Learning!");
        registerPopup.enterName("Jimbo");
        registerPopup.enterEmail(utils.getEMAIL_FOR_REGISTER());
        registerPopup.enterPassword("Qwerty1234");
        registerPopup.clickRegisterBtn();
        homePage.getProfileName();
        homePage.clickLogout();
















    }





}
