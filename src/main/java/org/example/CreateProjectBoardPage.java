package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.UUID;

public class CreateProjectBoardPage extends BasePage {

    @FindBy(css = "input[id='project_name']")
    private WebElement projectName;

    @FindBy(xpath = "//summary//span[@data-menu-button]")
    private WebElement selectTemplate;

    @FindBy(xpath = "//*[@id='project_template_BASIC_KANBAN']/..")
    private WebElement menuItem;

    @FindBy(xpath = "//form[contains(@action, '/projects')]//button[@type='submit']")
    private WebElement createButton;

    String newProjectNameString = "test-project" + UUID.randomUUID();

    public CreateProjectBoardPage(WebDriver driver) {
        super(driver);
    }

    public void createProjectBoard() {
        handleProjectNameClick();
        setNewProjectNameString();
        handleSelectTemplateClick();
        handleMenuItemOpen();
        handleCreateButtonClick();
    }

    public void handleProjectNameClick() {
        projectName.click();
    }

    public void setNewProjectNameString() {
        Actions actions = new Actions(driver);
        actions.sendKeys(projectName, newProjectNameString).build().perform();
    }

    public void handleSelectTemplateClick() {
        selectTemplate.click();
    }

    public void handleMenuItemOpen() {
        Actions actions = new Actions(driver);
        actions.moveToElement(menuItem);
        menuItem.click();
    }

    public void handleCreateButtonClick() {
        createButton.click();
    }
}
