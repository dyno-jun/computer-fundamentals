package com.dyno.chapter6;

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
// RenameFunction: 함수 선언 바꾸기 예제
public class RenameFunction {

  // Before:
  // 함수 이름이 의도를 명확히 드러내지 못하고 있습니다.
  public double calculate(double hourlyRate, int hoursWorked) {
    return hourlyRate * hoursWorked;
  }

  // After:
  // 1. 매개변수를 제거하려거든 먼저 함수 본문에서 제거 대상 매개변수를 참조하는 곳이 없는지 확인한다.
  // - 이 예제에서는 매개변수 제거가 필요하지 않음.

  // 2. 메서드 선언을 원하는 형태로 바꾼다.
  public double calculateBaseSalary(double hourlyRate, int hoursWorked) {
    return hourlyRate * hoursWorked;
  }

  // 3. 기존 메서드 선언을 참조하는 부분을 모두 찾아서 바뀐 형태로 수정한다.
  // - `calculate` 호출을 `calculateBaseSalary` 호출로 변경.

  // 4. 테스트한다.
  // - 기존 테스트가 정상적으로 작동하는지 확인.

  // 마이그레이션:
  // 1. 이어지는 추출 단계를 수월하게 만들어야 한다면 함수의 본문을 적절히 리팩터링 한다.
  public double calculateWithBonus(double hourlyRate, int hoursWorked, double bonusRate) {
    double baseSalary = calculateBaseSalary(hourlyRate, hoursWorked); // 기존 함수 활용
    return baseSalary + (baseSalary * bonusRate); // 보너스 추가
  }

  // 2. 함수 본문을 새로운 함수로 추출한다.
  private double calculateBonus(double baseSalary, double bonusRate) {
    return baseSalary * bonusRate;
  }

  // 3. 추출한 함수에 매개변수를 추가해야 한다면 간단한 절차를 따라 추가한다.
  // - `baseSalary`와 `bonusRate`를 매개변수로 추가.

  // 4. 테스트한다.
  // - `calculateBonus`가 정상적으로 작동하는지 확인.

  // 5. 기존 함수를 인라인 한다.
  public double calculateTotalCompensation(double hourlyRate, int hoursWorked, double bonusRate) {
    double baseSalary = calculateBaseSalary(hourlyRate, hoursWorked); // 기존 함수 활용
    return baseSalary + calculateBonus(baseSalary, bonusRate); // 인라인
  }

  // 6. 이름을 임시로 붙여뒀다면 함수 선언 바꾸기를 한 번 더 적용해서 원래 이름으로 되돌린다.
  // - 이름이 의도를 명확히 드러내는지 확인.
  // 7. 테스트한다.
  // - 최종 형태의 함수가 모든 요구사항을 충족하는지 확인.
}
