# ✈️ 3주 차 프리코스 미션 - 로또

## `소개`

사용자가 입력한 정보(로또 구매 금액, 로또 당첨 번호)를 기반으로,  
구매 금액에 맞춰 1~45 범위의 숫자 6개로 구성된 로또를 구매하고  
당첨 번호와 비교해 담첨 여부와 최종 수익률을 안내하는 미니 복권 서비스입니다.

## `주요 기능`

1. ### 사용자에게 로또 구매 금액을 입력받는다
1. ### 입력받은 구매 금액으로 로또를 구매한다
1. ### 구매한 로또 정보(6개 숫자)를 저장한다
1. ### 사용자에게 담첨 로또 번호를 입력받는다
1. ### 사용자에게 보너스 로또 번호를 입력받는다
1. ### 입력받은 당첨 번호로 당첨 여부를 확인한다
1. ### 최종적인 당첨 수와 당첨금, 수익률을 출력한다

---

<details><summary><h1>📋 2주차 피드백</h1></summary>

2주 차 미션의 학습 목표는 함수 분리와 테스트 도구 사용법을 익히는 것이었습니다.  
...  
완벽한 코드보다 중요한 것은 문제를 해결하기 위해 나만의 방법을 찾아가는 과정입니다.  
...  
이번 소감문에는 여러분의 도전 과정을 담아주세요. 예를 들어
- 이번 미션에서 가장 오래 고민했던 부분과 시도들
- 실패했지만 의미 있었던 도전
- 다음에는 다르게 접근해보고 싶은 부분  
  ...
### 공통 피드백
- README.md를 상세히 작성한다 ✅❗
  - 기존처럼 기능 명세와 체크리스트뿐만 아니라  
    프로젝트에 대한 설명과 주요 기능을 더 상세하게 설명하고 소개하기
- 기능 목록을 재검토한다 ✅
  - 기능 목록 장성 시 설계/구현 같은 상세한 내용은 배제한다.
  - 클래스명, 시그니처, 반환값은 상변하기 때문.
  - 기능 목록을 중심으로 작성하되, 정상 - 예외 상황을 함께 정리한다.
  - 완벽하게 정리하려 하기보단, 기능을 구현하면서 지속적으로 업데이트한다. ✅
- 기능 목록을 업데이트한다 ✅
  - 기능 목록, 체크리스트는 상변한다.
  - 시작부터 모든 기능을 완벽히 정리한다는 부담보단  
    기능을 구현하며 문서를 지속적으로 업데이트하기
  - `죽은 문서`가 아닌 `살아있는 문서`로 유지하기
- 값을 하드 코딩하지 않는다 ✅
  - 문자열이나 숫자 값 하드코딩 지양.
  - 상수(static final) 정의하고 의미있는 이름 부여.
  - 의미있는 이름으로 해당 값의 역활을 명시.
- 구현 순서는 상수 멤버변수 생성자 메서드 ✅
- 변수 이름에 자료형 사용 지양 ❗
  - 저번 과제에서의 CarList 클래스 - 변수명. 주의하기
- 한 메서드가 한 기능(역할) 담당 ✅
- 메서드가 한 가지 기능을 하는지 확인하는 기준 수립 ✅
- 테스트 작성 이유에 대해 경험을 토대로 정리 ✅
- 테스트는 작은 단위부터 큰 단위로 ✅

방향성은 일치한다!  
더 잘 정리하고 더 확실한 기준을 세워내자.

</details>

---

# ✅ 체크리스트

### `피드백 반영`
- [ ] 가장 오래 고민했던 부분과 시도 정리
  - 아키텍처 구조.
- [ ] 실패했지만 의미있던 도전 정리
- [ ] 다음에 다르게 접근해보고 싶은 부분 정리
- [X] README.md 상세히 작성
- [X] 기능 목록 작성 시 설계와 구현 없이 작성
- [X] 기능 목록 및 예외 상황 함께 정리
- [X] 구현 과정에서 지속적으로 README 업데이트
- [X] 하드 코딩 지양
- [X] 구현 순서 준수 `상수 > 멤버 변수 > 생성자 > 메서드`
- [X] 변수명에 자료형 배제
- [ ] 메서드 단일 기능 담당
- [ ] 메서드 단일 기능 담당 확인 기준 수립
  - [ ] 중복 코드 추출
  - [ ] 15 라인 이내로 구현
