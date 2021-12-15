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

public class CreateNoteTest {
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

        webDriver.navigate().to("https://github.com/login");
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
    }

    @BeforeEach
    void initMainPage() {
        Assertions.assertNotEquals("https://github.com/login", webDriver.getCurrentUrl());
    }

    @Test
    void createNote() throws InterruptedException {
        webDriver.navigate().to("https://github.com/users/smert0kotik/projects/23");
        Thread.sleep(2000);
        int elementsBefore = webDriver.findElements(By.xpath("//*[@id='column-cards-17242332']/*")).size();
        WebElement addNote = webDriver.findElement(By.xpath("//*[@id='column-17242332']/div[1]/div[1]/button"));
        WebElement addButton = webDriver.findElement(By.xpath("//*[@id='column-17242332']/div[1]/div[2]/form[1]/div/button[1]"));

        Actions actions = new Actions(webDriver);
        actions
                .click(addNote)
                .sendKeys(webDriver.findElement(By.xpath("//*[@id='column-17242332']/div[1]/div[2]/form[1]/text-expander/textarea")), "задача такая-то")
                .click(addButton)
                .build()
                .perform();


        Thread.sleep(2000);
        int elementsAfter = webDriver.findElements(By.xpath("//*[@id='column-cards-17242332']/*")).size();

        Assertions.assertEquals(elementsAfter, elementsBefore + 1);
    }


//    @Test
    void replaceNote() {
        webDriver.navigate().to("https://github.com/users/smert0kotik/projects/23");
        WebElement note = webDriver.findElement(By.xpath("//*[@id='card-74842285']"));
        WebElement toDoColumn = webDriver.findElement(By.xpath("//*[@id='column-cards-17242332']"));
        WebElement inProgressColumn = webDriver.findElement(By.xpath("//*[@id='column-17242333']"));

        note.click();
        note = webDriver.findElement(By.xpath("//*[@id='card-74842285']"));
        Actions actions2 = new Actions(webDriver);
        actions2
                .clickAndHold(note)
                .moveToElement(inProgressColumn)
                .release()
                .build()
                .perform();
    }

    @AfterAll
    static void exit() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }
}

