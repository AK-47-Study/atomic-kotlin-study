# Chapter1

## 😉 컴파일과 인터프리터

- `코틀린`은 `해석(interpret)`되지 않고 `컴파일(compile)`된다.
- 해석되는 언어의 명령은 `인터프리터`라는 별도의 프로그램을 통해 직접 실행된다.
- `컴파일`되는 언어의 `소스코드`는 하드웨어 프로세서에서 직접 실행되거나 `프로세서`를 본 딴 `가상 머신`에서 실행될 수 있는 다른 표현으로 변환된다.
- `C`, `C++`, `Go`, `Rust` 같은 언어는 중앙 처리 장치에서 직접 실행되는 기계 코드로 컴파일된다.
    - `Java`나 `Kotlin` 같은 언어는 `바이트 코드`로 번역된다.
- `바이트 코드`는 하드웨어 `CPU`에서 직접 실행되지 못하고 `바이트 코드` 명령을 실행할 수 있는 가상 머신에서 실행될 수 있는 `중간 수준의 형태`를 가진다.

![image](https://github.com/AK-47-Study/atomic-kotlin-study/assets/91787050/dbf173a0-8e60-4121-a3cc-3d510a375b25)

## ☺️ 가상 머신을 사용해 얻는 이점

- `가상 머신`만 설치되어 있으면 같은 `바이트 코드`를 어느 기계에서나 `실행`할 수 있다.
- `가상 머신`은 특정 하드웨어에 맞춰 `최적화`되어 속도 문제를 `해결`할 수 있다.

### 😩 오류의 종류 - [컴파일 시점 오류, 실행 시점 오류]

- `컴파일 시점`에 컴파일러는 코드를 검사해서 `컴파일 시점 오류`를 발견한다.
- `실행 시점 오류`는 컴파일 시점에 `감지할 수 없는 오류`를 말한다.
    - `실행 시점 오류`는 발견하기 더 어렵고 `수정 비용`도 많이 든다.
    - 정적으로 타입을 지정하는 언어는 `컴파일 시점`에 가능한 한 `많은 오류`를 찾는다.
    - `동적 언어`는 이런 안전성 검사를 실행 시점에 수행한다.

## 🫠 Kotlin의 강점

- `가독성`
    - `코틀린` 문법은 간결하고, 준비 코드 없이 `복잡한 아이디어`를 `표현`할 수 있다.
- `도구`
    - `코틀린`은 최상급의 `도구 지원`을 받을 수 있는 언어다.
- `다중 패러다임`
    - `코틀린`은 여러 프로그래밍 패러다임을 지원한다.
        - `명령형` 프로그래밍
        - `함수형` 프로그래밍
        - `객체 지향` 프로그래밍
    - `다중 플랫폼`
        - `코틀린` 소스 코드는 여러 타깃 `플랫폼`으로 `컴파일`할 수 있다.
            - JVM
            - 안드로이드
            - 자바스크립트
            - `네이티브 바이너리`
                - 특정 플랫폼과 `CPU`에 맞는 `기계어 코드`를 `생성`할 수 있다.

## 😑 Kotlin의 특징

- `Java 상호 운용성`
    - `Kotlin`은 기존 `Java 코드` 사이에 끼워 넣을 수 있다.
    - `Java 코드` 입장에서는 `Kotlin 코드`가 마치 `Java 코드`처럼 보인다.
    - `IntelliJ`에서 `Java 코드`를 `Kotlin`으로 자동 변환해주는 도구를 제공한다.
    
- `빈 값 표현 방식`
    - `코틀린`은 `널 오류`를 발생시킬 가능성이 있는 `연산`을 `컴파일 시점`에 `금지`함으로서 문제를 해결한다.
    - 이 특징 하나만으로 자바의 `널 오류`를 최소화하거나 아예 없앨 수 있다.
    

## 🤓 Hello World!  출력해보기

```kotlin
fun main() {
	println("Hello, world!")
}
```

- `println()`은 `String` 타입의 파라미터를 하나만 받는다.
- `println()` 대신 `print()`를 사용할 수도 있다.
    - `println()`은 파라미터를 화면에 출력한 후 커서를 다음 줄 맨 앞으로 옮긴다.
    - `print()`는 파라미터로 `전달받은 문자열`과 같은 줄에 커서를 남겨둔다.
- `Kotlin`은 식 끝에 `세미콜론`을 붙이지 않아도 된다.

## ✌🏼 val과 var

`Kotlin`은 식별자가 가리키는 내용이 프로그램을 실행하는 동안 변할 수 있는지에 따라 `두 가지 키워드`를 사용해  `변경 가능성`을 제어한다.

- `var` : 변할 수 있는 수(variable)의 약자로, 내용을 재대입할 수 있다.
- `val` : 값(value)의 약자로, 식별자의 값을 단 한번 만 초기화 할 수 있다.

```kotlin
fun main() {
	var sum = 0
  sum += 2
  sum += 3

  val num = 2
  num += 3 // -> Error! val 변수는 불변이다.

}
```

## 😀 Kotlin의 데이터 타입

- 타입은 `코틀린`이 각 타입에 속하는 `값`과 `연산`을 어떻게 사용하는 것이 올바른지 알려준다.

```kotlin
fun main() {
	var name = "Sally"
  println(name * 5.9) // 에러 -> 문자열에 대한 숫자 곱셈은 코틀린이 이해할 수 없다!
  println(name + 5.9) // 가능 -> 문자열에 5.9를 문자열로 더해서 Sally5.9가 출력된다.
}
```

- `타입 추론`

Kotlin에서는 `타입`을 명시적으로 지정해주지 않아도, 각 값을 어떻게 쓰는지 살펴보고 각 `변수의 타입`을 알아내는 `타입 추론`을 지원한다.

```kotlin
fun main() {
  // 명시적으로 변수의 타입을 선언하는 방법이다.
	var name: String = "Sally"

  // 명시적으로 타입을 선언하지 않아도, 타입 추론을 통해 String 타입을 추론하는 방법이다.
  var name = "Sally"
}
```

## 😁 Kotlin의 함수

- `함수`는 `일련의 동작`을 묶어주며, 프로그램을 체계적으로 구성하고 `코드를 재사용`하는 가장 기본적인 방법이다.

```kotlin
fun 함수이름(p1: 타입1, p2: 타입2, ...): 반환타입 {
	여러 줄의 코드 .. (함수 본문)
  return 결과
}
```

```kotlin
fun multiplyByTwo(x: Int): Int {
	println("Inside multiplyByTwo")
  return x * 2
}

fun main() {
	val r = multiplyByTwo(5)
  println(r)
}

```

- `의미 있는 결과`를 제공하지 않는 `함수`(`Java`의 `void`와 같다)의 반환 타입은 `Unit`이다.
    - `Unit`은 생략할 수 있다.
    

```kotlin
// Unit을 명시하지 않음
fun sayHello() {
	println("Hallo!")
}

// 반환타입 Unit을 명시
fun sayGoodBye(): Unit {
	println("Auf Wiedersehen!")
}

fun main() {
	sayHello()
	sayGoodbye()
}
```

- `함수 본문`이 중괄호로 둘러싸인 경우를 `블록 본문` 이라한다.
    - 등호 뒤에 식이 본문으로 지정된 경우를 `식 본문(expression body)`이라 한다.
    - `식 본문`을 사용하는 함수의 반환타입은 `추론 가능`하다.

```kotlin
// 블록 본문을 사용한 함수
fun multiplyByThree(x: Int): Int {
	return x * 3
}

// 식 본문을 사용
fun multiplyByThree(x: Int): Int = x * 3

// 식 본문을 사용하는 함수의 반환타입은 추론 가능하다.
fun multiplyByThree(x: Int) = x * 3
```

- `함수`를 작성할 때는 `서술적인 이름`을 사용해야 한다.
    - `코드`를 더 쉽게 읽을 수 있고, `코드`에 주석을 남겨야 할 `필요성`도 줄기 때문이다.

## 🤩 Kotlin의 조건문 - If 식

- `if` 키워드는 식을 검사해 그 값이 `true`나 `false` 중 어느 것인지 알아내고, 그 결과에 따라 작업을 수행한다.
- 참이나 거짓을 표시하는 식은 `불리언`이라고 한다.

```kotlin
fun main() {
  val n: Int = -11

  if (n > 0)
		println("It's Positive")
  else 
		println("It's negative or zero")
}
```

- `if 키워드`는 본문의 코드가 한 줄 인 경우 `중괄호`를 `포함`하지 않을 수 있다.
    - 본문의 코드가 `두 줄 이상`인 경우 `중괄호(몸체)`를 포함해야 한다.

```kotlin
fun oneOrTheOther(exp: Boolean): String = 
if (exp)
	"True"
else
	"False"
```

- `if 식`을 이용해 결과를 만들어 낼 수도 있다.
    - `조건식`의 평가 결과에 따라 `반환하는 값`을 `함수의 반환 값`으로 사용할 수 있다.