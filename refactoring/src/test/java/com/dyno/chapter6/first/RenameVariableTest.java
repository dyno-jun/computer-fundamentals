package com.dyno.chapter6.first;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RenameVariableTest {

  @Test
  public void testCalculateTotal_WithTax() {
    RenameVariable calculator = new RenameVariable();
    double price = 100.0; // 상품 가격
    double taxRate = 0.1; // 10% 세율

    double expected = 110.0; // 총 가격
    double actual = calculator.calculateTotal(price, taxRate);

    assertEquals(expected, actual, 0.01);
  }

  @Test
  public void testCalculateTotal_NoTax() {
    RenameVariable calculator = new RenameVariable();
    double price = 100.0; // 상품 가격
    double taxRate = 0.0; // 세금 없음

    double expected = 100.0; // 총 가격
    double actual = calculator.calculateTotal(price, taxRate);

    assertEquals(expected, actual, 0.01);
  }

  @Test
  public void testCalculateTotal_HighTax() {
    RenameVariable calculator = new RenameVariable();
    double price = 100.0; // 상품 가격
    double taxRate = 0.25; // 25% 세율

    double expected = 125.0; // 총 가격
    double actual = calculator.calculateTotal(price, taxRate);

    assertEquals(expected, actual, 0.01);
  }
}
