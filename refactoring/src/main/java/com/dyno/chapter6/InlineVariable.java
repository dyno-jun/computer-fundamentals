package com.dyno.chapter6;

// 1. 대입문의 우변에서 부작용이 생기지는 않는지 확인한다.
// 2. 변수가 불변으로 선언되지 않았다면 불변으로 만든후 테스트한다.
// 3. 이변수르 ㄹ가장 처음 사용하는 코드를 찾아서 대입문 우변의 코드로 바꾼다.
// 4. 테스트한다.
// 5. 변수를 사용하는 부분을 모두 교체할 때까지 이 과정을 반복한다.
// 6. 변수 선언문과 대입문을 지운다.
// 7. 테스트한다.
// InlineVariable: 변수 인라인하기 예제
public class InlineVariable {

  // Before:
  // `discountedPrice` 변수는 단순히 한 번만 사용되므로 굳이 변수로 선언할 필요가 없습니다.
  public double calculateFinalPrice(double price, double discountRate) {
    double discountedPrice = price * (1 - discountRate); // 불필요한 변수
    return discountedPrice + calculateShippingCost();
  }

  private double calculateShippingCost() {
    return 50.0; // 고정 배송비
  }

  // After:
  // 1. 대입문의 우변에서 부작용이 생기지는 않는지 확인한다.
  // - `price * (1 - discountRate)`는 부작용이 없는 순수 표현식입니다.

  // 2. 변수가 불변으로 선언되지 않았다면 불변으로 만든 후 테스트한다.
  // - `discountedPrice`는 재할당되지 않으므로 불변으로 선언해도 문제가 없습니다.

  public double calculateFinalPriceInline(double price, double discountRate) {
    // 3. 변수를 가장 처음 사용하는 코드를 찾아 대입문 우변의 코드로 바꾼다.
    // - `discountedPrice` 변수를 사용하던 코드를 `price * (1 - discountRate)`로 직접 대체합니다.
    return (price * (1 - discountRate)) + calculateShippingCost();
  }

  // 4. 테스트한다.
  // - 기존과 동일하게 동작하는지 확인합니다.

  // 5. 변수를 사용하는 부분을 모두 교체할 때까지 이 과정을 반복한다.
  // - 이 예제에서는 변수를 한 곳에서만 사용하므로 추가 작업이 필요 없습니다.

  // 6. 변수 선언문과 대입문을 지운다.
  // - `discountedPrice` 선언문 제거 완료.

  // 7. 테스트한다.
  // - 기존 테스트가 통과하는지 확인합니다.
}
