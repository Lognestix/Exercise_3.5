package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
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
      if (matches(product, text) == true) {
        int length = result.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(result, 0, tmp, 0, result.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        result = tmp;
      }
    }
    if (result.length > 0) {
      Product[] tmp = new Product[result.length];
      for (int cycle = 0; cycle < result.length; cycle++) {
        int index = result.length - cycle - 1;
        tmp[cycle] = result[index];
      }
      result = tmp;
    } else {
      result = null;
    }
    return result;
  }

  public boolean matches(Product product, String search) {
    if (product instanceof Book) { //Если в параметре product лежит объект класса Book,
      Book book = (Book) product; //то он ложится в переменную типа Book чтобы пользоваться методами класса Book.
      if (book.getAuthor().contains(search)) { //Проверка на наличие поискового слова в данных об авторе
        return true;
      }
    }
    if (product instanceof Smartphone) { //Если в параметре product лежит объект класса Smartphone,
      Smartphone smartphone = (Smartphone) product; //то он ложится в переменную типа Smartphone чтобы пользоваться методами класса Smartphone.
      if (smartphone.getManufacturer().contains(search)) { //Проверка на наличие поискового слова в данных о производителе
        return true;
      }
    }
    return false;
  }
}
