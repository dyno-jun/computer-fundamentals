package com.dyno.hash;

import java.util.HashSet;
import java.util.Set;

public class Panggram {
  public static void main(String[] args) {
    String sentence = "";
    boolean result = new Panggram().checkIfPangram(sentence);
    System.out.println(result);
  }

  public boolean checkIfPangram(String sentence) {
    Set<String> hashMap = new HashSet<>();

    for (int i = 0; i < sentence.length(); i++) {
      char c = sentence.charAt(i);
      hashMap.add(Character.toString(c));
    }

    return hashMap.size() == 26;
  }
}
