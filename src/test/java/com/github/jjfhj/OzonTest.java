package com.github.jjfhj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OzonTest extends TestBase {

    @ValueSource(strings = {"Всё о Муми-троллях. Книга 1", "Всё о Муми-троллях. Книга 2"})
    @DisplayName("Результаты поиска")
    @Tag("Blocker")
    @Tag("High")
    @Tag("Web")
    @ParameterizedTest(name = "Отображение товара {0} в результатах поиска")
    void checkingBookInSearchResults(String searchQuery) {
        open("https://www.ozon.ru/");
        $("[name='text']").setValue("Все о Муми-троллях").submit();
        $(".a9x3").shouldHave(text(searchQuery));
    }

    @CsvSource({
            "Мягкая обложка, Обложка: Мягкая обложка",
            "Твердый переплет, Обложка: Твердый переплет"
    })
    @DisplayName("Теги фильтра 'Обложка'")
    @Tag("Minor")
    @Tag("Low")
    @Tag("Web")
    @ParameterizedTest(name = "Отображение тега {0}")
    void checkingDisplayOfCoverFilterTag(String filterСheckbox, String tagName) {
        open("https://www.ozon.ru/");
        $("[name='text']").setValue("Вторая жизнь Уве").submit();
        $$(".ui-D6").findBy(text(filterСheckbox)).click();
        $("[class='ui-l5 ui-l6']").shouldHave(text(tagName));
    }

    @EnumSource(ProfileMenu.class)
    @DisplayName("Пункты меню неавторизованного пользователя")
    @Tag("Blocker")
    @Tag("High")
    @Tag("Web")
    @ParameterizedTest(name = "Отображение пункта меню {0}")
    void checkingDisplayOfAnonymousMenuItem(ProfileMenu profileMenu) {
        open("https://www.ozon.ru/");
        $(".g5j6").shouldHave(text(profileMenu.getProfileMenu()));
    }
}
