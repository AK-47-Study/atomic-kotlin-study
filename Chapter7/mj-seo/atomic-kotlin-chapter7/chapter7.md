## 😀 확장 람다

- `확장 람다`는 `확장 함수`와 비슷하다.
- 차이점이 있다면 `함수`가 아닌 `람다`라는 점이다.

```kotlin
// 일반적인 람다 형태다.
val va: (String, Int) -> String = { str, n -> 
  str.repeat(n) + str.repeat(n)
}

// 확장 함수 구문을 사용하는 확장 람다이다.
val vb: String.(Int) -> String = {
  this.repeat(it) + repeat(it)
}
```

- `확장 람다`는 확장을 호출하는 형태와 `전통적인 함수` 를 호출하는 형태로 `호출`이 가능하다.
- `일반 람다`는 `확장 형태`로 호출할 수 없다.

```kotlin
// 파라미터가 없는 확장 람다 정의가 가능하다.
val zero: Int.() -> Boolean = {}

// 확장 람다도 여러 개의 파라미터를 받을 수 있다.
val one: Int.(Int) -> Boolean = {}

val two: Int.(Int, Int) -> Boolean = {}
```

- `확장 람다`도 `파라미터`를 여러 개 받을 수 있다.

```kotlin
fun f1(lambda: (A, B) -> Int) = 
  lambda(A(), B())

// 함수의 파라미터로 확장 람다를 사용할 수 있다.
fun f2(lambda: A.(B) -> Int) = 
  A().lambda(B())
```

- `함수`의 `파라미터`로 확장 람다를 사용하는 경우가 더 일반적이다.

```kotlin
fun unitReturn(lambda: A.() -> Unit) = 
  A().lambda()

fun noUnitReturn(lambda: A.() -> String) = 
  A().lambda()

fun main() {
  
  // 확장 람다가 Unit을 반환하면 마지막 식의 값을 무시한다.
  unitReturn { 1 }
  unitReturn { }

  noUnitReturn { "Must return the proper type" }
  // Unit을 반환하는 경우가 아니라면 반드시 값을 리턴해야 한다 -> 컴파일 에러
  noUnitReturn { }
}
```

- `확장 람다`의 반환 타입이 `Unit`이면 람다 본문의 `마지막 식` 값을 무시한다.

```kotlin
fun String.transform1(
  n: Int, lambda: (String, Int) -> String
) = lambda(this, n)

fun String.transform2(
  n: Int, lambda: String.(Int) -> String
) = lambda(this, n)

val duplicate: String.(Int) -> String = {}

val alternate: String.(Int) -> String = {}

fun main() {
  // 일반 람다를 파라미터로 받는 위치에 확장 람다를 전달할 수도 있다.
  "hello".transform1(5, duplicate)
     .transform2(3, alternate)
}
```

- `일반 람다`를 `파라미터`로 받는 위치에 `확장 람다`를 전달할 수 있다.
    - 두 람다의 `파라미터`가 `호환`되어야 가능하다.

```kotlin
fun Int.d1(f: (Int) -> Int) = f(this) * 10

fun Int.d2(f: Int.() -> Int) = f() * 10

fun f1(n: Int) = n + 3

fun Int.f2() = this + 3

fun main() {
  74.d1(::f1)
  74.d2(::f1)

  74.d1(Int::f2)
  74.d2(Int::f2)
}
```

- `::`을 사용하면 확장 람다가 필요한 곳에 함수 참조를 넘길 수 있다.
- `확장 함수`에 대한 참조는 `확장 람다`와 `타입`이 같다.
    - `Int::f2`는 `Int.() → Int` 와 같다.

```kotlin
open class Base {
  open fun f() = 1
}

class Derived : Base() {
  override fun f() = 99
}

fun Base.g() = f()

fun Base.h(x1: Base.() -> Int) = xl()

fun main() {
  val b: Base() = Derived()
  
  // 일반 확장 함수와 확장 람다 모두에서 다형성이 동작한다.
  b.g()
  b.h { f() }
}
```

- `일반 확장 함수`와 `확장 람다` 모두에서 `다형성`이 동작한다.

