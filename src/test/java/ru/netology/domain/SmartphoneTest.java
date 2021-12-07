package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test   //Unit-тест логики класса Smartphone
    public void shouldSmartphoneMatches() {
        Smartphone smartphone = new Smartphone(5, "Galaxy A72", 33_500, "Samsung");

        boolean actualSuperValue = smartphone.matches("Galaxy A72");
        assertTrue(actualSuperValue, "Существующее значение в родителе");

        boolean actualValue = smartphone.matches("Samsung");
        assertTrue(actualValue, "Существующее значение");

        boolean actualNolValue = smartphone.matches("Юпитер");
        assertFalse(actualNolValue, "Не существующее значение");
    }
}