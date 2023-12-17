## 😀 객체는 모든 곳에 존재한다.

- `객체`는 `프로퍼티(val & var)`를 사용해 데이터를 저장하고 함수를 사용해 데이터에 대한 연산을 수행한다.

## 😄 용어 정리

- `클래스(class)` : 새로운 데이터 타입의 기초가 될 `프로퍼티`와 `함수`를 정의한다.
    - `사용자 정의 타입`이라고 부르기도 한다.
- `멤버(member)` : 클래스에 속한 프로퍼티나 함수를 말한다.
- `멤버 함수(member function)` : 특정 클래스에 속한 `객체`가 있어야만 사용할 수 있는 `함수`를 말한다.
- `객체 생성` : 클래스에 해당하는 `val`이나 `var` 값을 만드는 과정이다. 클래스의 `인스턴스`를 생성한다고 말한다.

## 😕 IntRange

```kotlin
fun main() {
  val r1 = IntRange(0, 10)
  val r2 = IntRange(5, 7)
  println(r1)
  println(r2)
}
```

- `IntRange` 는 객체의 일종이며, 범위를 나타내는데 사용된다.
- `IntRange`의 멤버 함수인 `sum()` 을 호출하면 `IntRange` 범위안에 속하는 모든 정수를 더한 값을 돌려준다.

```kotlin
fun main() {
  val r = IntRange(0, 10)
  println(r.sum())
}
```

## 😳 수 타입의 변환

- `코틀린`에서의 수 타입 변환은 `toLong()` , `toDouble()`  등의 명시적 함수로 할 수 있다.

```kotlin
fun fraction(numerator: Long, denom: Long) = 
  numerator.toDouble() / denom
```

## 😀 클래스 만들기

- `Kotlin` 에서는 직접 원하는 객체의 타입을 정의할 수 있다.

```kotlin
class Giraffe

fun main() {
  // Java와 다르게 new 연산자를 쓰지 않는다.
  val g1 = Giraffe()
}
```

## 🫡 클래스 정의 규칙

- `클래스`의 이름은 반드시 `글자`(A-Z, 대소문자, 한글 등 각국 언어를 표기하는 문자)로 시작해야 한다.
    - 두 번째 자리부터는 `숫자`나 `밑줄`을 포함할 수 있다.
- 관례적으로 클래스 이름의 `첫 글자`는 `대문자`로 표기하고, `val`이나 `var`로 쓰이는 이름의 첫 번째 글자는 `소문자`로 표기한다.
- `복잡한 클래스`를 정의할 때는, `중괄호({ })` 를 사용해서 클래스의 `특성`이나 `행동 양식`을 포함하는 클래스 본문을 정의한다.
- `클래스 본문` 안에 정의된 함수를 `멤버 함수`라고 부른다.
    - `Java`와 같은 객체지향 언어에서는 멤버 함수를 `메서드(method)`라고 부르지만, `Kotlin`에서는 함수라고 표현한다.
    
    ```kotlin
    class Giraffe {
      fun walk() {
        println("Giraffe is Walk!")
      }
    }
    ```
    

- `함수`는 두 가지 종류로 나눌 수 있다.
    - `멤버 함수` : 클래스에 속한 함수
    
    ```kotlin
    class Cat {
      fun meow() = "mrrow!"
    }
    ```
    
    - `최상위 함수` : 클래스에 속하지 않은 함수
    
    ```kotlin
    fun topFunction() = "Top Function!"
    
    class Dog {
      fun bark() = "bark! bark!"
    }
    ```
    

## 😶‍🌫️ 멤버 함수의 호출

- `멤버 함수` 는 어떤 클래스에 속한 특정 `인스턴스`에 대해 작용한다.
    - `멤버 함수`를 호출하려면 반드시 `객체`를 `지정`해야 한다.

- `멤버 함수` 안에서는 `this`라는 이름으로 이 참조에 접근할 수 있다.
    - `멤버 함수`는 클래스에 속한 `다른 요소`들을 `멤버 이름`만으로 접근할 수 있다.

```kotlin
class Hamster {
  fun speak() = "Hamster is Speak!"
  fun exercise() = 
     this.speak() +  // this로 한정
        speak() +    // this 없이 호출
        "Running on wheel!"
}
```

