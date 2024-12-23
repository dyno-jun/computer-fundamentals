package com.dyno.chapter7;

// Usage
public class RemoveMiddleManExample {
  public static void main(String[] args) {
    Department dept = new Department("Alice");
    Person person = new Person(dept);

    System.out.println("Manager: " + person.getDepartment().getManager());
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

    // Client directly calls the delegate now
    public Department getDepartment() {
      return department;
    }
  }
}
