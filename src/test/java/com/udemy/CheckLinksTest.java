package com.udemy;

import com.udemy.pages.TeachPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckLinksTest extends TestBase {
    @Test(description = "Check  Business and Teach Links")
    public void checkLinks() {
        homePage.openHomePage();
        homePage.clickBusinessLink();
        Assert.assertTrue(businessPage.checkBusinessMainText().contains(utils.getBusinessMainText()));
        Assert.assertTrue(driver.getCurrentUrl().contains("request-demo"));
        teachPage.clickTeachLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("teaching"));
        Assert.assertTrue(teachPage.checkTeachText().contains(utils.getTeachText()));









    }
}
