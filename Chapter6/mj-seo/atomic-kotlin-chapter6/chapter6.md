## 😀 예외 처리

- `컴파일 시점`에 감지할 수 없는 `오류`는 `실행 시점`에 처리해야 한다.
- `예외 처리`는 다음 세 가지 활동을 합친 것과 같다.
    - 오류 보고
    - 복구
    - 자원 해제
    

### 오류 보고

- `표준 라이브러리`의 `예외`로 충분하지 못한 경우가 자주 있는데, `예외`를 구체적으로 처리하기 위해서 `Exception`이나 `Exception`의 하위 타입을 상속한 `CustomException`을 정의할 수 있다.

```kotlin
class CustomException(
   val value: Int
) : Exception("wrong value: $value")

fun main() {
  capture {
    // throw 식은 Throwable의 하위 타입을 요구한다.
    throw Exception(13)
  }
}
```

- `throw` 식은 `Throwable`의 하위 타입을 요구한다.
    - `Throwable`은 모든 예외의 최고 조상이며, `Error`의 `조상`이기도 하다.
    

### 복구

- `예외 처리`의 큰 목적은 `복구`이다.
- `프로그램`을 예외로 인해 종료되지 않고, `안정적인 상태`로 되돌린 후 실행을 `계속`하려는 목적이 있다.
- `예외`는 무조건 복구되는 것이 아니라, `복구`가 불가능한 경우도 아주 많다.
- `예외`가 던져지면 `예외 처리 메커니즘`이 예외를 처리하기에 적절한 위치를 찾는다.
    - 예외와 일치하는 `핸들러`를 찾으면 `예외`를 잡고, `예외를 처리할 핸들러`를 찾지 못하면 콘솔에 스택 트레이스를 `출력`하면서 `종료`된다.

```kotlin
fun function1(): Int = throw Exception(-52)

fun function2() = function1()

fun main() {
  // 예외를 처리할 핸들러가 없으므로 스택 트레이스가 출력된다.
  function3()
}
```

- `예외`를 처리하려면 `catch 키워드` 다음에 처리하려는 `예외의 목록`을 `나열`해야 한다.
    - 그 후 복구 과정을 구현하는 `코드`를 `작성`한다.

```kotlin
fun toss(which: Int) = when (which) {
  1 -> throw Exception1(1)
  2 -> throw Exception2("Exception 2")
  3 -> throw Exception3("Exception 3")
  else -> "OK"
}

fun test(which: Int): Any? = 
   try {
     toss(which)
   } catch (e: Exception1) {
     e.value
   } catch (e: Exception2) {
     e.message
   } catch (e: Exception3) {
     e.message
   }
```

- `예외`를 처리하는 여러 개의 `catch 블럭`이 있을 경우, `타입이 일치(상위, 하위)`할 경우 가장 먼저 만나는 `catch 블럭`이 `예외`를 `처리`한다.

### 예외 하위 타입

```kotlin
fun testCode(code: Int) {
  if (code <= 1000) {
    throw IllegalArgumentException(
       "'code' must be > 1000: $code")
    )
  }
}

fun main() {
   try {
     testCode("A1".toInt(16))
   } catch (e: IllegalArgumentException) {
     e.message
   }

   try {
     // testCode() 뿐만 아니라 toInt(radix)에 의해서도 IllegalArgumentException이 발생!
     testCode("0".toInt(1))
   } catch (e: IllegalArgumentException) {
     e.message
   }
}
```

- `testCode()`와 `toInt(radix)`는 모두 문제가 발생하면 `IllegalArgumentException`을 발생 시키기 때문에 사용자에게 `혼란`을 줄 수 있다.
- 따라서 `하위 예외 타입`을 정의해 다른 예외를 던지게 하면 `명확한 의미`를 `전달`할 수 있다.

