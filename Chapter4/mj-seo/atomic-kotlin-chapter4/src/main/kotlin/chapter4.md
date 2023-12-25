## 😃 람다

- `람다(Lambda)` 는 `부가적인 장식`이 덜 들어간 함수이다.
- `함수 생성`에 필요한 `최소한의 코드`만 필요하고, 다른 코드에 `람다`를 직접 `삽입`할 수 있다.

```kotlin
val list = listOf(1, 2, 3, 4)

// 중괄호 사이에서 사용한 코드가 람다이다.
val result = list.map({ n: Int -> "[$n]" })
```

- `Kotlin`은 람다의 타입을 `추론`할 수 있다.
    - 따라서 `Int` 타입을 명시하지 않아도, 코드를 작성할 수 있다.

```kotlin
val list = listOf(1, 2, 3, 4)

val result = list.map({ n -> "[$n]" })
```

- `람다의 파라미터`가 `하나`라면 `Kotlin`은 자동으로 파라미터 이름을 `it`로 만든다.
    - `파라미터가 하나`라면 n → 과 같은 코드를 `작성할 필요`가 없다는 뜻이기도 하다.

```kotlin
val list = listOf(1, 2, 3, 4)

val result = list.map({ "[$it]" })
```

- `map()` 은 모든 타입의 `List`에 사용이 가능하다.

```kotlin
val list = listOf('a', 'b', 'c', 'd')

// 람다의 it의 타입이 Char 이라는 것을 추론할 수 있다.
val result = list.map({ "[${it.upperCase()}]" })
```

- `함수의 파라미터`가 람다 뿐이라면 괄호를 람다를 둘러싼 괄호를 제거해서 `더 깔끔한 코드` 작성이 가능하다.

```kotlin
val list = listOf('a', 'b', 'c', 'd')

val result = list.map { "[${it.upperCase()}]" }
```

- `함수`가 여러 파라미터를 받는데, 람다가 `마지막 파라미터`라면 람다를 인자 목록을 감싼 괄호 뒤에 위치시킬 수 있다.

```kotlin
val list = listOf(9, 11, 23, 32)

list.joinToString(" ") { "[$it]" }
```

- `파라미터`가 `두 개` 이상인 람다를 사용하는 표준 라이브러리의 함수도 있다.

```kotlin
val list = listOf('a', 'b' , 'c')

list.mapIndexed { index, element -> 
   "[$index: $element]"
}
```

- `람다`가 `특정 인자`를 사용하지 않는 경우에는 `밑줄`을 사용할 수 있다.
    - `밑줄`을 쓰면 람다가 어떤 인자를 사용하지 않는다는 `컴파일러 경고`를 `무시`할 수 있다.

```kotlin
val list = listOf('a', 'b', 'c')

// _(밑줄)이 들어간 위치는 원래 원소의 값(element)가 들어갈 자리지만, 사용하지 않겠다고 표시한 것이다.
list.mapIndexed { index, _ -> 
   "[$index]"
}
```

- `파라미터`가 없는 `람다`가 있을 수 있다.
    - `코틀린 스타일 가이드`에서는 `파라미터`가 없다는 사실을 강조하기 위해 `화살표를 남겨두는 것`을 권장하지 않고 있다.

```kotlin
run { -> trace("A Lambda") }

// 코틀린 스타일 가이드에서 권장하는 방식이다.
run { trace("Without args") }
```

- `일반 함수`를 쓸 수 있는 곳이라면 `람다`로 대체가 가능하다.
    - `람다`가 너무 복잡하면 `이름 붙은 함수`를 사용하는 것이 더 명확하다.
    - `람다`를 단 한 번만 사용하더라도 람다가 너무 커지면, `이름 붙은 함수`로 작성하는 것이 훨씬 좋다.

## 🤓 람다의 중요성

- `람다`는 그저 `문법 설탕`처럼 보일 수 있지만, 프로그래밍에 `중요한 능력`을 부여해준다.

`컬렉션`에 적용할 수 있는 `풍부한 함수 라이브러리`가 없을때 `짝수`만 걸러내는 `함수`를 이렇게 직접 구현해야 한다.

```kotlin
fun filterEven(nums: List<Int>): List<Int> {
  val result = mutableListOf<Int>()
  
  for (i in nums) {
    if (i % 2 == 0)
      result += i
  }

  return result
}
```

- `람다`를 사용하면, 표준 라이브러리 함수 `filter()`를 이용해 손쉽게 `조건에 맞는 원소`만 걸러낼 수 있다.

```kotlin
val list = listOf(1, 2, 3, 4, 5, 6)

val result = list.filter { it % 2 == 0 }

result eq "[2, 4, 6]" // filter()에 술어(Predicate)를 제공해 필요한 원소만 뽑아냈다.
```

- `함수형 프로그래밍`은 문제를 `작은 단계`로 풀어나간다.
    - `filter()`는 엄격히 `테스트된 함수`이므로 버그가 생길 여지가 거의 없다.
    - `작고 디버깅이 잘 이뤄진 해법`을 많이 갖추면, 매번 디버깅 할 필요 없이 `쉽게 조합`해서 사용할 수 있다.

- 람다는 `var`과 `val`에 담을 수 있고, 이를 통해 재사용할 수 있다.