- `불필요`하게 `this`를 `명시`하는 것은 좋지 않다.
    - `코드`를 읽는 사람은 왜 `코드`를 이렇게 작성했는지 한 번 고민해야 할 수 있기 때문이다.

## 🥱 클래스의 프로퍼티

- `Property`를 정의함으로서 `클래스` 안에서 `상태`를 유지할 수 있다.
    - `var 프로퍼티`는 `재대입`이 `가능`하지만, `val 프로퍼티`는 그렇지 않다.
    
    ```kotlin
    fun main() {
      var number1 = 1
      number1 = 2 // -> 재대입 가능
    
      val number2 = 1
      number2 = 1 // -> 재대입 불가 Error 발생 
    }
    ```
    
- `멤버 함수`는 점 표기법을 쓰지 않고 자신이 속한 객체의 `프로퍼티`에 `접근`할 수 있다.

```kotlin
class Cup {
  var percentFull = 0
  val max = 100

  fun add(increase: Int): Int {
    // 점 표기법을 쓰지 않아도 자신이 속한 객체의 프로퍼티에 접근 가능
    percentFull += increase
    if (percentFull > max) 
       percentFull = max
       return percentFull
  }
}
```

- `최상위 프로퍼티`로 `가변 프로퍼티`를 정의하는 것은 `안티패턴`으로 간주된다.
    - 프로그램의 복잡성이 올라갈수록 `공유된 가변 상태`에 대해 제대로 `추론`하기가 어려워지기 때문이다.
    - `가변 상태`는 `클래스 안`에 가두는 것이 가장 좋다.

- `val`로 선언한다고 해서 `객체의 상태`가 반드시 바뀌지 않는 것은 아니다.
    - `객체`를 대입하게 되면 참조가 대입되기 때문에 `원본 객체`의 변경이 있다면 `val`로 선언해도 상태는 변한다.

```kotlin
class Kitchen {
  var table: String = "Round table"
}

fun main() {
  val kitchen1 = Kitchen()
  val kitchen2 = kitchen1

  // kitchen1의 프로퍼티를 변경하면 kitchen2도 영향을 받는다 -> 참조를 공유하기 때문
  kitchen1.table = "Square table"
}
```

- `var` 과 `val` 은 객체가 아니라 참조를 제한한다.

## 😚 클래스의 생성자

- `생성자`에 정보를 전달해서 `객체`를 초기화 할 수 있다.

```kotlin
class Wombat

fun main() {
  val wombat = Wombat()
}
```

- `생성자`는 `파라미터`를 가질 수 있고, `인자`를 받는다.
- `var` 또는 `val`을 지정하지 않은 `생성자 파라미터`는 `생성자 밖`에서 `접근`할 수 없다.

```kotlin
class Alien(name: String) {
  val greeting = "Poor $name!"
}

fun main() {
  val alien = Alien("Mr. Meeseeks")
  println(alien.greeting)
  
  // 생성자 안에서는 name에 접근할 수 있지만 생성자 밖에서는 접근이 불가능하다 -> Error!
  alien.name
}
```

## 🙄 클래스의 toString( )

- `println()` 은 문자열 대신 객체를 전달받은 경우, 객체의 `toString()`을 호출한 결과를 출력한다.
    - 클래스의 직접 `toString()` 을 정의하지 않으면 디폴트 `toString()`이 호출된다.
    - `toString()` 함수는 `Debugging` 과정에서도 `호출`되기 때문에 `재정의`하는 것이 좋다.

```kotlin
class Animal(val name: String) {
  // override 키워드는 이미 정의된 toString() 메서드를 새로 정의하곘다는 뜻을 코틀린에게 전달한다.
  override fun toString() = "Animal name is $name"
}
```

## 😎 가시성 제한하기

- `라이브러리`를 만든 사람은 자신이 변경한 내용이 `클라이언트의 코드`에 영향을 끼치지 않는다는 확신을 바탕으로 자유롭게 라이브러리를 `수정`하고 `개선`하길 원한다.
- 클라이언트에게 공개되면 안 될 부분을 `Public API`로 공개하게 되면, 그 `API`는 `개선`이나 `수정`의 여지를 잃게된다.
- 따라서 `변화해야 하는 요소`와 `동일하게 유지되어야 하는 요소`를 `분리`하는 것이 `소프트웨어 설계`에서의 일차적으로 고려해야 할 내용이다.

## 🥹 Kotlin의 접근 변경자

