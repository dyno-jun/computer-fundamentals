package com.dyno.chapter6.first;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EncapsulateVariableTest {

  @Test
  public void testGetBalance() {
    EncapsulateVariable account = new EncapsulateVariable(100.0);
    assertEquals(100.0, account.getBalance());
  }

  @Test
  public void testSetBalance() {
    EncapsulateVariable account = new EncapsulateVariable(100.0);
    account.setBalance(200.0);
    assertEquals(200.0, account.getBalance());
  }

  @Test
  public void testSetBalance_NegativeValue() {
    EncapsulateVariable account = new EncapsulateVariable(100.0);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      account.setBalance(-50.0);
    });
    assertEquals("Balance cannot be negative.", exception.getMessage());
  }

  @Test
  public void testDeposit() {
    EncapsulateVariable account = new EncapsulateVariable(100.0);
    account.deposit(50.0);
    assertEquals(150.0, account.getBalance());
  }

  @Test
  public void testDeposit_NegativeValue() {
    EncapsulateVariable account = new EncapsulateVariable(100.0);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      account.deposit(-10.0);
    });
    assertEquals("Deposit amount must be positive.", exception.getMessage());
  }

  @Test
  public void testWithdraw() {
    EncapsulateVariable account = new EncapsulateVariable(100.0);
    account.withdraw(50.0);
    assertEquals(50.0, account.getBalance());
  }

  @Test
  public void testWithdraw_InsufficientFunds() {
    EncapsulateVariable account = new EncapsulateVariable(100.0);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      account.withdraw(150.0);
    });
    assertEquals("Insufficient funds.", exception.getMessage());
  }

  @Test
  public void testWithdraw_NegativeValue() {
    EncapsulateVariable account = new EncapsulateVariable(100.0);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      account.withdraw(-10.0);
    });
    assertEquals("Withdraw amount must be positive.", exception.getMessage());
  }
}