```kotlin
/*
*  주어진 숫자가 짝수인지 판별하는 람다
*  -> Kotlin 타입 추론기가 파라미터의 타입을 결정할 수 있는 문맥이 없으므로 타입 명시가 필요하다.
*/
val lambda = { number: Int -> number % 2 == 0 }

val list = listOf(1, 2, 3, 4, 5)

// 람다를 재사용할 수 있다.
list.filter(lambda) // [2, 4]
list.any(lambda) // true
```

- `람다`는 `자신의 영역 밖`에 있는 `요소`를 `참조`할 수 있는 능력이 있다.
    - `함수`가 자신이 속한 환경의 요소를 `포획`하거나 `닫아 버리는 것`을 `클로저(Closer)`라고 한다.
    - `클로저`랑 `람다`는 다른 개념이지만 `일부 언어`에서는 `혼동`하고 있다.
        - `클로저가 없는 람다`가 있을 수 있고, `람다가 없는 클로저`가 있을 수 있다.

```kotlin
val list = listOf(1, 5, 7, 10)
val divider = 5

// 언어가 클로저를 지원한다면 동작한다 -> 람다는 자신의 밖에 정의된 divider를 포획한다(divider)
list.filter = { it % divider == 0 }

// 람다는 포획한 요소를 읽는 것 뿐만 아니라 변경할 수도 있다.
val sum = 0

list.filter { it % divider == 0 }
  // 자신의 밖에 정의된 sum을 변경할 수 있다.
  .forEach { sum += it }
```

- `람다`가 `가변 변수`를 포획해 변경할 수 있지만, 보통은 `환경의 상태`를 변경하지 않는 형태로 코드를 변경할 수 있다.

```kotlin
val list = listOf(1, 5, 7, 10)
val divider = 5

list.filter { it % divider == 0 }
   .sum() // list의 원소를 모두 더한 값을 돌려준다.
```

- `일반 함수`도 주변 환경의 요소를 포획해 읽거나, 변경할 수 있다.

```kotlin
var x = 100

fun useX() {
  // 주변 환경의 x를 포획해 변경한다.
  x++
}
```

## 🤫 컬렉션에 대한 연산

- `함수형 언어`는 `컬렉션`을 다룰 수 있는 `강력한 수단`을 제공한다.
    - `map()`, `filter()`, `any()`, `forEach()`등 많은 표준 라이브러리 함수를 지원하고 있다.

- `List`를 생성하는 여러가지 방법

```kotlin
/*
*  0 ~ 9까지의 리스트가 생성된다. 
*  -> List의 생성자는 인자가 두 개 존재하는데, 하나는 List의 크기이고 나머지 하나는
*     List의 각 원소를 초기화하는 람다다.
*/
val list1 = List(10) { it }

// 한 값(0)으로만 이뤄진 리스트가 생성된다.
val list2 = List(10) { 0 }

// 문자로 이뤄진 리스트를 생성한다.
val list3 = List(10) { 'a' + it }

// 정해진 순서를 반복해서 a, b, c 순서대로 반복되는 리스트를 생성한다.
val list4 = List(10) { list3[it % 3] }

// MutableList 역시 같은 방법으로 초기화 할 수 있다.
val mutableList1 = MutableList(5, { 10 * (it + 1) })

// 인자 목록 뒤에 마지막 파라미터가 람다라면 인자목록 외부에 람다를 위치시킬 수 있다. 
val mutableList2 = MutableList(5) { 10 * (it + 1) }
```

- 다양한 `컬렉션 함수`를 통해 `술어(Predicate)`로 원소를 검사할 수 있다.
    - `filter()`  : 주어진 술어와 일치하는 원소가 들어 있는 `새 리스트`를 만든다.
    
    ```kotlin
    val list = listOf(1, 2, 3, 4)
    
    list.filter { it % 2 == 0} // [2, 4] 짝수만 존재하는 리스트 반환
    ```
    
    - `any()` : 원소 중 어느 하나에 대해 `술어가 true` 를 반환하면 `true` 를 반환한다.
    
    ```kotlin
    val list = listOf(1, 2, 3, 4)
    
    list.any { it == 3 } // true -> 리스트에 3이라는 원소가 존재
    ```
    
    - `all()`  : `모든 원소`가 `술어와 일치`하는지 검사한다.
    
    ```kotlin
    val list = listOf(1, 2, 3, 4)
    
    list.all { it == 3 } // false -> 모든 리스트의 원소가 3은 아니기 때문이다.
    ```
    
    - `none()`  : 술어와 일치하는 원소가 `하나도 없는지 검사`한다.
    
    ```kotlin
    val list = listOf(1, 2, 3, 4)
    
    list.none { it == 5 } // true -> 모든 리스트의 원소가 5와 일치하지 않는다. 
    ```
    
    - `find()` : 술어와 일치하는 `첫 번째 원소`를 반환한다. 원소가 없다면 `예외를 발생`시킨다.
    
    ```kotlin
    val list = listOf(1, 2, 3, 4)
    
    list.find { it % 2 == 0 } // 2가 반환된다 -> 4도 조건에 일치하지만 2가 첫 원소이기 때문 
    ```
    
    - `firstOrNull()` : 술어와 일치하는 `첫 번째 원소`를 반환한다. 원소가 없다면 `null`을 반환한다.
    
    ```kotlin
    val list = listOf(1, 2, 3, 4)
    
    list.firstOrNull { it == 5 } // null이 반환된다 -> 일치하는 원소가 없기 때문이다.
    ```
    
    - `lastOrNull()` : 술어와 일치하는 `마지막 원소` 를 반환하고, `원소` 가 없다면 `null` 을 반환한다.
    
    ```kotlin
    val list = listOf(1, 2, 3, 4)
    
    list.lastOrNull { it % 2 == 0 } // 4를 반환한다 -> 2도 조건에 일치하지만 4가 마지막 원소
    ```
    
    - `count()`  : 술어와 일치하는 `원소의 개수`를 반환한다.
    
    ```kotlin
    val list = listOf(1, 2, 3, 4)
    
    list.count { it % 2 == 0 } // 2를 반환한다 -> [2, 4] 조건에 맞는 원소는 2개이다.
    ```
    

