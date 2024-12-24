package com.dyno.chapter8;

public class MoveStatementsToCallerExample {

  public void generateReport() {
    System.out.println("Report Header");
    new Report().generateContent();
  }

  class Report {
    public void generateContent() {
      System.out.println("Report Content");
    }
  }
}
