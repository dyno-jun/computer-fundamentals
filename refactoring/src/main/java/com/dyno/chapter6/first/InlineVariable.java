package com.dyno.chapter6.first;

// 1. 대입문의 우변에서 부작용이 생기지는 않는지 확인한다.
// 2. 변수가 불변으로 선언되지 않았다면 불변으로 만든후 테스트한다.
// 3. 이변수를 가장 처음 사용하는 코드를 찾아서 대입문 우변의 코드로 바꾼다.
// 4. 테스트한다.
// 5. 변수를 사용하는 부분을 모두 교체할 때까지 이 과정을 반복한다.
// 6. 변수 선언문과 대입문을 지운다.
// 7. 테스트한다.
public class InlineVariable {
  public double calculateTotalPrice(double price, double taxRate) {
    double tax = price * taxRate; // 중간 변수 선언
    double totalPrice = price + tax; // 중간 변수 사용
    return totalPrice;
  }

  // AFTER
  //  public double calculateTotalPrice(double price, double taxRate) {
  //    // 중간 변수를 인라인 처리
  //    return price + (price * taxRate);
  //  }
}
