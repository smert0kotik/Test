package org.example;

import org.junit.jupiter.api.BeforeAll;

public class BaseWithLoginTest extends BaseTest {
    @BeforeAll
    public static void setLogin() {
        BaseTest.login();
    }
}
