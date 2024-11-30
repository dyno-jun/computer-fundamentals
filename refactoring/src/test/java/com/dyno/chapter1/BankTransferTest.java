package com.dyno.chapter1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BankTransferTest {

  @Test
  public void testTransferAmountLessThan5000() {
    BankTransfer transfer = new BankTransfer("Alice", "Bob", 3000);
    String result = transfer.processTransfer();
    assertEquals("Transferring 3000.0 from Alice to Bob", result);
  }

  @Test
  public void testTransferAmountBetween5000And10000() {
    BankTransfer transfer = new BankTransfer("Alice", "Bob", 6000);
    String result = transfer.processTransfer();
    assertEquals("Transferring 6060.0 from Alice to Bob", result);
  }

  @Test
  public void testTransferAmountGreaterThan10000() {
    BankTransfer transfer = new BankTransfer("Alice", "Bob", 15000);
    String result = transfer.processTransfer();
    assertEquals("Transferring 15300.0 from Alice to Bob", result);
  }

  @Test
  public void testZeroAmountTransfer() {
    BankTransfer transfer = new BankTransfer("Alice", "Bob", 0);
    String result = transfer.processTransfer();
    assertEquals("Transferring 0.0 from Alice to Bob", result);
  }

  @Test
  public void testNegativeAmountTransfer() {
    BankTransfer transfer = new BankTransfer("Alice", "Bob", -100);
    String result = transfer.processTransfer();
    assertEquals("Transferring -100.0 from Alice to Bob", result);
  }
}