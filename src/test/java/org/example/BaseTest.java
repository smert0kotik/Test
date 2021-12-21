package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {
    public static WebDriver webDriver;

    @BeforeAll
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static void login() {
        webDriver.navigate().to("https://github.com/login");
        LoginPage page = new LoginPage(webDriver);

        page
            .setLogin("elvinrain13@gmail.com")
            .setPassword("elvinrain7895123")
            .loginIn();


        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("logged-in")));
    }

    @BeforeEach
    void initMainPage() {
        Assertions.assertNotEquals("https://github.com/login", webDriver.getCurrentUrl());
    }

    @AfterAll
    static void exit() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }
}
