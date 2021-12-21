package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(css = "input[id='login_field']")
    private WebElement loginInput;

    @FindBy(css = "input[id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login']//form//*[@type='submit']")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginIn() {
        loginBtn.click();
    }

    public LoginPage setLogin(String login) {
        loginInput.click();
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
        return this;
    }
}
