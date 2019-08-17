package com.lits.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverContext {

    private static WebDriver webDriver;

    public static WebDriver getDriver() {

        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver
                    .manage()
                    .timeouts()
                    .implicitlyWait(30, TimeUnit.SECONDS);
        }

        return webDriver;
    }

    public static void loadURL(String url) {
        getDriver().get(url);
    }

    public static void stop() {
        getDriver().quit();
    }
}
