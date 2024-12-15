package com.dyno.chapter6.first;

// 간단한 절차
// 1.매개변수를 제거하려거든 먼저 함수 본문에서 제거 대상 매개변수를 참조하는 곳이 없는지 확인한다.
// 2. 메서드 선언을 원하는 형태로 바꾼다.
// 3. 기존 메서드 선언을 참조하는 부분을 모두 찾아서 바뀐 형태로 수정한다.
// 4. 테스트한다.

// 마이그레이션
// 1.  이어지는 추출 단계를 수월하게 만들어야 한다면 함수의 본문을 적절히 리팩터링 한다.
// 2. 함수 본문을 새로운 함수로 추출한다.
// 3. 추출한 함수에 매개변수를 추가해야 한다면 간단한 절차를 따라 추가한다.
// 4. 테스트한다.
// 5. 기존 함수를 인라인 한다.
// 6. 이름을 임시로 붙여뒀다면 함수 선언 바꾸기를 한 번 더 적용해서 원래 이름으로 되돌린다.
// 7. 테스트한다.
public class RenameFunction {
  public double calculateDiscount(double price, double discountRate) {
    return applyDiscount(price, discountRate); // 새로운 함수 호출
  }

  // AFTER
  //  // 함수명을 더 명확하게 변경
  public double applyDiscount(double price, double discountRate) {
    return price * (1 - discountRate);
  }
}
