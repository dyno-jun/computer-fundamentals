package com.dyno.chapter6.first;

// 1. 변수로의 접근과 갱신을 전담하는 캡슐화 함수들을 만든다.
// 2. 정적 검사를 수행한다.
// 3. 변수를 직접 참조하던 부분을 모두 적절한 캡슐화 함수 호출로 바꾼다. 하나씩 바꿀 대마다 테스트한다.
// 4. 변수의 접근 범위를 제한한다.
// 5. 테스트한다.
// 6. 변수 값이 레코드라면 레코드 캡슐화하기를 적용할지 고려해본다.
public class EncapsulateVariable {
  private double balance; // 변수 접근 제한

  public EncapsulateVariable(double balance) {
    this.balance = balance;
  }

  // Getter
  public double getBalance() {
    return balance;
  }

  // Setter
  public void setBalance(double balance) {
    if (balance < 0) {
      throw new IllegalArgumentException("Balance cannot be negative.");
    }
    this.balance = balance;
  }

  // 캡슐화된 메서드 추가 (비즈니스 로직)
  public void deposit(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Deposit amount must be positive.");
    }
    setBalance(getBalance() + amount);
  }

  public void withdraw(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Withdraw amount must be positive.");
    }
    if (amount > balance) {
      throw new IllegalArgumentException("Insufficient funds.");
    }
    setBalance(getBalance() - amount);
  }
}
