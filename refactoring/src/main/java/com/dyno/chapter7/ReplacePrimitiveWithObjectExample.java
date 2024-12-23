package com.dyno.chapter7;

class Money {
  private final double amount;

  public Money(double amount) {
    this.amount = amount;
  }

  public Money add(Money other) {
    return new Money(this.amount + other.amount);
  }

  @Override
  public String toString() {
    return "$" + amount;
  }
}

// Usage
public class ReplacePrimitiveWithObjectExample {
  public static void main(String[] args) {
    Money price = new Money(50);
    Money tax = new Money(5);

    Money total = price.add(tax);
    System.out.println("Total: " + total);
  }
}
