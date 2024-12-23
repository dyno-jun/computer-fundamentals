package com.dyno.chapter7;

class Person {
  private String name;
  private int age;

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String name) {
    this.name = name;
  }

  // Getter
  public int getAge() {
    return age;
  }

  // Setter
  public void setAge(int age) {
    this.age = age;
  }
}

// Usage
class EncapsulateRecordExample {
  public static void main(String[] args) {
    Person person = new Person();
    person.setName("John Doe");
    person.setAge(30);

    System.out.println("Name: " + person.getName());
    System.out.println("Age: " + person.getAge());
  }
}
