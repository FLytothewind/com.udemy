package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class HomePage {

    private WebDriver driver;
    private  WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    By userProfileLocator = By.xpath("//*[@data-purpose='user-dropdown' or @class='header--gap-xxs--2u1SO list-menu--list-menu--1IWp4 popover--popover--t3rNO popover--popover-hover--14ngr']");
    By logoutBtnLocator = By.xpath("//*[@data-purpose='do-logout' or contains(text(),'Log out')]");
    By searchFieldLocator = By.xpath("//*[@data-purpose='search-input' or @class='udlite-text-input udlite-text-input-small udlite-text-sm udlite-search-form-autocomplete-input js-header-search-field']");
    By searchFieldBtnLocator = By.xpath("(//*[@class='input-group-btn' or @type='submit'])[1]");
    By categoriesDropdownLocator = By.xpath("//*[@data-purpose='browse-courses-link' or @class='header--browse-nav--82GLV popover--popover--t3rNO popover--popover-hover--14ngr']");
//    By lastCategoryLocator = By.xpath("(//ul[@class='dropdown-menu' and @aria-labelledby='header.browse']//span[@class='fx'])[13]");
//    String categoriesTemplateXpath = "(//ul[@class='dropdown-menu' and @aria-labelledby='header.browse']//span[@class='fx'])";
    By mainCategoryLocator = By.xpath("//*[@class='menu__link' or @class='udlite-btn udlite-btn-large udlite-btn-ghost udlite-heading-md list-menu--item--1crtM udlite-block-list-item udlite-block-list-item-small udlite-text-sm udlite-block-list-item-neutral']");
    By logoutAlertLocator = By.xpath("//*[@class='with-icon alert alert-success']");
    By businessLinkLocator = By.xpath("//*[@class='dropdown--ufb zero-state dropdown--open-on-hover dropdown' or @class='header--gap-sm--2PR4A header--try-ufb--1kzro popover--popover--t3rNO popover--popover-hover--14ngr']");
//    By teachLinkLocator = By.xpath("//*[@class='header--gap-sm--2PR4A header--try-ufb--1kzro udlite-popover-open popover--popover--t3rNO popover--popover-hover--14ngr' or @class='dropdown--open-on-hover dropdown--instructor zero-state dropdown--open-on-hover dropdown']");

    public void openHomePage(){
        driver.get("https://www.udemy.com/");
    }




    public void navigateToProfileName() {
        wait.until(ExpectedConditions.elementToBeClickable(userProfileLocator));
        Actions builder = new Actions(driver);
        WebElement userProfile = driver.findElement(userProfileLocator);
        builder.moveToElement(userProfile).build().perform();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtnLocator));
        WebElement logoutBtn = driver.findElement(logoutBtnLocator);
        logoutBtn.click();
    }

    public String checkSearchField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        WebElement searchField = driver.findElement(searchFieldLocator);
        return searchField.getAttribute("placeholder");
    }

    public void enterTextInField(String text) {
        WebElement searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(text);
    }

    public void clickSearchFieldBtn() {
        WebElement searchFieldBtn = driver.findElement((searchFieldBtnLocator));
        searchFieldBtn.click();
    }

    public void openCategoriesDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(categoriesDropdownLocator));
        WebElement categoriesDropdown = driver.findElement(categoriesDropdownLocator);
        Actions builder = new Actions(driver);
        Action moveToDropdown = builder
                .moveToElement(categoriesDropdown)
                .click(categoriesDropdown)
                .build();
        moveToDropdown.perform();
    }

//    public ArrayList createCategoriesArrayList() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(lastCategoryLocator));
//        ArrayList<String> categories = new ArrayList<>();
//        for (int i = 1; i <= 13; i++) {
//            categories.add((driver.findElement(By.xpath(categoriesTemplateXpath + "[" + i + "]"))).getText());
//        }
//        return categories;
//    }

    public List<String> getMainCategoriesNames() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(mainCategoryLocator))
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String checkLogoutAlert() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutAlertLocator));
        WebElement logoutAlert = driver.findElement(logoutAlertLocator);
        return logoutAlert.getText();
    }

    public void clickBusinessLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(businessLinkLocator));
        WebElement businessLink = driver.findElement(businessLinkLocator);
        businessLink.click();
    }

//    public void clickTeachLink() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(teachLinkLocator));
//        WebElement teachLink = driver.findElement(teachLinkLocator);
//        teachLink.click();
//    }




}
