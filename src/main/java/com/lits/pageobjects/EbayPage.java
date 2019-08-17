package com.lits.pageobjects;

import com.lits.webdriver.WebDriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayPage {

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchInput;

    public EbayPage() {

        PageFactory
                .initElements(
                        WebDriverContext.getDriver(), this);
    }

    public void searchFor(String text) {

        searchInput.sendKeys(text);

        searchInput.submit();
    }
}