- [X] 경험을 토대로 테스트 작성 이유 정리
  - [ ] 학습테스트 별도 저장소에서 작성해보기
- [X] 문제를 작게 나눠 단위 테스트부터 구현하기

### `기능 요구 사항`

- [X] 사용자로부터 로또 구입 금액을 입력받는다.
- [X] `class OutputView` - 구입 금액 입력 안내
- [X] 구입 금액이 유효하다면, 구입 금액에 맞춰 로또를 구매한다.

  - ### ❗구입 금액이 0원이라면 예외로 처리할까 기능으로 처리할까?
    - 기능으로 처리한다면 당첨 번호를 받을 필요 없이 그냥 프로그램 종료도 가능.
    - 예외로 처리해서 다시 입력받는 것이 정상적/바람직한 구현이라 판단.
- `class InputView`
- 모든 입력값에 대한 기초적 유효성 검증 담당
- `readLine()` is not blank
- `readPositiveInt()` is Numeric, positive integer
- `readWinningNumbers()` is can split by "," / each token is Numeric / ...

- [X] 구매한 로또의 정보를 저장한다
  - [X] `class UserLotteries`
  - [X] `toString()` 저장된 로또들의 정보를 출력하기 위해 toString을 재정의한다

- [X] 로또 구입 금액에 맞춰 발행한 로또 수량 및 번호를 출력한다.
- [X] `class OutputView` - 로또 구매 결과 안내
  - [X] `toString()` 재정의 - 로또 번호는 오름차순으로 정렬하여 보여준다.

  - [X] 로또 1장의 가격은 `1,000`원이다.
  - [X] `validAmount(int amount)` > [Validator](#class-validator) - 유효한 입력값을 반복해서 받을 수 있는 구조로 구현

- [X] 로또는 6개의 로또 번호로 구성된다.
- [X] 모든 로또 번호는 중복되지 않는다.

  - [X] `class Lotto`
    - [X] `Set<LottoNumber> numbers`
      - [X] `validate()` in `constructor()`
      - [X] `contains(LottoNumber lottoNumber)` 해당 로또에 특정 로또 번호의 포함 여부 반환
      - [X] `calcMatchCount(Lotto targetLotto)` 다른 로또와 비교해 일치하는 번호의 개수 계산해 반환
      - [X] `toString()` 구매 결과 출력을 위한 toString 재정의
      - ### `class Lotto` `테스트`
        - [X] 6개의 로또 번호로 생성 - `기능`
        - [X] 중복된 로또 번호로 생성 - `예외`
        - [X] 6개 미만의 로또 번호로 생성 - `예외`
        - [X] 6개 초과의 로또 번호로 생성 - `예외`
      - [X] `validate()`에서 위 유효성 검증 로직 구현하기 
        - #### ❗어차피 LottoNumber 가 검증하는데 중복 검증 필요성?
        - 검증 로직이 매우 복잡한 게 아닌 이상 유효성 검증이 철저할수록 완성도 증진한다 판단

  - [X] 모든 로또 번호는 1~45 범위의 숫자이다.
  - [X] `class LottoNumber`
    - [X] `validate()` in `constructor()`
    - [X] `getNumber()` 구현 및 `toString()` 에 numbers 사용
    - ### `class LottoNumber` `테스트`
      - [X] 정상 범위로 생성 - `기능`
      - [X] 미만 범위로 생성 - `예외`
      - [X] 초과 범위로 생성 - `예외`
      - [X] 값은 숫자를 가진 경우 equals - `기능`
      - [X] 다른 숫자를 가진 경우 notEquals - `기능`
    - [X] `validate()`에서 위 유효성 검증 로직 구현하기

- [X] 사용자로부터 당첨 번호 6개와 보너스 번호 1개를 입력받는다.
  
  - [X] 6개의 번호를 입력받는다.
    - [X] `class InputView`
    - [X] `readWinningNumbers()`
  - [X] 모든 번호는 중복되지 않는 6개의 정수이며, 쉼표를 기준으로 구분한다.
    - [X] 공백 등 잘못된 입력값은 `readLine()` 단계에서 예외 발생.
    - [X] 구분자 오류나 6개 이외의 숫자를 입력한 경우 예외 발생. - `validate(String input)`
    - [X] 각 숫자의 중복이나 범위를 벗어난 경우 `Lotto` 생성 단계에서 예외 발생.
    - [X] 하지만, 설계한 대로 반복적 유효성 검증을 통한 유효성 보장 구현, 
    - [X] `parsePositiveInteger()` - 각 숫자가 양수임을 검증 
    - [X] `validate()` in `parseNumbers()`
      - [X] `splitTokensIfValid()` 쉼표를 기준으로 스플릿한 토큰이 정확히 6개가 아니면 예외
      - [X] `validateDuplicated()` 쉼표를 기준으로 스플릿한 토큰 중 중복이 존재하면 예외
    - [X] 6개의 숫자를 쉼표로 구분해서 입력 - `기능`
    - [X] 숫자를 공백 등 잘못된 구분자로 구분해서 입력 - `예외`
    
        - #### ❗공백은 `trim()`등으로 제거하면 되지 않나? 
        - 쉼표가 아닌 공백을 구분자로 사용할 경우 trim()으론 숫자 사이의 공백을 없앨 수 없고,  
          공백을 포함한 숫자를 parse 시도할 경우 런타임 예외가 발생한다. 예외처리가 타당.
        - #### ❗테스트 구현은?  
        > 구현한 기능에 대한 단위 테스트를 작성한다. `단, UI(System.out, System.in, Scanner) 로직은 제외한다.`
        - #### ❗UI 로직은 테스트하지 않지만, 유효성 검증은 테스트해도 되지 않나?  
          일단은 비즈니스 로직에 유효성 검증이 있으니 스킵, 추후 고려
      
  - [X] 6개의 당첨 번호로 winningNumbers List 를 생성한다.
    - [X] `parseNumbers()`
    
  - [X] 1개의 보너스 번호를 입력받는다.
  - [X] 보너스 번호는 로또 번호와 동일한 유효성 검증을 진행하고, 당첨 번호들과 중복되지 않아야 한다.
  - [X] winningNumbers, bonusNumber 로 WinningNumbers 를 생성한다.
  - [X] WinningNumbers 는 Lotto 를 멤버로 가진다.
  - [X] `class WinningNumbers`
    - [X] `Lotto lotto`
  
      - #### ❗Lotto 를 멤버로 가지기 VS 로또를 상속해 numbers 를 멤버로 가지기
      - 상속과 다형성의 명확한 원칙에 따른 답 존재.
      - `LSP (리스코프 치환 원칙)` 위반
      - > 자식 클래스는 부모 클래스를 대체할 수 있어야 한다
        - 6개의 `번호`를 가진 `로또`와, 6개 + 보너스 1개의 `당첨 번호 정보`를 가진 `당첨 정보` 는  
          상속 관계로는 바람직하지 않다. 기능적으론 대체할 수 있을지언정 논리적으로 대체의 합리성이 부족
      - == 상속(is-a) 관계가 아닌 컴포지션(has-a) 관계로 구현하는 것이 바람직하다.
      - 그렇다면 WinningLotto보단 Winning 이나 WinningInfo 등이 알맞은 클래스명 아닌가?
      - ### 클래스는 `무엇`을 할 것인지 그 역할을 이름으로 짐작할 수 있도록 작성되어야 한다.
      - `Lotto`는 6개의 로또 번호를 가진 객체, WinningLotto 는 6개의 _당첨_ 번호와 1개의 보너스 번호를 가진 객체.
      - 복권 / 당첨 / 당첨 복권 / 당첨 번호 / 당첨 정보 등 다양한 역할과 이름 중 적합한 것은?
      - 구글 검색 상 상위 검색어는 `당첨 번호`. WinningLotto -> WinningNumbers
      
    - [X] `LottoNumber bonusNumber`
    - [X] `validate(LottoNumber bonusNumber)` in `constructor()`
    - [X] `determineWinning(Lotto userLotto)` 로또의 당첨 여부 판별, 등수 반환
    - [X] `calcMatchCount(Lotto userLotto)` Lotto 클래스의 일치 번호 개수 계산 기능 활용
    - [X] `isBonusNumberMatched(Lotto userLotto)` Lotto 클래스의 특정 로또 번호 포함 여부 기능 활용
  
      - #### ❗보너스넘버의 중복 검증은 어느 클래스의 책임인가?
      - 입력값 기초 유효성 검증은 InputView 가. 
      - 상세 유효성 검증은 LottoNumber 가.
      - 중복 검증만 하면 될 텐데 Lotto VS WinningNumbers?
      - 실제 numbers 는 Lotto 내부에. bonusNumber 는 WinningNumbers 내부에.
      - 즉, 보너스넘버는 WinningNumbers 만의 멤버이므로,   
        `WinningNumbers` 클래스가 컴포지션 관계인 `Lotto` 클래스의 행위를 통해 검증.
  
    - ### `class WinningNumbers` `테스트`
      - 대부분의 테스트가 `Lotto` 와 중복되는 부분이 있지만 정확한 테스트를 위해 전부 구현하기
      - [X] 6개의 로또 번호와 중복되지 않는 보너스 번호로 생성 - `기능`
      - [X] 6개 미만의 로또 번호로 생성 - `예외`
      - [X] 6개 초과의 로또 번호로 생성 - `예외`
      - [X] 중복된 로또 번호로 생성 - `예외`
      - [X] 범위를 벗어난 로또 번호로 생성 - `예외`
      - [X] 범위를 벗어난 보너스 번호로 생성 - `예외`
      - [X] 보너스 번호가 로또 번호와 중복 - `예외`

- [X] 당첨 번호와 보너스 번호로 로또들의 당첨 여부를 판별한다.

  - [X] 구매한 로또의 번호와 당첨 번호를 비교한다.
  
    - ### ❗비교와 당첨 판별의 주체는?
    - `Parser` 든 `WinningChecker` 든 반복 작업이 아닌 일회성 작업을 위해 클래스를 분리하는 것이 필요한가?
    - 클래스의 비대화는 지양하는 것이 맞으나, 보너스넘버를 `WinningNumbers` 클래스가 검증하듯  
      클래스의 명확한 책임과 역할을 담당할 수 있도록 구현해야 한다.
    - [클래스의 역할](###) 단순히 데이터만을 보유하는 것이 아닌, `무엇`을 `하는`, 행위 또한 보유하는 것이 클래스의 역할.
    
  - [X] WinningNumbers 클래스가 구매한 로또들의 당첨 여부를 비교한다.
  - [X] `determineEveryLotteries()`
    - [X] `class WinningNumbers`
    - [X] `determineWinning()`
    - [X] 이 때, 당첨 결과는 정해진 특정 값에 한정되므로, 이 부분이 바로 [Enum](https://github.com/nn98/java-lotto-8/wiki/Java-Enum%EC%9D%98-%EC%82%AC%EC%9A%A9-%EC%9D%B4%EC%9C%A0) 을 활용해 구현하는 부분.
      - [X] `enum Winning`
      - [X] `1st ~ 5th + losing(defeating?)`
        - ❗일치수가 3 미만이면 당첨이 아니다. 일치수 3 ~ 0 에 해당하는 enum도 생성해야?
        - 불필요한 코드 반복보단 일괄 꽝으로 처리하는게. `valueOf()` 의 `.orElse(LOSING)` 에서 처리.
      - [X] `Winning valueOf()`
      - [X] `calcPrize()`
      - `getName()` 안해도 테스트에서 문제없이 비교 가능. getter 지양. 
      - ### `enum Winning` `테스트`
        - [X] 당첨 번호와 보너스 번호 일치 여부로 순위 반환
          - [X] 6개 일치부터 ~ 3개 미만 일치까지, `name` 과 `prize` `@CsvSource` 로 테스트 - `기능`
        - [X] 지정되지 않은 값으로 `valueOf()` - `예외`
         
          - ### ❗예외를 굳이 throw 하는 대신
          - 예외 발생 시 입력을 다시 받아야 한다. 이미 당첨 확인 중이라면 입력값에 오류가 없었어야 하는데  
            이 시점에서 재입력을 받는다? 그래선 안되고 그럴 수도 없다. 예외는 자체적으로 `orElse` 처리.
           
        - [X] 1등 + 3등 각 1개씩 당첨 시 상금의 합도 동일 - `기능`

- [ ] 판별된 당첨 결과를 저장한다.
- [ ] `class Statistics`
  - [ ] `int amount`
  - [ ] `List<Winning> winnings`
  - [ ] `int totalPrize`

- [ ] 판별된 당첨 여부로 당첨 수 및 당첨금을 출력한다.
  - [ ] 일치한 개수와 총 당첨금을 계산한다.
  
- [ ] 판별된 당첨 결과와 로또 구매 금액을 기반으로 수익률을 출력한다.
  - [ ] 구매 금액과 최종 당첨금을 가지고 최종 수익률을 계산한다.
  - [ ] `double calcProfit(int amount, int totalPrize)`

- [ ] 로또 게임을 종료한다.
  - [ ] `InputView.close()`

- [ ] 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시키고,  
  "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 `입력을 다시 받는다.`

  - [ ] `예외`
  - [ ] 숫자 대신 `문자`를 입력(당첨 번호 입력에서의 구분자 `,` 제외)
    - [ ] 공백 입력
    - [ ] 소수(소수점) 입력
    - [ ] 음수(`-`기호) 입력
  - [ ] 중복된 숫자 입력
  - [ ] 범위 초과 숫자 입력
  - [ ] 1000으로 나누어 떨어지지 않는 구입 금액 입력
  - [ ] `재입력`
  - [ ] 예외가 발생한 위치, 해당 메소드를 그대로 재실행
  
    - [ ] ### [❗잘못된 입력에 대한 재시도, 반복 처리는 어떻게?](#-생각할-부분)

---

# 🏆 도전

### `TDD`
- [X] 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.
- [ ] 통합적인 기능에 대한 통합 테스트를 통해 의도한 대로 정확하게 동작하는 구현을 확인한다.

### `Commit`
- [X] 하나의 커밋은, 그 자체로 정상적인 동작을 보장해야 한다.  
  오류 없이 동작하는 상황에서 `README`에 정리한 기능 목록 단위로 커밋하기

---

# 🫤 고민

### 💡

---

## 📋 요구사항

### ❗ 코딩

- [ ] [pr 체크리스트](pr_checklist.md) 준수
- [ ] 3항 연산자 배제
- [ ] 중복 코드 추출
- [ ] 작명에 자료형 배제
- [ ] 메서드의 길이 15라인 이내로 제한
- [X] [Java Enum 적용해서 구현](https://github.com/nn98/java-lotto-8/wiki/Java-Enum%EC%9D%98-%EC%82%AC%EC%9A%A9-%EC%9D%B4%EC%9C%A0)
- [X] Lotto 클래스 관련
  - [X] 제공된 Lotto 클래스를 사용하여 구현해야 한다.
    - 제공된 구조를 기반으로 추가 기능을 구현
  - [ ] Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
    - 이는 곧 numbers만으로 기능 구현은 충분히 가능
  - [ ] numbers의 접근 제어자인 private은 변경할 수 없다.
    - 접근 제어자는 유지해서 은닉하되 타입은 가변
  - [X] Lotto의 패키지를 변경할 수 있다.
    - 아키텍처와 패턴에 맞춰 원하는 패키지로 이동 가능 

### ❗ 테스트

- [X] 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.
- [ ] 기능 구현을 완료한 후 가이드에 따라 모든 테스트가 성공적으로 실행되는지 확인한다.
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- [X] 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- [X] 단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.

### ❗ 의존성

- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  - [ ] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
  - [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

---

## 🛠️ 기능

### ❗ 입ㆍ출력

<details><summary><h3><code>입력</code></h3></summary>

<ul>

- [ ] 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
</ul>
<pre><code data-highlighted="yes" class="hljs language-undefined">14000</code></pre>
<ul>

- [ ] 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
</ul>
<pre><code data-highlighted="yes" class="hljs language-apache"><span class="hljs-attribute">1</span>,<span class="hljs-number">2</span>,<span class="hljs-number">3</span>,<span class="hljs-number">4</span>,<span class="hljs-number">5</span>,<span class="hljs-number">6</span></code></pre>
<ul>

- [ ] 보너스 번호를 입력 받는다.
</ul>
<pre><code data-highlighted="yes" class="hljs language-undefined">7</code></pre>

</details>

---

<details><summary><h3><code>출력</code></h3></summary>

<ul>

- [ ] 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
</ul>
<pre><code data-highlighted="yes" class="hljs language-prolog"><span class="hljs-number">8</span>개를 구매했습니다.
[<span class="hljs-number">8</span>, <span class="hljs-number">21</span>, <span class="hljs-number">23</span>, <span class="hljs-number">41</span>, <span class="hljs-number">42</span>, <span class="hljs-number">43</span>]
[<span class="hljs-number">3</span>, <span class="hljs-number">5</span>, <span class="hljs-number">11</span>, <span class="hljs-number">16</span>, <span class="hljs-number">32</span>, <span class="hljs-number">38</span>]
[<span class="hljs-number">7</span>, <span class="hljs-number">11</span>, <span class="hljs-number">16</span>, <span class="hljs-number">35</span>, <span class="hljs-number">36</span>, <span class="hljs-number">44</span>]
[<span class="hljs-number">1</span>, <span class="hljs-number">8</span>, <span class="hljs-number">11</span>, <span class="hljs-number">31</span>, <span class="hljs-number">41</span>, <span class="hljs-number">42</span>]
[<span class="hljs-number">13</span>, <span class="hljs-number">14</span>, <span class="hljs-number">16</span>, <span class="hljs-number">38</span>, <span class="hljs-number">42</span>, <span class="hljs-number">45</span>]
[<span class="hljs-number">7</span>, <span class="hljs-number">11</span>, <span class="hljs-number">30</span>, <span class="hljs-number">40</span>, <span class="hljs-number">42</span>, <span class="hljs-number">43</span>]
[<span class="hljs-number">2</span>, <span class="hljs-number">13</span>, <span class="hljs-number">22</span>, <span class="hljs-number">32</span>, <span class="hljs-number">38</span>, <span class="hljs-number">45</span>]
[<span class="hljs-number">1</span>, <span class="hljs-number">3</span>, <span class="hljs-number">5</span>, <span class="hljs-number">14</span>, <span class="hljs-number">22</span>, <span class="hljs-number">45</span>]</code></pre>
<ul>

- [ ] 당첨 내역을 출력한다.
</ul>
<pre><code data-highlighted="yes" class="hljs language-apache"><span class="hljs-attribute">3</span>개 일치 (<span class="hljs-number">5</span>,<span class="hljs-number">000</span>원) - <span class="hljs-number">1</span>개
<span class="hljs-attribute">4</span>개 일치 (<span class="hljs-number">50</span>,<span class="hljs-number">000</span>원) - <span class="hljs-number">0</span>개
<span class="hljs-attribute">5</span>개 일치 (<span class="hljs-number">1</span>,<span class="hljs-number">500</span>,<span class="hljs-number">000</span>원) - <span class="hljs-number">0</span>개
<span class="hljs-attribute">5</span>개 일치, 보너스 볼 일치 (<span class="hljs-number">30</span>,<span class="hljs-number">000</span>,<span class="hljs-number">000</span>원) - <span class="hljs-number">0</span>개
<span class="hljs-attribute">6</span>개 일치 (<span class="hljs-number">2</span>,<span class="hljs-number">000</span>,<span class="hljs-number">000</span>,<span class="hljs-number">000</span>원) - <span class="hljs-number">0</span>개</code></pre>
<ul>

- [ ] 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
</ul>
<pre><code data-highlighted="yes" class="hljs language-erlang-repl">총 수익률은 <span class="hljs-number">62.5</span><span class="hljs-comment">%입니다.</span></code></pre>
<ul>

- [ ] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
</ul>
<pre><code data-highlighted="yes" class="hljs language-prolog">[<span class="hljs-symbol">ERROR</span>] 로또 번호는 <span class="hljs-number">1</span>부터 <span class="hljs-number">45</span> 사이의 숫자여야 합니다.</code></pre>
<h4>실행 결과 예시</h4>
<pre><code data-highlighted="yes" class="hljs language-prolog">구입금액을 입력해 주세요.
<span class="hljs-number">8000</span>
<span class="hljs-number">8</span>개를 구매했습니다.
[<span class="hljs-number">8</span>, <span class="hljs-number">21</span>, <span class="hljs-number">23</span>, <span class="hljs-number">41</span>, <span class="hljs-number">42</span>, <span class="hljs-number">43</span>]
[<span class="hljs-number">3</span>, <span class="hljs-number">5</span>, <span class="hljs-number">11</span>, <span class="hljs-number">16</span>, <span class="hljs-number">32</span>, <span class="hljs-number">38</span>]
[<span class="hljs-number">7</span>, <span class="hljs-number">11</span>, <span class="hljs-number">16</span>, <span class="hljs-number">35</span>, <span class="hljs-number">36</span>, <span class="hljs-number">44</span>]
[<span class="hljs-number">1</span>, <span class="hljs-number">8</span>, <span class="hljs-number">11</span>, <span class="hljs-number">31</span>, <span class="hljs-number">41</span>, <span class="hljs-number">42</span>]
[<span class="hljs-number">13</span>, <span class="hljs-number">14</span>, <span class="hljs-number">16</span>, <span class="hljs-number">38</span>, <span class="hljs-number">42</span>, <span class="hljs-number">45</span>]
[<span class="hljs-number">7</span>, <span class="hljs-number">11</span>, <span class="hljs-number">30</span>, <span class="hljs-number">40</span>, <span class="hljs-number">42</span>, <span class="hljs-number">43</span>]
[<span class="hljs-number">2</span>, <span class="hljs-number">13</span>, <span class="hljs-number">22</span>, <span class="hljs-number">32</span>, <span class="hljs-number">38</span>, <span class="hljs-number">45</span>]
[<span class="hljs-number">1</span>, <span class="hljs-number">3</span>, <span class="hljs-number">5</span>, <span class="hljs-number">14</span>, <span class="hljs-number">22</span>, <span class="hljs-number">45</span>]
당첨 번호를 입력해 주세요.
<span class="hljs-number">1</span>,<span class="hljs-number">2</span>,<span class="hljs-number">3</span>,<span class="hljs-number">4</span>,<span class="hljs-number">5</span>,<span class="hljs-number">6</span>
보너스 번호를 입력해 주세요.
<span class="hljs-number">7</span>
당첨 통계
---
<span class="hljs-number">3</span>개 일치 (<span class="hljs-number">5</span>,<span class="hljs-number">000</span>원) - <span class="hljs-number">1</span>개
<span class="hljs-number">4</span>개 일치 (<span class="hljs-number">50</span>,<span class="hljs-number">000</span>원) - <span class="hljs-number">0</span>개
<span class="hljs-number">5</span>개 일치 (<span class="hljs-number">1</span>,<span class="hljs-number">500</span>,<span class="hljs-number">000</span>원) - <span class="hljs-number">0</span>개
<span class="hljs-number">5</span>개 일치, 보너스 볼 일치 (<span class="hljs-number">30</span>,<span class="hljs-number">000</span>,<span class="hljs-number">000</span>원) - <span class="hljs-number">0</span>개
<span class="hljs-number">6</span>개 일치 (<span class="hljs-number">2</span>,<span class="hljs-number">000</span>,<span class="hljs-number">000</span>,<span class="hljs-number">000</span>원) - <span class="hljs-number">0</span>개
총 수익률은 <span class="hljs-number">62.5</span><span class="hljs-comment">%입니다.</span></code></pre>

</details>

---

### 💡 생각할 부분

- [ ] ❗잘못된 입력에 대한 재시도, 반복 처리는 어떻게?
  - 에러가 발생핟다면 재귀적으로 해당 메서드를 재호출해서 리턴하면 될 듯
  - 에러 발생 시점은? 
    - inputView 에서 정상적인 값인지 검증
    - Domain 에서 비즈니스 로직에 부합한 값인지 검증 
  - 위 2번의 검증을 통해 에러를 발생시키기

---

## 📜 설계

```jsonpath

상수값 추출해서 constants / Enum class로 정리

Enum 객체 생성 - 로또 당첨 꽝부터 1~5등까지.
number, bonusNumber, rank(등수), prize,
 
일치 여부를 판별할 WinningChecker 객체 

입/출력 Input/OutpuView 객체

실행 흐름을 관리할 LottoController 객체

프로그램 진입점 Application 객체

```

### `순서`

- 의존관계 없이 고유하게 존재할 const, Enum > 
- 값을 보유할 Lotto > 
- Lotto 상속받아 당첨값 보유할 WinningNumbers > 
- 값을 비교할 WinningChecker
- ...