```kotlin
fun exec(
  arg1: Int, arg2: Int,
  f: Int.(Int) -> Boolean
) = arg1.f(arg2)

fun main() {
  // 확장 람다 대신 익명 함수를 넘길 수 있다.
  exec(10, 2, fun Int.(d:Int): Boolean {
    return this % d == 0
  })
}
```

- `익명 확장 람다` 대신 `익명 확장 함수`를 넘겨줄 수 있다.

```kotlin
// StringBuilder 객체를 직접 생성하고 문자열을 만드는 함수
private fun messy(): String {
  val built = StringBuilder()

  built.append("ABCs: ")
  ('a'..'x').forEach { built.append(it) }

  return built.toString()
}

// buildString()은 자체적으로 StringBuilder 객체를 생성하고 toString을 호출해 문자열을 얻는다.
private fun clean() = buildString {
  append("ABCs: ")
  ('a'..'x').forEach { append(it) }
}
```

- `buildString()`을 사용하면 `built`라는 이름의 `변수`를 관리하고, `append()` 호출의 `수신 객체`를 직접 만드록 관리할 필요가 없고 `모든 코드`가 `간결`해진다.

## 🤨 영역 함수

- `영역 함수`는 객체의 이름을 사용하지 않아도 그 객체에 접근할 수 있는 `임시 영역`을 만들어준다.
- `영역 함수`는 오로지 코드를 더 간결하고 읽기 좋게 만들기 위해 존재한다.

영역 함수는 다섯 가지 종류가 있다.

- `let()`
- `run()`
- `with()`
- `apply()`
- `also()`

`람다`와 함께 쓰이며, 따로 `임포트` 할 필요는 없다.

`영역 함수`는 문맥 객체를 `it`로 다루는지 `this`로 다루는지와 `함수`가 어떤 값을 `반환`하는지에 따라 달라진다.

`with`는 나머지 네 함수와 `다른 호출 문법`을 사용하고 있다.

```kotlin
data class Tag(var n: Int = 0) {
  var s: String = ""
  fun increment() = ++n
}

fun main() {
  // let(): 객체를 'it'로 접근하고 람다의 마지막 식의 값을 반환
  Tag(1).let {
    it.s = "let: ${it.n}"
    it.increment()
  }

  // run(): 객체를 'this'로 접근하고 람다의 마지막 식을 반환
  Tag(3).run {
    s = "run: $n"
    increment()
  }

  // with(): 객체를 'this'로 접근하고 람다의 마지막 식을 반환
  with(Tag(4)) {
    s = "with: $n"
    increment()
  }
 
  // apply(): 객체를 'this'로 접근하고 변경된 객체를 다시 반환
  Tag(5).apply {
    s = "apply: $n"
    increment()
  }

  // also(): 객체를 'it'로 접근하고 변경된 객체를 다시 반환
  Tag(6).also {
    it.s = "also: ${it.n}"
    it.increment()
  }
}
```

- `let()`, `run()`, `with()`는 람다의 마지막 식을 반환한다.
    - `let()`은 객체를 `it` 키워드를 이용해 접근한다.
    - `run()`, `with()`는 객체를 `this`로 접근하고, `this`는 생략이 가능하다.
- `apply()`, `also()`는 변경된 객체를 다시 반환한다.
    - `apply()`는 객체를 `this`로 접근하고, `also()`는 `it` 키워드로 객체에 접근한다.

```kotlin
fun gets(): String? = 
  if (Random.nextBoolean()) "str!" else null

fun main() {
  // Safe-Call을 사용하면 영역 함수를 null이 될 수 있는 수신 객체에도 적용할 수 있다.
  gets()?.let {
    it.removeSuffix("!") + it.length
  }

  // Safe-Call을 활용할 수 없으므로 수신 객체 안에서 Null 검사를 수행할 수 밖에 없다.
  with(gets()) { this?.length() }
}
```

- `문맥 객체`에 대해 `Safe-Call`을 적용하면 영역에 들어가기에 앞서 `null 검사`를 수행한다.
- `Safe-Call`을 사용하지 않는다면 `영역 함수` 안에서 개별적으로 `null 검사`를 해야 한다.
- `with()`는 `Safe-Call`을 활용할 수 없기 때문에 `함수 영역` 안에서 `null 검사`를 해야 한다.
- `영역 함수`는 수신 객체가 `null` 이라면 전체 영역이 무시된다.

