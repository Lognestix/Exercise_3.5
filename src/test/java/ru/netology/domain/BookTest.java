package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test   //Unit-тест логики класса Book
    public void shouldBookMatches() {
        Book book = new Book(3, "Лабиринт отражений", 3_400, "Сергей Лукьяненко");

        boolean actualSuperValue = book.matches("Лабиринт отражений");
        assertTrue(actualSuperValue, "Существующее значение в родителе");

        boolean actualValue = book.matches("Лукьяненко");
        assertTrue(actualValue, "Существующее значение");

        boolean actualNolValue = book.matches("Юпитер");
        assertFalse(actualNolValue, "Не существующее значение");
    }
}