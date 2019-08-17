package com.lits.tests;

import com.lits.imdb.MovieDetailsPage;
import com.lits.imdb.SignInPage;
import com.lits.webdriver.WebDriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MultimediaContentTest {

    public static final String BASE_URL = "https://www.imdb.com/registration/signin";
    public static final String EMAIL = "tomasjefferson334@gmail.com";
    public static final String PASSWORD = "Amway123";
    public static final String MOVIE_URL = "https://www.imdb.com/title/tt0068646/";

    private SignInPage signInPage = new SignInPage();
    private MovieDetailsPage movieDetailsPage = new MovieDetailsPage();

    @Test
    public void testIMDB () {

        // NAVIGATE TO SIGN IN URL
        WebDriverContext.loadURL(BASE_URL);

        // SELECT SIGN IN METHOD
        signInPage.signInWithIMDB();

        // SIGN IN STEP
        signInPage
                .signWithEmailAndPassword(EMAIL, PASSWORD);

        // GO TO MOVIE URL
        WebDriverContext.loadURL(MOVIE_URL);

        // CHECK MOVIE TITLE AND MOVIE YEAR
        Assert.assertTrue(
                movieDetailsPage.getMovieTitle().contains("The Godfather"));
        Assert.assertTrue(
                movieDetailsPage.getMovieTitle().contains("1972"));

        // CHECK CAST LIST SIZE
        Assert.assertTrue(
                movieDetailsPage.castListSize() > 0, "Cast section is not displayed correctly, list is empty but should not be");

        movieDetailsPage.clickOnActorIcon(0);
    }

    @AfterMethod
    public void tearDown() {
//        WebDriverContext.stop();
    }
}
