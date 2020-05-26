package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @Test(description = "Search some text")
    public void Search() {

        homePage.openHomePage();
        Assert.assertEquals(homePage.checkSearchField(), "What do you want to learn?");
        homePage.enterTextInField(utils.getSEARCH_TEXT());
        homePage.clickSearchFieldBtn();
        Assert.assertTrue(searchResultsPage.checkResults().contains(utils.getSEARCH_TEXT().toLowerCase()));
        Assert.assertFalse(!driver.getCurrentUrl().contains("ref=home"));
        Assert.assertEquals(searchResultsPage.checkHeaderSearchFieldResults(), utils.getSEARCH_TEXT());
        Assert.assertTrue(searchResultsPage.checkFirstResultElement().toLowerCase().contains(utils.getSEARCH_TEXT().toLowerCase()));





    }
}
