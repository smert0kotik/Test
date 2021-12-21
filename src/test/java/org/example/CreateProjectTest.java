package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateProjectTest extends BaseWithLoginTest {

    @Test
    void createProject() {
        CreateProjectPage page = new CreateProjectPage(webDriver);
        page.createProject();
        Assertions.assertEquals("https://github.com/new/project", webDriver.getCurrentUrl());
    }
}
