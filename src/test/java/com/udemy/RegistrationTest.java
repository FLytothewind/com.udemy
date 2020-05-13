package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

import java.io.File;


public class RegistrationTest {

    @Test(description = "Registration With Valid Credentials")
    public void registrationWithValidCredentials() {
        File chromeDriver = new File("src/main/resources/chromedriver");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();



        WebDriver driver = new ChromeDriver(chromeService);
        driver.get("https://www.udemy.com/");
        pause(3000);


        WebElement registerButton = driver.findElement(
                By.xpath("//*[@data-purpose='header-signup']"));
        registerButton.click();
        pause(2000);

        WebElement checkSignUpHeader = driver.findElement(
                By.xpath("//*[@class=' loginbox-v4__header loginbox-v4__header--signup']"));
        Assert.assertEquals(checkSignUpHeader.getText(), "Sign Up and Start Learning!");

        WebElement nameField = driver.findElement(By.id("id_fullname"));
        nameField.clear();
        nameField.sendKeys("Jimbo");

        final String randomEmail = randomEmail();
        WebElement emailField = driver.findElement(By.xpath("//*[@type='email']"));
        emailField.clear();
        emailField.sendKeys(randomEmail);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("qwerty1234");

        WebElement signUpButn = driver.findElement(By.id("submit-id-submit"));
        signUpButn.click();
        pause(5000);

        Actions builder = new Actions(driver);
        WebElement userProfile = driver.findElement(By.xpath("//*[@class='dropdown--open-on-hover dropdown--user dropdown--open-on-hover dropdown']"));
        builder.moveToElement(userProfile).build().perform();

        WebElement logoutBtn = driver.findElement(By.xpath("//*[@data-purpose='do-logout']"));
        Assert.assertEquals(logoutBtn.getText(), "Log out");
        logoutBtn.click();


        driver.quit();
    }

    public static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@appcreative.net";
    }

    private  void pause(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