```kotlin
val functions = listOf(
  fun(name: String?) {
    // 영역 함수는 연쇄 호출에서 nullable 한 타입과 함께 쓸 수 있다.
    name
      ?.takeUnless { it.isBlank() }
      ?.let { trace("$it in let") }
  }
)
```

- `영역 함수`는 `연쇄 호출`이 가능하고, `nullable` 한 타입과 함께 쓸 수 있다.

```kotlin
fun nesting(s: String, i: Int): String = 
  with(s) {
    with(i) {
      toString()
    }
  } + 
  s.let {
    i.let {
      toString()
    }
  }
```

- `영역 함수`를 내포시키는 경우에는 `가독성`이 좋지 않다.
- 어떤 문맥에서 여러가지 `this`나 `it` 객체가 있을 수 있기 때문이다.

### 영역 함수와 인라인

`람다`를 인자로 전달하면 `람다 코드`를 `외부 객체`에 넣기 때문에 일반 `함수 호출`에 비해 실행 시점에 부가 비용이 발생한다.

`람다`가 주는 이점에 비하면 `부가 비용`은 큰 문제가 되지 않고, `JVM`은 부가 비용을 상쇄해줄 만한 최적화 기능이 있다.

`영역 함수`를 `inline`으로 만들면 모든 실행 시점 부가 비용을 없앨 수 있다.

`컴파일러`가 `inline 함수 호출`을 함수의 본문으로 `치환`하여, 함수의 모든 `파라미터`를 실제 제공된 인자로 바꿔주기 때문이다.

`인라인 함수`에 람다를 전달하는 경우에 `클래스`나 `객체`가 추가로 생기지 않는다는 장점이 있다.

이런 동작은 `인라인 함수`에 `람다 리터럴`을 바로 전달하는 경우에만 성립한다, 즉 `람다`를 `변수`에 담아서 전달하거나 `다른 함수`가 반환하는 `람다`를 전달하면 `람다`를 저장하기 위한 `객체`가 생긴다.

`일반적`으로 `inline`의 목적은 `함수 인자`로 전달되는 람다를 `인라이닝`하거나 `실체화한 제네릭스`를 정의하는 목적이 크다.

### Inline Function

```kotlin
// Kotlin 코드
fun doSomethingElse(lambda: () -> Unit) {
   println("Doing something else")
   lambda()
}

// 위의 Kotlin 코드를 Java로 디컴파일 했을때
public static final void doSomethingElse(Function0 lambda) {
  System.out.println("Doing something else");
  lambda.invoke();
}
```

- `일반 람다`를 사용하면, `람다식`을 위한 `객체`가 `생성`된다.

```kotlin
fun doSomething() {
  println("Before lambda")
  
  /*
  *  람다를 직접 넘겨주면 함수를 호출할때마다 새로운 객체를 생성해서
  *  넘겨준다는 문제가 있다.
  */
  doSomethingElse {
    println("Inside lambda")
  }

  println("After lambda")
}

// 위의 Kotlin 코드를 Java로 디컴파일 했을때
public static final void doSomething() {
   System.out.println("Before lambda");
   doSomethingElse(new Function() {
       public final void invoke() {
         System.out.println("Inside lambda")
       }
   })
}
```

- `doSomething()` 함수를 호출할 때마다 `새로운 람다 객체`가 `생성`된다는 문제가 있다.

```kotlin
inline fun doSomethingElse(lambda: () -> Unit) {
  println("Doing something else")
  lambda()
}

public static final void doSomething() {
   System.out.println("Before lambda")
   System.out.println("Doing something else")
   System.out.println("Inside lambda")
   System.out.println("After lambda")
}
```

- `inline 함수`를 사용하면 `객체`를 항상 새로 만들지 않고, 해당 함수의 내용을 호출한 함수에 넣는 방식으로 `컴파일`하여 `최적화`를 수행한다.
- 만약 `람다`에 `파라미터`가 있는 경우에는, 메모리 절약에 더 도움이 된다.

