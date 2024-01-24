# CHAPTER 6

## 예외 처리

> 실패는 항상 일어날 수 있는 일이다.
>

전부터 프로그램에서 `실패`는 프로그램이 `멈추`거나, `데이터가 손실`되거나, 심지어 `운영체제가 중단`될 가능성을 가지고 있었다.

그래서 오류 처리를 개선하는 것은 `코드의 신뢰성`을 높이는 아주 좋은 방법이다.

최근 애플리케이션은 `동시성`을 자주 사용해 오류가 발생했을 때 동작을 멈추지 않고 `계속 실행`되어야 한다.

예외 처리는 `오류 보고`, `복구`, `자원 해제`를 합친 활동이다.

**`오류 보고`**

예외를 더 구체적으로 처리하기 위해 `Exception` 이나 `Exception의 하위` 타입을 상속한 새 예외 타입을 정의할 수 있다.

```kotlin

class Exception1(
    val value: Int
) : Exception("wrong value : $value")

open class Exception2(
    description: String
) : Exception(description)

class Exception3(
    description: String
): Exception2(description)

fun main() {
    capture {
        throw Exception1(13)
    }eq "Exception1 : wrong value: 13"

    capture {
        throw Exception3("error")
    }eq "Exception3 : error"
}
```

`복구`

예외 처리 목표는 `복구`다.

복구는 문제를 해결하고 `프로그램`을 안정적인 상태로 되돌린 후 `실행을 계속`하며, 오류정보를 `로깅`하는 과정이 포함된다.

```kotlin
fun function1(): Int =
    throw Exception1(-52)

fun function2() = function1()

fun function3() = function2()

fun main() {
    function3() // 예외 터짐
}
```

- 예외를 `잡아낼 핸들러`를 찾으면 `핸들러 검색`이 끝나고 `핸들러가 실행`.
- 프로그램이 `일치하는 핸들러`를 찾지 못하면 콘솔에 `스택 트레이스`를 출력 후 종료.

```kotlin
fun toss(which : Int) = when(which){
    1 -> throw Exception1(1)
    2 -> throw Exception2("Exception2")
    3 -> throw Exception3("Exception3")
    else -> "OK"
}

fun test(which: Int): Any? =
    try {
        toss(which)
    } catch (e: Exception1) {
        e.value
    } catch (e: Exception3) {
        e.message
    } catch (e: Exception2) {
        e.message
    }

fun main() {
    test(0) eq  "OK"
    test(1) eq 1
    test(2) eq "Exception2"
    test(3) eq "Exception3"
}
```

- 예외를 `catch`해 처리 후 프로그램이 `예외로 중단`되지 않게 막을 수 있다.

`예외 하위 타입`

```kotlin
class IncorrectInputException(
    message: String
): Exception(message)

fun checkCode(code: Int){
    if (code <= 1000){
        throw IncorrectInputException(
            "Code must be > 1000: $code"
        )
    }
}

fun main() {
    try {
        checkCode("A1".toInt(16))
    }catch (e: IncorrectInputException  ) {
        e.message eq "Code must be > 1000: 161"
    }catch (e : IllegalArgumentException){
        "Produces error" eq "if it get here"
    }

    try {
        checkCode("1".toInt(1))
    }catch (e: IncorrectInputException) {
        "Produces error" eq "if it gets here"
    }catch (e : IllegalArgumentException){
        e.message eq
                "radix 1 was not in valid range 2..36"
    }
}
```

- 다른 상황에서의 예외를 `같은 예외로 처리`하면 안된다.

`자원 해제`

`finally`는 예외를 처리하는 과정에서 `자원을 해제`할 수 있게 보장하고, `try 블록`이 정상적으로 끝났거나 예외가 발생했는지와 관계없이 `항상 실행`된다.

`Atomic Test의 예외 처리`

`capture()` 는 함수를 인자로 받아 실행 → 오류 발생 시 `CapturedException 객체` 리턴

```kotlin
fun capture(f:() -> Unit): CapturedException =
    try {
        f()
        CapturedException(null,
            "<Error> : Expected an exception")
    }catch (e: Throwable){
        CapturedException(e::class,
        if (e.message != null) "${e.message}"
        else "")
    }

fun main() {
    capture {
        throw Exception("!!!")
    } eq "Exception: !!!"
    capture {
        1
    } eq "<Error> : Expected an exception"
}
```

`가이드라인`

`코틀린 예외`의 주목적은 프로그램 버그를 발견하는 것이지 `예외 복구가 아니다` → 예외를 잡아내는 부분이 있다면 `코드 스멜`

- 논리 오류
    - 코드에 있는 `버그`이며, 버그의 예외를 전혀 잡지 않거나 애플리케이션의 `최상위 수준`에서 예외를 잡고 `버그를 보고`.
