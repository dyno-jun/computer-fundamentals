package com.dyno.chapter8;

public class MoveStatementsIntoFunctionExample {

  class Invoice {
    public void generate() {
      System.out.println("Start invoice generation");
      performCalculation();
      System.out.println("End invoice generation");
    }

    private void performCalculation() {
      calculateTotal();
    }

    private void calculateTotal() {
      System.out.println("Calculating total");
    }
  }
}