- `public` : 어떤 위치에서든 접근 가능한 접근 제어를 가진다.
- `protected` : 상속 관계에서만 접근 가능한 접근 제어를 가진다.
- `internal` : 같은 모듈 안에서만 접근이 가능하다.
    - 어떤 요소를 `private`으로 정의 하기에는 `제약`이 너무 심하고, `public`으로 지정해 `공개 API`로 만들기 애매할 경우에는 `internal`을 `사용`하는 것이 좋다.
- `private` : 그 정의가 들어 있는 파일 내부에서만 접근이 가능하다.

```kotlin
class Cookie(
  private var isReady: Boolean
) {
  // 접근 제어자를 지정하지 않으면 public이 기본이다.
  fun bite() = println("bite")
}
```

- `내부 구현`을 노출시켜야 하는 경우를 제외하고는 `프로퍼티`를 `private`로 만드는 것이 좋다.

## 🤭 Kotlin의 패키지

- `import 키워드`를 써서 다른 파일에 정의된 코드를 `재사용`할 수 있다.

```kotlin
import kotlin.math.PI
import kotlin.math.cos

fun main() {
  println(PI)
  println(cos(PI))
  println(cos(2 * PI))
}
```

- `as 키워드`를 이용하면 import 하면서 `이름`을 `변경`할 수 있다.
    - `as`는 라이브러리에서 `이름을 잘못 선택`했거나 `이름이 너무 길 때` 유용하다.

```kotlin
import kotlin.math.PI as circleRatio
import kolin.math.cos as cosine

fun main() {
  println(circleRatio)
  println(cosine(circleRatio))
}
```

- `패키지`에 있는 모든 내용을 `임포트`하려면 `별표(*)`를 사용한다.

```kotlin
import kotlin.math.*

fun main() {
  println(E)
  println(E.roundToInt())
}
```

- `파일 이름`이 항상 `클래스 이름`과 같아야 하는 `자바`와 다르게, `코틀린`에서는 소스 코드 파일 이름을 아무 이름이나 붙여도 된다.
- `패키지 이름`도 아무 이름이나 선택할 수 있다.
    - `패키지 이름`과 패키지 파일이 들어 있는 `디렉터리의 경로`를 똑같이 하는 것이 `좋은 스타일`로 여겨진다.

## 😕 함수의 중위 표기법

- `infix` 키워드를 붙인 함수는 `a.함수(b)` 호출을 `a 함수 b` 처럼 쓸 수 있게 해준다.

```kotlin
class Operator(var data: Int) {
    infix fun add(number: Int) {
        data += number
    }
}

fun main() {
    val operator = Operator(1)
    operator add 1

    println(operator.data) // 2
}
```

## 😖 Kotlin의 List

- `List`는 `컨테이너`라고 부르며, 컬렉션이라고 부르기도 한다.
    - `List`는 `표준 코틀린 패키지`에 들어 있기 때문에 `import`를 할 필요가 없다.

```kotlin
fun main() {
  // 읽기 전용 리스트 생성
  val ints = listOf(99, 3, 5, 11)

  var result = 0
  // index는 0부터 시작하기 때문에, 에러가 발생한다 -> Index 4가 없기 때문
  for (index in 1..4) {
     result += list[index]
  }

  result = 0
  for (value in ints) {
     // 원소를 한 번에 하나만 선택하지 않고 in을 사용해 컨테이너 전체에 대해 이터레이션한다.
     // -> 이터레이션을 사용하면 1 차이로 인한 오류를 없앨 수 있다.
     result += value
  }
}
```

## 👿 List의 정렬

- 생성된 `List`에 `sort` 또는 `reverse`를 호출하면 원본 `List`를 직접 정렬한다.
    - `sorted`와 `reversed`를 호출하면 원본을 변경하지 않고, `새로운 List`를 정렬해서 반환한다.

```kotlin
fun main() {
  val list = listOf(5, 1, 3, 4)
  
  val sortedList = list.sorted() // [1, 3, 4, 5]
  val reversedList = list.reversed() // [5, 4, 3, 1]
  list.sort() // [1, 3, 4, 5]
  list.reverse() // [5, 4, 3, 1]
}
```

## 🤗 파라미터화한 타입

- `타입 추론`을 사용하는 것은 `좋은 습관`이다.
- `코드`를 더 이해하기 쉽게 작성하고 싶은 경우에는 직접 `타입을 명시`해야 할 때도 있다.

