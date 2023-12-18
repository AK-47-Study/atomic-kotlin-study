## 😈 확장 함수

- `Kotlin` 확장 함수는 `기존 클래스`에 `멤버 함수`를 추가하는 것과 같은 효과를 낸다.
- 확장할 대상 타입은 `수신 객체 타입`이라고 한다.

```kotlin
fun 수신타입.확장함수() { ... }

fun String.singleQuote() = "'$this'"
```

- `확장 함수`는 원래 `수신 객체`에 있던 `멤버 함수`인 것처럼 호출할 수 있다.
    - `확장 함수`를 다른 패키지에서 사용하려면 `import` 해야한다.

- `this 키워드`를 사용해 `멤버 함수`나 다른 확장에 접근이 가능하다.
    - 클래스 내부에서 `this`를 생략할 수 있었던 것 처럼 `확장 함수` 안에서도 `this`를 생략할 수 있다.
    - 명시적으로 `멤버`를 `한정`시킬 필요가 없다.

```kotlin
fun String.strangeQuote() = 
  this.singleQuote().singleQuote()

fun String.tooManyQuotes() = 
   doubleQuote().doubleQuote()
```

- `확장 함수`는 확장 대상 타입(수신 객체 타입)의 `public 원소`에만 `접근`할 수 있다.

## 😄 이름 붙은 인자와 디폴트 인자

- `Kotlin` 에서는 함수를 `호출`하면서 `이름 붙은 인자`를 사용할 수 있다.
    - `이름 붙은 인자`를 사용하면 `코드 가독성`이 좋아진다.

```kotlin
fun color(red: Int, green: Int, blue: Int) = 
   "($red, $green, $blue)"

fun main() {
  // 이름 붙은 인자와 일반 위치 기반 인자를 섞어서 사용할 수 있다.
  color(52, 34, blue = 0)
  // 일단 인자 순서를 변경하고 나면, 인자 목록의 나머지 부분에서도 이름 붙은 인자를 사용해야 한다.
  color(red = 76, green = 89, blue = 0)
  // 이름 붙은 인자를 사용하면 인자의 순서를 바꿀 수도 있다.
  color(green = 1, blue = 99, red = 8)
}
```

- `이름 붙은 인자`는 `디폴트 인자`와 결합하면 더 유용하다.
    - `디폴트 인자`란 `파라미터`의 디폴트 값을 함수 정의에서 `지정`하는 것을 말한다.

```kotlin
fun color(
  red: Int = 0,
  green: Int = 0,
  blue: Int = 0
)

fun main() {
  color(139) // green, blue는 디폴트 인자인 0의 값을 가진다.
  color(blue = 139) // red, blue는 디폴트 인자인 0의 값을 가진다.
}
```

- `덧붙은 콤마`를 사용하면, 콤마를 추가하거나 빼지 않아도 `새로운 아이템`을 추가하거나 `아이템의 순서`를 바꿀 수 있다.

```kotlin
fun color(
  red: Int = 0,
  green: Int = 0,
  blue: Int = 0, // 추가적으로 콤마를 붙이지 않아도 새로운 아이템을 추가할 수 있다.
)
```

- `객체 인스턴스`를 `디폴트 인자`로 전달하는 경우에는 `같은 인스턴스`가 반복해서 전달된다.

```kotlin
val da = DefaultArg()

// 같은 인스턴스가 반복해서 전달된다.
fun g(d: DefaultArg = da) = println(d)
```

- `인자 이름`을 붙였을때 가독성이 증가하는 경우에만 `이름 붙은 인자`를 쓰자.

```kotlin
fun calculate(int x, int y) = x + y 

fun main() {
  listOf(1, 2, 3).joinToString(". ", "", "!") // 어느 것이 구분자인지 알아내기 어렵다.

  // 어떤 것이 구분자인지 명확히 알 수 있어, 가독성이 증가한다.
  listOf(1, 2, 3).joinToString(separator = ". ", postfix = "!") 

  calculate(1, 2) 
  /*
  *  인자 이름이 있는 것과 없는 것이 가독성에 큰 차이가 없다.
  *  -> 이런 경우에는 인자 이름을 지정하지 않는 것이 좋다.
  */
  calculate(x = 1, y = 2) 
}
```