```kotlin
class IncorrectInputException(
  message: String
) : Exception(message)

fun checkCode(code: Int) {
  if (code <= 1000) {
    throw IncorrectInputException(
       "'code' must be > 1000: $code")
    )
  }
}

fun main() {
   try {
     checkCode("A1".toInt(16))
   } catch (e: IncorrectInputException) {
     e.message
   } catch (e: IllegalArgumentException) {
     e.message
   }

   try {
     // testCode() 뿐만 아니라 toInt(radix)에 의해서도 IllegalArgumentException이 발생!
     checkCode("0".toInt(1))
   } catch (e: IncorrectInputException) {
     e.message
   } catch (e: IllegalArgumentException) {
     e.message
   }
}
```

- `하위 예외 타입`을 정의해 `명확한 메시지`를 `전달`하는 것도 중요하지만 그렇다고 해서 `너무 많은 예외 타입`을 만드는 것은 좋지 않다.
- `처리 방식`이 달라야 한다면, `다른 예외 타입`을 사용해 구분하고 처리 방법이 같은 경우에는 동일한 예외 타입을 사용하되 `생성자 인자`를 다르게 주는 방식으로 `구체적인 정보`를 `전달`하는 것이 좋다.

### 자원 해제

- `실패`를 피할 수 없을 때 `자원`을 자동으로 해제하게 만들면 `프로그램`의 다른 부분이 계속 안전하게 실행되도록 도움을 줄 수 있다.
- `finally`는 예외를  처리하는 과정에서 `자원`을 `해제`할 수 있게 보장한다. `finally` 블럭은  `예외 발생` 여부와 상관 없이 반드시 실행된다.
- `try` 문 또는 `catch` 문 안에서 `return`을 사용해도 `finally` 블럭은 `무조건 실행`된다.

```kotlin
fun checkValue(value: Int) {
  try {
    trace(value)
    if (value <= 0) 
       throw IllegalArgumentException("Not Good Value")
  } finally {
    // 예외가 발생했지만 반드시 실행됨을 보장한다.
    trace("In finally clause for $value")
  }
}
```

### Kotlin 예외 사용 가이드

- `논리 오류`: 논리 오류는 `코드에 있는 버그`다. 관련된 예외를 전혀 잡지 않거나, 애플리케이션의 최상위 수준에서 `예외`를 잡고 `버그`를 `보고`하는 것이 좋다.
- `데이터 오류`: 프로그래머가 `제어할 수 없는 잘못된 데이터`에 의해 생긴 오류는 예외를 던지지 않고, `orNull` 버전의 함수를 사용해 `대비`하는 것이 좋다.
- `검사 명령` : 검사 명령은 `논리 오류`를 검사하므로, `함수 호출`을 통해 `논리적 오류`를 검사할 수 있어 예외를 명시적으로 던질 필요가 없어진다.
- `입출력(I/O) 오류`: 입출력 오류는 복구할 수 있는 경우가 종종 있으므로, `애플리케이션`에서는 이런 예외를 처리하고 `복구`를 시도하는 `코드`가 필요하다.

## 😐 검사 명령

- `검사 명령`은 만족시켜야 하는 `제약 조건`을 적은 `단언문`이다.
- 보통 `함수 인자`와 결과를 `검증`할 `검사 명령`을 사용한다.

### `require()`

- `require()`는 보통 `함수 인자`를 `검증`하기 위해 사용된다.
- `함수 본문` 맨 앞에 위치하는 경우가 많다.

```kotlin
data class Month(val monthNunmber: Int) {
  init {
    /*
    *  require()는 조건을 만족하지 못할 경우 IllegalArgumentException을 던진다.
    *  require()의 두 번째 파라미터로 String을 만들어내는 람다를 제공하면 예외를 던지기 전까지
    *  문자열 생성 비용이 들지 않는다.
    */
    require(monthNumber in 1..12) {
       "Month out of range: $monthNumber"
    }
  }
}

fun singleArgRequire(arg: Int): Int {
  /*
  *  파라미터가 하나인 require() 함수도 있다.
  *  -> 실패 메시지가 파라미터 두 개인 경우보다 더 명확하지 않지만, 이 정도로도 충분한 경우도 있다.
  */
  require(arg > 5)
  return arg
}
```

