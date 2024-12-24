package com.dyno.chapter8;

public class ReplaceInlineCodeWithFunctionCallExample {

  class Discount {
    public double calculate(double price) {
      return applyDiscount(price);
    }

    private double applyDiscount(double price) {
      return price > 100 ? price * 0.9 : price;
    }
  }
}
