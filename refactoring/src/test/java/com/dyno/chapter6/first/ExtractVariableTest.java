package com.dyno.chapter6.first;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ExtractVariableTest {

  @Test
  public void testCanPerformTransaction_SufficientFunds() {
    ExtractVariable account = new ExtractVariable(100.0);
    assertTrue(account.canPerformTransaction(50.0));
  }

  @Test
  public void testCanPerformTransaction_InsufficientFunds() {
    ExtractVariable account = new ExtractVariable(100.0);
    assertFalse(account.canPerformTransaction(150.0));
  }

  @Test
  public void testCanPerformTransaction_InvalidAmount() {
    ExtractVariable account = new ExtractVariable(100.0);
    assertFalse(account.canPerformTransaction(-10.0));
  }

  @Test
  public void testPerformTransaction_Success() {
    ExtractVariable account = new ExtractVariable(100.0);
    account.performTransaction(50.0);
    assertEquals(50.0, account.getBalance());
  }

  @Test
  public void testPerformTransaction_InsufficientFunds() {
    ExtractVariable account = new ExtractVariable(100.0);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      account.performTransaction(150.0);
    });
    assertEquals("Invalid transaction: insufficient funds or negative amount.", exception.getMessage());
  }

  @Test
  public void testPerformTransaction_InvalidAmount() {
    ExtractVariable account = new ExtractVariable(100.0);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      account.performTransaction(-10.0);
    });
    assertEquals("Invalid transaction: insufficient funds or negative amount.", exception.getMessage());
  }
}
