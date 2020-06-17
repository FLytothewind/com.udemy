package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckLinksTest extends TestBase {
    @Test(description = "Check  Business and Teach Links")
    public void checkLinks() {
        homePage.openHomePage();
        homePage.clickBusinessLink();
        Assert.assertTrue(businessPage.checkBusinessMainText().contains(utils.getBusinessMainText()));
        teachPage.clickTeachLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("teaching"));









    }
}
