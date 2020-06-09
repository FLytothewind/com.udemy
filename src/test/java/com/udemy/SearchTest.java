package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @Test(description = "Search some text")
    public void searchSome() {

        homePage.openHomePage();
        Assert.assertEquals(homePage.checkSearchField(), utils.getSearchFieldPlaceholder());
        homePage.enterTextInField(utils.getSearchText());
        homePage.clickSearchFieldBtn();
        Assert.assertTrue(searchResultsPage.checkResults().contains(utils.getSearchText().toLowerCase()));
        Assert.assertFalse(!driver.getCurrentUrl().contains("search"));
        Assert.assertEquals(searchResultsPage.checkHeaderSearchFieldResults(), utils.getSearchText());
        Assert.assertTrue(searchResultsPage.checkFirstResultElement().toLowerCase().contains(utils.getSearchText().toLowerCase()));





    }
}
