package com.dyno.chapter6;

// 1. 변활할 레코드를 입력받아서 값을 그대로 반환하는 변환 함수를 만든다.
// 2. 묶을 함수 중 함수 하나를 골라서 본문 코드를 변환 함수로 옮기고, 처리 결과를 레코드에 새 필드로 기록한다. 그런 다음 클라이언트 코드가 이 필드를 사용하도록 수정한다.
// 3. 테스트한다.
// 4. 나머지 관련 함수도 위 과정에 따라 처리한다.
// CombineFunctionTransform: 여러 함수를 변환 함수로 묶기 예제
public class CombineFunctionTransform {

  // Before:
  // 여러 함수가 Employee 레코드의 데이터를 개별적으로 처리합니다.
  public double calculateBaseSalary(Employee employee) {
    return employee.getHourlyRate() * employee.getHoursWorked();
  }

  public double calculateBonus(Employee employee) {
    double baseSalary = calculateBaseSalary(employee);
    return (employee.getPerformanceRating() > 4) ? baseSalary * 0.2 : 0;
  }

  public double calculateTotalCompensation(Employee employee) {
    double baseSalary = calculateBaseSalary(employee);
    double bonus = calculateBonus(employee);
    return baseSalary + bonus;
  }

  // After:
  // 1. 변환할 레코드를 입력받아서 값을 그대로 반환하는 변환 함수를 만든다.
  public Employee transformEmployee(Employee employee) {
    // Employee 객체를 변환하면서 필요한 계산을 수행
    Employee transformedEmployee = new Employee(employee.getName(), employee.getHourlyRate(), employee.getHoursWorked(), employee.getPerformanceRating());
    transformedEmployee.setBaseSalary(calculateBaseSalary(employee)); // 기본 급여 계산
    transformedEmployee.setBonus(calculateBonus(transformedEmployee)); // 보너스 계산
    transformedEmployee.setTotalCompensation(transformedEmployee.getBaseSalary() + transformedEmployee.getBonus()); // 총 보상 계산
    return transformedEmployee;
  }

  // 2. 묶을 함수 중 하나를 골라 변환 함수로 옮기고, 처리 결과를 레코드에 새 필드로 기록한다.
  // - `calculateBaseSalary`와 `calculateBonus`를 `transformEmployee`로 이동.

  // 3. 테스트한다.
  // - 클라이언트 코드가 새 필드를 사용하도록 수정 후 테스트.

  // 클라이언트 코드 예제:
  public void printEmployeeCompensation(Employee employee) {
    Employee transformedEmployee = transformEmployee(employee); // 변환 함수 호출
    System.out.println("직원 이름: " + transformedEmployee.getName());
    System.out.println("기본 급여: " + transformedEmployee.getBaseSalary());
    System.out.println("보너스: " + transformedEmployee.getBonus());
    System.out.println("총 보상: " + transformedEmployee.getTotalCompensation());
  }
}

// Employee 클래스 정의 (레코드)
class Employee {
  private String name;
  private double hourlyRate;
  private int hoursWorked;
  private int performanceRating;

  private double baseSalary;
  private double bonus;
  private double totalCompensation;

  public Employee(String name, double hourlyRate, int hoursWorked, int performanceRating) {
    this.name = name;
    this.hourlyRate = hourlyRate;
    this.hoursWorked = hoursWorked;
    this.performanceRating = performanceRating;
  }

  public String getName() {
    return name;
  }

  public double getHourlyRate() {
    return hourlyRate;
  }

  public int getHoursWorked() {
    return hoursWorked;
  }

  public int getPerformanceRating() {
    return performanceRating;
  }

  public double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public double getBonus() {
    return bonus;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }

  public double getTotalCompensation() {
    return totalCompensation;
  }

  public void setTotalCompensation(double totalCompensation) {
    this.totalCompensation = totalCompensation;
  }
}

// 테스트 코드
class CombineFunctionTransformTest {
  public static void main(String[] args) {
    CombineFunctionTransform transformer = new CombineFunctionTransform();

    Employee employee = new Employee("John Doe", 50.0, 160, 5); // 이름, 시급, 근무 시간, 성과 평점
    transformer.printEmployeeCompensation(employee);
  }
}
