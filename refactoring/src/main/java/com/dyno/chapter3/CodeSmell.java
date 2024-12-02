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
  void processOrder() {
//    validateOrder();
//    calculateShipping();
//    applyDiscount();
//    sendConfirmationEmail();
  }

  // 개선된 코드
  void processOrderRefactored() {
//    validateOrder();
//    calculateShipping();
//    applyDiscount();
//    sendConfirmationEmail();
  }

  // 3.4 긴 매개변수 목록 (Long Parameter List)
  // 함수의 매개변수가 너무 많아서 이해하기 어렵습니다.
  void createUser(String name, int age, String address, String email, String phone) {
  }

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

  void createUser(UserInfo userInfo) {
  }

  // 3.5 전역 데이터 (Global Data)
  // 전역 변수를 사용하면 데이터의 의도를 파악하기 어렵고, 부작용이 생기기 쉽습니다.
  public static int globalCounter = 0;

  // 개선된 코드
  public class Counter {
    private int value = 0;

    public void increment() {
      value++;
    }

    public int getValue() {
      return value;
    }
  }

  // 3.6 가변 데이터 (Mutable Data)
  // 데이터가 쉽게 변경될 수 있으면 추적이 어렵습니다.
  public String name;

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

  // 3.7 뒤엉킨 변경 (Divergent Change)
  // 하나의 클래스가 여러 가지 이유로 변경되는 경우입니다.
  public class Report {
    void generatePdf() {
      // PDF 생성 로직
    }

    void sendViaEmail() {
      // 이메일 발송 로직
    }
  }

  // 개선된 코드
  public class ReportGenerator {
    void generate() {
      // 리포트 생성 로직
    }
  }

  public class EmailSender {
    void sendReport(ReportGenerator report) {
      // 리포트를 이메일로 전송하는 로직
    }
  }

  // 3.8 산탄총 수술 (Shotgun Surgery)
  // 하나의 변경이 여러 클래스에 영향을 미치는 경우입니다.
  public class Employee {
    void promote() {
      // 여러 클래스에 걸쳐 수정 필요
    }
  }

  // 개선된 코드
  public class PromotionService {
    void promoteEmployee(Employee employee) {
      // 직원 승진 로직을 한곳으로 집중화
    }
  }

  // 3.9 기능 편애 (Feature Envy)
  // 한 클래스가 다른 클래스의 데이터에 지나치게 의존하는 경우입니다.
  public class Order {
    double calculateTotalPrice() {
      return getPrice() * getQuantity();
    }

    double getPrice() {
      return 100.0; // 예시 값
    }

    int getQuantity() {
      return 2; // 예시 값
    }
  }

  // 개선된 코드
  public class PriceCalculator {
    double calculate(Order order) {
      return order.getPrice() * order.getQuantity();
    }
  }

  // 3.10 데이터 뭉치 (Data Clumps)
  // 항상 함께 사용되는 데이터가 따로 존재하는 경우입니다.
  void printAddress(String street, String city, String postalCode) {
    System.out.println("Street: " + street);
    System.out.println("City: " + city);
    System.out.println("Postal Code: " + postalCode);
  }

  // 개선된 코드
  class Address {
    String street;
    String city;
    String postalCode;

    Address(String street, String city, String postalCode) {
      this.street = street;
      this.city = city;
      this.postalCode = postalCode;
    }
  }

  void printAddress(Address address) {
    System.out.println("Street: " + address.street);
    System.out.println("City: " + address.city);
    System.out.println("Postal Code: " + address.postalCode);
  }

  // 3.11 기본형 집착 (Primitive Obsession)
  // 기본 데이터 타입만을 고집하여 도메인 개념을 표현하지 못하는 경우입니다.
  class OrderPrimitive {
    String product;
    int quantity;
  }

  // 개선된 코드
  class Product {
    String name;

    Product(String name) {
      this.name = name;
    }
  }

  class Order {
    Product product;
    int quantity;

    Order(Product product, int quantity) {
      this.product = product;
      this.quantity = quantity;
    }
  }

  // 3.12 반복되는 switch문 (Repeated Switch Statements)
  // 같은 조건문이 반복될 때 발생합니다.
  String getEmployeeRole(String employeeType) {
    switch (employeeType) {
      case "Manager":
        return "Full Access";
      case "Staff":
        return "Limited Access";
      default:
        return "No Access";
    }
  }

  // 개선된 코드
  abstract class Employee {
    abstract String getRole();
  }

  class Manager extends Employee {
    @Override
    String getRole() {
      return "Full Access";
    }
  }

  class Staff extends Employee {
    @Override
    String getRole() {
      return "Limited Access";
    }
  }

  // 3.13 반복문 (Loops)
  // 반복문을 함수형 프로그래밍 패턴으로 바꾸는 것이 좋습니다.
  int totalQuantity(int[] quantities) {
    int total = 0;
    for (int quantity : quantities) {
      total += quantity;
    }
    return total;
  }

  // 개선된 코드
  int totalQuantityRefactored(int[] quantities) {
    return Arrays.stream(quantities).sum();
  }

  // 3.14 성의없는 요소 (Lazy Element)
  // 클래스나 메서드가 충분히 의미를 가지지 못하는 경우입니다.
  class LazyClass {
    // 의미 없는 빈 클래스
  }

  // 개선된 코드: 클래스 제거 혹은 클래스에 기능 추가

  // 3.15 추측성 일반화 (Speculative Generality)
  // 필요하지 않은 일반화가 이루어지는 경우입니다.
  abstract class Payment {
    abstract void makePayment();
  }

  // 개선된 코드: 필요할 때까지 간단한 구현만 유지
  class SimplePayment {
    void makePayment() {
      // 간단한 결제 처리 로직
    }
  }

  // 3.16 임시 필드 (Temporary Field)
  // 필드가 특정 상황에서만 값이 있는 경우입니다.
  class EmployeeWithTemporaryField {
    String name;
    String temporaryDepartment;
  }

  // 개선된 코드
  class EmployeeRefactored {
    String name;
    Optional<String> department;
  }

  // 3.17 메시지 체인 (Message Chains)
  // 여러 객체를 연속으로 호출하는 경우입니다.
  class Department {
    Manager getManager() {
      return new Manager();
    }
  }

  class Company {
    Department getDepartment() {
      return new Department();
    }
  }

  void printManagerName(Company company) {
    String managerName = company.getDepartment().getManager().getName();
    System.out.println(managerName);
  }

  // 개선된 코드
  class CompanyRefactored {
    Manager getCompanyManager() {
      return getDepartment().getManager();
    }
  }

  void printManagerNameRefactored(CompanyRefactored company) {
    String managerName = company.getCompanyManager().getName();
    System.out.println(managerName);
  }

  // 3.18 중개자 (Middle Man)
  // 불필요하게 다른 클래스의 기능을 감싸기만 하는 경우입니다.
  class MiddleMan {
    Employee employee;

    String getEmployeeName() {
      return employee.getName();
    }
  }

  // 개선된 코드: 중개자 제거
  Employee employee = new Employee();
  String employeeName = employee.getName();

  // 3.19 내부자 거래 (Insider Trading)
  // 두 클래스가 서로의 내부 정보를 지나치게 공유하는 경우입니다.
  class FriendClass {
    void update(Employee employee) {
      // 내부 정보에 접근하는 코드
    }
  }

  // 개선된 코드: 정보 은닉 강화
  class EmployeeEncapsulated {
    private String status;

    void updateStatus(String newStatus) {
      this.status = newStatus;
    }
  }

  // 3.20 거대한 클래스 (Large Class)
  // 너무 많은 책임을 가진 클래스입니다.
  class LargeClass {
    void manageEmployee() {}
    void generateReports() {}
    void processPayroll() {}
  }

  // 개선된 코드: 클래스를 분할하여 책임 분리
  class EmployeeManager {
    void manageEmployee() {}
  }

  class ReportGenerator {
    void generateReports() {}
  }

  class PayrollProcessor {
    void processPayroll() {}
  }

  // 3.21 서로 다른 인터페이스의 대안 클래스들 (Alternative Classes with Different Interfaces)
  // 비슷한 역할을 하는데 인터페이스가 다른 클래스들이 존재하는 경우입니다.
  interface PaymentProcessor {
    void processPayment();
  }

  class PayPalPayment implements PaymentProcessor {
    @Override
    public void processPayment() {}
  }

  class CreditCardPayment implements PaymentProcessor {
    @Override
    public void processPayment() {}
  }

  // 3.22 데이터 클래스 (Data Class)
  // 데이터만 저장하고 기능이 없는 클래스입니다.
  class DataClass {
    String name;
    int age;
  }

  // 개선된 코드: 데이터와 관련된 동작을 추가
  class Person {
    String name;
    int age;

    void introduce() {
      System.out.println("Hello, my name is " + name);
    }
  }

  // 3.23 상속 포기 (Refused Bequest)
  // 상속받은 클래스가 부모 클래스의 기능을 사용하지 않는 경우입니다.
  class UnusedInheritance extends BaseClass {
    @Override
    void unusedMethod() {}
  }

  // 개선된 코드: 상속 대신 컴포지션 사용
  class Component {
    void usefulMethod() {}
  }

  class CompositeClass {
    Component component = new Component();
  }

  // 3.24 주석 (Comments)
  // 코드를 보충 설명하는 주석이 많다면, 그만큼 코드가 읽기 어렵다는 신호일 수 있습니다.
  // This method increments the counter by one
  public void incrementCounter() {
    counter++;
  }

  // 개선된 코드
  public void increment() {
    counter++;
  }
}