package com.dyno.chapter6;


// 1. 두번째 단계에 해당하는 코드를 독립 함수로 추출한다.
// 2. 테스트한다.
// 3. 중간 데이터 구조를 만들어서 앞에서 추출한 함수의 인수로 추가한다.
// 4. 테스트한다.
// 5. 추출한 두번째 단계 함수의 매개변수를 하나씩 검토한다. 그중 첫번째 단계에서 사용되는 중간 데이터 구조로 옮긴다. 하나씩 옮길 때마다 테스트한다.
// 6. 첫번째 단계 코드를 함수로 추출하면서 중간 데이터 구조를 반환 하도록 만든다.
// 단계 쪼개기 (Split Phase) 예시
public class SplitPhase {

  // Before:
  // 모든 로직이 하나의 메서드에 포함되어 있어 복잡합니다.
  public void processOrder(Order order) {
    double basePrice = order.getQuantity() * order.getItemPrice(); // 기본 가격 계산
    double discount = (basePrice > 1000) ? basePrice * 0.1 : 0; // 할인 계산
    double finalPrice = basePrice - discount; // 최종 가격 계산
    System.out.println("총 금액: " + finalPrice); // 결과 출력
  }

  // After: 단계별로 쪼개면서 리팩터링 진행
  // 1. 두번째 단계에 해당하는 코드를 독립 함수로 추출한다.
  private double calculateDiscount(double basePrice) {
    return (basePrice > 1000) ? basePrice * 0.1 : 0;
  }

  public void processOrderStep1(Order order) {
    double basePrice = order.getQuantity() * order.getItemPrice();
    double discount = calculateDiscount(basePrice); // 독립 함수 호출
    double finalPrice = basePrice - discount;
    System.out.println("총 금액: " + finalPrice);
  }
  // 2. 테스트한다.
  // - 이 시점에서 프로세스가 기존과 동일하게 작동하는지 테스트합니다.

  // 3. 중간 데이터 구조를 만들어서 앞에서 추출한 함수의 인수로 추가한다.
  static class PricingData {
    double basePrice;
    double discount;

    public PricingData(double basePrice) {
      this.basePrice = basePrice;
    }
  }

  private double calculateDiscount(PricingData pricingData) {
    pricingData.discount = (pricingData.basePrice > 1000) ? pricingData.basePrice * 0.1 : 0;
    return pricingData.discount;
  }

  public void processOrderStep2(Order order) {
    double basePrice = order.getQuantity() * order.getItemPrice();
    PricingData pricingData = new PricingData(basePrice); // 중간 데이터 구조 생성
    calculateDiscount(pricingData);
    double finalPrice = pricingData.basePrice - pricingData.discount;
    System.out.println("총 금액: " + finalPrice);
  }
  // 4. 테스트한다.
  // - 중간 데이터 구조가 제대로 작동하는지 테스트합니다.

  // 5. 추출한 두번째 단계 함수의 매개변수를 하나씩 검토한다.
  //    그중 첫번째 단계에서 사용되는 중간 데이터 구조로 옮긴다.
  private PricingData calculateBasePrice(Order order) {
    double basePrice = order.getQuantity() * order.getItemPrice();
    return new PricingData(basePrice);
  }

  public void processOrderStep3(Order order) {
    PricingData pricingData = calculateBasePrice(order); // 중간 데이터 구조 반환
    calculateDiscount(pricingData);
    double finalPrice = pricingData.basePrice - pricingData.discount;
    System.out.println("총 금액: " + finalPrice);
  }
  // 6. 첫번째 단계 코드를 함수로 추출하면서 중간 데이터 구조를 반환 하도록 만든다.
  // - 최종 단계에서는 각 단계를 명확히 분리합니다.

  public void processOrderFinal(Order order) {
    PricingData pricingData = calculateBasePrice(order);
    calculateDiscount(pricingData);
    double finalPrice = calculateFinalPrice(pricingData);
    printFinalPrice(finalPrice);
  }

  private double calculateFinalPrice(PricingData pricingData) {
    return pricingData.basePrice - pricingData.discount;
  }

  private void printFinalPrice(double finalPrice) {
    System.out.println("총 금액: " + finalPrice);
  }
}

// Order 클래스 정의 (도우미 클래스)
class Order {
  private int quantity;
  private double itemPrice;

  public Order(int quantity, double itemPrice) {
    this.quantity = quantity;
    this.itemPrice = itemPrice;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getItemPrice() {
    return itemPrice;
  }
}
