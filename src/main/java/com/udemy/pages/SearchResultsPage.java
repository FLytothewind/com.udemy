package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='udlite-heading-xxl']")
            private WebElement searchResults;
    @FindBy(xpath = "//input[contains(@id, 'search-form-autocomplete')]")
            private WebElement headerSearchFieldResults;
    @FindBy(xpath = "(//*[@class='udlite-heading-sm udlite-focus-visible-target course-card--course-title--2f7tE'])[1]")
            private WebElement firstResultElement;

    By searchResultsLocator = By.xpath("//*[@class='udlite-heading-xxl']");
    By headerSearchFieldResultsLocator = By.xpath("//input[contains(@id, 'search-form-autocomplete')]");
    By firstResultElementLocator = By.xpath("(//*[@class='udlite-heading-sm udlite-focus-visible-target course-card--course-title--2f7tE'])[1]");

    public String checkResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsLocator));
        return searchResults.getText();
    }

    public String checkHeaderSearchFieldResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerSearchFieldResultsLocator));
        return headerSearchFieldResults.getAttribute("value");
    }

    public String checkFirstResultElement() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResultElementLocator));
        return firstResultElement.getText();
    }
}