### `requireNotNull()`

- `requireNotNull()`은 `첫 번째 인자`가 `null`인지 검사해 `null`이 아니면 그 값을 돌려준다.
- `첫 번째 인자`가 `null` 이라면 `IllegalArgumentException`을 발생시킨다.
- 성공한 경우 `requireNotNull()`의 인자는 자동으로 `null`이 아닌 `타입`으로 `스마트 캐스트` 된다.
- `requireNotNull()`역시 `파라미터`가 `한 개`인 버전과 `두 개`인 버전이 있는데 `특정 문제(null-check)`만 한다는 점에서 `파라미터`가 한 개인 버전이 더 유용하게 쓰인다.

```kotlin
fun notNull(n: Int?): Int {
  requireNotNull(n) {
    "notNull() argument cannot be null"
  }
  
  // requireNotNull() 검증이 성공하면 null이 아닌 타입으로 스마트 캐스트 된다.
  return n * 9
}
```

### `check()`

- `check()`는 `require()`와 동일하지만 `IllegalStateException`을 던진다는 차이가 있다.
- `check()`는 함수의 맨 끝에서 `함수 결과` 또는 `반환 값`이 올바른지 `검증`하기 위해 사용한다.

```kotlin
fun createResultFile(create: Boolean) {
  if (create)
    resultFile.writeText("Results\n# ok")
  
  check(resultFile.exists()) {
    "${resultFile.name} doesn't exist!"
  }
}
```

`사전 조건`이 인자가 제대로 들어왔다는 가정이 있어도, `사후 조건`이 `실패`할 수 있다.

따라서 항상 `프로그래밍 실수`가 있다는 뜻이다. 그러므로 `사후 조건`을 보게 되는 경우가 더 드물다.

`프로그래머`가 코드가 올바르다고 확신하면, `성능에 미치는 영향`을 `최소화`하기 위해 사후 조건을 주석으로 처리하거나 제거할 수 있기 때문이다.

그렇다고 하더라도, 검사를 `제 위치`에 남겨둬서 `미래`에 `코드를 변경`해 발생하는 문제를 즉시 감지할 수 있어야 하는데, 이런 문제는 `사후 조건 검사` 단위를 `단위 테스트`로 옮기는 것으로 `해결`할 수 있다.

### `assert()`

- `check()`문을 `주석` 처리했다가 삭제하는 수고를 덜기 위해 `assert()`를 `사용`할 수 있다.
- `assert()`는 프로그래머가 명령줄 플래그를 이용해 `활성화`할 수 있다.
- `assert()`는 자바에서 온 명령이고, 기본적으로 비활성화 되어 있으므로 `check()` 또는 `require()`를 사용하는 것이 좋다.

## 🫤 Nothing 타입

- `Nothing`은 함수가 결코 반환되지 않는다는 사실을 표현하는 `반환 타입`이다.
- `항상 예외를 던지는 함수`의 반환 타입이 `Nothing`이다.

```kotlin
// 무한 루프를 발생시키더라도 Unit이나 Int 타입으로 함수를 정의해도 컴파일 에러는 나지 않는다.
fun infinite(): Nothing {
  // 무한 루프를 발생시키는 함수이므로 이 함수는 결코 반환되지 않는다.
  while (true) {}
}
```

- `컴파일러`가 함수 본문을 분석했을때, `함수`가 예외를 던지지 않고 `정상적으로 실행`이 끝나거나 `루프`가 중간에 `종료`될 가능성이 있음을 발견한 경우 `함수의 반환 타입`을 `Nothing`으로 지정할 수 없다는 에러가 발생한다.

```kotlin
fun foo(): Nothing {
  while (true) {
    // 무한 루프에 걸리지 않고 루프가 중간에 종료될 가능성이 있다.
    if (Random.nextBoolean()) break
  }
}
```

