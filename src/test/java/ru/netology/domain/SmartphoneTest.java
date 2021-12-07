package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    //Общие данные:
    private final Smartphone smartphone = new Smartphone(5, "Galaxy A72", 33_500, "Samsung");

    //Unit-тесты логики класса Smartphone
    @Test
    public void shouldSmartphoneMatchesSuperValue() {
        boolean actual = smartphone.matches("Galaxy A72");
        assertTrue(actual, "Существующее значение в родителе");
    }

    @Test
    public void shouldSmartphoneMatchesValue() {
        boolean actual = smartphone.matches("Samsung");
        assertTrue(actual, "Существующее значение");
    }

    @Test
    public void shouldSmartphoneMatchesNolValue() {
        boolean actual = smartphone.matches("Юпитер");
        assertFalse(actual, "Не существующее значение");
    }
}