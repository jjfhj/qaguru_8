package com.github.jjfhj;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class CatalogItems {

    public static Stream<Arguments> productCategories() {
        return Stream.of(
                Arguments.of("Умный дом и безопасность", List.of("Охранные системы Видеонаблюдение Умный дом")),
                Arguments.of("Моноблоки и системные блоки", List.of("Системные блоки Моноблоки"))
        );
    }
}
