package com.dyno.chapter7;

// Usage
public class HideDelegateExample {

  public static void main(String[] args) {
    Department dept = new Department("Alice");
    Person person = new Person(dept);

    System.out.println("Manager: " + person.getDepartmentManager());
  }

  public static class Department {
    private final String manager;

    public Department(String manager) {
      this.manager = manager;
    }

    public String getManager() {
      return manager;
    }
  }

  public static class Person {
    private final Department department;

    public Person(Department department) {
      this.department = department;
    }

    public String getDepartmentManager() {
      return department.getManager(); // Hides delegate
    }
  }
}
