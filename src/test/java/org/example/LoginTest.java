package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {

    static WebDriver webDriver;

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    void initMainPage() {
        Assertions.assertDoesNotThrow( () -> webDriver.navigate().to("https://github.com/login"),
                "Страница недоступна");
    }

    @Test
    void loginTest() {
        WebElement loginInput = webDriver.findElement(By.cssSelector("input[id='login_field']"));
        WebElement passwordInput = webDriver.findElement(By.cssSelector("input[id='password']"));
        WebElement loginBtn = webDriver.findElement(By.xpath("//*[@id='login']//form//*[@type='submit']"));

        Actions actions = new Actions(webDriver);
        actions
                .click(loginInput)
                .sendKeys(loginInput, "elvinrain13@gmail.com")
                .click(passwordInput)
                .sendKeys("elvinrain7895123")
                .click(loginBtn)
                .build()
                .perform();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("logged-in")));
        Assertions.assertNotEquals("https://github.com/login", webDriver.getCurrentUrl());
    }

    @AfterAll
    static void exit() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }
}