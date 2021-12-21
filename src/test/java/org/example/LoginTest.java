package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    @BeforeEach
    @Override
    void initMainPage() {
        Assertions.assertDoesNotThrow( () -> webDriver.navigate().to("https://github.com/login"),
                "Страница недоступна");
    }

    @Test
    void loginTest() {
        BaseTest.login();
        Assertions.assertNotEquals("https://github.com/login", webDriver.getCurrentUrl());
    }
}