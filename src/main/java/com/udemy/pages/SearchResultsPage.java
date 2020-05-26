package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By searchResultsLocator = By.xpath("//*[@class='udlite-heading-xxl']");
    By headerSearchFieldResultsLocator = By.xpath("//input[contains(@id, 'search-form-autocomplete')]");
    By firstResultElementLocator = By.xpath("(//*[@class='udlite-heading-sm udlite-focus-visible-target course-card--course-title--2f7tE'])[1]");

    public String checkResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsLocator));
        WebElement searchResults = driver.findElement(searchResultsLocator);
        return searchResults.getText();
    }

    public String checkHeaderSearchFieldResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerSearchFieldResultsLocator));
        WebElement headerSearchFieldResults = driver.findElement(headerSearchFieldResultsLocator);
        return headerSearchFieldResults.getAttribute("value");
    }

    public String checkFirstResultElement() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResultElementLocator));
        WebElement firstResultElement = driver.findElement(firstResultElementLocator);
        return firstResultElement.getText();
    }
}