`filter()`와 `count()`는 `모든 원소`에 술어를 적용하지만, `any()`나 `find()`는 결과를 찾으면 이터레이션이 `즉시 중단`된다.

- `filter()`는 술어를 만족하는 그룹을, `filterNot()`은 만족하지 않는 원소들의 그룹을 반환한다.
    - `partition()`은 동시에 양쪽 그룹을 만들어낸다.
    
    ```kotlin
    val list = listOf(-3, -1, 5, 7, 10)
    
    // 술어를 만족하는 그룹 생성
    val isPositive = list.filter { it > 0 } // [5, 7, 10]
    // 술어를 만족하지 않는 그룹 생성
    val isNegative = list.filterNot { it > 0 } // [-3, -1]
    
    /*
    *  술어를 만족하는 그룹과 그렇지 않은 그룹을 동시에 생성
    *  parition() 함수는 List가 들어있는 Pair 객체를 만든다.
    *  -> 구조 분해 선언을 이용하면 여러 val 또는 var에 값을 바인딩 시킬 수 있다.
    */ 
    val (pos, neg) = list.partition { it > 0 }
    ```
    

- `filterNotNull()` 은 `null을 제외`한 원소들로 이뤄진 `새 List`를 반환한다.

```kotlin
val list = listOf(1, 2, null)

list.filterNotNull() // [1, 2] -> null을 제거한다.
```

- 합계를 구할 때 `정수 합계`를 구하는 `sumOf()` 를 사용할 수 있다.
    - `sumBy()`와 `sumByDouble()` 함수는 현재 `Deprecated` 되었다.
    - `sumOf()` 는 람다가 반환하는 값의 타입을 사용해 합계를 계산하기 때문에 `Overflow`가 발생하지 않도록 방지할 수 있다.
        - 람다에서 값을 반환할때, `toBigDecimal()` 또는 `toBigInteger()`를 호출하면 된다.

```kotlin
data class Product(
   val description: String,
   val price: Double
)

val products = listOf(
  Product("bread", 2.0),
  Product("wine", 5,0)
)

products.sumOf { it.price } // sumOf()로 price 값의 합계를 구한다.

// 반환하는 값이 Overflow가 발생할 여지가 있다면 더 큰 타입으로 변환해주면 된다.
products.sumOf { it.price.toBigDecimal() }

```

- `컬렉션`을 정렬할때는 여러가지 함수로 `오름차순` 또는 `내림차순`으로 정렬 할 수 있다.
    - `sorted()`와 `sortedBy()`는 컬렉션을 `오름차순`으로 정렬한다.
    - `sortedDescending()` 과 `sortedByDescending()` 은 컬렉션을 내림차순으로 정렬한다.
    - `~By`가 붙은 `정렬 함수`는 람다에 정해진 `비교 기준`에 따라서 정렬을 수행한다.
    - `minByOrNull()` 은 주어진 대소 비교 기준에 따라 찾은 `최솟값`을 돌려주고, 리스트가 비어있으면 null을 반환한다.
    
    ```kotlin
    data class Product(
       val description: String,
       val price: Double
    )
    
    val products = listOf(
      Product("bread", 2.0),
      Product("wine", 5,0)
    )
    
    val numberList = listOf(2, 4, 1, 0)
    
    numberList.sorted() // [0, 1, 2, 4] 
    
    products.sortedBy { it.price } // 가격을 기준으로 오름차순 정렬
    
    numberList.sortedDescending() // [4, 2, 1, 0] 
    
    products.sortedByDescending { it.price } // 가격을 기준으로 내림차순 정렬
    
    products.minByOrNull { it.price } // Product("bread" , 2.0)을 반환한다.
    ```
    
- `take()`와 `drop()`은 각각 `첫 번째 원소`를 취하거나, 첫 번째 원소를 제거하는 함수이다.

```kotlin
val list = listOf(1, 2, 3, 4, 5)

list.take(2) // [1, 2] -> 처음 두 개의 원소를 취한다.

list.drop(2) // [3, 4, 5] -> 처음 두 개의 원소를 버린다.
```

- `takeLast()` 와 `dropLast()` 는 각각 마지막 원소를 취하거나, 마지막 원소를 제거한다.

```kotlin
val list = listOf(1, 2, 3, 4, 5)

list.takeLast(2) // [4, 5] -> 마지막 두 개의 원소를 취한다.

list.dropLast(2) // [1, 2, 3] -> 마지막 두 개의 원소를 버린다.
```

- `takeWhile()`과 `dropWhlie()` 은 각각 앞에서부터 `술어(Predicate)` 를 만족하지 않을 때까지 검사를 수행해 인수를 취한 후, `List로 반환`하거나 원소를 버리고 `List로 반환`한다.

```kotlin
val list = listOf(1, 2, 3, 4, 5)

list.takeWhile { it < 3 } // [1, 2] -> 3을 만났을때 거짓이 되므로 [1, 2] 반환

list.dropWhile { it < 3 } // [3, 4, 5] -> 3을 만났을때 거짓이 되므로 [3, 4, 5] 반환 
```

