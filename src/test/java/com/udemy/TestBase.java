package com.udemy;

import Config.Utils;
import com.udemy.pages.HomePage;
import com.udemy.pages.LoginPopup;
import com.udemy.pages.RegisterPopup;
import com.udemy.pages.SearchResultsPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.sql.Date;

public class TestBase {
    WebDriver driver;
    WebDriverWait wait;
    Cookie cookie;
    Utils utils = new Utils();
    HomePage homePage;
    RegisterPopup registerPopup;
    LoginPopup loginPopup;
    SearchResultsPage searchResultsPage;


    @BeforeMethod(description = "Open browser")
    public void openBrowser() {

        File chromeDriver = new File("src/main/resources/chromedriver");

        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

                 cookie = new Cookie.Builder("dj_session_id", "kkfhowl8ac1i7qyv50o6rom6ukgfv4n4")//For the test, you need to take active cookies of the existing logged in user
                .domain("www.udemy.com")
                .path("/")
                .build();




        driver = new ChromeDriver(chromeService);
        wait = new WebDriverWait(driver, 15);
        homePage = new HomePage(driver, wait);
        registerPopup = new RegisterPopup(driver, wait);
        loginPopup = new LoginPopup(driver, wait);
        searchResultsPage = new SearchResultsPage(driver, wait);
    }

//    @AfterMethod(description = "Close browser")
//    public void closeBrowser() {
//        driver.quit();
//    }
}
