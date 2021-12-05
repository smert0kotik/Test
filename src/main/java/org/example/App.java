package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
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

        try {
            Thread.sleep(3000);
        }   catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}


