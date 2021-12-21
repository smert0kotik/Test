package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CreateNoteTest extends BaseWithLoginTest {
    @Test
    void createNote() throws InterruptedException {
        webDriver.navigate().to("https://github.com/users/smert0kotik/projects/23");
        Thread.sleep(2000);
        int elementsBefore = webDriver.findElements(By.xpath("//*[@id='column-cards-17242332']/*")).size();

        CreateNotePage page = new CreateNotePage(webDriver);
        page.createNote();

        Thread.sleep(2000);
        int elementsAfter = webDriver.findElements(By.xpath("//*[@id='column-cards-17242332']/*")).size();

        Assertions.assertEquals(elementsAfter, elementsBefore + 1);
    }
}