- 데이터 오류
    - 제어할 수 없는 잘못된 데이터에 의해 생긴 `오류`이며, 애플리케이션은 프로그램 로직을 탓하지 않고 `오류를 처리`해야한다.
- 검사 명령
    - `논리 오류`를 검사, 버그를 찾으면 예외를 발생 시키지만 `함수 호출`처럼 보여 명시적으로 예외를 던질 필요가 없어진다.
- 입출력 오류
    - 제어할 수 없는 외부 조건이지만, `무시해서는 안되는 오류`.

## 검사 명령

> 검사 명령은 만족시켜야 하는 제약 조건을 적은 단언문이다. 보통 함수 인자와 결과를 검증할 때 검사 명령을 사용한다.
>

검사 명령은 일반적으로 `실패 시 오류`를 던지며, `요구 조건`을 생각하기도 쉬워지고, 작성된 코드를 이해하기도 `수월`해진다.

`require ()`

보통 함수 인자를 검증하기 위해 사용되며, `인자 검증`이나 `사전 조건 검증`을 `컴파일 시점`에 할 수는 없다.

```kotlin
data class Month(val monthNumber: Int) {
    init {
        require(monthNumber in 1..12){
            "Month out of range : $monthNumber"
        }
    }
}

fun main() {
    Month(1) eq "Month(monthNumber=1)"
    capture { Month(13) } eq
            "IllegalArgumentException : " +
            "Month out of range : 13"
}
```

- `require()` 를 생성자 안에서 호출.
- 조건을 만족하지 못하면 IllegalArgumentException 리턴.

`requrieNotNull ()`

첫 번째 인자가 `null인지 검사`해 널이 아니면 그 값을 돌려준다 → 널이라면 `IllegalArgumentException 발생`

성공 → 자동으로 널이 아닌 타입으로 `스마트 캐스트`

```kotlin
fun notNull(n: Int?) : Int{
    requireNotNull(n) {
        "notNull() argument cannot be null"
    }
    return n * 9
}

fun main() {
    val n: Int? = null
    capture { 
        notNull(n)
    } eq "IllegalArgumentException: " +
            "notNull() argument cannot be null"
    capture {
        requireNotNull(n)
    } eq "IllegalArgumentException: " +
            "Required value was null."
    notNull(11) eq 99
}
```

`check ()`

- require() 와 `동일`하지만 `IllegalStateException`을 던진다는 차이.
- 함수의 맨 끝에서 함수 결과가 `올바른자 검증`.

```kotlin
val resultFile = DataFile("Results.txt")

fun createResultFile(create: Boolean) {
    if (create)
        resultFile.writeText("Results\n# ok")
    check(resultFile.exists()){
        "${resultFile.name} doesn't exits!"
    }
}

fun main() {
    resultFile.erase()
    capture {
        createResultFile(false)
    } eq "IllegalStateException: "+
            "Results.txt doesn't exist!"
    createResultFile(true)
}
```

사전 조건 인자가 제대로 들어왔다고 가정 후 사후 조건이 실패한다는 건 `프로그래밍 실수`가 있다는 의미

- 성능에 미치는 영향을 최소화하기 위해 `사후 조건`을 `주석으로 처리`하거나 제거할 수 있다.
- 이런 검사를 제 위치에 남겨 추후에 코드를 변경해 발생하는 `문제를 즉시 감지`할 수 있게 하는 것은 좋은 방법.
- 남겨두는 방법 중 하나는 `사후 조건 검사`를 `단위 테스트`로 옮기는 것

`assert ()`

`check ()` 문을 주석 처리했다가 해제하는 수고를 덜기 위해 사용

특별한 설정 없이 사용 가능한 `require()` 과 `check()` 를 사용하는 것이 좋다.

## Nothing 타입

> `Nothing`은 함수가 결코 반환되지 않는다는 사실을 표현하는 반환 타입이다.
>

항상 예외를 던지는 함수의 반환 타입이 `Nothing`.

`코틀린 컴파일러`가 함수 본문이 항상 예외를 던진다는 사실이나 `항상 루프`를 돈다는 사실을 추론할 수는 있지만 `모든 추론이 가능한 것은 아니다`.

```kotlin
fun later(s: String) : Int = TODO("later()")

fun later2(s: String) : Int = TODO()

fun main() {
    capture {
        later("Hello")
    } eq "NotImplementedError: " +
            "An operation is not implemented: later()"
    capture {
        later2("Hello!")
    } eq "NotImplementedError: " +
            "An operation is not implemented."
}
```

- `TODO()` 는 Nothing을 `반환`
- `later()` 와 `later2()` 는 모두 Nothing이 아닌 `타입 반환`
- `Nothing`은 모든 타입과 호환 가능.

```kotlin
fun fail(i: Int): Nothing =
    throw Exception("fail($i)")

fun main() {
    capture {
        fail(1)
    } eq "Exception: fail(1)"
    capture {
        fail(2)
    } eq "Exception: fail(2)"
}
```

