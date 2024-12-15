package com.dyno.chapter6.first;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RenameFunctionTest {

  @Test
  public void testApplyDiscount() {
    RenameFunction renamer = new RenameFunction();
    double price = 100.0;
    double discountRate = 0.2; // 20% 할인

    double expected = 80.0; // 할인 후 가격
    double actual = renamer.applyDiscount(price, discountRate);

    assertEquals(expected, actual, 0.01);
  }

  @Test
  public void testApplyDiscount_NoDiscount() {
    RenameFunction renamer = new RenameFunction();
    double price = 100.0;
    double discountRate = 0.0; // 할인 없음

    double expected = 100.0; // 할인 후 가격
    double actual = renamer.applyDiscount(price, discountRate);

    assertEquals(expected, actual, 0.01);
  }

  @Test
  public void testApplyDiscount_FullDiscount() {
    RenameFunction renamer = new RenameFunction();
    double price = 100.0;
    double discountRate = 1.0; // 100% 할인

    double expected = 0.0; // 할인 후 가격
    double actual = renamer.applyDiscount(price, discountRate);

    assertEquals(expected, actual, 0.01);
  }

  @Test
  public void testLegacyCalculateDiscount() {
    RenameFunction renamer = new RenameFunction();
    double price = 100.0;
    double discountRate = 0.2; // 20% 할인

    double expected = 80.0; // 할인 후 가격
    double actual = renamer.calculateDiscount(price, discountRate);

    assertEquals(expected, actual, 0.01);
  }
}
