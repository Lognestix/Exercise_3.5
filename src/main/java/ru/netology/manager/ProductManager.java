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