### Inline Function은 만능인가?

- `JVM`의 `JIT 컴파일러`에 의해서 일반 함수들은 `inline 함수`를 사용했을 때 더 좋다고 판단되면 자동으로 만들어준다.
- `public inline 함수`는 `private 함수`에 접근할 수 없다는 한계점도 있고, `inline 함수`를 사용하면 안좋은 경우도 있을 수 있다.
- `inline 함수`를 사용하면 `inline 함수`가 호출되는 부분에 `함수 코드` 전체가 추가되므로, 바이트 코드의 양이 늘어나게 되는 단점을 가지면서, `함수`에 해당하는 객체를 만들지 않아 `메모리`를 아낄 수 있다는 장점도 공존한다.
- `inline 함수`는 `Function` 구현 객체가 만들어지지 않기 때문에 `다른 함수의 인자`에 전달 자체가 될 수 없다.

## 🙄 제네릭스 만들기

- `제네릭스`는 나중에 지정할 타입에 대해 작동하는 `코드`를 말한다.
- `다형적인 함수`의 파라미터에 맞는 객체를 만들기 위해서는 `클래스 계층`을 `상속`해아 하는데, `다형성`을 활용하는 경우 `단일 계층`만 가능하다는 점은 너무 큰 제약이 될 수 있다.

### Any - 코틀린 클래스 계층의 뿌리

- `Any`는 코틀린 클래스 계층의 루트다.
    - 모든 `코틀린 클래스`는 `Any`를 상위 클래스로 가진다.

- `Any` 타입을 `파라미터`로 받아서 다운 캐스트를 하는 방법도 있지만, 타입을 변환할 때 잘못된 타입을 지정하면 `런타임 오류`가 발생할 가능성이 존재한다.

```kotlin
class Person {
  fun speak() = "Hi!"
}

class Dog {
  fun bark() = "Ruff!"
}

fun talk(speaker: Any) = when (speaker) {
  is Person -> speaker.speak()
  is Dog -> speaker.bark()
  else -> "Not a talker"
}
```

- `새로운 타입`을 추가할 때마다 `talk()` 함수를 변경해야 하고, 변경하지 않으면 실행 시점의 정보에 의존해야 문제를 찾을 수 있다는 `단점`이 있다.

```kotlin
fun <T> gFunction(arg: T): T = arg

class GClass<T>(val x: T) {
  fun f(): T = x
}

class GMemberFunction {
  fun <T> f(arg: T): T = arg
}

interface GInterface<T> {
  val x: T
  fun f(): T
}
```

- `제네릭 파라미터 T`는 정해지지 않은 타입을 표현한다.
- `제네릭`을 호출하는 코드는 `타입 추론`이 가능하다.
    - `제네릭`이나 `제네릭`을 호출하는 코드가 너무 복잡해서 `컴파일러`가 타입 추론을 하지 못하는 경우에는 직접 명시해 주어야 한다.

### 타입 정보 보존하기

- `제네릭 클래스`나 `제네릭 함수`의 내부 코드는 `T 타입`에 대해 알 수 없다.
- `타입 소거`를 통해 반환값이 원하는 타입인지 명시적으로 `검사`하고 `변환`할 필요가 없어진다.

```kotlin
open class Create<T>(private var contents: T) {
  fun put(item: T) { contents = item }
  fun get(): T = contents
}

fun main() {
  val cc = Create(Car())
  val car: Car = cc.get()
}
```

- `Create<T>`는 T 타입만 `put()`으로 넣을 수 있도록 보장하고, `get()`을 호출하면 `T 타입`의 값이 결과로 나오도록 보장한다.

```kotlin
fun <T, R> Create<T>.map(f: (T) -> R): List<R> = 
  listOf(f(get())
```

- `제네릭 확장 함수`를 이용하면 `map()`과 같은 변환 함수를 정의할 수 있다.

### 타입 파라미터 제약

- `타입 파라미터 제약`은 제네릭 타입 인자가 `다른 클래스`를 `상속`해야 한다고 지정한다.
- `<T : Base>`는 T가 `Base` 타입이나 `Base`에서 파생된 타입이어야 한다는 뜻이다.

