package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class CreateProjectBoardTest extends BaseWithLoginTest {

    @Test
    @Epic("Создание проекта")
    @Description("Заполнение полей проекта")
    void createProjectBoard() throws InterruptedException {
        webDriver.navigate().to("https://github.com/new/project");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        CreateProjectBoardPage page = new CreateProjectBoardPage(webDriver);
        page.createProjectBoard();

        Assertions.assertTrue(webDriver.getCurrentUrl().contains("https://github.com/users/smert0kotik/projects/"));
    }
}
