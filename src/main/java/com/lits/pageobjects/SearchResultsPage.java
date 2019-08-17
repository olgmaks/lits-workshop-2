package com.lits.pageobjects;

import com.lits.webdriver.WebDriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {

    @FindBy(css = "#srp-river-results>ul>li>div>div>a")
    private List<WebElement> titles;

    public SearchResultsPage() {
        PageFactory.initElements(WebDriverContext.getDriver(), this);
    }

    public void clickFirstSearchResult() {

        titles.get(0).click();
    }
}
