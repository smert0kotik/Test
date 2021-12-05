package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class App2 {
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://github.com/login");
        WebElement loginInput = driver.findElement(By.cssSelector("input[id='login_field']"));
        loginInput.click();
        loginInput.sendKeys("elvinrain13@gmail.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("input[id='password']"));
        passwordInput.click();
        passwordInput.sendKeys("elvinrain7895123");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id='login']//form//input[@type='submit']"));
        submitButton.click();

        driver.get("https://github.com/new/project");
        WebElement projectName = driver.findElement(By.cssSelector("input[id='project_name']"));
        projectName.click();
        projectName.sendKeys("test");

        WebElement selectTemplate = driver.findElement(By.xpath("//summary//span[@data-menu-button]"));
        selectTemplate.click();

        By menuItemLocator = By.xpath("//*[@id='project_template_BASIC_KANBAN']/..");
        new WebDriverWait(driver, Duration.ofSeconds(48)).until(ExpectedConditions.presenceOfElementLocated(menuItemLocator));

        WebElement menuItem = driver.findElement(menuItemLocator);
        menuItem.click();

        WebElement createButton = driver.findElement(By.xpath("//form[contains(@action, '/projects')]//button[@type='submit']"));
        createButton.click();

        driver.quit();
    }
}
