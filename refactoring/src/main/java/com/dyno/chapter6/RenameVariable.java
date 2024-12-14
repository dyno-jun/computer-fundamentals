package com.dyno.chapter6;

// 1. 폭넓게 쓰이는 변수라면 변수 캡슐화하기 를 고려한다.
// 2. 이름을 바꾼 변수를 참조하는 곳을 모두 찾아서, 하나씩 변경한다.
// 3. 테스트한다.
// RenameVariable: 변수 이름 바꾸기 예제
public class RenameVariable {

  // Before:
  // `hp`라는 변수명이 의도를 명확히 드러내지 못하고 있습니다.
  private int hp;

  // After:
  // 1. 폭넓게 쓰이는 변수라면 변수 캡슐화하기를 고려한다.
  // - 캡슐화를 통해 변수 접근을 전담하는 메서드를 추가.
  private int healthPoints;

  public int getHealthPoints() {
    return healthPoints;
  }

  public void setHealthPoints(int healthPoints) {
    if (healthPoints < 0) {
      throw new IllegalArgumentException("Health points cannot be negative.");
    }
    this.healthPoints = healthPoints;
  }

  // 기존의 변수명을 사용하던 메서드
  public void takeDamage(int damage) {
    // 2. 이름을 바꾼 변수를 참조하는 곳을 모두 찾아서, 하나씩 변경한다.
    // - `hp`를 `healthPoints`로 변경.
    this.healthPoints -= damage;
    if (this.healthPoints < 0) {
      this.healthPoints = 0; // 생명력이 0 이하로 내려가지 않도록 처리
    }
  }

  public void heal(int amount) {
    this.healthPoints += amount;
  }

  // 3. 테스트한다.
  // - 변경된 변수 이름이 올바르게 동작하는지 테스트합니다.
}