## 🙃 Overloading

- `함수 파라미터 리스트`가 서로 다른 `같은 이름의 함수`를 만들어 사용하는 것을 `오버로딩` 이라고 한다.
    - 함수 이름, 파라미터 목록, 반환 타입으로 이뤄진 `함수의 시그니처`를 비교해서 `함수`를 `구분`한다.
    - `함수의 반환타입`이 다른 것은 `오버로딩`이 아니다.

```kotlin
fun f() = 0
// f()를 오버로딩했다.
fun f(n: Int) = n +2
```

- `코틀린`은 `확장 함수`와 `멤버 함수`의 시그니처가 같은 경우, `멤버 함수`를 `우선시`한다.
    - 다른 파라미터 목록을 제공한다면, `멤버 함수`를 `확장 함수`로 `오버로딩`할 수 있다.

```kotlin
class My {
  fun foo() = 0
}

fun My.foo() = 1 // 멤버 함수가 우선시 되기 때문에 호출해도 실행되지 않는다.
fun My.foo(i: Int) = i + 2 // 다른 파라미터 목록을 제공하므로, 오버로딩 할 수 있다.
```

- `함수 오버로딩`과 `디폴트 인자`를 같이 사용하는 경우, `오버로딩`한 함수를 호출하면 `함수 시그니처`와 함수 호출이 가장 `가깝게 일치`되는 `함수`를 호출한다.

```kotlin
fun foo(n: Int = 99) = trace("foo-1-$n")

fun foo() {
  trace("foo-2")
  foo(14)
}

fun main() {
  foo() // 파라미터가 없는 두 번째 버전이 호출된다.
  trace eq """
    foo-2
    foo-1-14
  """
}
```

- `오버로딩`이 있으면 `함수 파라미터`에 있는 정보를 함수 이름에 `반복`하지 않아도 된다.

```kotlin
// 오버로딩이 없는 언어에서는 함수 이름에 함수 파라미터에 있는 정보를 반복한다.
fun addInt(i: Int, j: Int) = i + j
fun addDouble(i: Double, j: Double) = i + j

// Kotlin과 같이 오버로딩이 있는 언어에서는 add()를 오버로딩해서 깔끔한 코드 작성이 가능하다.
fun add(i: Int, j: Int) = i + j
fun add(i: Double, j: Double) = i + j
```

### 😀 When Expression

- Java에 `switch - case`가 있다면, Kotlin에는 `when expression`이 있다.

```kotlin
fun numberToAlphabet(i: Int): String = 
  when (i) {
    1 -> "A"
    2 -> "B"
    3 -> "C" 
    ... 
    else -> throw IllegalArgumentException()
  }
```

- `when` 식의 결과를 사용하지 않는 경우에만 `else`를 생략할 수 있다.
    - 이 경우에는 일치하지 않으면 `아무 일도 일어나지` 않고 `when` 문이 `종료`된다.

```kotlin
fun main() {
  val yes = "A"
  val no = "B"

  for (choice in listOf(yes, no, yes)) {
    when (choice) {
      /*
      *  when의 결과 값을 사용하지 않고 문으로 취급하기 때문에 else가 없어도 동작한다.
      *  일치하지 않으면 아무일도 일어나지 않는다.
      */
      yes -> println("Hooray!")
      no -> println("Too bad!")
    }
  }
}
```

- `Set`과 `Set`을 매치할 수도 있고, `List`와 `List`도 매치가 가능하다.

```kotlin
fun mixColorsSet(first: String, second: String) = 
  when (setOf(first, second)) {
    setOf("red", "blue") -> "purple"
    setOf("red", "yellow") -> "orange"
    setOf("blue", "yellow") -> "green"
    else -> "unknown"
  }

fun mixColorsList(first: String, second: String) = 
  when (listOf(first, second)) {
    listOf("red", "blue") -> "purple"
    listOf("red", "yellow") -> "orange"
    listOf("blue", "yellow") -> "green"
    else -> "unknown"
  }

fun main() {
  mixColorsSet("red", "blue") -> // purple
  mixColorsSet("blue", "red") -> // purple
  mixColorsSet("blue", "yellow") -> // green

  mixColorsList("red", "blue") -> // purple
  mixColorsList("blue", "red") -> // unknown(순서까지 일치해야 같은 것으로 매칭한다)
  mixColorsList("blue", "yellow") -> // green
}
```