- `fail()` 은 항상 예외를 던지기 때문에 `Nothing`을 반환.
- `fail()` 사용하면 오류 처리 전략을 쉽게 변경 가능.

```kotlin
fun main() {
    val none: Nothing? = null

    var nullableString: String? = null //
    nullableString = "abc"
    nullableString = none
    nullableString eq null

    val nullableInt: Int? = none
    nullableInt eq null 

    val listNone: List<Nothing?> = listOf(null) //
    val ints: List<Int?> = listOf(null)
    ints eq listNone
}
```

- 널이 될 수 있는 타입의 `var` 나 `val` 에 대입할 수 있다.
- null과 none의 타입이 모두 `Nothing?`이므로 대입 가능
- `null 값`만 들어있는 `List`는 컴파일러가 `<Nothing?>` 이라고 추론
- → `null`만 들어 있는 `List`로 초기화하고 싶을 때는 원소의 타입을 `명시`해야 한다.

## 자원 해제

> `try-finally 블록`을 써서 자원을 정리하는 과정은 지루하고 실수를 저지르기 쉽다. `코틀린 라이브러리 함수`는 여러분을 대신해 자원을 `정의`해준다.
>

`finally 절`에서 자원을 해제해 닫는 도중에 예외가 발생한다면 `다른 try 블록`이 필요해진다.

→ 나중에 발생한 예외가 최초에 발생했던 `예외를 감춰서는 안되니` 제대로 자원을 해제하는 `과정이 지저분`해진다.

→ 이런 복잡도를 낮추기 위해 코틀린이 제공하는 `use 함수`는 자원을 제대로 해제

```kotlin
fun main() {
    DataFile("Results.txt")
        .bufferedReader()
        .use { it.readLines().first() } eq
            "Results"
}
```

- `use()`는 자바의 `AutoCloseable 인터페이스`를 구현하는 모든 객체에 작용
- 인자로 받은 코드 블록을 실행하고, 블록을 어떻게 빠져나왔는지 `관계없이` 객체의 `close()` 호출
- 모든 예외를 다시 던져주기 때문에 프로그램에서는 여전히 예외를 처리해야 한다.

```kotlin
class Usable(): AutoCloseable {
    fun func() = trace("func()")
    override fun close() = trace("close()")
}

fun main() {
    Usable().use { it.func() }
    trace eq "func() close()"
}
```

- `use()` 를 사용해 자원을 생성하는 시점에 자원 해제를 `확실히 보장`.
- `자원 사용을 끝낸 시점`에 직접 자원 해제 코드를 `작성할 필요도 없`다.

## `로깅`

> `로깅`은 실행중인 프로그램에서 정보를 얻는 행위이다.
>

`로깅`을 사용해 동적으로 기능을 켜고, 필요 없을 때 기능을 끌 수 있고, 디버깅을 할 때 유용.

- `trace()`, `debug()`, `info()` 는 동작에 대한 정보 기록.
- `warn()`과 `error()`는 문제가 발생했다는 사실 표시.
- `디폴트 설정`이 `trace`와 `debug` 수준을 표시하지 않도록 되어 있어 아무것도 출력하지 않는다.
- 보고 수준을 변경 하려면 `로깅 설정 변경 필요`.

## 단위 테스트

> 단위 테스트는 함수의 여러 측면에 대해 올바른지 검증하는 테스트를 작성하는 방법이다. 단위 테스트를 사용하면 망가진 코드가 빠르게 드러나고 개발 속도가 향상된다.
>

단위 테스트는 프로그래머가 작성해 프로젝트를 `빌드`할 때마다 `실행`되며, 자주 실행되기네 실행속도가 빨라야한다.

- 단언문 함수로 실제 값과 예상값을 비교하는 `assertEquals()`
- `첫 번째 파라미터`로 들어온 `Boolean 식`이 참인지 검증하는 `assertTrue()`

### 테스트 `프레임워크`

단언문 함수와 테스트를 실행하고 결과를 표시하기 위한 `메커니즘`으로 이뤄진다.

단언문은 기반 `테스트 프레임워크`의 적절한 함수에 처리를 위임.

코드

- @Test 를 @org.junit.jupiter.api로 치환해 컴파일하라고 `컴파일에 명령`.
- 각 단위 테스트는 `한 가지 동작만`을 검증해야한다.
- @Test 함수 3가지 방법 실행 가능
    - 독립적 실행
    - 클래스의 일부분 실행
    - 애플리케이션에 정의된 모드 테스트와 함께 실행

### 모킹과 통합 테스트

실제 구성 요소를 의존 괸계에 추가하는 대신 `모킹` 에 의존하곤 한다.

`Mock`은 테스트를 실행하는 동안 실물을 대신하는 가짜이며, 저장된 `데이터의 무결성`을 유지하기 위해 데이터베이스를 `모킹`하는 경우가 많다.