```kotlin
fun main() {
  val strings = lisfOf("one", "two", "three")

  val strings2: List<String> = listOf("one", "two", "three")
}
```

## 😠 함수의 타입 추론

```kotlin
// 반환 타입을 추론한다.
fun inferred(p: Char, q: Char) = listOf(p, q)

// 반환 타입을 명시한다.
fun explicit(p: Char, q: Char): List<Char> = listOf(p, q)
```

- `코틀린`은 함수의 반환 타입을 명시해서, 반환하려는 값의 타입을 의도에 맞게 `강제`할 수 있다.

## 🤯 읽기 전용과 가변 List

- `listOf()` 함수로 생성하는 List는 `읽기 전용 리스트`를 생성한다.
- `mutableListOf()` 함수로 생성하는 List는 `가변 리스트`를 생성한다.

```kotlin
fun main() {
  val mutableList = mutableListOf<Int>()

  mutableList.add(1)
  mutableList.addAll(listOf(2, 3))

  mutableList += 4
  mutableList += listOf(5, 6)

  val immutableList = listOf<Int>()
  
  immutableList += 1    // immutableList는 데이터를 변경할 수 없다.
  immutableList.add(1)
}
```

## 😉 += 연산자의 비밀

```kotlin
fun main() {
  var list = listOf('X')
  list += 'Y'
  
  println(list) // ['X', 'Y']
}
```

- `+= 연산자`를 사용하면 불변성을 마치 위배하고 있는 것 처럼 보인다.
    - `list`를 `var`로 선언했기 때문에 컴파일러는 새로운 `List`를 대입할 수 있다.
    - `list`의 내부를 변경하는 것이 아니라 ‘Y’라는 원소를 추가한 새로운 `List`를 `재대입`한 것 뿐이다.

## 😳 가변 인자 목록

- `vararg 키워드`는 길이가 변할 수 있는 인자 목록을 만든다.
    - `vararg 키워드`를 사용하면 `listOf` 처럼 임의의 길이로 인자를 받을 수 있는 함수를 정의할 수 있다.
    - `vararg 키워드`는 마지막 `파라미터`로만 사용이 가능하다.
        - 선언은 `첫 파라미터`나 `중간 파라미터`로도 가능하지만 사용이 불가능하다.

```kotlin
fun numbers(vararg d: Double) {}
```

- `vararg 인자`는 함수 본문에서 `파라미터 이름`을 통해 접근할 수 있고, `Array`로 취급된다.

```kotlin
fun sum(vararg numbers: Int): Int {
  var total = 0
  for (n in numbers) {
    total += n
  }
}

```

## 🤧 스프레드 연산자( * )

- `Array`를 `가변 인자 목록`으로 `변환`하고 싶다면, `스프레드 연산자( * )`를 사용하면 된다.

```kotlin
fun main() {
  val array = intArray(4, 5)
  sum(1, 2, 3, *array, 6)
}
```

- `List`는 `Array`로 변환 후 `스프레드 연산자`를 사용해 가변 인자 목록을 사용할 수 있다.

```kotlin
fun sum(vararg numbers: Int): Int {
   var result = 0

   for (number in numbers) {
      result += number
   }

   return result
}

fun main() {
  val list = listOf(1, 2, 3, 4, 5)
  println(sum(*list.toIntArray())) // 15
}
```

## 😍 Kotlin의 Set

- `Set`은 각각의 값이 오직 하나만 존재할 수 있는 `컬렉션`이다.

```kotlin
fun main() {
  val intSet = setOf(1, 1, 2, 3, 9, 9, 4)
  
  (9 in intSet) // in 연산으로 포함 여부를 검사할 수 있다.
  intSet.contains(9) // contains 호출로도 대체할 수 있다.
  
  // 합집합 연산도 가능하다.
  intSet.union(setOf(3, 4, 5, 6))

  // 교집합 연산도 가능하다.
  intSet intersect setOf(0, 1, 2, 7, 8)

  // 차집합 연산도 가능하다.
  intSet subtract setOf(0, 1, 9, 10)
}
```

- `List`에서 중복을 제거하려면 `Set`으로 변환하면 된다.

```kotlin
fun main() {
  val list = listOf(3, 3, 2, 1, 2)
  
  // List는 Set으로 변환이 가능하고, 중복이 제거된다.
  list.toSet() eq setOf(1, 2, 3)
}
```

