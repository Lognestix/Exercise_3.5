# Настройки добавленные в pom.xml для данного проекта
```xml
    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.2</version>
                <configuration>
                    <failIfNoTests>true</failIfNoTests>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.5</version>
                <executions>
                    <execution>
                        <id>agent-Smith</id>
                        <phase>initialize</phase>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>report-agent-Smith</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.22</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>3.6.28</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```
# Код Java находящийся в этом репозитории
```Java
package ru.netology.domain;

import java.util.Objects;

public class Product {
  private int id;
  private String name;
  private int price;

  public Product() {
  }

  public Product(int id, String name, int price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public boolean matches(String search) {
    if (getName().contains(search)) { //Проверка на наличие поискового слова в данных названия
      return true;
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return id == product.id &&
        price == product.price &&
        Objects.equals(name, product.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price);
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
```
```Java
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
```
```Java
package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
  private String author;

  public Book() {
    super();
  }

  public Book(int id, String name, int price, String author) {
    super(id, name, price);
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public boolean matches(String search) {
    if (super.matches(search)) { //Вызов родительского метода
      return true;
    }
    if (getAuthor().contains(search)) { //Проверка на наличие поискового слова в данных об авторе
      return true;
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Book book = (Book) o;
    return Objects.equals(author, book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), author);
  }

  @Override
  public String toString() {
    return "Book{" +
        "author=" + author +
        '}';
  }
}
```
```Java
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
```
```Java
package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
  private String manufacturer;

  public Smartphone() {
    super();
  }

  public Smartphone(int id, String name, int price, String manufacturer) {
    super(id, name, price);
    this.manufacturer = manufacturer;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  @Override
  public boolean matches(String search) {
    //Вызов родительского метода
    //Проверка на наличие поискового слова в данных о производителе
    return super.matches(search) || getManufacturer().contains(search);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Smartphone shirt = (Smartphone) o;
    return Objects.equals(manufacturer, shirt.manufacturer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), manufacturer);
  }

  @Override
  public String toString() {
    return "Smartphone{" +
            "manufacturer=" + manufacturer +
            '}';
  }
}
```
```Java
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
```
```Java
package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
  //Добавление необходимыех полей, конструкторов и методов
  private ProductRepository repository;

  public ProductManager(ProductRepository repository) { this.repository = repository; }

  //Добавление продукта в репозиторий
  public void addProduct(Product item) { repository.save(item); }

  public Product[] searchBy(String text) {
    Product[] products = repository.findAll();
    Product[] result = new Product[0];
    for (Product product : products) {
      if (product.matches(text)) {
        int length = result.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(result, 0, tmp, 0, result.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        result = tmp;
      }
    }
    return result;
  }
}
```
```Java
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
```
```Java
package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
  private Product[] items = new Product[0];

  public void save(Product item) {
    int length = items.length + 1;
    Product[] tmp = new Product[length];
    System.arraycopy(items, 0, tmp, 0, items.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  public Product[] findAll() {
    return items;
  }

  public Product findById(int id) {
    for (Product item : items) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }

  public void removeById(int id) {
    int length = items.length - 1;
    Product[] tmp = new Product[length];
    int index = 0;
    for (Product item : items) {
      if (item.getId() != id) {
        tmp[index] = item;
        index++;
      }
    }
    items = tmp;
  }
}
```