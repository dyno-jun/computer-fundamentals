package com.dyno.chapter7;

// Usage
public class ExtractClassExample {

  public static void main(String[] args) {
    Address address = new Address();
    address.setCity("Seoul");
    address.setStreet("123 Main St");

    System.out.println("Address: " + address.getCity() + ", " + address.getStreet());
  }

  // Original Class
  static class Person {
    private String name;
    private String address; // Move to Address class

    // Getters and setters for name and address...

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }
  }

  // Extracted Class
  static class Address {
    private String city;
    private String street;

    // Getters and setters for city and street...

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getStreet() {
      return street;
    }

    public void setStreet(String street) {
      this.street = street;
    }
  }
}
