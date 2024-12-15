package com.dyno.chapter6.second;

// 1. 함수를 새로 만들고 목적을 잘드러내는 이름을 붙인다. (어떻게 가아닌 무엇을 하는지 의도가 드러나야한다.
// 2. 추출할 코드를 원본 함수에서 복사하여 새 함수에 붙여넣는다.
// 3. 추출한 코드 중 원본 함수의 지역 변수를 참조하거나 추출한 함수의 유효범위를 벗어나는 변수는 없는지 검사한다. 있다면 매개변수로 전달한다.
// 4. 변수를 다 처리했다면 컴파일한다.
// 5. 원본 함수에서 추출한 코드 부분을 새로 만든 함수 호출하는 문장으로 바꾼다.
// 6. 테스트 한다.
// 7. 다른 코드에 비슷한 코드를 변경할지 검토한다.
public class ExtractFunction {

  // Before:
  // 복잡한 로직이 한 메서드에 모두 포함되어 있어 가독성이 떨어집니다.
  public void generateInvoice(EFOrder order) {
    double basePrice = order.getQuantity() * order.getItemPrice();
    double tax = basePrice * 0.1;
    double total = basePrice + tax;

    System.out.println("주문서");
    System.out.println("상품명: " + order.getItemName());
    System.out.println("수량: " + order.getQuantity());
    System.out.println("기본 가격: " + basePrice);
    System.out.println("세금: " + tax);
    System.out.println("총 금액: " + total);
  }

  // After:
  // 1. 함수를 새로 만들고 목적을 잘 드러내는 이름을 붙인다.
  //  public void generateInvoice(EFOrder order) {
  //    printInvoiceDetails(order); // 추출한 함수 호출
  //  }

  // 2. 추출할 코드를 원본 함수에서 복사하여 새 함수에 붙여넣는다.
  private void printInvoiceDetails(EFOrder order) {
    double basePrice = calculateBasePrice(order); // 가격 계산
    double tax = calculateTax(basePrice); // 세금 계산
    double total = basePrice + tax;

    System.out.println("주문서");
    System.out.println("상품명: " + order.getItemName());
    System.out.println("수량: " + order.getQuantity());
    System.out.println("기본 가격: " + basePrice);
    System.out.println("세금: " + tax);
    System.out.println("총 금액: " + total);
  }

  // 3. 추출한 코드 중 원본 함수의 지역 변수를 참조하거나 추출한 함수의 유효범위를 벗어나는 변수가 없는지 검사한다.
  // - `basePrice`와 `tax`는 새로 만든 함수에서 처리되므로 문제없습니다.
  // - `order`는 매개변수로 전달합니다.

  // 4. 변수를 다 처리했다면 컴파일한다.
  // - 컴파일 완료

  // 5. 원본 함수에서 추출한 코드 부분을 새로 만든 함수 호출하는 문장으로 바꾼다.
  // - `printInvoiceDetails(order)`로 대체 완료

  // 6. 테스트 한다.
  // - 코드를 실행해 기존과 동일하게 동작하는지 확인

  // 7. 다른 코드에 비슷한 코드를 변경할지 검토한다.
  // - 재사용 가능한 추가 함수들을 확인하고 더 개선할 수 있는지 검토합니다.

  private double calculateBasePrice(EFOrder order) {
    return order.getQuantity() * order.getItemPrice();
  }

  private double calculateTax(double basePrice) {
    return basePrice * 0.1;
  }
}

// Order 클래스 정의 (도우미 클래스)
class EFOrder {
  private final String itemName;
  private final int quantity;
  private final double itemPrice;

  public EFOrder(String itemName, int quantity, double itemPrice) {
    this.itemName = itemName;
    this.quantity = quantity;
    this.itemPrice = itemPrice;
  }

  public String getItemName() {
    return itemName;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getItemPrice() {
    return itemPrice;
  }
}