```kotlin
fun <T: Disposable> nameOf(disposable: T) = 
   disposable.name

fun <T: Disposable> T.name() = name
```

- `nameOf()` 함수는 `Disposable`과 그 `하위 타입`을 `파라미터`로 받을 수 있다.

```kotlin
fun nameOf2(disposable Disposable) = 
   disposable.name

fun Disposable.name2() = name
```

- `제네릭스`을 사용하지 않아도 같은 결과를 만들어 낼 수 있지만, `다형성`을 사용하면 `반환 타입`을 기반 타입으로 `업캐스트`해 반환해야 하지만, `제네릭스`를 사용하면 `정확한 타입`을 지정할 수 있다.

```kotlin
fun List<Disposable>.aRandom(): Disposable = 
  this[rnd.nextInt(size)]

fun <T: Disposable> List<T>.bRandom(): T = 
  this[rnd.nextInd(size)]
```

`타입 파라미터` 제약이 필요한 경우는 두 가지가 모두 필요할 때 뿐이다.

- 타입 파라미터 안에 선언된 `함수`나 `프로퍼티`에 접근해야 한다.
- `결과`를 반환할 때 `타입`을 `유지`해야 한다.

```kotlin
// 제약이 없어서 action()에 접근할 수 없다.
fun <T> List<T>.noAccess(): T {
  val d: T = this[rnd.nextInt(size)]
  // d.action()
  return d
}

// action()에 접근하고 정확한 타입을 반환한다.
fun <T: Disposable> List<T>.both(): T {
  val d: T = this[rnd.nextInt(size)]
  d.action()
  return d
}
```

- `T`에 제약을 가한 `both()` 에서만 `action()`에 접근하면서 `정확한 타입`을 반환할 수 있다.

### 타입 소거

`코틀린`은 `자바`와의 호환성을 유지하기 위해 `타입 소거`를 받아들이기로 결정했다.

최초의 자바에서 `제네릭`이 포함되어 있지 않은 상태로 코드들이 작성되어, `제네릭스` 도입시 기존 코드를 깨지 않는 `절충점`이 필요했는데, 그 `절충점`이 `타입 소거`다.

`코틀린 설계자`들이 타입 소거를 사용하기로 결정한 이유는 두 가지다.

- `자바 호환성`을 유지한다.
- `타입 정보`를 유지하려면 `부가 비용`이 든다.
    - 제네릭 타입 정보를 저장하면 제네릭을 사용하는 `List`나 `Map`이 차지하는 메모리가 상당히 늘어난다.

### 함수의 타입 인자에 대한 실체화

`제네릭 함수`를 호출할 때도 `타입 정보`가 소거된다.

`함수 인자`의 `타입 정보`를 보존하려면 `reified 키워드`를 추가해야 한다.

```kotlin
// 실행 시점에 T의 정보가 지워지기 때문에, 타입 정보를 전달해 해결해야 한다.
fun <T: Any> a(kClass: KClass<T>) = a(kClass)

// reified 키워드를 활용하면 제네릭 파라미터를 이용할 수 있다.
inline fun <reified T: Any> d() = a(T::class)

val kd = d<K>()
```

- `컴파일러`가 `T`의 타입을 알고 넘겨줄 수 있는데, 명시적으로 `타입 정보`를 전달하는 것은 불필요한 중복이다.
- `reified 키워드`를 활용하면 `제네릭 타입 파라미터`를 이용할 수 있다.
    - `reified`를 사용하기 위해서는 `제네릭 함수`를 `inline`으로 선언해야 한다.
    

```kotlin
inline fun <reified T> check(t: Any) = t is T

fun main() {
  check<String>("1")    // true
  check<Int>(1)         // false
}
```

- `실체화`를 사용하면 `is`로 제네릭 파라미터 타입을 `검사`할 수 있다.

```kotlin
inline fun <reified T : Disposable> select() = 
  items.filterIsInstance<T>().map { it.name }
```

- `실체화`를 응용하면 특정 하위 타입 `Disposable` 원소의 이름을 반환하는 함수를 만들 수도 있다.

