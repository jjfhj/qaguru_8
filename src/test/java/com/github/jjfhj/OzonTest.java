package com.github.jjfhj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OzonTest extends TestBase {

    @CsvSource({
            "Мягкая обложка, Обложка: Мягкая обложка",
            "Твердый переплет, Обложка: Твердый переплет"
    })
    @DisplayName("Отображение тега фильтра 'Обложка'")
    @Tag("Minor")
    @Tag("Low")
    @ParameterizedTest(name = "Отображение тега {0}")
    void checkingDisplayOfCoverFilterTag(String filterСheckbox, String tagName) {
        open("https://www.ozon.ru/");
        $("[name='text']").setValue("Вторая жизнь Уве").submit();
        $$(".ui-D6").findBy(text(filterСheckbox)).click();
        $("[class='ui-l5 ui-l6']").shouldHave(text(tagName));
    }
}