- `takeLastWhile()`과 `dropLastWhile()`은 원리는 같지만, `뒤에서`부터 술어를 만족하지 않을때까지 검사를 수행한다는 점이 `takeWhile()`과 `dropWhile()`과는 `다르다.`

```kotlin
val list = listOf(1, 2, 3, 4, 5)

list.takeLastWhile { it > 3 } // [4, 5] -> 3을 만났을 때 거짓이 된다.

list.dropLastWhile { it > 3 } // [1, 2, 3] -> 3을 만났을 때 거짓이 된다.
```

- `List`에서 본 연산 중 아래와 같은 연산은 `Set`에도 사용이 가능하다.
    - `maxByOrNull()`
    - `filter()`
    - `map()`
- `filter()`와 `map()`을 `Set`에 적용하면 `List`로 결과를 `반환`받는다는 것에 주의해야 한다.
    - 위의 연산 이외에도 `대부분의 연산`은 `사용가능` 하지만, `findFirst()`와 같이 컬렉션이 저장된 원소 순서에 따라 결과가 달라질 수 있는 연산을 적용하면 `실행할때마다 다른 결과`를 내놓을 수 있다는 점에 주의해야 한다.
    

## 🫢 멤버 참조

- `멤버 참조는` 함수, 프로퍼티, 생성자에 대해 뻔한 `람다`를 대신할 수 있다.
    - `멤버 함수`나 `프로퍼티 이름` 앞에는 그들이 속한 클래스 이름과 `이중 콜론(::)`을 위치시켜서 멤버 참조를 만들 수 있다.

```kotlin
data class Animal(
  val isTall: Boolean
)

fun main() {
   val animalList = listOf(Animal(true), Animal(false))
   
   // Boolean 타입의 isTall 멤버 프로퍼티를 멤버 참조로 넘기고 있다.
   animalList.filterNot(Animal::isTall)
}
```

- 객체의 `정렬 순서`를 지정해야 할 때는 `프로퍼티 참조`가 유용하다.
    - `sortedWith()`는 Comparator를 사용해서 리스트를 정렬한다.
        - `compareBy()`에 인자를 하나만 넘기면, `sortedBy()`와 같은 결과를 얻는다.

```kotlin
data class Animal(
  val name: String,
  val age: Int
)

fun main() {
  val animalList = listOf(Animal("dog", 10), Animal("cat", 20))
  
  // 나이 순으로 먼저 정렬하고, 이름 순으로 정렬한다.
  animalList.sortedWith(compareBy(
    Animal::age, Animal::name))
}
```

- `Kotlin`에서는 `함수 타입`이 필요한 곳에 `함수`를 바로 넘길 수 없지만 `함수에 대한 참조`는 넘길 수 있다.
    - `람다`에 로직을 넣는 것보다, 람다를 `별도의 함수`로 추출하면 코드를 더 이해하기 쉽게 작성할 수 있고, 람다가 커지고 복잡해지는 것을 막을 수 있다.

```kotlin
// Animal 클래스의 확장 함수로 isDog 함수를 추가했다.
fun Animal.isDog(): Boolean = this.name == "dog"

fun main() {
  val animalList = listOf(Animal("dog", 10), Animal("cat", 20))
  
  animalList.any(Animal::isDog) // true -> dog 라는 이름을 가진 동물이 하나 있다.
}
```

- `최상위 수준 함수`에 대한 참조를 만들 때는 `::function`  처럼 사용할 수 있다.

```kotlin
// Animal을 유일한 파라미터로 받는 최상위 함수 정의
fun isCat(animal: Animal) = animal.name == "cat"

fun main() {
  val animalList = listOf(Animal("dog", 10), Animal("cat", 20))
   
  animalList.filter(::isCat)      // [Animal("cat", 20)] 
  animalList.filterNot(::isCat)   // [Animal("dog", 10)]
}
```

- `클래스 이름`을 사용해 `생성자에 대한 참조`를 만들 수도 있다.

```kotlin
data class Student(
  val id: Int,
  val name: String
) 

fun main() {
   val names = listOf("Alice", "Bob")

   /*
   * mapIndexed의 람다 파라미터는 두 개(index, element)이므로,
   * Student 클래스의 생성자에 각각 id와 name으로 값이 바인딩되어 Student 객체로 변환된다.
   */
   val students = names.mapIndexed(::Student) 
}
```

- `확장 함수`에 대한 `참조`도 가능하다.

```kotlin
fun Int.times47() = times(47)

fun goInt(n : Int, g: (Int) -> Int) = g(n)

fun main() {
   // goInt에 Int 클래스의 확장함수 참조를 넘겨줄 수 있다.
   goInt(12, Int::times47)
}
```

## 😈 고차 함수

- `프로그래밍 언어`에서 `함수`를 `다른 함수`의 인자로 넘길 수 있거나, `함수`를 `함수`의 반환 값으로 돌려줄 수 있으면 `고차 함수`를 지원한다고 말한다.
- `filter()`, `map()`, `any()` 등이 고차 함수의 특징을 가지고 있다.

```kotlin
// 람다에 참조를 저장한다.
val isPlus: (Int) -> Boolean = { it > 0 }

fun main() {
  // 함수(isPlus())를 다른 함수(any())의 인자로 넘기는 고차 함수의 특징을 보여준다.
  listOf(1, 2, -3).any(isPlus)
}
```

