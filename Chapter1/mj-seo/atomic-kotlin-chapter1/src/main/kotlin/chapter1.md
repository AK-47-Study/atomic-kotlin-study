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
 
## 😉 Kotlin의 문자열 템플릿

- `식별자 이름` 앞에 `$`를 붙이면, `문자열 템플릿`이 그 식별자의 내용을 `String`에 넣어준다.

```kotlin
fun main() {
   val answer = 42
   println("Found $answer!")

   // $ 다음에 오는 대상이 프로그램 식별자가 아니면 아무 일도 일어나지 않는다.
   println("printing a $1") 
}
```

- `문자열 연결(+)`로도 `String`에 값을 넣을 수 있다.

```kotlin
fun main() {
  val s = "hi\n"
  val n = 41
  val d = 3.14

   println("first : " + s + "second: " + n + 
			", third: " + d)
}
```

- `${}`의 중괄호 안에 식을 넣으면 그 식을 평가한다.
    - 평가한 결과값을 `String으로 변환`해 결과 `String`에 삽입한다.

```kotlin
fun main() {
   val condition = true
   println(
      "${if (condition) 'a' else 'b'}")
   val x = 11
   println("$x + 4 = ${x + 4}")
}
```

- `문자열` 안에 `큰따옴표` 등 특수 문자를 넣어야 하는 경우 `이스케이프 문자(\)`를 사용한다.
    - `이스케이프` 문자 대신 `큰따옴표`를 연달아 세 개 쓰는 `String 리터럴`을 사용해도 된다.

```kotlin
fun main() {
   val s = "value"
   println("s = \"$s\".")
   println("""s = "$s".""")
}
```

## 😎 Kotlin의 수 타입

- `식별자`를 만들고 `정숫값`을 대입하면 `Kotlin`은 `Int 타입`을 `추론`한다.
    - 가독성을 위해 `Kotlin` 에서는 숫자 사이에 `밑줄(_)`을 넣도록 `허용`한다.

```kotlin
fun main() {
   val million = 1_000_000 // Int를 추론
   println(million)
}
```

- `Kotlin`의 `Int 타입`은 `32비트` 표현의 제약으로 -2^31 ~ +2^31 -1 사이의 값을 저장할 수 있다.
    - `Int.MAX_VALUE`, `Int.MIN_VALUE`와 같이 저장할 수 있는 `최소`, `최대 값`을 가진 `상수`를 `제공`한다.

```kotlin
val int_max_value = Int.MAX_VALUE

val int_min_value = Int.MIN_VALUE
```

- `수 타입`의 범위를 초과하는 수를 대입하면 `overflow`가 일어난 결과를 얻게 된다.

```kotlin
fun main() {
   val i: Int = Int.MAX_VALUE
   println(i + i) // -2 -> Overflow 발생
}
```

- `큰 수`를 `저장`해야 한다면 `Long 타입`을 쓰면 된다.
    - `Long` 타입은 -2^63 ~ +2^63-1 까지의 값을 표현할 수 있다.
    - `Long` 타입 역시 `최소`, `최대 값`을 표현하는 `상수`를 `제공`한다.
    

## 🤫 Kotlin의 논리 연산

- `Kotlin` 에서도 `논리 부정` 연산, `논리 합` 연산, `논리 곱` 연산을 제공한다.

```kotlin
val booleanValue = true

val negateExpression = !booleanValue // false -> 논리 부정
val orExpression = booleanValue || !booleanValue // true -> 논리 합
val andExpression = booleanValue && !booleanValue // false -> 논리 곱
```

## 👨🏼‍💻 Kotlin의 반복문

- `Kotlin` 역시 `while` 키워드를 사용한다.
    - `while`은 주어진 `Boolean` 식이 `true`인 동안 블록을 `반복 수행`한다.

```kotlin
fun main() {
   var i = 0
   whlie (i < 100) {
     print(".")
     i += 10
   }
}
```

- `do - while` 문은 `Boolean` 식이 `false`를 반환해도 본문이 `최소 한 번`은 `실행`된다.

```kotlin
fun main() {
  var i = 0
  do {
    print(".")
    i += 10
    // 조건이 거짓이지만 본문이 한 번은 실행된다.
  } while (i > 10)
}
```

- `Kotlin`에서는 두 번째로 `for 키워드`를 지원한다.
    - `for 키워드`는 주어진 순열에 속한 각 값에 대해 `코드 블록`을 `실행`한다.

```kotlin
fun main() {
  for (i in 1..100) {
     println("number is = $i")
  }
}
```

- `반복할 범위`를 정의하는 방법은 `두 가지`가 있다.
    - `…` : `1..10`은 1 ~ 10 즉 `양 끝 값`을 `포함`한 범위를 만든다.
    - `until` : `1 until 10`은 until `다음에 오는 값`을 `제외`한 범위를 만든다.
        - 즉 `1..9` 까지의 `범위`를 가지게 된다.

```kotlin
1..100 // 1 ~ 100까지 증가하면서 반복
1 until 100 // 1 ~ 99까지 증가하면서 반복
100 downTo 1 // 100 ~ 1까지 감소하면서 반복

1..100 step 2 // 1 ~ 100까지 2씩 증가하면서 반복
100 downTo 1 step 3 // 100 ~ 1까지 3씩 감소하면서 반복
```

- `문자 범위`도 `반복`이 가능하다.

```kotlin
fun main() {
  for (c in 'a'..'z') {
     print(c)
  }
}
```

- `조건`이나 `범위`가 아닌 단순히 `정해진 횟수`만큼 `반복`이 필요한 경우에는 `repeat` 함수를 사용할 수 있다.

```kotlin
fun main() {
  repeat(2) {
     println("hi!")
  }
}
```

## 🥶 Kotlin의 in 키워드

- `for 문`을 제외한 모든 `in 키워드`는 어떤 값이 `주어진 범위` 안에 들어있는지 `검사하는 용도`로 `사용`된다.

```kotlin
fun main() {
   val percent = 35
   println(percent in 1..100)
}
```

- `문자`도 `범위 검사`가 가능하다.

```kotlin
fun main() {
  val keyword1 = 't'
  val keyword2 = 'z'
  println(keyword1 in "kotlin") // true
  println(keyword2 in "kotlin") // false
	
  val keyword3 = "ac"
  val keyword4 = "zz"
  println(keyword3 in "aa".."az") // true
  println(keyword4 in "aa".."az") // false
}
```

## 😐 Kotlin의 식(Expression)과 문(Statement)

- `Kotlin` 에서의 `식`과 `문`은 차이가 있다.
    - `문`은 `효과를 발생`시키지만 결과를 내놓지 않는다.
    - `식`은 항상 `결과`를 만들어낸다.

- `식`은 값을 돌려주기 때문에 `결과값`을 `변수`에 `대입`하거나 `다른 식`의 `일부분`으로 쓸 수 있다.
    - `문`은 `다른 식`의 `일부분`이 되거나 `변수`에 `대입`할 수 없는 `최상위 요소`다.
- 모든 `함수 호출` 코드는 `식`이다.
    - `Unit`을 반환하는 함수라도, `Unit`을 `변수`에 `대입`할 수 있기 때문에 `결과`를 만드는 `식`이다.

```kotlin
fun isBig(number: Int) = if (number > 100) "Big!!" else "Small!!"

fun findNumber(number: Int) = 
	when (number) {
          1 -> "ONE"
          2 -> "TWO"
          3 -> "THREE"
          else -> "It's Too Big Number!"
	}
```