- 인자를 취하지 않는 `when 식`도 있다.
    - 이 경우에는 각 `매치 가지`를 `Boolean 조건`에 따라 검사한다.

```kotlin
fun bmiMetricWithWhen(
  kg: Double,
  heightM: Double,
): String {
  val bmi = kg / (heightM * heightM)
  return when {
    bmi < 18.5 -> "Underweight"
    bmi < 25 -> "Normal weight"
    else -> "Overweight"
  }
}
```

## 😆 Enum

- `enum class`는 모아둔 이름을 관리하는 편리한 방법이다.

```kotlin
enum class Level {
  // enum을 만들면 enum의 이름에 해당하는 문자열을 돌려주는 toString()이 생성된다.
  Overflow, High, Medium, Low, Empty
}

fun main() {
  Level.Medium eq "Medium"

  // values()는 Array를 반환하므로 toList()를 호출해 배열을 List로 만든다.
  Level.values().toList() // [Overflow, High, Medium, Low, Empty]
  
  // ordinal은 상수의 순서를 정수로 지정한다. 첫 상수는 0으로 표현된다.
  Level.Overflow.ordinal = 0
  Level.Medium.ordinal = 2 
}
```

- `when 식`을 사용해 `enum 항목`마다 서로 다른 동작을 수행할 수 있다.

```kotlin
fun checkLevel(level: Level) {
   when (level) {
     Overflow -> trace(">>> Overflow!")
     Empty -> trace("Alert: Empty")
     else -> trace("Level $level OK")
   }
}
```

- `enum class` 또한 `멤버 함수`나 `멤버 프로퍼티`를 정의할 수 있다.
    - `enum`은 `코드 가독성`을 높여주므로 항상 사용하는 게 바람직하다.

```kotlin
enum class Direction(val notation: String) {
  North("N"), South("S"), 
  East("E"), West("W")

  val opposite: Direction {
    get() = when (this) {
      North -> South
      South -> North
      West -> East
      East -> West
    }
  }
}
```

## 😟 Data Class

- `data 클래스`를 사용하면 코드양을 줄이면서 여러 가지 `공통 작업`을 편하게 수행할 수 있다.
    - `data 키워드`는 몇 가지 기능을 클래스에 추가하라고 `코틀린`에게 지시한다.
    - 모든 `생성자 파라미터`는 `var` 또는 `val`로 선언해야 한다.

```kotlin
data class Simple(
  val arg1: String,
  var arg2: Int
)

fun main() {
  val s1 = Simple("Hi", 29)
  val s2 = Simple("Hi", 29)
  
  // data 클래스는 toString()이 정의되어 있다.
  s1 eq "Simple(arg1=Hi, arg2=29)"

  // data 클래스는 equals 메서드도 정의되어 있다.
  s1 eq s2 -> // true
}
```

- `data 클래스`에는 `copy()` 함수가 정의되어 있는데, 현재 객체의 모든 데이터를 포함하는 `새 객체`를 생성해준다.

```kotlin
data class Animal(
  val name: String,
  val age: Int,
)

fun main() {
   val dog = Animal("dog", 14)
   val cat = Animal("cat", 5)

   val copyDog = dog.copy()
   val copyCat = cat.copy()
   

   dog eq copyDog // -> true
   cat eq copyCat // -> true
}
```

- `data 클래스`는 `hashCode()` 함수도 생성해준다.
    - `hashCode()` 를 직접 작성하는 건 까다롭고 실수하기 쉽기 때문에 `data 클래스`를 사용하면 편하다.
    - `HashMap`이나 `HashSet`에서는 `hashCode()` 를 `equals()` 와 함께 사용해 `Key` 를 빠르게 검색한다.