- `참조`를 통해 `함수`를 `호출`하는 것은, `일반적인 함수`를 `호출`하는 것과 모양이 다르지 않다.

```kotlin
val helloWorld: () -> String = { "Hello world!" }

fun main() {
  // 일반 함수와 같이 호출이 가능하다.
  helloWorld()
}
```

- `함수`가 `함수 파라미터`를 받는 경우, 해당 인자로 `람다`나 `함수 참조`를 전달 받을 수 있다.

```kotlin

// List의 확장 함수 any를 구현한다면 아래와 같이 구현할 수 있을 것이다.
fun <T> List<T>.any(
  predicate: (T) -> Boolean
): Boolean {
  for (element in this) {
    if (predicate(element)
      return true
  }

  return false
}

fun main() {
 // any()를 여러 타입의 List에 호출할 수 있도록 제네릭 타입의 확장 함수로 정의했다.
 val ints = listOf(1, 2, -3)
 ints.any { it > 0 } 

 val strings = lisfOf("abc", " ")
 string.any { it.isBlank() }
}
```

- `함수의 반환 타입`이 `nullable`한 타입일 수 있다.
    - 함수의 반환 타입이 `nullable`한 타입인 것과, `함수 전체의 타입`이 `nullable`한 타입이 되는 것은 `다르다.`

```kotlin
// 함수의 반환 타입이 nullable한 타입이다.
val transform: (String) -> Int? = 
   { s: String -> s.toIntOrNull() }

// 함수 전체의 타입이 nullable한 타입이다.
val mightBeNull: ((String) -> Int)? = null

// 함수 전체의 타입이 nullble한 타입이라면 null-check 없이 호출이 불가능하다.
if (mightBeNull != null) {
   mightBeNull("abc")
}
```

## 🤭 List 조작하기

- `묶기 연산(Zipping)`과 `평평하게 하기(flattening)` 연산은 List를 다룰때 흔히 사용하는 연산이다.
    - 묶기 - `zip()`
        - 두 List의 원소를 `하나씩 짝짓는 방식`으로 묶어준다.
    
    ```kotlin
    fun main() {
      val left = listOf("a", "b", "c", "d")
      val right = listOf("q", "r", "s", "t")
    
      // 두 리스트를 (왼쪽 리스트의 원소, 오른쪽 리스트의 원소)와 같이 순서쌍을 생성해 묶어준다.
      left.zip(right) // [(a, q), (b, r), (c, s), (d, t)]
    
      // 문자가 들은 리스트와 숫자로 이뤄진 IntRange를 순서쌍으로 생성해준다.
      left.zip(0..4) // [(a, 0), (b, 1), (c, 2), (d, 3]
    
      // 하나의 리스트라도 Iteration 중에 원소가 전부 사용되면 zip() 연산은 중단된다.
      (10..100).zip(right) // [(10, q), (11, r), (12, s), (13, t]
    }
    ```
    
- `zip()` 연산을 통해 만들어진 `Pair` 대해 `연산을 적용`하는 기능도 있다.

```kotlin
data class Person(
  val name: String, 
  val id: Int
)

fun main() {
  val names = listOf("Bob", "Jill")
  val ids = listOf(1731, 9274)
  
  // zip()을 통해 만들어진 Pair에 대해 연산을 수행할 수 있다.
  names.zip(ids) { name, id -> 
    Person(name, id)
  }
}
```

- `하나의 List`에서 어떤 원소와 그 원소에 `인접한 다음 원소`를 묶으려면 `zipWithNext()`를 사용하면 된다.

```kotlin
fun main() {
  val list= listOf('a', 'b', 'c', 'd')
  
  list.zipWithNext() // [Pair(a, b), Pair(b, c), Pair(c, d)]
  
  // zipWithNext() 또한 생성된 Pair에 대해 연산을 적용할 수 있다.
  list.zipWithNext() { a, b -> "$a$b" }
}
```

### 😐 List 평평하게 하기

- `flatten()` 은 각 원소가 List인 List를 인자로 받아서 `원소가 따로따로 들어있는 List`를 만들어준다.

```kotlin
val list = listOf(listOf(1, 2), listOf(3, 4))

// List<List<Int>> -> List<Int>로 변환해준다.
list.flatten() // [1, 2, 3, 4]
```

- `flatten()` 과 `map()` 연산을 모두 수행해야 하는 경우가 흔하기 떄문에, flatMap()이라는 합성 연산을 제공한다.

```kotlin
class Book(
  val title: String,
  val authors: List<String>
)

fun main() {
  val books = listOf(
    Book("1984", listOf("George Orwell"), 
    Book("Ulysses", listOf("James Joyce")))

  // map()은 작가의 List의 List를 생성한다. 그러므로 flatten()을 호출해야 사용하기 편하다.
  books.map { it.authors }.flatten() 

  // flatMap()을 사용하면 위의 작업을 한 번에 만들어 낼 수 있다.
  books.flatMap { it.authors }
}
```

## 😯 Map 만들기

- `Map`을 사용하면 키를 사용해 값에 빠르게 접근할 수 있다.
- 표준 라이브러리 함수인 `groupBy()`를 이용하면 특정 기준에 따라 `그룹핑 된 결과`를 `Map`에 담아 반환한다.

```kotlin
fun main() {
  // 사람의 나이를 기준으로 그룹핑 된 map을 반환한다.
  val map: Map<Int, List<Person>> = people().groupBy(Person::age)

  // filter()를 사용하면, 나이 별로 filter()를 반복 호출해야 결과를 얻을 수 있다.
  people().filter { it.age == 20 }
  people().fileter { it.age == 15 } 
  ...
}
```

