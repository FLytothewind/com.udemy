package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoriesMenuTest extends TestBase {
    @Test(description = "Testing of categories in the \"Categories\" menu")
    public void getCategories() {

        homePage.openHomePage();

        homePage.openCategoriesDropdown();

        Assert.assertEquals(homePage.createCategoriesArrayList(), utils.ARRAY_LIST_OF_CATEGORIES());
    }
}
