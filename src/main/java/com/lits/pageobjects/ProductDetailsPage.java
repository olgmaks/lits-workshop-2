package com.lits.pageobjects;

import com.lits.webdriver.WebDriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {

    @FindBy(id = "isCartBtn_btn")
    private WebElement addToCartButton;

    @FindBy(name = "Colour")
    private WebElement colorSelect;

    public ProductDetailsPage() {

        PageFactory
                .initElements(
                        WebDriverContext.getDriver(), this);
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public void selectDefaultColor() {

        new Select(colorSelect).selectByValue("0");
    }
}
