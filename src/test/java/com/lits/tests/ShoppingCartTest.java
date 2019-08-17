package com.lits.tests;

import com.lits.pageobjects.EbayPage;
import com.lits.pageobjects.ProductDetailsPage;
import com.lits.pageobjects.SearchResultsPage;
import com.lits.pageobjects.ShoppingCartPage;
import com.lits.webdriver.WebDriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ShoppingCartTest {

    @Test
    public void testAddToShoppingCart() {

        EbayPage ebayPage = new EbayPage();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

        WebDriverContext.loadURL("https://www.ebay.com/");

        ebayPage.searchFor("iphone x");

        searchResultsPage.clickFirstSearchResult();

        productDetailsPage.selectDefaultColor();
        String productDetailsURL = WebDriverContext.getDriver().getCurrentUrl();

        productDetailsPage.addProductToCart();

        Assert.assertEquals(
                WebDriverContext.getDriver().getCurrentUrl(),
                "https://cart.payments.ebay.com/",
                "Browser is not located on shopping cart url");
    }


    @AfterMethod
    public void tearDown() {
        WebDriverContext.stop();
    }

}