### `TODO()`

- 내장 함수 `TODO()`는 항상 반환 타입이 `Nothing`이고, `NotImplementedError`를 던진다.
- `Nothing`은 모든 타입과 호환 가능하다(`Nothing은 모든 다른 타입의 하위 타입`으로 취급된다)
- `TODO()` 함수는 자세한 `세부 사항`을 채워 넣기 전에 모든 것이 맞아 떨어지는지 `검증`할 때 유용하다.

```kotlin
// Nothing은 모든 다른 타입의 하위 타입으로 취급 되므로, String의 하위 타입으로 취급된다.
fun later(s: String): String = TODO("later()")
```

`추가적인 타입 정보`가 없는 상태로 그냥 `null`이 주어지면 `컴파일러`가 `null`이 될 수 있는 `Nothing 타입`으로 추론한다.

```kotlin
// null 값만 들어있는 List로 초기화하면 Nothing? 타입으로 추론된다.
val listNone: List<Nothing?> = listOf(null)

// null이 될 수 있는 타입의 List의 정확한 초기 타입을 명시하려면 타입을 List이 타입을 명시해야 한다.
val listTyped: List<String?> = listOf(null)
```

## ☺️ 자원 해제

- `try-finally` 블럭을 써서 자원을 정리하는 과정은 `프로그래머`가 `실수`로 `누락`하기 쉽다.
- `코틀린 라이브러리 함수`를 사용해 대신 `자원`을 `정리`하는 것이 좋다.
- `use()` 함수는 닫을 수 있는 `자원`을 제대로 해제해주고, `자원 해제 코드`를 직접 작성하는 수고를 하지 않아도 되게 도와준다.
- `use()`는 자바의 `AutoCloseable` 인터페이스를 `구현`하는 `모든 객체`에 `적용`할 수 있다.
    - `return`을 포함하는 `정상적인 경로`나 예외와 관계 없이 객체의 `close()`를 호출해준다.
    - `use()`는 모든 예외를 다시 던져주기 때문에 `프로그램`이 `예외`를 `처리`해야 한다.

```kotlin
fun main() {
  DataFile("Results.txt")
    .bufferedReader()
    .use { it.readLines().first() } eq
    "Results"
}
```

### `useLines()` vs `forEachLine()`

### `useLines()`

- `useLines()`에 전달된 람다 내부에서 이뤄진다.
- `useLines()`는 파일을 닫고 `람다`가 `반환`하는 `결과`를 `반환`한다.

```kotlin
fun main() {
   // useLines()는 명시적으로 파일 내용을 반환하지 않는 한, 람다 밖에서는 파일 내용을 사용할 수 없다.
   DataFile("Results.txt").useLines {
     lines -> lines.filter { 
        line -> "#" in line   
     }.first()
  }
}
```

### `forEachLine()`

- `파일`의 `각 줄`에 대해 `작업`을 쉽게 적용할 수 있다.
- `forEachLine()`에 전달된 람다는 `Unit`을 반환한다.
- `람다` 안에서는 원하는 일을 `부수 효과`를 통해 달성해야 하기 때문에, 함수형에 가까운 함수는 `useLines()`이다.

```kotlin
fun main() {
   DataFile("Results.txt").forEachLine {
     if (it.startsWith("#")) {
        trace("$it")
     }
   }
}
```

### `AutoCloseable` 인터페이스

- `AutoCloseable` 인터페이스를 구현하면 `close()` 함수를 `오버라이드` 해야 한다.
- `use()`를 사용하면 `자원`을 생성하는 시점에 `자원 해제`를 확실히 `보장`할 수 있다.

```kotlin
class Usable() : AutoCloseable {
  fun func() = trace("func()")
  override fun close() = trace("close()")
}

fun main() {
  Usable().use { it.func() }
  trace eq "func() close()"
}
```

## 🫢 로깅(Logging)

