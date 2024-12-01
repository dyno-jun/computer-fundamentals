package com.dyno.chapter2.before;

public class LoanCalculator {
  public double calculateMonthlyPayment(double principal, double annualInterestRate, int years) {
    double monthlyInterestRate = annualInterestRate / 12 / 100;
    int numberOfPayments = years * 12;
    return principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
  }
}
