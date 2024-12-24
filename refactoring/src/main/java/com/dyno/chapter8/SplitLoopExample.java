package com.dyno.chapter8;

public class SplitLoopExample {

  public void processItems(Item[] items) {
    for (Item item : items) {
      System.out.println("Processing: " + item.getName());
    }

    double total = 0.0;
    for (Item item : items) {
      total += item.getPrice();
    }

    System.out.println("Total price: " + total);
  }

  class Item {
    private final String name;
    private final double price;

    public Item(String name, double price) {
      this.name = name;
      this.price = price;
    }

    public String getName() {
      return name;
    }

    public double getPrice() {
      return price;
    }
  }
}
