package com.dyno.chapter8;

import java.util.Arrays;

public class ReplaceLoopWithPipelineExample {

  public double calculateTotal(Item[] items) {
    return Arrays.stream(items)
        .filter(item -> item.getPrice() > 20.0)
        .mapToDouble(Item::getPrice)
        .sum();
  }

  class Item {
    private final double price;

    public Item(double price) {
      this.price = price;
    }

    public double getPrice() {
      return price;
    }
  }
}
