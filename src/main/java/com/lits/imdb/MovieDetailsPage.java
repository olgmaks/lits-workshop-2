package com.lits.imdb;

import com.lits.webdriver.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MovieDetailsPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='title_wrapper']/h1")
    private WebElement movieTitle;

    @FindBy(xpath = "//*[@class='cast_list']//tr")
    private List<WebElement> castList;

    public String getMovieTitle() {
        return movieTitle.getText().trim();
    }

    public int castListSize() {
        // -1 TO NOT INCLUDE HEADING ROW INTO COUNT
        return castList.size() - 1;
    }

    public void clickOnActorIcon(int actorIndex) {

        WebElement actorRow = castList.get(++actorIndex);

        actorRow
                .findElement(By.className("primary_photo"))
                .findElement(By.tagName("a")).click();
    }
}
