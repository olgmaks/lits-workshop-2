package com.lits.imdb;

import com.lits.webdriver.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {


    @FindBy(xpath = "//*[contains(@class, 'imdb-logo')]/..")
    private WebElement signInWithIMDB;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;


    public void signInWithIMDB() {

        signInWithIMDB.click();
    }

    public void signWithEmailAndPassword(String email,
                                         String password) {

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        passwordInput.submit();
    }
}
