package com.dyno.chapter6.first;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InlineVariableTest {

  @Test
  public void testCalculateTotalPrice() {
    InlineVariable calculator = new InlineVariable();
    double price = 100.0;
    double taxRate = 0.1; // 10% 세율

    double expected = 110.0; // 예상 결과
    double actual = calculator.calculateTotalPrice(price, taxRate);

    assertEquals(expected, actual, 0.01); // 소수점 오차 허용
  }

  @Test
  public void testCalculateTotalPrice_ZeroTaxRate() {
    InlineVariable calculator = new InlineVariable();
    double price = 100.0;
    double taxRate = 0.0; // 0% 세율

    double expected = 100.0; // 예상 결과
    double actual = calculator.calculateTotalPrice(price, taxRate);

    assertEquals(expected, actual, 0.01);
  }

  @Test
  public void testCalculateTotalPrice_HighTaxRate() {
    InlineVariable calculator = new InlineVariable();
    double price = 100.0;
    double taxRate = 0.25; // 25% 세율

    double expected = 125.0; // 예상 결과
    double actual = calculator.calculateTotalPrice(price, taxRate);

    assertEquals(expected, actual, 0.01);
  }
}
