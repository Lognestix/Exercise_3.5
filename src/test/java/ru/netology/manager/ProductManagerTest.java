package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    //Общие данные:
    private final ProductRepository repository = new ProductRepository();
    private final ProductManager productManager = new ProductManager(repository);

    private final Book zero = new Book(0, "Одиссея капитана Блада", 3_700, "Рафаэль Сабатини");
    private final Book first = new Book(1, "Час Быка", 3_200, "Иван Ефремов");
    private final Book second = new Book(2, "Изгой", 3_500, "Руслан Михайлов");
    private final Book third = new Book(3, "Лабиринт отражений", 3_400, "Сергей Лукьяненко");

    private final Smartphone fourth = new Smartphone(4, "Galaxy A12", 13_500, "Samsung");
    private final Smartphone fifth = new Smartphone(5, "Galaxy A72", 33_500, "Samsung");
    private final Smartphone sixth = new Smartphone(6, "Galaxy Z Flip 3 ", 95_500, "Samsung");
    private final Smartphone seventh = new Smartphone(7, "iPhone 13 Pro", 107_500, "Apple");

    @BeforeEach
    public void setUp() {
        productManager.addProduct(zero);
        productManager.addProduct(first);
        productManager.addProduct(second);
        productManager.addProduct(third);
        productManager.addProduct(fourth);
        productManager.addProduct(fifth);
        productManager.addProduct(sixth);
        productManager.addProduct(seventh);
    }

    @Test
    public void shouldSearchBySeveralValues() {
        Product[] actual = productManager.searchBy("Galaxy");
        Product[] expected = {fourth, fifth, sixth};
        assertArrayEquals(expected, actual, "Несколько найденных значений");
    }

    @Test
    public void shouldSearchByOneValueBook() {
        Product[] actual = productManager.searchBy("Ефремов");
        Product[] expected = {first};
        assertArrayEquals(expected, actual, "Одно найденное значение книги");
    }

    @Test
    public void shouldSearchByOneValueSmartphone() {
        Product[] actual = productManager.searchBy("Apple");
        Product[] expected = {seventh};
        assertArrayEquals(expected, actual, "Одно найденное значение смартфона");
    }

    @Test
    public void shouldSearchByNoValue() {
        Product[] actual = productManager.searchBy("Носки");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual, "Не найденное значение");
    }
}