### 타입 변성

`T`와 `U` 사이에 `상속 관계`가 있을 때, `Container` 타입을 어떤 식으로 쓸지에 따라 `Container`의 타입 파라미터에 `in` 또는 `out` 변성 애너테이션을 붙여서 `상하위 타입 관계`를 제한할 수 있다.

```kotlin
class Box<T>(private var contents: T) {
  fun put(item: T) { contents = item }
  fun get(): T = contents
}

class InBox<in T>(private var contents: T) {
  fun put(item: T) { contents = item }
}

class OutBox<out T>(private var contents: T) {
  fun get(): T = contents
}
```

- `in T`는 `T` 객체를 집어넣을 수는 있어도, `T` 객체가 나올 수는 없다.
- `out T`는 `T` 객체가 나올 수는 있어도, 집어넣을 수는 없다.

### 무공변 vs 공변 vs 반공변

`무공변`

- `Box<Cat>`과 `Box<Pet>` 사이에 아무런 하위 타입 관계가 없다.
    - 둘 중 어느 쪽도 반대쪽에 대입될 수 없다.

`공변`

- `OutBox<out T>`는 `OutBox<Cat>`을 `OutBox<Pet>`으로 업캐스트하는 방향이 `Cat`을 `Pet`으로 업캐스트 하는 방향과 같은 방향으로 변한다.

`반공변`

- `InBox<Pet>`이 `InBox<Cat>`의 하위 타입인 것을 말한다.
    - `InBox<Pet>`을 `InBox<Cat>`으로 업캐스트하는 방향이 `Cat`을 `Pet`으로 업캐스트 하는 방향과 반대 방향으로 변하기 때문에 `반공변` 이라 표현한다.
    - `Java`의 `하한 경계 와일드 카드` 개념과 같다고 볼 수 있다.

