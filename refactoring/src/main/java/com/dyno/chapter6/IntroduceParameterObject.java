package com.dyno.chapter6;

// 1. 적당한 데이터 구조가 아직 마련되어 있지 않다면 새로 만든다.
// 2. 테스트 한다.
// 3. 함수 선언 바꾸기로 새 데이터 구조를 매개변수로 추가한다.
// 4. 테스트한다.
// 5. 함수 호출 시 새로운 데이터 구조 인스턴스를 넘기도록 수정한다. 하나씩 수정할 때마다 테스트한다.
// 6. 기존 매개변수를 사용하던 코드를 새 데이터 구조의 원소로 사용하도록 바꾼다.
// 7. 다 바꿨다면 기존 매개변수를 제거하고 테스트한다.
// IntroduceParameterObject: 매개변수 객체 도입하기 예제
public class IntroduceParameterObject {

  // Before:
  // 함수가 여러 개별 매개변수를 받아 처리하고 있어 가독성과 유지보수성이 떨어집니다.
  public double calculateDistance(double startX, double startY, double endX, double endY) {
    return Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
  }

  // After:
  // 1. 적당한 데이터 구조가 아직 마련되어 있지 않다면 새로 만든다.
  // - `Point` 클래스 추가 (start와 end를 포괄하는 데이터 구조).

  public static class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  public static class LineSegment {
    public Point start;
    public Point end;

    public LineSegment(Point start, Point end) {
      this.start = start;
      this.end = end;
    }
  }

  // 2. 테스트 한다.
  // - Point와 LineSegment를 올바르게 생성하는지 테스트.

  // 3. 함수 선언 바꾸기로 새 데이터 구조를 매개변수로 추가한다.
  public double calculateDistance(LineSegment segment) {
    // 6. 기존 매개변수를 사용하던 코드를 새 데이터 구조의 원소로 사용하도록 바꾼다.
    return Math.sqrt(Math.pow(segment.end.x - segment.start.x, 2) + Math.pow(segment.end.y - segment.start.y, 2));
  }

  // 7. 다 바꿨다면 기존 매개변수를 제거하고 테스트한다.
}
