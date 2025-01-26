package com.dyno.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class StackExample {
  public boolean isValid(String s) {
    Map<Character, Character> matching = new HashMap<>();
    matching.put('(', ')');
    matching.put('[', ']');
    matching.put('{', '}');

    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (matching.containsKey(c)) { // if c is an opening bracket
        stack.push(c);
      } else {
        if (stack.empty()) {
          return false;
        }

        char previousOpening = stack.pop();
        if (matching.get(previousOpening) != c) {
          return false;
        }
      }
    }

    return stack.empty();
  }
}