![image](https://github.com/AK-47-Study/atomic-kotlin-study/assets/91787050/a190d704-8131-4e85-b8da-668dd2ea819b)


`함수`는 `공변`적인 반환 타입을 가진다.

```kotlin
interface Parent
interface Child : Parent

interface X {
  fun f(): Parent
}

interface Y : X {
  override fun f(): Child
}
```

- `Y`에서 오버라이드하는 `f()`가 `Child`를 반환하지만 `X`의 `f()`는 `Parent`를 반환한다.
- `오버라이드`하는 함수가 `오버라이드` 대상 함수보다 더 구체적인 `반환 타입`을 돌려줘도 된다.

## 🫢 연산자 오버로딩

- `연산자 오버로딩`은 새로만든 타입에 대해 연산자에 의미를 부여하거나 `추가`로 `의미`를 부여할 수 있다.
- `Kotlin`은 우리에게 익숙한 연산자만 `오버로딩`을 지원하고, `연산자의 우선순위`도 바꿀 수 없게 함으로서 이 기능을 남용하는 것을 방지했다.

```kotlin
data class Num(val n: Int)

// 연산자를 오버로딩 하려면 operator 키워드를 이용한다.
operator fun Num.plus(rval: Num) = 
  Num(n + rval.n)
```

- `연산자`를 오버로딩 하려면 `fun 키워드` 앞에 `operator`를 붙여야 한다.
- `+ 연산자`에 대한 특별 함수는 `plus()`인데, `함수 이름`으로는 `연산자`에 따라 미리 정해진 특별한 이름만 쓸 수 있다.

```kotlin
data class Num2(private val n: Int) {
  operator fun plus(rval: Num2) = Num2(n + rval.n)
}
```

- `연산자`를 확장 함수로 정의하면 클래스의 `private 멤버`를 볼 수 없지만, `멤버 함수`로 정의하면 private 멤버에 접근이 가능하다.

### 동등성

- `==(동등성)`과 `≠(비동등성)`은 `equals()` 멤버  함수를 호출해준다.
- `data 클래스`는 자동으로 저장된 모든 필드를 서로 비교하는 `equals()`를 오버라이드 해준다.

```kotlin
class E(var v: Int) {
  override fun equals(other: Any?) = when {
    this === other -> true
    other !is E -> false
    else -> v == other.v
  }
}
```

- `===(삼중 등호)` 기호는 `참조 동등성`을 검사한다.
    - `참조 동등성`이란 메모리에서 같은 객체를 가리키는지 여부를 뜻한다.

```kotlin
fun equalsWithElvis(a: E?, b: E?) = 
  a?.equals(b) ?: (b === null)
```

- `nullable` 한 객체를 `==`로 비교하면 코틀린은 `null 검사`를 강제한다.
    - `if` 나 `엘비스 연산자`를 통해 `null 검사`를 할 수 있다.
    

### 산술 연산자 오버로딩

- `기본 산술 연산자`를 `확장`으로 정의하는 것도 가능하다.

```kotlin
// 단항 연산자 -> 부호 반전 또는 논리 연산(+, -, !)
operator fun E.unaryPlus() {}
operator fun E.unaryMinus() {}
operator fun E.not() {}

// 증감 연산자(++, --)
operator fun E.inc() {}
operator fun E.dec() {}

// 2항 연산자(+, -, *, %, /)
operator fun E.plus(e: E) {}
operator fun E.minus(e: E) {}
// 곱하기 연산
operator fun E.times(e: E) {}
operator fun E.div(e: E) {}
// 나머지 연산
operator fun E.rem(e: E)

// 복합 대입 연산자(+=, -=, *=, /=, %=)
operator fun E.plusAssign(e: E) {}
operator fun E.minusAssign(e: E) {}
operator fun E.timesAssign(e: E) {}
operator fun E.divAssign(e: E) {}
operator fun E.remAssign(e: E) {}
```

### 비교 연산자 오버로딩

- `compareTo()`를 정의하면 모든 `비교 연산자`를 쓸 수 있다.

```kotlin
operator fun E.compareTo(e: E): Int = 
  v.compareTo(e.v)
```

### 범위와 컨테이너

- `rangeTo()`는 범위를 생성하는 `..연산자`를 `오버로드` 한다.
- `contains()`는 값이 범위 안에 들어가는지 여부를 알려주는 `in 연산`을 `오버로드`한다.

```kotlin
operator fun E.rangeTo(e: E) = R(v..e.v)

operator R.contains(e: E): Boolean = 
  e.v in r
```

### 컨테이너 원소 접근

- `get()`과 `set()`은 `각괄호([])`를 사용해 컨테이너의 원소를 `읽고 쓰는 연산`을 정의한다.

```kotlin
data class C(val c: MutableList<Int>) {
  override fun toString() = "C($c)"
}

operator fun C.contains(e: E) = e.v in c

operator fun C.get(i: Int): E = E(c[i])

operator fun C.set(i: Int, e: E) {
  c[i] = e.v
}
```

- `IDE`에서 연산자를 클릭하면 어떤 함수가 `실행`되는지 `정의`를 볼 수 있다.

### 호출 연산자

- `객체 참조` 뒤에 괄호를 넣으면 `invoke()`를 호출한다.
- `invoke()` 연산자는 객체가 함수처럼 작동하게 만든다.

```kotlin
class Func {
  operator fun invoke() = "invoke()"
  operator fun invoke(i: Int) = "invoke($i)"
}

fun main() {
  val f = Func()
  f()      // -> invoke()
  f(22)    // -> invoke(22)
}
```

### 역작은따옴표로 감싼 함수 이름

- `코틀린`은 함수 이름을 `역작은 따옴표`로 감싸는 경우, 함수 이름에 `공백`, 몇몇 `비표준 글자`, `예약어` 등을 사용하는 것을 허용한다.

```kotlin
fun `A long name with spaces`() = Unit

fun `*how* is this working?`() = Unit

fun `'when' is a keyword`() = Unit
```

- `단위 테스트`에서는 테스트에 대해 자세히 설명하는 읽기 쉬운 이름의 `테스트 함수`를 정의할 수 있으므로 이런 기능이 특히 유용하게 쓰인다.

`연산자 오버로딩`을 함에 있어서, `프로그램`의 의미를 이해하기 어렵도록 `연산자`를 정의하지 않도록 주의해서 취급해야 한다.
