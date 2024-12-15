package com.dyno.chapter6.first;

// 1. 폭넓게 쓰이는 변수라면 변수 캡슐화하기 를 고려한다.
// 2. 이름을 바꾼 변수를 참조하는 곳을 모두 찾아서, 하나씩 변경한다.
// 3. 테스트한다.
public class RenameVariable {
  public double calculateTotal(double p, double t) { // 변수 이름이 불명확함
    return p + (p * t);
  }

  // AFTER
  //  public double calculateTotal(double price, double taxRate) { // 변수 이름을 명확하게 변경
  //    return price + (price * taxRate);
  //  }
}
