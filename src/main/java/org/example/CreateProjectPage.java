package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CreateProjectPage extends BasePage {

    @FindBy(xpath = "//body/div[1]/header/div[6]/details/summary")
    private WebElement createMenu;

    @FindBy(xpath = "//body/div[1]/header/div[6]/details/details-menu/a[5]")
    private WebElement newProject;

    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    public void createProject() {
        handleCreateMenuOpen();
        handleNewProjectClick();
    }

    public void handleCreateMenuOpen() {
        createMenu.click();
    }

    public void handleNewProjectClick() {
        Actions actions = new Actions(driver);
        actions.moveToElement(newProject);
        newProject.click();
    }
}
