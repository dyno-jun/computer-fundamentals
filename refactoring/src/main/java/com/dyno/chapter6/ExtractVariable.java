package com.dyno.chapter6;

// 1. 추출하려는 표현식에 부작용은 없는지 확인한다.
// 2. 불변 변수를 하나 선언하고 이름을 붙일 표현식의 복제본을 대입한다.
// 3. 원본표현식을 새로 만든 변수로 교체한다.
// 4. 테스트한다.
// 5. 표현식을 여러 곳에서 사용한다면 각각을 새로 만든 변수로 교체한다. 하나 교체할 때마다 테스트한다.
// ExtractVariable: 변수 추출하기 예제
public class ExtractVariable {

  public void printOrderDetails(ExtractOrder order) {
    // Before:
    // 복잡한 표현식이 한 줄에 포함되어 있어 이해하기 어렵습니다.
    double finalPrice = order.getQuantity() * order.getItemPrice() * (1 - order.getDiscount()) + order.getShippingCost();
    System.out.println("최종 가격: " + finalPrice);
  }

  // After:
  // 1. 추출하려는 표현식에 부작용은 없는지 확인한다.
  // - 표현식에서 사용되는 `getQuantity`, `getItemPrice`, `getDiscount`, `getShippingCost`는 모두 읽기 전용이고 부작용이 없습니다.
  public void printOrderDetailsRefactored(ExtractOrder order) {
    // 2. 불변 변수를 하나 선언하고 이름을 붙일 표현식의 복제본을 대입한다.
    double basePrice = order.getQuantity() * order.getItemPrice(); // 기본 가격 계산
    double discountedPrice = basePrice * (1 - order.getDiscount()); // 할인된 가격 계산
    double shippingCost = order.getShippingCost(); // 배송비

    // 3. 원본 표현식을 새로 만든 변수로 교체한다.
    double finalPrice = discountedPrice + shippingCost;

    // 4. 테스트한다.
    // - 코드를 실행해 기존과 동일하게 동작하는지 확인합니다.
    System.out.println("최종 가격: " + finalPrice);
  }

  // 5. 표현식을 여러 곳에서 사용한다면 각각을 새로 만든 변수로 교체한다.
  public void printOrderSummary(ExtractOrder order) {
    double basePrice = order.getQuantity() * order.getItemPrice(); // 기본 가격 계산
    double discountedPrice = basePrice * (1 - order.getDiscount()); // 할인된 가격 계산
    double shippingCost = order.getShippingCost(); // 배송비
    double finalPrice = discountedPrice + shippingCost;

    System.out.println("주문 요약:");
    System.out.println("기본 가격: " + basePrice);
    System.out.println("할인된 가격: " + discountedPrice);
    System.out.println("배송비: " + shippingCost);
    System.out.println("최종 가격: " + finalPrice);
  }
}

// Order 클래스 정의 (도우미 클래스)
class ExtractOrder {
  private int quantity;
  private double itemPrice;
  private double discount;
  private double shippingCost;

  public ExtractOrder(int quantity, double itemPrice, double discount, double shippingCost) {
    this.quantity = quantity;
    this.itemPrice = itemPrice;
    this.discount = discount;
    this.shippingCost = shippingCost;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getItemPrice() {
    return itemPrice;
  }

  public double getDiscount() {
    return discount;
  }

  public double getShippingCost() {
    return shippingCost;
  }
}
