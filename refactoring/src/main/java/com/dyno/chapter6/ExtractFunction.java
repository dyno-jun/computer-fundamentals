package com.dyno.chapter6;

// 1. 함수를 새로 만들고 목적을 잘드러내는 이름을 붙인다. (어떻게 가아닌 무엇을 하는지 의도가 드러나야한다.
// 2. 추출할 코드를 원본 함수에서 복사하여 새 함수에 붙여넣는다.
// 3. 추출한 코드 중 원본 함수의 지역 변수를 참조하거나 추출한 함수의 유효범위를 벗어나는 변수는 없는지 검사한다. 있다면 매개변수로 전달한다.
// 4. 변수를 다 처리했다면 컴파일한다.
// 5. 원본 함수에서 추출한 코드 부분을 새로 만든 함수 호출하는 문장으로 바꾼다.
// 6. 테스트 한다.
// 7. 다른 코드에 비슷한 코드를 변경할지 검토한다.
public class ExtractFunction {

  public void test() {
    Order order = new Order("고객명", 10000);
    order.printOrderDetails();
  }
}

// 요구사항
// 주문 객체는 현재 고객 이름과 총금액을 나타낸다.

class Order {
  private final String customerName;
  private final double totalAmount;

  public Order(String customerName, double totalAmount) {
    this.customerName = customerName;
    this.totalAmount = totalAmount;
  }

  // Before:
  // printOrderDetails 메서드가 모든 작업을 처리하고 있어 복잡함.
  public void printOrderDetails() {
    System.out.println("***** 고객 주문 내역 *****"); // 헤더 출력
    System.out.println("고객 이름: " + customerName); // 고객 이름 출력
    System.out.println("총 금액: " + totalAmount); // 총 금액 출력
  }
//
//  // After:
//  // 절차:
//  // 1. 헤더 출력 부분을 함수로 추출합니다.
//  // 2. 세부 사항 출력 부분도 함수로 추출합니다.
//  public void printOrderDetails() {
//    printHeader();
//    printDetails();
//  }
//
//  private void printHeader() {
//    System.out.println("***** 고객 주문 내역 *****");
//  }
//
//  private void printDetails() {
//    System.out.println("고객 이름: " + customerName);
//    System.out.println("총 금액: " + totalAmount);
//  }
}
