package com.udemy;

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

        By registerBtnLocator = By.xpath("//*[@data-purpose='header-signup']");
        By checkSignUpHeaderLocator = By.xpath("//*[@class=' loginbox-v4__header loginbox-v4__header--signup']");
        By nameFieldLocator = By.id("id_fullname");
        By randomEmailLocator = By.xpath("//*[@type='email']");
        By passwordFieldLocator = By.id("password");
        By signUpBtnLocator = By.id("submit-id-submit");
        By userProfileLocator = By.xpath("//*[@data-purpose='user-dropdown']");
        By logoutBtnLocator = By.xpath("//*[@data-purpose='do-logout']");



        driver.get("https://www.udemy.com/");

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();


        wait.until(ExpectedConditions.elementToBeClickable(registerBtnLocator));
        WebElement registerBtn = driver.findElement(registerBtnLocator);
        registerBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(checkSignUpHeaderLocator));
        WebElement checkSignUpHeader = driver.findElement(checkSignUpHeaderLocator);
        Assert.assertEquals(checkSignUpHeader.getText(), "Sign Up and Start Learning!");

        WebElement nameField = driver.findElement(nameFieldLocator);
        nameField.clear();
        nameField.sendKeys("Jimbo");

        final String randomEmail = randomEmail();
        WebElement emailField = driver.findElement(randomEmailLocator);
        emailField.clear();
        emailField.sendKeys(randomEmail);

        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys("qwerty1234qwerty");

        WebElement signUpBtn = driver.findElement(signUpBtnLocator);
        signUpBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(userProfileLocator));
        Actions builder = new Actions(driver);
        WebElement userProfile = driver.findElement(userProfileLocator);
        builder.moveToElement(userProfile).build().perform();


        WebElement logoutBtn = driver.findElement(logoutBtnLocator);
        Assert.assertEquals(logoutBtn.getText(), "Log out");
        logoutBtn.click();



    }

    public static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@appcreative.net";
    }



}
