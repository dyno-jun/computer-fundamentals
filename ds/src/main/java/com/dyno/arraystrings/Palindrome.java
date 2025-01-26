package com.dyno.arraystrings;


class Palindrome {

  public static void main(String[] args) {
    boolean result = new Palindrome().isPalindrome("leeeel");
    System.out.println(result);
  }

  public boolean isPalindrome(String s) {
    StringBuilder builder = new StringBuilder();

    for (char ch : s.toCharArray()) {
      if (Character.isLetterOrDigit(ch)) {
        builder.append(Character.toLowerCase(ch));
      }
    }

    String filteredString = builder.toString();
    String reversedString = builder.reverse().toString();

    return filteredString.equals(reversedString);
  }
}
