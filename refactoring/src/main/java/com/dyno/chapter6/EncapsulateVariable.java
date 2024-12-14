package com.dyno.chapter6;

// 1. 변수로의 접근과 갱신을 전담하는 캡슐화 함수들을 만든다.
// 2. 정적 검사를 수행한다.
// 3. 변수를 직접 참조하던 부분을 모두 적절한 캡슐화 함수 호출로 바꾼다. 하나씩 바꿀 대마다 테스트한다.
// 4. 변수의 접근 범위를 제한한다.
// 5. 테스트한다.
// 6. 변수 값이 레코드라면 레코드 캡슐화하기를 적용할지 고려해본다.
// EncapsulateVariable: 변수 캡슐화하기 예제
public class EncapsulateVariable {

  // Before:
  // `discountRate`가 외부에서 직접 접근 가능하여 캡슐화되지 않은 상태입니다.
  public double discountRate = 0.1;

  // After:
  // 1. 변수로의 접근과 갱신을 전담하는 캡슐화 함수들을 만든다.
//  private double discountRate = 0.1;

  public double getDiscountRate() {
    return discountRate; // 접근 전담
  }

  public void setDiscountRate(double discountRate) {
    if (discountRate < 0 || discountRate > 1) {
      throw new IllegalArgumentException("할인율은 0에서 1 사이여야 합니다.");
    }
    this.discountRate = discountRate; // 갱신 전담
  }

  // 2. 정적 검사를 수행한다.
  // - 캡슐화 함수 작성 후 컴파일 에러 확인.

  // 3. 변수를 직접 참조하던 부분을 모두 적절한 캡슐화 함수 호출로 바꾼다.
  public double calculateDiscountedPrice(double basePrice) {
    // 기존에 직접 접근했던 부분을 캡슐화 함수 호출로 변경
    return basePrice * (1 - getDiscountRate());
  }

  // 4. 변수의 접근 범위를 제한한다.
  // - `discountRate`의 접근 범위를 `private`으로 제한했습니다.

  // 5. 테스트한다.
  // - 기존 로직이 캡슐화된 상태에서도 정상적으로 작동하는지 확인.

  // 6. 변수 값이 레코드라면 레코드 캡슐화하기를 적용할지 고려해본다.
  // - 이 경우 변수는 단순 값이므로 레코드 캡슐화는 필요하지 않음.
}