```kotlin
data class Key(val name: String, val id: Int)

fun main() {
  /*
  * hashCode() 함수가 작성되어 있지 않다면, 
  * Hash를 사용하는 자료구조가 정상적으로 동작하지 않는다.
  */
  val korvo: Key = Key("Korvo", 19)
  
  val map = HashMap<Key, String>()
  map[korvo] = "Alien"
  
  val set = HashSet<Key>()
  set.add(korvo)
  set.contains(korvo)  
}
```

## 😨 구조 분해 선언

- `구조 분해 선언`을 사용하면 `여러 식별자`를 동시에 선언하면서 초기화할 수 있다.

```kotlin
val (a, b, c) = 여러_값이_들어있는_값
```

- 표준 라이브러리에 있는 `Pair 클래스` 를 쓰면 두 값을 반환할 수 있다.

```kotlin
fun compute(input: Int): Pair<Int, String> = 
  if (input > 5)
    Pair(input * 2, "High")
  else
    Pair(input * 2, "Low")

fun main() {
  compute(7) eq Pair(14, "High")
  compute(4) eq Pair(8, "Low")
}
```

- `구조 분해 구문`에서는, 여러 값이 들어있는 값을 `여러 컴포넌트`로 `분해`해서 각 컴포넌트를 순서대로 대입해준다.

```kotlin
fun main() {
  // value에는 14, description에는 "High"가 대입된다.
  val (value, description) = Pair(14, "High")
  value eq 14
  description eq "High"
}
```

- `Kotlin`은 `Pair`와 `Triple`만 제공한다.
    - 더 많은 값을 저장하고 싶다면 상황에 맞는 `특별한 클래스`를 `작성`하면 된다.

```kotlin
data class Computation(
  val data: Int,
  val info: String
)

fun main() {
  /*
  * data 클래스의 인스턴스를 구조 분해할 때는 data 클래스 생성자에 
  * 각 프로퍼티가 나열된 순서대로 값이 대입된다.
  */
  val (value, description) = Computation(14, "High")
  value eq 14
  description eq "High"

  // 구조 분해 선언으로 선언할 식별자 중 일부가 필요하지 않다면, 이름 대신 밑줄(_)로 사용할 수 있다.
  val (_, description) = Computation(2, "Low")
}
```

- `for 루프` 를 사용하면, 다른 `data 클래스` 의 객체로 이뤄진 `Map` 또는 `List`에 대해 값의 각 부분을 구조분해로 얻을 수 있다.

```kotlin
fun main() {
  val map = mapOf(1 to "one", 2 to "two")
  
  for ((key, value) in map) {
    println("$key = $value") // map을 구조분해 해서 key와 value를 얻는다.
  }

   val listOfPairs = listOf(Pair(1, "one"), Pair(2, "two"))
   
   for ((i, s) in listOfPairs) {
     println("$i = $s") // list에 들어있는 Pair를 구조분해 해서 값을 얻는다.
   }

   val list = listOf('a', 'b', 'c')

   for ((index, value) in list.withIndex()) {
     // withIndex() 사용으로, 컬렉션의 값을 구조 분해 가능한 IndexedValue 타입에 담아 반환한다.
     println("$index = $value") 
   }
}
```

- `구조 분해 선언`은 지역 `var`나 `val`에만 적용할 수 있고, `클래스 프로퍼티`를 정의할 때는 사용이 `불가능`하다.

## 🤓 Nullable Type

- `Kotlin` 에서는 `null` 이 될 수 있는 타입과 `null` 이 될 수 없는 타입을 구분한다.

```kotlin
val string1: String // null이 될 수 없는 타입

val string2: String? // null이 될 수 있는 타입
```

- `null이 될 수 없는 타입`의 뒤에 `?` 를 붙이면 `null이 될 수 있는 타입`이 된다.
    - 타입 이름 끝에 `?`를 붙여서 기존 타입을 바꾼 것 같지만, 실제로는 `다른 타입`을 `지정`한 것이다.
    - `Kotlin`은 `null이 될 수 있는 타입`은 `멤버 프로퍼티`나 `멤버 함수`에 접근할 수 없도록 `제어`한다.

