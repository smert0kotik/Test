package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateProjectBoardTest extends BaseWithLoginTest {

    @Test
    void createProjectBoard() throws InterruptedException {
        webDriver.navigate().to("https://github.com/new/project");
        Thread.sleep(2000);
        CreateProjectBoardPage page = new CreateProjectBoardPage(webDriver);
        page.createProjectBoard();

        Assertions.assertTrue(webDriver.getCurrentUrl().contains("https://github.com/users/smert0kotik/projects/"));
    }
}
