package com.dyno.chapter3;

public class CodeSmell {

  // 3.1 기이한 이름 (Mysterious Name)
  // 이름이 모호하거나 의도가 명확하지 않은 경우입니다.
  void doStuff() {
    // Doing mysterious stuff...
  }

  // 개선된 코드
  void calculateMonthlySalary() {
    // 월급을 계산하는 명확한 함수명
  }

  // 3.2 중복 코드 (Duplicated Code)
  // 여러 곳에서 동일한 코드가 반복될 때 발생합니다.
  class Sales {
    double calculateDiscount(double amount) {
      return amount * 0.1; // 중복 코드
    }
  }

  class Marketing {
    double calculateDiscount(double amount) {
      return amount * 0.1; // 중복 코드
    }
  }

  // 개선된 코드
  class DiscountCalculator {
    double calculateDiscount(double amount) {
      return amount * 0.1;
    }
  }

  // 3.3 긴 함수 (Long Function)
  // 함수가 너무 길어서 이해하기 어렵습니다.
  //  void processOrder() {
  //    validateOrder();
  //    calculateShipping();
  //    applyDiscount();
  //    sendConfirmationEmail();
  //  }
  //
  //  // 개선된 코드
  //  void processOrderRefactored() {
  //    validateOrder();
  //    calculateShipping();
  //    applyDiscount();
  //    sendConfirmationEmail();
  //  }

  // 3.4 긴 매개변수 목록 (Long Parameter List)
  // 함수의 매개변수가 너무 많아서 이해하기 어렵습니다.
  void createUser(String name, int age, String address, String email, String phone) {}

  // 개선된 코드
  class UserInfo {
    String name;
    int age;
    String address;
    String email;
    String phone;

    UserInfo(String name, int age, String address, String email, String phone) {
      this.name = name;
      this.age = age;
      this.address = address;
      this.email = email;
      this.phone = phone;
    }
  }

  void createUser(UserInfo userInfo) {}

  // 3.5 전역 데이터 (Global Data)
  // 전역 변수를 사용하면 데이터의 의도를 파악하기 어렵고, 부작용이 생기기 쉽습니다.
  public int globalCounter = 0;

  // 개선된 코드
  public class Counter {
    private int value = 0;

    public int getValue() {
      return value;
    }

    // 3.24 주석 (Comments)
    // 코드를 보충 설명하는 주석이 많다면, 그만큼 코드가 읽기 어렵다는 신호일 수 있습니다.
    // This method increments the counter by one
    public void incrementCounter() {
      value++;
    }

    // 개선된 코드
    public void increment() {
      value++;
    }
  }

  // 개선된 코드
  public class UserData {
    private final String name;

    public UserData(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }
}

