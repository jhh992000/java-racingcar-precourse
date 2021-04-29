# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---

## 기능 요구사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 프로그램 실행 결과
<img src="https://user-images.githubusercontent.com/67728580/116456887-baaa8000-a89d-11eb-9f11-3321daeb24a5.png" width="80%" alt="프로그램 실행 결과" />

## 프로그래밍 요구사항 - 1주차와 동일한 기준
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - [https://naver.github.io/hackday-conventions-java/](https://naver.github.io/hackday-conventions-java/)
* indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
* 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
* else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
* 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.

## 프로그래밍 요구사항 - 2주차 추가
* 일급콜렉션을 활용해 구현한다.
  * 참고문서: https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/
* 모든 원시값과 문자열을 포장한다.
  * 참고문서: https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4

## 프로그래밍 요구사항 - 단위 테스트
* 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in, Scanner) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
* JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를 통해 JUnit 학습하기.pdf" 문서를 참고해 사용법을 익힌 후 JUnit5 기반 단위 테스트를 구현한다.

## 미션 저장소 및 진행 요구사항
* 미션은 https://github.com/next-step/java-racingcar-precourse 저장소를 fork/clone해 시작한다.
* 기능을 구현하기 전에 java-racingcar-precourse/README.md 파일에 구현할 기능 목록을 정리해 추가 한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
* AngularJS Commit Message Conventions 참고해 commit log를 남긴다.
* 과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고한다.

## 2차 미션 마감 및 기준
* 2021년 5월 4일(화) 23시 59분까지 GitHub을 통한 미션 제출과 메일전송까지 완료해야 한다
* 2021년 5월 5일(수) 00시 이후 추가 push도 허용하지 않는다.
* 2021년 5월 5일(수) 00시 이후 제출한 경우 미션을 제출하지 않은 것으로 한다.

---

## 기능 목록
- 속도 (원시값과 문자열의 포장)
  - [x] 속성 : 속도번호
  - [x] 기능 : 랜덤한 속도번호를 생성한다. (0~9 사이의 랜덤값)
  - [x] 기능 : 전진 가능 여부를 반환한다.
  - [x] 기능 : 속도번호를 반환한다.
- 자동차속도 (일급 컬렉션)
  - [x] 속성 : 자동차 속도 리스트 (전진을 시도한)
  - [x] 기능 : 전진을 시도한 속도를 추가한다.
  - [x] 기능 : 총 전진한 횟수를 반환한다. (속도 4이상인것들 카운트)
  - [x] 기능 : 회차별 전진한 횟수를 반환한다. (속도 4이상인것들 카운트)
- 자동차 (VO)
  - [x] 생성시 필수 값 : 이름
  - [x] 속성 : 이름 (문자열, 5자 이하만 가능)
  - [x] 속성 : 자동차속도 (리스트)
  - [x] 기능 : 문자열이 5자 이하인지 확인한다.
  - [x] 기능 : 전진을 시도한다.
- 경주 (Service)
  - [ ] 생성시 필수 값 : 자동차 이름 목록, 반복횟수
  - [ ] 속성 : 자동차 리스트
  - [ ] 속성 : 반복횟수
  - [ ] 기능 : 경주를 시작한다. (입력횟수만큼 반복)
    - [ ] 반복하며 각 자동차의 전진하는 메서드 호출하고 결과를 출력한다.
  - [ ] 기능 : 최종 우승자를 선별하고 출력해준다. (우승자는 1명이상 가능)
  - [ ] 기능 : 숫자인지 여부를 확인한다.
  - [ ] 기능 : 양수인지 여부를 확인한다.
  - [ ] 기능 : 문자열을 특정구분자 기준으로 분리하여 리스트로 반환한다. (5자 이상이면 예외발생)
- 경주 (Controller)
  - [ ] 자동차 이름을 입력받는다. comma(,)를 기준으로 구분
  - [ ] 사용자에게 시도할 횟수를 입력받는다. (숫자만 입력가능, 양수)
  - [ ] 입력받은 값으로 경주 Service를 생성하고 경주를 시작한다.

## 구현시 참고사항
* 객체의 값을 그대로 가져다 쓰지말고 메세지를 보내어 원하는 값을 확인/식별하는 방식으로 구현
