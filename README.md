# 컴퓨터 공학 개론

소프트웨어 개발의 핵심 개념을 정리하고 기초를 탄탄하게 유지하기 위한 레포지토리 입니다. 이 레포지토리는 자료구조, 알고리즘, 운영체제, 컴퓨터 구조, 데이터베이스, 소프트웨어 설계 원칙 등개발의 기초가 되는 다양한 주제를 다룹니다.

---

## 📚 목차

1. [소개](#소개)
2. [다루는 주제](#다루는-주제)
3. [프로젝트 구조](#프로젝트-구조)
4. [사용 방법](#사용-방법)
---

## 💡 소개

이 레포지토리는 컴퓨터 공학의 기본 개념을 정리하고 어떤 프로젝트가 되든 기본 개념을 탄탄하게 가져가기 위해 만들었습니다. 언어는 자바로 작성합니다.

---

## 📂 다루는 주제

- **자료구조 (Data Structures)**
    - 배열, 연결 리스트, 스택, 큐, 트리, 그래프, 해시 테이블
- **알고리즘 (Algorithms)**
    - 정렬, 탐색, 동적 프로그래밍, 그리디 알고리즘, 분할 정복
- **운영체제 (Operating Systems)**
    - 프로세스 관리, 스케줄링, 메모리 관리, 파일 시스템
- **데이터베이스 (Databases)**
    - SQL, NoSQL, 정규화, 인덱싱, 트랜잭션, ACID 특성
- **아키텍처 (Architecture)**
    - MVC, 마이크로서비스, 모놀리식 아키텍처, 클린 아키텍처
- **객체지향 프로그래밍 (Object-Oriented Programming, OOP)**
    - 캡슐화, 추상화, 상속, 다형성
    - SOLID 원칙
    - 설계 및 구현 모범 사례
- **디자인 패턴 (Design Patterns)**
    - 생성 패턴 (Singleton, Factory, Builder)
    - 구조 패턴 (Adapter, Decorator, Composite)
    - 행동 패턴 (Observer, Strategy, Command)
- **리팩토링 (Refactoring)**
    - 코드 냄새 (Code Smells)
    - 주요 리팩토링 기법 (메서드 추출, 임시 변수를 질의로 교체 등)
    - 도구 및 모범 사례

---

## 🏗️ 프로젝트 구조

```plaintext
computer-fundamentals/
│
├── ds/            # 자료구조 모듈
│   └── src/
│       ├── main/java/          # 구현 코드
│       └── test/java/          # 테스트 코드
│
├── algorithm/                  # 알고리즘 모듈
│   └── src/
│       ├── main/java/          # 구현 코드
│       └── test/java/          # 테스트 코드
│
├── os/           # 운영체제 모듈
│   └── src/
│       ├── main/java/          # 구현 코드
│       └── test/java/          # 테스트 코드
│
├── database/                   # 데이터베이스 모듈
│   └── src/
│       ├── main/java/          # 구현 코드
│       └── test/java/          # 테스트 코드
│
├── architecture/               # 아키텍처 모듈
│   └── src/
│       ├── main/java/          # 설계 패턴 및 아키텍처 코드
│       └── test/java/          # 테스트 코드
│
├── oop/                        # 객체지향 프로그래밍 모듈
│   └── src/
│       ├── main/java/          # OOP 개념 및 예제 코드
│       └── test/java/          # OOP 관련 테스트 코드
│
├── design-patterns/            # 디자인 패턴 모듈
│   └── src/
│       ├── main/java/          # 디자인 패턴 구현 코드
│       └── test/java/          # 테스트 코드
│
├── refactoring/                # 리팩토링 예제
│   └── src/
│       ├── main/java/          # 리팩토링된 코드 예제
│       └── test/java/          # 테스트 코드
│
├── README.md                   # 프로젝트 개요 및 사용법
└── settings.gradle.kts         # 모듈 등록
```
## 🛠️ 사용 방법
- 레포지토리 클론
레포지토리를 로컬로 복제합니다
```
git clone https://github.com/your-username/computer-fundamentals.git
cd computer-fundamentals
```
- Gradle 설치
Gradle이 설치되어 있는지 확인하세요. 설치가 필요하다면 Gradle 공식 사이트를 참고하세요.

- 프로젝트 빌드
다음 명령어로 프로젝트를 빌드합니다

```
./gradlew build
```
- 예제 실행
특정 모듈(예: oop)의 예제를 실행하려면 다음 명령어를 입력하세요

```
./gradlew :oop:run
```
- 테스트 실행
모든 모듈의 테스트를 실행하려면 다음 명령어를 사용하세요
```
./gradlew test
```
- 모듈 별 실행
특정 모듈만 빌드하거나 테스트하고 싶다면 : 뒤에 모듈 이름을 입력하세요.
```
./gradlew :data-structures:test
```
