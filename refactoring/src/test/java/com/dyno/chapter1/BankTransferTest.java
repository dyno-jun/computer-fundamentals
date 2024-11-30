package com.dyno.chapter1;

import static org.junit.jupiter.api.Assertions.*;

import com.dyno.chapter1.before.BankTransfer;
import org.junit.jupiter.api.Test;


public class BankTransferTest {

  @Test
  public void testTransferAmountBelow5000() {
    BankTransfer bankTransfer = new BankTransfer("Alice", "Bob", 3000);
    String result = bankTransfer.processTransfer();
    assertEquals("Transferring 3000.0 from Alice to Bob", result);
  }

  @Test
  public void testTransferAmountBetween5000And10000() {
    BankTransfer bankTransfer = new BankTransfer("Charlie", "Dave", 6000);
    String result = bankTransfer.processTransfer();
    double expectedTotal = 6000 + (6000 * 0.01);
    assertEquals("Transferring " + expectedTotal + " from Charlie to Dave", result);
  }

  @Test
  public void testTransferAmountAbove10000() {
    BankTransfer bankTransfer = new BankTransfer("Eve", "Frank", 15000);
    String result = bankTransfer.processTransfer();
    double expectedTotal = 15000 + (15000 * 0.02);
    assertEquals("Transferring " + expectedTotal + " from Eve to Frank", result);
  }

  @Test
  public void testTransferAmountExactly5000() {
    BankTransfer bankTransfer = new BankTransfer("George", "Hank", 5000);
    String result = bankTransfer.processTransfer();
    assertEquals("Transferring 5000.0 from George to Hank", result);
  }

  @Test
  public void testTransferAmountExactly10000() {
    BankTransfer bankTransfer = new BankTransfer("Ivy", "Jack", 10000);
    String result = bankTransfer.processTransfer();
    double expectedTotal = 10000 + (10000 * 0.01);
    assertEquals("Transferring " + expectedTotal + " from Ivy to Jack", result);
  }
}
