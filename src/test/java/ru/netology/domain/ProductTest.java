package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test   //Unit-тест логики класса Product
    public void shouldProductMatches() {
        Product product = new Product(2, "Изгой", 3_500);

        boolean actualValue = product.matches("Изгой");
        assertTrue(actualValue, "Существующее значение");

        boolean actualNolValue = product.matches("Юпитер");
        assertFalse(actualNolValue, "Не существующее значение");
    }
}