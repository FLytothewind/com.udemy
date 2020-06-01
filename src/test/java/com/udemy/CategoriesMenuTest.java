package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.udemy.constants.BaseConst.MAIN_CATEGORIES;

public class CategoriesMenuTest extends TestBase {
    @Test(description = "Testing of categories in the Categories menu")
    public void checkCategories() {

        homePage.openHomePage();

        homePage.openCategoriesDropdown();

        Assert.assertEquals(homePage.getMainCategoriesNames(), MAIN_CATEGORIES);

//        Assert.assertEquals(homePage.createCategoriesArrayList(), utils.ARRAY_LIST_OF_CATEGORIES());
    }
}
