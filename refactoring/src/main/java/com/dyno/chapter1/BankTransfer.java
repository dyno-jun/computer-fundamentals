package com.dyno.chapter1;

interface FeeCalculator {
  double calculateFee(double amount);
}

class HighAmountFeeCalculator implements FeeCalculator {
  @Override
  public double calculateFee(double amount) {
    return amount * 0.02;
  }
}

class MediumAmountFeeCalculator implements FeeCalculator {
  @Override
  public double calculateFee(double amount) {
    return amount * 0.01;
  }
}

class NoFeeCalculator implements FeeCalculator {
  @Override
  public double calculateFee(double amount) {
    return 0;
  }
}

class FeeCalculatorFactory {
  public static FeeCalculator getFeeCalculator(double amount) {
    if (amount > 10000) {
      return new HighAmountFeeCalculator();
    } else if (amount > 5000) {
      return new MediumAmountFeeCalculator();
    } else {
      return new NoFeeCalculator();
    }
  }
}

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
    return generateTransferMessage(calculateTotalAmount(calculateFee()));
  }

  private double calculateFee() {
    return FeeCalculatorFactory.getFeeCalculator(amount).calculateFee(amount);
  }

  private double calculateTotalAmount(double fee) {
    return amount + fee;
  }

  private String generateTransferMessage(double totalAmount) {
    return "Transferring " + totalAmount + " from " + sender + " to " + receiver;
  }
}




