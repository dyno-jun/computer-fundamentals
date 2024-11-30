package com.dyno.chapter1.before;

public class BankTransfer {
  private String sender;
  private String receiver;
  private double amount;

  public BankTransfer(String sender, String receiver, double amount) {
    this.sender = sender;
    this.receiver = receiver;
    this.amount = amount;
  }

  public String processTransfer() {
    double fee = 0;
    if (amount > 10000) {
      fee = amount * 0.02;
    } else if (amount > 5000) {
      fee = amount * 0.01;
    }
    double totalAmount = amount + fee;

    return "Transferring " + totalAmount + " from " + sender + " to " + receiver;
  }
}