package com.dyno.chapter6.second;

// 1. 다형 메서드인지 확인한다.
// 2. 인라인할 함수를 호출하는 곳을 모두 찾는다.
// 3. 각 호출문을 함수 본문으로 교체한다.
// 4. 하나씩 교체할 때마다 테스트한다.
// 5. 함수 정의를 삭제한다.

// InlineFunction: 함수 인라인하기 예제
public class InlineFunction {

  // Before:
  // `calculateTax` 메서드가 단순한 계산만 수행하며 복잡성이 낮아 굳이 분리할 필요가 없습니다.
  public double calculateTotalPrice(double basePrice) {
    double tax = calculateTax(basePrice); // 함수 호출
    return basePrice + tax;
  }

  private double calculateTax(double basePrice) {
    return basePrice * 0.1; // 세금 계산
  }

  // After:
  // 1. 다형 메서드인지 확인한다.
  // - `calculateTax`는 다형성이 필요하지 않은 단순 메서드입니다.

  // 2. 인라인할 함수를 호출하는 곳을 모두 찾는다.
  // - `calculateTotalPrice` 메서드에서 `calculateTax`가 호출됩니다.

  public double calculateTotalPriceInline(double basePrice) {
    // 3. 각 호출문을 함수 본문으로 교체한다.
    // - `calculateTax(basePrice)`를 `basePrice * 0.1`로 교체합니다.
    double tax = basePrice * 0.1; // 세금 계산 인라인 처리
    return basePrice + tax;
  }

  // 4. 하나씩 교체할 때마다 테스트한다.
  // - 기존 테스트가 통과하는지 확인합니다.

  // 5. 함수 정의를 삭제한다.
  // - `calculateTax` 메서드를 삭제합니다.
}
