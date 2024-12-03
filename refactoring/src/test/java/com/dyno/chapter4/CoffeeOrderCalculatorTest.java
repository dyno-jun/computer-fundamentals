package com.dyno.chapter4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeOrderCalculatorTest {

  @Test
  public void testAmericanoHotNoCoupon() {
    CoffeeOrderCalculator order = new CoffeeOrderCalculator("Americano", "Hot", false);
    assertEquals(3000.0, order.calculatePrice(), 0.01);
  }

  @Test
  public void testLatteIceWithCoupon() {
    CoffeeOrderCalculator order = new CoffeeOrderCalculator("Latte", "Ice", true);
    assertEquals(4050.0, order.calculatePrice(), 0.01);
  }

  @Test
  public void testEspressoHotWithCoupon() {
    CoffeeOrderCalculator order = new CoffeeOrderCalculator("Espresso", "Hot", true);
    assertEquals(3150.0, order.calculatePrice(), 0.01);
  }

  @Test
  public void testLatteHotNoCoupon() {
    CoffeeOrderCalculator order = new CoffeeOrderCalculator("Latte", "Hot", false);
    assertEquals(4000.0, order.calculatePrice(), 0.01);
  }

  @Test
  public void testAmericanoIceNoCoupon() {
    CoffeeOrderCalculator order = new CoffeeOrderCalculator("Americano", "Ice", false);
    assertEquals(3500.0, order.calculatePrice(), 0.01);
  }

  @Test
  public void testInvalidMenu() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new CoffeeOrderCalculator("Mocha", "Hot", false).calculatePrice();
    });
    assertEquals("Unknown menu item", exception.getMessage());
  }

  @Test
  public void testInvalidTemperature() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new CoffeeOrderCalculator("Americano", "Warm", false).calculatePrice();
    });
    assertEquals("Unknown temperature option", exception.getMessage());
  }
}
