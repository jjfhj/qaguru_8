package com.github.jjfhj;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        // Изменен дефолтный браузер для обхода капчи, которая появляется в хроме
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
    }
}