```kotlin
val s1: String = "abc"
val s2: String? = s1

s1.length

s2.length // 컴파일 되지 않는다 -> nullable 하므로, 멤버 프로퍼티 접근 불가
```

- 명시적으로 `if 검사`를 수행하면, `null이 될 수 있는 타입`도 멤버 프로퍼티나 멤버 함수에 `접근`할 수 있다.

```kotlin
val s: String? = "abc"

if (s != null) {
  s.length  // 호출 가능 -> 명시적으로 if 검사를 수행해, null이 아님이 확실하기 떄문이다.
}
```

- `null이 될 수 없는 타입`을 정의하면 `null이 될 수 있는 타입`도 자동으로 사용할 수 있게 된다.

```kotlin
class Animal {}

fun main() {
  // null이 될 수 없는 타입에 그저 ?만 붙이면 null이 될 수 있는 타입으로 사용이 가능하다.
  val s1: Animal = Animal()
  val s2: Animal? = null
}
```

## 😫 Safe Call & Elvis Operator

- `안전한 호출(safe call)`은 일반 호출에 사용하는 점(.)을 `물음표와 점(?.)` 으로 바꾼 것이다.
    - `안전한 호출`을 사용하면 `nullable`한 타입의 멤버에 접근하면서 `예외`가 발생하지 않게 해준다.
    - `안전한 호출`은 수신 객체가 null이 아닐 때만 연산을 수행한다.

```kotlin
// String 클래스의 확장 함수 정의
fun String.printString() = println(this)

val s1: String? = "Howdy"
val s2: String? = null

s1?.printString() // Howdy 출력
s2?.printString() // 수신 객체가 null 이므로 아무일도 일어나지 않는다.
```

- 수신객체가 `null`일 때, 결과로 `null`을 만들어내는 것 이상의 일이 필요할때는 `엘비스 연산자`를 사용한다.
    - `엘비스 연산자`는 물음표 뒤에 콜론을 붙인(`?:`) 연산자다.
    - 상당수의 프로그래밍 언어가 코틀린 `엘비스 연산자`와 같은 역할을 하는 `널 복합 연산자`를 제공한다.

```kotlin
val s1: String? = null
val s2: String? = "abcde"

val length1 = s1?.length ?: 0 // 수신객체가 null 이므로, 0이 값이 된다.
val length2 = s2?.length ?: 0 // 수신객체가 null이 아니므로, 5가 값이 된다.
```

## 🥱 Null 아님 단언

- 어떤 참조가 `null`이 될 수 없다는 사실을 특별히 알 수 있는 경우에 사용한다.
- `null`이 될 수 없다고 확신할 수 있는 경우에 `느낌표 두 개(!!)`로 `널 아님 단언`을 할 수 있다.
    - 널 아님 단언을 하면 `null`이 대입되는 경우에도 연산을 수행해 `NPE`가 발생할 수 있다.
    - `위험성`이 있으니, 꼭 `필요한 경우`에만 `사용`해야한다.

```kotlin
var s1: String? = "abc"
var s2: String? = null

s1!!.length // 정상적으로 수행된다.
s2!!.length // NPE가 발생한다.
```

## 🤭 확장 함수와 Null이 될 수 있는 타입

- `null이 될 수 있는 타입`도 `확장 함수`를 정의할 수 있다.
    - `null이 될 수 있는 타입`의 확장 함수는 `안전한 호출`을 사용하지 않아도 호출이 가능하다.

```kotlin
val s1: String? = null

// 이 두 함수는 String? 타입의 확장 함수이기 때문에, safe-call 없이 호출이 가능하다.
s1.isNullOrEmpty()
s1.isNullOrBlank()
```

- `null이 될 수 있는 타입` 을 확장할 때는 `조심`해야 한다.
    - 상황이 단순하고 함수 이름에서 `수신 객체가 null`일 수 있음을 암시하는 경우에는 `확장 함수`가 유용하다.
        - ex) `isNullOrEmpty()` , `isNullOrBlank()`
    - 일반적으로는 `null이 될 수 없는 타입`의 `확장 함수`가 더 유용하다.