- 그룹이 두 개만 필요한 경우에는 술어에 의해 컬렉션 내용을 `두 그룹`으로 나누는 `partition()` 함수가 더 직접적이다.
    - `groupBy()`는 결과 그룹이 세 개 이상인 경우 적합하다.

- `List`에 대해서 `associateWith()`를 사용하면, 리스트 원소를 키로 하고 `associateWith()` 함수에 전달된 람다를 `리스트 원소에 적용한 값`을 `반환 값`으로 하는 `Map`을 만들 수 있다.

```kotlin
val map: Map<Person, String> = people().associateWith { it.name }
```

- `associateBy()`는 리스트 원소가 반환 값이 되고, 람다를 `리스트 원소에 적용한 값`이 `키`가 된다.
    - `associateBy()` 함수가 작업을 진행하는 도중 키가 겹치는 문제가 생기면 일부 객체가 제대로 들어가지 않을 수 있다.
    - `맨 나중`에 생성되는 `원소가 Map에 포함`된다(Map에서 키가 겹치면 value가 계속 덮어 씌워지기 때문이다.)

```kotlin
val map: Map<String, Person> = people().associateBy { it.name }
```

- `getOrElse()`는 키가 없을 때 `디폴트 값을 계산하는 방법`이 담긴 `람다`를 인자로 받는다.
    - `getOrPut()`은 `MutableMap`에만 적용할 수 있고, 키가 없을 때 값을 계산한 후 Map에 저장하고 저장한 값을 반환한다.

```kotlin
val map = mapOf(1 to "one", 2 to "two")

map.getOrElse(0) { "zero" } // 0에 해당하는 value가 없으므로, zero를 반환

// 읽기 전용 Map을 변경 가능한 Map으로 변환 가능하다.
val mutableMap = map.toMutableMap()

mutableMap.getOrPut(0) { "zero" } 
```

- `Map`에서도 `filter()` 연산을 적용할 수 있고, `filterKeys()` 와 `filterValues()` 와 같은 연산도 제공한다.
    - `filter()` : `Entry 전체`에 대해 술어를 적용한다.
    
    ```kotlin
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    
    map.filter { entry -> entry.key % 2 == 1 && entry.value.contains('o')
    ```
    
    - `filterKeys()` : Map의 `Key`에 대해 술어를 적용한다.
    
    ```kotlin
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    
    map.filterKeys { it % 2 == 1 } 
    ```
    
    - `filterValues()` : Map의 `Value`에 대해 술어를 적용한다.
    
    ```kotlin
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    
    map.filterValues { it.conatins('o') }
    ```
    
- `Map`에서는 `map()`, `mapKeys()`, `mapValues()` 와 같은 연산으로 `Map`을 변환할 수 있다.
    - `map()` : Map의 각 원소(Entry)에 접근해서 Map을 변환한다.
    
    ```kotlin
    val map = mapOf(2 to "two", 4 to "four")
    
    map.map { "${it.key}=${it.value}" } // list 형태로 변환된다.
    
    map.map { (key, value) -> "$key=$value" } // 람다 파라미터 명시도 가능하다.
    
    map.mapKeys { (num, _) -> -num } // 모든 키의 값이 변환된 새 Map을 반환한다.
    
    map.mapValues { (_, value) -> "minus $value" } // 모든 값이 변환된 새 Map을 반환
    ```
    
- `any()` 나 `all()` 과 같은 함수도 `Map`에 적용이 가능하다.

```kotlin
val map = mapOf(1 to "one", -2 to "minus two")

map.any { (key, _) -> key < 0 } 
map.all { (key, _) -> key < 0 }

map.maxByOrNull { it.key } // 원소가 없을 수도 있으므로 nullable한 타입을 반환한다.
```

## 😯 시퀀스(Sequence)

- `Kotlin`의 `Sequence`는 List와 비슷하지만, Sequence를 대상으로 해서는 `Iteration`만 수행이 가능하다.
    - 인덱스를 써서 `Seqeunce`의 원소에 접근할 수 없다.
    - `Seqeunce`는 Java 또는 다른 함수형 언어에서는 `Stream`이라고 부른다.
    - `List`에 대한 연산은 `즉시(eagerly)` 계산된다.
        - `List`의 연산을 연쇄시키면 첫 번째 연산의 `결과`가 나온 후에야 `다음 연산` 적용이 가능하다.

```kotlin
val list = listOf(1, 2, 3, 4)

list.filter { it % 2 == 0 }
  .map { it * it }
  .any { it < 10 }
```

