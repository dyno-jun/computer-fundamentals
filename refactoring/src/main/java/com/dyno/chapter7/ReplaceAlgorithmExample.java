package com.dyno.chapter7;

import java.util.Collections;
import java.util.List;

// Usage
public class ReplaceAlgorithmExample {

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    ReplaceAlgorithm example = new ReplaceAlgorithm();

    System.out.println("Max: " + example.findMax(numbers));
  }

  public static class ReplaceAlgorithm {
    public int findMax(List<Integer> numbers) {
      return Collections.max(numbers); // Replaces custom logic
    }
  }
}