## 👨🏼‍💻 Generics

- `제네릭스`는 `파라미터화한 타입`을 만든다.

```kotlin
class Holder(value: String) {
   fun getValue(): String = value
}

class GenericHolder<T>(value: T) {
   fun getValue(): T = value
}

fun main() {
  // 한 개의 타입만 객체에 넣을 수 있다.
  val holder = Holder("123")

  // 제네릭 적용으로, 여러 타입을 담을 수 있는 유연함을 가진다.
  val genericHolder1 = GenericHolder("123")
  val genericHolder2 = GenericHolder(123)
  val genericHolder3 = GenericHolder(123.0)
}
```

- 모든 타입의 `부모 타입`인 `Any(Universal Type)`을 사용해도 제네릭처럼 유연하지 못하다.

```kotlin
class AnyHolder(private val value: Any) {
   fun getValue(): Any = value
}

fun main() {
  val holder = AnyHolder("abc")
  val any = holder.getValue()
  
  /*
  * 컴파일 되지 않는다 -> Any 타입에는 length 라는 프로퍼티가 없기 때문이다.
  * 객체를 Any 타입으로 대입하면서 객체 타입이 String 이라는 사실을 더 이상 추적할 수 없다.
  */
  any.length
}
```

- `제네릭 함수`도 정의할 수 있다.

```kotlin
// 제네릭 함수를 정의하려면 타입 파라미터를 함수 이름 앞에 붙이면 된다.
fun <T> identity(arg: T): T = arg

// 제네릭 확장 함수를 만들 수도 있다.
fun <T> List<T>.first(): T {
  if (isEmpty())
    throw NoSuchElementException("Empty List")
  return this[0]
}

fun <T> List<T>.firstOrNull(): T? = 
  if (isEmpty()) null else this[0]

```

## 😡 확장 프로퍼티

- `확장 함수`를 정의하는 것처럼 `확장 프로퍼티`를 정의할 수도 있다.

```kotlin
// 아래와 같은 형식으로 정의한다 -> Custom Getter는 필수다.
val ReceiverType.extensionProperty: PropType
  get() { ... }

val String.indices: IntRange
  get() = 0 until length
```

- `제네릭 확장 프로퍼티`를 정의할 수도 있다.
    - `코틀린 스타일 가이드`에서는 함수가 예외를 던질 경우 `프로퍼티`보다는 `함수`를 사용하는 것을 권장한다.

```kotlin
val <T> List<T>.firstOrNull: T? 
  get() = if (isEmpty()) null else this[0]
```

- `제네릭 인자 타입`을 사용하지 않으면 `스타 프로젝션(*)`으로 대신할 수 있다.
    - `스타 프로젝션`을 사용하면 `담긴 원소`의 `타입 정보`를 모두 잃어버린다.
    - `List<*>`에서 얻은 원소는 `Any?`에만 대입 가능하다.

```kotlin
val List<*>.indices: IntRange
  get() = 0 until size
```

## 🤓 Break & Continue

- `break`와 `continue`를 사용해 `제한적인 점프`를 제공한다.
    - `continue`는 루프의 시작 위치로, `break`는 루프의 끝으로 점프한다.

```kotlin
fun main() {
  for (i in 4 until 100 step 4) {
    if (i == 8) continue
    if (i == 40) break
    println(i)
  }
}
```

- `레이블`은 `break`와 `continue`가 자신이 속한 `루프의 범위`를 뛰어넘게 할 수 있다.

```kotlin
fun main() {
   val strings = mutableListOf<String>()

   outer@ for (c in 'a'..'e') {
     for (i in 1..9) {
       if (i == 5) continue@outer // 바깥 for문의 시작 위치로 돌아간다.
       if ("$c$i" == "c3") break@outer // 바깥 for 문을 빠져나간다 -> 전체 for문 중단
       strings.add("$c$i")
     }
   }
}
```

- 루프 본문을 `별도의 함수로 추출`하면 `break`나 `continue` 없이 `return`으로 `대체`할 수 있다.
    - 더 `간단`하고 `읽기 좋은 해법`에는 `break`나 `continue`가 `없는 경우`가 많다.
