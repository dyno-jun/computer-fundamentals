package com.dyno.chapter7;

class Order {
  private final double itemPrice;
  private final int quantity;

  public Order(double itemPrice, int quantity) {
    this.itemPrice = itemPrice;
    this.quantity = quantity;
  }

  public double getTotalPrice() {
    return getBasePrice() * 1.1; // Add 10% tax
  }

  private double getBasePrice() {
    return itemPrice * quantity;
  }
}

// Usage
public class ReplaceTempWithQueryExample {
  public static void main(String[] args) {
    Order order = new Order(100, 2);
    System.out.println("Total Price: " + order.getTotalPrice());
  }
}
