package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    //Общие данные:
    private final Book book = new Book(3, "Лабиринт отражений", 3_400, "Сергей Лукьяненко");

    //Unit-тесты логики класса Book
    @Test
    public void shouldBookMatchesSuperValue() {
        boolean actual = book.matches("Лабиринт отражений");
        assertTrue(actual, "Существующее значение в родителе");
    }

    @Test
    public void shouldBookMatchesValue() {
        boolean actual = book.matches("Лукьяненко");
        assertTrue(actual, "Существующее значение");
    }

    @Test
    public void shouldBookMatchesValueNolValue() {
        boolean actual = book.matches("Юпитер");
        assertFalse(actual, "Не существующее значение");
    }
}