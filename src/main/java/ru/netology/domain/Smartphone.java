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