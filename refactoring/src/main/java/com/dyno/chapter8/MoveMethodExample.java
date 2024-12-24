package com.dyno.chapter8;

public class MoveMethodExample {

  class Customer {
    private final Address address;

    public Customer(Address address) {
      this.address = address;
    }

    public Address getAddress() {
      return address;
    }
  }

  class Address {
    private final String city;
    private final String state;

    public Address(String city, String state) {
      this.city = city;
      this.state = state;
    }

    public double calculateShippingCost() {
      return calculateDistance() * 1.5;
    }

    private double calculateDistance() {
      return 100.0; // Example distance calculation
    }
  }
}
