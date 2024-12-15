package com.dyno.chapter6.first;

// 1. 추출하려는 표현식에 부작용은 없는지 확인한다.
// 2. 불변 변수를 하나 선언하고 이름을 붙일 표현식의 복제본을 대입한다.
// 3. 원본표현식을 새로 만든 변수로 교체한다.
// 4. 테스트한다.
// 5. 표현식을 여러 곳에서 사용한다면 각각을 새로 만든 변수로 교체한다. 하나 교체할 때마다 테스트한다.
// 은행 계좌 예제로 작성해고 spring test 작성해줘
public class ExtractVariable {
  private double balance;

  public ExtractVariable(double balance) {
    this.balance = balance;
  }

  public boolean canPerformTransaction(double amount) {
    // 변수 추출 적용
    boolean hasSufficientFunds = balance >= amount;
    boolean isAmountPositive = amount > 0;
    return hasSufficientFunds && isAmountPositive;
  }

  public void performTransaction(double amount) {
    if (canPerformTransaction(amount)) {
      balance -= amount;
    } else {
      throw new IllegalArgumentException(
          "Invalid transaction: insufficient funds or negative amount.");
    }
  }

  public double getBalance() {
    return balance;
  }
}
