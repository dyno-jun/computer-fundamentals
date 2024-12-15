package com.dyno.chapter6.second;

// 1. 함수들이 공유하는 공통 데이터 레코드를 캡슐화 한다.
// 2. 공통 레코드를 사용하는 함수 각각을 새 클래스로 옮긴다.
// 3. 데이터를 조작하는 로직들은 함수로 추출해서 새 클래스로 옮긴다.
// CombineFunctions: 여러 함수를 클래스로 묶기 예제
public class CombineFunctions {

  // Before:
  // 여러 함수가 공통 데이터 레코드(EmployeeData)를 사용하고 있음.
  public double calculateBaseSalary(EmployeeData employeeData) {
    return employeeData.getHourlyRate() * employeeData.getHoursWorked();
  }

  public double calculateBonus(EmployeeData employeeData) {
    double baseSalary = calculateBaseSalary(employeeData);
    return (employeeData.getPerformanceRating() > 4) ? baseSalary * 0.2 : 0;
  }

  public double calculateTotalCompensation(EmployeeData employeeData) {
    double baseSalary = calculateBaseSalary(employeeData);
    double bonus = calculateBonus(employeeData);
    return baseSalary + bonus;
  }
}

// EmployeeData 클래스 정의 (공통 데이터 레코드)
class EmployeeData {
  private final String name;
  private final double hourlyRate;
  private final int hoursWorked;
  private final int performanceRating;

  public EmployeeData(String name, double hourlyRate, int hoursWorked, int performanceRating) {
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
}

// After:
// 1. 함수들이 공유하는 공통 데이터 레코드를 캡슐화 한다.
// 2. 공통 레코드를 사용하는 함수 각각을 새 클래스로 옮긴다.
// 3. 데이터를 조작하는 로직들은 함수로 추출해서 새 클래스로 옮긴다.
// class Employee {
//  private EmployeeData employeeData;
//
//  public Employee(EmployeeData employeeData) {
//    this.employeeData = employeeData;
//  }
//
//  public double calculateBaseSalary() {
//    return employeeData.getHourlyRate() * employeeData.getHoursWorked();
//  }
//
//  public double calculateBonus() {
//    double baseSalary = calculateBaseSalary();
//    return (employeeData.getPerformanceRating() > 4) ? baseSalary * 0.2 : 0;
//  }
//
//  public double calculateTotalCompensation() {
//    double baseSalary = calculateBaseSalary();
//    double bonus = calculateBonus();
//    return baseSalary + bonus;
//  }
// }
//
//// 클라이언트 코드
// public void printEmployeeDetails(EmployeeData employeeData) {
//  Employee employee = new Employee(employeeData);
//  System.out.println("기본 급여: " + employee.calculateBaseSalary());
//  System.out.println("보너스: " + employee.calculateBonus());
//  System.out.println("총 보상: " + employee.calculateTotalCompensation());
// }
// }
