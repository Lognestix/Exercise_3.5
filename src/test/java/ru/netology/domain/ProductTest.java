package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    //Общие данные:
    private final Product product = new Product(2, "Изгой", 3_500);

    //Unit-тесты логики класса Product
    @Test
    public void shouldProductMatchesValue() {
        boolean actual = product.matches("Изгой");
        assertTrue(actual, "Существующее значение");
    }

    @Test
    public void shouldProductMatchesNolValue() {
        boolean actual = product.matches("Юпитер");
        assertFalse(actual, "Не существующее значение");
    }
}