- `Set` 역시 `+=` , `-=` 연산자를 사용해 원소를 `추가`하거나 `삭제`할 수 있다.

```kotlin
fun main() {
  val mutableList = mutableSetOf<Int>()
  mutableSet += 42
  mutableSet += 42

  mutableSet eq setOf(42) 
  mutableSet -= 42

  mutableSet eq setOf<Int>()
}
```

## 🤒 Kotlin의 Map

- `Kotlin`에도 `key-value` 형식을 가진 `Map` 자료구조가 있다.

```kotlin
fun main() {
  // map을 정의할 때는 key to value로 값의 쌍을 넣어줄 수 있다.
  val constants = mapOf("Pi" to 3.141, "e" to 2.718)

  // 키 - 값 쌍을 이터레이션 할 수 있다.
  for (entry in constants) {
    println("${entry.key}=${entry.value}")
  }

  // 이터레이션을 하면서 키와 값을 분리한다.
  for ((key, value) in constants) {
    println("$key=$value")
  }
}
```

- `MutableMap`에는 원소를 여러가지 방식으로 추가할 수 있다.
    - `mapOf()` 와 `mutableMapOf()` 로 생성된 `Map` 은 원소가 전달된 순서를 유지해준다.
        - 다른 `Map` 은 순수가 보장되지 않을 수 있다.

```kotlin
fun main() {
  val m = mutableMapOf(5 to "five", 6 to "six")
  map[5] eq "five" // map에서 원소를 가져올때는 map[key]로 가져올 수 있다.

  map[5] = "5ive" // map에 원소를 넣을때는 map[key] = value로 할 수 있다.
  map += 4 to "four" // key to value로 만든 Pair 객체로 Map에 데이터를 넣을 수 있다.
}
```

- `Map` 에서 원소를 가져오는 방법은 `getValue()`  호출과 `getOrDefault()`  호출이 있다.

```kotlin
fun main() {
   val map = mapOf('a' to "attempt")
   // 일치하는 원소가 없다면 null을 준다.
   map['b'] eq null 

   // NoSuchElementException이 발생한다.
   map.value('b') 
   
   // 키와 일치하는 값이 없으면 default value를 반환한다.
   map.getOrDefault('b', "??") eq "??"  
}
```

## 😛 프로퍼티 접근자

- `프로퍼티` 이름을 사용해 `프로퍼티`를 읽을 수 있다.

```kotlin
class Data(var i: Int)

fun main() {
  val data = Data(10)
  data.i eq 10 // 'i' 프로퍼티를 읽음
  data.i = 20 // 'i' 프로퍼티에 값을 쓴다.
}
```

- `프로퍼티`에는 `get()` , `set()` 을 정의할 수 있다.
    - `set()`  과 `get()` 을 정의하는 순서는 중요하지 않다.
    - `field` 라는 이름은 `getter`와 `setter` 안에서만 접근 가능하다.

```kotlin
class Default {
  val i: Int = 0
    get() {
      trace("get()")
      return field
    }
    set(value) {
      trace("set($value)")
      field = value
    }
}
```

- `프로퍼티`를 `private`으로 정의하면 두 접근자 모두 `private`가 된다.
    - `setter`를 `private`로 하고, `getter`는 `public`으로 할 수도 있다.

```kotlin
class Counter {
  var value: Int = 0
    private set
  fun inc() = value++
}
```

- `필드`가 없는 `프로퍼티`를 `정의`할 수도 있다.

```kotlin
class Cage(private val maxCapacity: Int) {
   private val hamsters = mutableListOf<Hamster>()

   // 보통은 get()을 정의한하.
   val capacity: Int
      get() = maxCapacity - hamsters.size

   val full: Boolean
      get() = hamsters.size == maxCapacity

   
   // 프로퍼티를 사용하는 코드가 더 가독상이 좋지만, 모든 함수를 프로퍼티로 변환하지는 말아야한다.
   // -> 계산 비용이 많이 들지 않고, 객체 상태가 바뀌지 않는 한 같은 결과를 내놓는 함수는 프로퍼티를
   //    사용하는 것이 좋다.
   fun capacity(): Int = maxCapacity - hamsters.size
   fun isFull(): Boolean = hamsters.size == maxCapacity
}
```