- `즉시 계산`은 단순하지만 최적이 아니다.
    - `any()`를 만족하는 첫 번째 원소를 만나서 적용한 뒤 `연쇄적인 연산`을 멈출 수 있다면 합리적이다.
    - `즉시 계산`은 `수평적 평가`라고 한다.
    
    ![image](https://github.com/AK-47-Study/atomic-kotlin-study/assets/91787050/f1c157aa-cb53-40de-8be4-cfd010c5051c)

    - 다음 줄에 있는 연산을 수행하기 전에, 현재 `수평적 수준`에 있는 모든 원소에 대해 `연산이 처리`되어야 한다.
    
- `즉시 계산`의 대안으로 `지연 계산`이 있다.
    - 지연 계산은 `계산이 필요할 때`만 계산을 `수행`한다.
    - 시퀀스에 대해 `지연 계산`을 수행하는 것을 `수직적 평가`라고 한다.

    ![image](https://github.com/AK-47-Study/atomic-kotlin-study/assets/91787050/b824534e-08ca-4012-a0d2-d2d57e58d482)

    - `지연 계산`을 사용하면, 어떤 원소와 연관된 값이 `진짜 필요할 때`만 그 원소와 `관련된 연산`을 `수행`한다.
    - `원본 컬렉션`의 마지막 원소를 처리하기 전에 `최종 결과`를 찾아내면 나머지 원소는 처리하지 않는다.
    
- `filter()`나 `map()`을 `Sequence`에 대해 호출하면 다른 `Sequence`가 생기며, 계산 결과를 요청할 때 까지는 아무 일도 벌어지지 않는다.
    - `새 Seqeunce`는 모든 연산에 대한 정보를 저장해 두고, `필요할 때`만 `저장된 연산`을 `수행`한다.

```kotlin
val r = listOf(1, 2, 3, 4)
   .asSequence() // Sequence() 사용 -> 지연 연산 사용
   .filter(Int::isEven)
   .map(Int::square) // 현재 객체의 타입은 kotlin.sequences.TransformingSequence 이다.
```

- `Sequence의 연산`에는 두 종류가 있다.
    - 중간 연산과 최종 연산이 있다.
    - 중간 연산은 `Sequence`를 내놓고, 최종 연산은 `Sequence가 아닌 값`을 내놓는다.

```kotlin
val result = listOf(1, 2, 3, 4)
    .asSequence()
    .filter(Int::isEven)
    .map(Int::square)
    .toList() // [4, 16] -> 최종 연산을 수행하면 모든 연산이 실행된다.
```

- `generateSequence()` 를 사용하면 자연수를 이용한 `무한 시퀀스`를 만들 수 있다.
    - 람다가 `null`을 반환하면 시퀀스가 끝난다.
    - 첫 번째 인자는 `시퀀스의 초기 값`이고, 뒤에 붙는 람다는 이전 원소로부터 `다음 원소를 만드는 방법`을 정의한다.

```kotlin
// 시퀀스의 초기 값은 1이며, 1씩 증가하는 무한 시퀀스를 만든다.
val naturalNumbers = generateSequence(1) { it + 1 }

// 앞에서 3개의 원소만 추출해서 List로 만들어 반환한다 -> [1, 2, 3]
naturalNumbers.take(3).toList()
```

- 첫 번째 인자를 요구하지 않고 `Sequence의 다음 원소`를 반환하는 람다만 받는 `generateSequence()` 함수도 존재한다.

```kotlin
val items = mutableListOf("first", "second", "third", "XXX", "4th")

val seq = generateSequence {
   /*
   * removeAt(0)은 List의 맨 처음 원소를 제거하고 그 원소를 반환한다.
   * takeIf()는 수신 객체가 조건을 만족하면 반환하고, 아니면 null을 반환한다.
   */
   items.removeAt(0).takeIf { it != "XXX" }
}

seq.toList() // ["first", "second", "third"]
```

- `Sequence`는 한 번만 `Iteration` 할 수 있다.
    - 두 번 `Iteration`을 시도하려고 하면 `예외`가 `발생`한다.
        - `반복 Iteration`이 가능한 `시퀀스`도 존재한다.
    - 두 번 이상의 `Iteration`이 필요하다면 우선 `시퀀스`를 `Collection 타입` 중 하나로 `변환`해야한다.

- `takeIf()` 대신 항상 일반 `If` 를 사용할 수 있지만, `연쇄 호출` 중간에 자연스럽게 사용하고 코드의 가독성을 올리려면 `takeIf()`를 사용하는 것이 좋다.

```kotlin
// takeIf() 사용
generateSequence(6) {
  (it - 1).takeIf { it > 0 }
}

// 일반 If문 사용
generateSequence(6) {
  if (it - 1 > 0) it else null
}
```

## 🫡 지역 함수

- `함수 안에서도 함수`를 정의할 수 있다. 이런 함수를 `지역 함수`라고 한다.
- `지역 함수`는 자신이 속한 함수 내부에서만 볼 수 있으므로, `이름 공간(namespace)` 을 오염시키지 않는다.

```kotlin
fun main() {
  val logMsg = StringBuilder()
  // 지역 함수는 자신이 속한 함수 내부에서만 볼 수 있다.
  fun log(message: String) = logMsg.appendLine(message)
}
```

- 지역 함수는 `클로저(Closer)`이다. 따라서 자신을 둘러싼 환경의 `var`나 `val`을 `포획`할 수 있다.
    - `지역 확장 함수`를 정의하는 것도 가능하다.

```kotlin
fun main() {
  fun String.exclaim() = "$this!"
}
```

- `함수 참조`를 사용해 `지역 함수`를 참조할 수 있다.

```kotlin
fun main() {
  fun isEven(number: Int) = number % 2 == 0

  val numbers = listOf(1, 2, 3, 4)
  
  // 최상위 레벨 함수 처럼 ::function으로 함수의 참조를 넘길 수 있다.
  numbers.any(::isEven)
}
```

- `isEven()` 함수는 한 번만 사용되므로, 람다로 정의하는 쪽이 좋을 수 있다.
    - 람다로 정의하기 어렵거나, 람다가 커지는 경우 `익명 함수`를 사용하는 것도 방법이 될 수 있다.
    - `익명 함수`는 `fun 키워드`로 함수를 정의하는 것은 `일반 함수`와 같지만, 함수의 이름을 붙이지 않는다는 점에서 `일반 함수 정의`와 다르다.

```kotlin
fun main() {
   listOf(1, 2, 3, 4).any(
     fun(number: Int): Boolean {
       if (number % 2 == 0) {
         return true
       }

       return false
     })
}
```

- `함수`가 `함수`를 `반환`하는 경우, 반환된 함수를 사용할 수 있다.

```kotlin
fun first(): (Int) -> Int {
  val func = fun(i: Int) = i + 1
  func(1)
}

fun main() {
  // first()를 호출하면, 함수를 반환하므로 바로 뒤에 인자 목록을 추가해 반환된 함수를 호출할 수 있다.
  first()(1)
}
```

## 😀 List 접기

- `fold()`는 리스트의 모든 원소를 순서대로 조합해서 `결과값`을 `하나` 만들어낸다.
    - `fold()`는 순수 함수형 언어에서 값을 `누적시키는 유일한 방법`이다.
    - `Kotlin`에서는 여전히 일반 `for 루프`를 사용하는 경우가 있다.

```kotlin
val list = listOf(1, 10, 100, 1000)

/*
* fold()는 초기 값을 받고, 누적 된 값과 현재 원소에 대해 연산을 연속적으로 적용시킨다.
* fold()는 더 이상 리스트에 원소가 없을 때 연산을 중단하고, 마지막 sum을 반환한다.
*/
list.fold(0) { sum, n -> 
  sum + n
}
```

- `fold()` 는 원소를 처리하는 방향에 따라서 두 가지로 나뉜다.
    - `fold()`  : 원소를 `왼쪽에서 오른쪽`으로 처리
    - `foldRight()` : 원소를 `오른쪽에서 왼쪽`으로 처리

- 첫 번째 원소가 `누적값의 초기값`이 되어야 할때는 `reduce()`와 `reduceRight()`를 사용할 수 있다.

```kotlin
val chars = "A B C D E".split(" ")

chars.reduce { acc, e -> "$acc $e" } // A B C D E

chars.reduceRight { acc, e -> "$acc $e" } // E D C B A
```

- `runningFold()` 와 `runningReduce()` 는 각각의 중간 단계 값을 포함해서 List로 반환한다.

```kotlin
val list = listOf(11, 13, 17, 19)

// 초기 값인 7이 저장되고, List의 각 원소와 연산을 진행하며 각 과정의 값을 저장한다.
list.runningFold(7) { sum, n -> 
  sum + n
} 

// 초기 값으로 List의 첫 원소를 저장하고, 각 원소와 연산을 진행하며 중간 과정의 값을 저장한다.
list.runningReduce { sum, n -> 
  sum + n
}
```

## 🤔 재귀 - Recursion

- `재귀`는 `함수 안`에서 `함수 자신을 호출`하는 프로그래밍 기법이다.
    - 코드는 읽기 쉽지만 `처리 비용`이 많이 든다.
- `꼬리 재귀(tail recursion)`은 일부 재귀 함수에 명시적으로 적용할 수 있는 `최적화 방법`이다.

```kotlin
fun factorial(n: Long): Long {
  if (n <= 1) return 1
  return n * factorial(n - 1) // 재귀 호출
}
```

- `StackOverflow` 에러를 막기 위해서는 `Iteration`을 사용해야 한다.
    - 호출 스택 넘침을 막기 위해 함수형 언어들은 `꼬리 재귀`라는 기법을 사용한다.
    - 꼬리 재귀는 `tailrec 키워드`를 사용해 만든다.
        - 이 키워드를 사용하면 `재귀 호출`을 `Iteration`으로 변환해 `호출 스택 비용을 제거`해준다.
        - `꼬리 재귀`는 `컴파일러`가 수행하는 `최적화`에 해당하고, `모든 재귀 함수`가 대상이 될 수는 없다.
        - `tailrec`을 사용하려면, `재귀`가 `마지막 연산`이어야 한다.
            - `재귀 함수`가 `자기 자신을 호출`해 얻은 `결과 값`을 아무 연산도 적용하지 않고 `즉시 반환`해야 한다는 의미이다.

```kotlin
// tailrec 적용 불가
fun factorial(n: Long): Long {
  if (n <= 1) return 1
  // 재귀가 마지막 연산이 아니다 -> 자기 자신을 호출해 얻은 결과에 n을 곱하고 있다.
  return n * fatorial(n - 1) 
}

tailrec fun factorial(n:Long, accumulator:Long): Long = 
  // 재귀가 마지막 연산이다 -> 자기 자신을 호출해 얻은 결과를 즉시 반환한다.
  if (n == 0L) accumulator else factorial(n - 1, accumulator + 1)
```

- `꼬리 재귀` 예제 → `피보나치 수열` 구하기
    - `디폴트 인자 값`을 사용하면 `지역 함수`를 사용하지 않아도 된다.
    - `정해진 값`이 아닌 `다른 값`을 넣으면 잘못된 결과가 나오기 때문에, `외부 함수`로 `지역 꼬리 재귀 함수`를 가려주어서 사용자가 `잘못 호출`하지 않도록 `보호장치`를 가지고 있는 것이다.

```kotlin
fun fibonacci(n: Int): Long {
  tailrec fun fibonacci(
    n: Int,
    current: Long,
    next: Long
  ): Long {
    if (n == 0) return current
    return fibonacci(n - 1, next, current + next)
  }

  return fibonacci(n, 0L, 1L)
}
```
