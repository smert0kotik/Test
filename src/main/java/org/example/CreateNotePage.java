package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNotePage extends BasePage{

    @FindBy(xpath = "//*[@id='column-17242332']/div[1]/div[1]/button")
    private WebElement addNote;

    @FindBy(xpath = "//*[@id='column-17242332']/div[1]/div[2]/form[1]/text-expander/textarea")
    private WebElement noteContent;

    @FindBy(xpath = "//*[@id='column-17242332']/div[1]/div[2]/form[1]/div/button[1]")
    private WebElement addButton;

    public CreateNotePage(WebDriver driver) {
        super(driver);
    }

    public void createNote() {
        handleAddNoteClick();
        setNoteContent();
        handleAddButtonClick();
    }

    public void handleAddNoteClick() {
        addNote.click();
    }

    public void setNoteContent() {
        noteContent.sendKeys("задача такая-то");
    }

    public void handleAddButtonClick() {
        addButton.click();
    }
}
