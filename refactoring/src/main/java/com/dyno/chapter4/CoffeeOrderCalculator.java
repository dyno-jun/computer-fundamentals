package com.dyno.chapter4;

public class CoffeeOrderCalculator {
  private String menu;
  private String temperature;
  private boolean hasDiscountCoupon;

  public CoffeeOrderCalculator(String menu, String temperature, boolean hasDiscountCoupon) {
    this.menu = menu;
    this.temperature = temperature;
    this.hasDiscountCoupon = hasDiscountCoupon;
  }

  public double calculatePrice() {
    double price = 0;

    // 메뉴에 따른 기본 가격 설정
    switch (menu) {
      case "Americano":
        price = 3000;
        break;
      case "Latte":
        price = 4000;
        break;
      case "Espresso":
        price = 3500;
        break;
      default:
        throw new IllegalArgumentException("Unknown menu item");
    }

    // 온도에 따른 추가 가격 설정 (아이스는 500원 추가)
    if ("Ice".equalsIgnoreCase(temperature)) {
      price += 500;
    } else if (!"Hot".equalsIgnoreCase(temperature)) {
      throw new IllegalArgumentException("Unknown temperature option");
    }

    // 할인 쿠폰 적용
    if (hasDiscountCoupon) {
      price *= 0.9; // 10% 할인
    }

    return price;
  }
}
