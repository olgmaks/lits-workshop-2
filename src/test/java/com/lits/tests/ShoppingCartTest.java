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

    private EbayPage ebayPage = new EbayPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void testAddToShoppingCart() {

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
