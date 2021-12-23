package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateProjectTest extends BaseWithLoginTest {

    @Test
    @Epic("Создание проекта")
    @Description("Переход к созданию проекта")
    void createProject() {
        CreateProjectPage page = new CreateProjectPage(webDriver);
        page.createProject();
        Assertions.assertEquals("https://github.com/new/project", webDriver.getCurrentUrl());
    }
}
