package com.dyno.chapter8;

/** */
public class MoveFieldExample {

  class Order {
    private final Customer customer;

    public Order(Customer customer) {
      this.customer = customer;
    }

    public Customer getCustomer() {
      return customer;
    }
  }

  class Customer {
    private final String name;
    private final String address;

    public Customer(String name, String address) {
      this.name = name;
      this.address = address;
    }

    public String getAddress() {
      return address;
    }
  }
}
