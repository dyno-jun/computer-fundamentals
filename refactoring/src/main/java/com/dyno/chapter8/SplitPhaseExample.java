package com.dyno.chapter8;

public class SplitPhaseExample {

  class OrderProcessor {
    public void processOrder(MoveFieldExample.Order order) {
      var items = fetchOrderItems(order);
      var total = calculateTotal(items);
      generateInvoice(total);
    }

    private String[] fetchOrderItems(MoveFieldExample.Order order) {
      return new String[] {"item1", "item2"};
    }

    private double calculateTotal(String[] items) {
      return items.length * 10.0;
    }

    private void generateInvoice(double total) {
      System.out.println("Invoice total: " + total);
    }
  }
}