- `로깅`은 실행 중인 프로그램에서 `정보`를 얻게 해준다.
- `로깅`을 사용하면 필요할 때 `동적`으로 기능을 켜고, 필요 없을 때 `기능`을 끌 수 있다.
- `로깅`은 `예외`가 발생하거나 문제가 생겼을때 `프로그래머`와 관리자에게 문제를 발견할 수 있는 `방법`을 제공한다.

```kotlin
// Kotlin-Logging 라이브러리는 SLF4J 위에 만든 퍼사드다.
private val log = KLogging().logger

fun main() {
  val msg = "Hello, Kotlin Logging!"

  log.trace(msg)
  log.debug(msg)
  log.info(msg)
  log.warn(msg)
  log.error(msg)
}
```

`로깅`은 `라이브러리 함수`를 호출하는 것만큼 단순하지 않다.

`실행 시점`에 `로깅`을 지원하기 위한 구성 요소가 상당히 많이 필요하며, `로깅`은 보통 사용자에게 배포되는 제품에 포함되어 있는 경우가 많다.

`서버`처럼 장기간 실행되어야 하는 프로그램의 경우 특히 `로그 파일`의 관리가 중요한데, `로그 파일`이 저장 장치를 가득 채우지 않도록 해주는 `전략`이 `포함`되어야 하기 때문이다.

## 😳 단위 테스트

- `단위 테스트`는 함수의 여러 측면에 대해 올바른지 `검증하는 테스트`를 작성하는 방법이다.
- `단위 테스트` 를 사용하면 `망가진 코드`가 빠르게 드러나고 `개발 속도`가 `향상`된다.

### 테스트 프레임워크

- `JVM` 기반의 `프로그래머`가 가장 애용하는 `테스트 프레임워크`는 `JUnit5`이다.
- `JUnit5`를 추가하려면 `build.gradle.kts`의 `dependencies`에 `관련 의존성`을 `추가`해야 한다.
- `@Test` 애너테이션은 `일반 함수`를 `테스트 함수`로 바꿔준다.

```kotlin
class SampleTest {
  @Test
  fun testFortyTwo() {
    expect(42, "Incorrect, ") { fortyTwo() }
  }
}
```

`테스트 클래스`는 보통 여러 `단위 테스트`를 포함하고 있고, `단위 테스트`는 `한 가지` 동작만을 검증하는 것이 이상적이다.

`한 가지 동작`만 검증해야 새 기능을 추가하고 `단위 테스트`가 실패했을 때 빠르게 `문제 원인`을 찾을 수 있기 때문이다.

```kotlin
class StateMachineTest {
  val sm = StateMachine()
  
  @Test
  fun start() {
    sm.start()
    assertEquals(State.On, sm.state)
  }

  @Test
  fun `pause and resume`() {
    sm.start()
    sm.pause()
    assertEquals(State.Paused, sm.state)
  }
}
```

- `코틀린`은 일반적으로 `함수 이름`에 `글자`와 `숫자`만 허용하지만, `함수 이름`을 백틱(`)으로 감싸면 이름에 아무 문자나 사용할 수 있다.
    - 이 기능을 이용하면 `테스트를 기술하는 문장`을 `함수 이름`으로 쓸 수 있다.
- `다른 요소`에 의존하는 시스템으로 인해 `격리된 테스트`를 만드는 것은 어렵다.
    - `실제 구성 요소`를 의존 관계에 추가하는 대신 `Mocking`을 의존하여 테스트한다.
    - `Mock`은 테스트를 실행하는 동안 `실물`을 대신하는 가짜이며, `저장된 데이터의 무결성`을 유지하기 위해 `데이터베이스`를 모킹하는 경우가 많다.
    - `MockK` 같은 모킹 라이브러리를 사용해 `Mock`을 만들 수도 있다.
- `단위 테스트`는 내부로 가는 테스트이고, `통합 테스트`는 밖으로 향하는 테스트이다.
