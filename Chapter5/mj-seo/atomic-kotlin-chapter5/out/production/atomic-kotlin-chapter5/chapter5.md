# Chapter5

## 😔 인터페이스

- `인터페이스`는 `클래스`가 무엇을 하는지는 기술하지만, 어떻게 하는지는 기술하지 않는다.
- `인터페이스`는 일반적으로 구현은 포함하지 않는다.
- `인터페이스`는 존재의 목표나 임무를 기술하고, `클래스`는 세부적인 구현 사항을 포함한다.
- `인터페이스`는 `class` 키워드 대신 `interface 키워드`를 사용해 정의한다.
    - `인터페이스`를 구현한 클래스를 정의하려면, 클래스 이름 뒤에 `콜론(:)`과 `인터페이스 이름`을 넣어주면 된다.

```kotlin
interface Computer {
  // 함수를 선언하지만, 아무 구현도 제공하지 않는다.
  fun prompt(): String
  fun calculateAnswer(): Int
}

class Desktop: Computer {
  // 인터페이스 멤버를 구현할 때는 override 변경자를 붙여야 한다.
  override fun prompt() = "Hello!"
  override fun calculateAnswer() = 11
}
```

- `인터페이스`는 함수를 선언하지만, `아무 구현`도 제공하지 않는다.
    - `인터페이스`를 구현하는 `클래스(구현체)`가 구현하는 본문을 제공해야 한다.

```kotlin
interface Player {
  // 인터페이스가 프로퍼티를 선언할 수도 있다.
  val symbol: Char
}

class Food : Player {
  // 프로퍼티를 선언한 인터페이스를 구현하는 클래스는 항상 프로퍼티를 오버라이드해야 한다.
  override val symbol = '.'
}

class Robot : Player {
  // 값을 반환하는 Custom Getter를 사용해 프로퍼티를 오버라이드 한다. 
  override val symbol get() = 'R'
}

// 생성자 인자 목록에서 symbol을 오버라이드 할 수 있다.
class Wall(override val symbol: Char) : Player
```

- `Enum`도 `인터페이스`를 구현할 수 있다.

```kotlin
interface Hotness {
  fun feedback(): String
}

enum class SpiceLevel : Hotness {
  // 각 Enum 원소들의 본문에서 feedback() 함수를 오버라이드 하면 된다.
  Mild {
    override fun feedback() = "It adds flavor!"
  },
  Medium {
    override fun feedback() = "Is it warm in here?"
  }
}
```

- `단일 추상 메서드(Single Abstract Method, SAM)` 인터페이스는 하나의 `추상 함수`만을 가지는 특별한 인터페이스이다.

```kotlin
// SAM 인터페이스는 fun interface 키워드를 이용해 정의한다.
fun interface ZeroArg {
  fun f(): Int
}

fun interface OneArg {
  fun g(n: Int): Int
}

// 클래스가 SAM 인터페이스를 구현할 수 있다.
class VerboseZero : ZeroArg {
  override fun f() = 11
}

// 람다를 사용해서 구현할 수 있다. 이런 경우를 SAM 변환이라고 한다.
val samZero = ZeroArg { 11 }
```

- `SAM 인터페이스`는 `fun interface` 키워드를 이용해 정의한다.
    - `구현 방법`에는 클래스가 `인터페이스를 구현`하는 것과, `람다를 사용`하는 방법이 있다.
        - `람다`를 사용하는 경우에는 `SAM 변환(SAM conversion)`이라고 부른다.
        - `람다`를 사용하면 한 객체를 만들기 위해 `클래스를 억지로 정의`할 필요가 없다는 `장점`이 있다.
    - `SAM 인터페이스`가 필요한 메서드에 인터페이스를 구현하는 `구현체 대신에 람다`를 바로 전달할 수 있다.
    

## 😆 복잡한 생성자

- `생성자`는 새 객체를 만드는 `특별한 함수`이다.
- `객체 생성 과정`을 좀 더 제어하고 싶다면, 클래스 본문에 `생성자 코드`를 `추가`할 수 있다.

```kotlin
private var counter = 0

class Message(text: String) {
  private val content: String
  
  // init 블록은 객체 생성 중에 실행된다.
  init {
    counter += 10
    content = "[$counter] $text"
  }
  
  // init 블록이 여러개라면 클래스 본문에 정의된 순서대로 실행된다.
  init {}
  init {} ...
}
```

- `생성자`는 `생성자 파라미터 목록`과 `init 블록`을 합친 것과 같다.
- `init 블록`을 여럿 정의할 수 있고, 각 init 블록들은 `클래스 본문에 정의된 순서대로 실행`된다.
    - 크고 복잡한 클래스에서 `init 블록`을 여기저기 분산시키면 `유지 보수 문제`를 `야기`할 수 있다.

## 🤓 부생성자

- 같은 클래스에 속한 `객체를 만들어내는 방법`을 `여러가지` 원할 경우, 생성자를 `오버로드` 해야 한다.
- `생성자 파라미터 목록`과 `프로퍼티 초기화`, `init 블록`들을 모두 합한 생성자는 `주생성자`라고 부른다.
- `부생성자`는 반드시 `this 키워드`를 통해서 `주생성자`나 다른 `부생성자`를 `호출`해야한다.

```kotlin
class WithSecondary(i: Int) {
  init {
    trace("Primary: $i")
  }
  
  // 부생성자가 주 생성자를 호출
  constructor(c: Char) : this(c - 'A') {
    trace("Secondary: '$c'")
  }
  
  // 부생성자가 달느 부생성자를 호출
  constructor(s: String) : this(s.first()) {}

  // 에러! -> 주생성자를 호출하지 않으면 컴파일이 안된다.
  constructor(f: Float) {}
}
```

- `부생성자`에서 다른 생성자를 호출하는 부분은 `생성자 로직 앞에 위치`해야 한다.
- `주생성자`는 언제나 `부생성자`에 의해 직접 호출되거나, 다른 `부생성자 호출`을 통해 간접적으로 호출되어야 한다.
    - `생성자` 사이에 공유되어야 하는 모든 `초기화 로직`은 반드시 `주생성자에 위치`해야 한다.
- 부생성자를 쓸 때 `init 블록`을 꼭 쓸 필요는 없다.

## 😯 상속

- `상속`은 `기존 클래스`를 `재사용`하면서 변경해 `새로운 클래스`를 만드는 메커니즘이다.
- `특정 클래스`를 닮았지만 일부 차이가 있는 `새 클래스`가 필요하다면 `상속`을 이용할 수 있다.

```kotlin
// 상속 구문은 인터페이스를 구현하는 구문과 비슷하다. 콜론(:)뒤에 상속할 클래스의 생성자를 호출하면 된다.
open class Base

class Derived : Base()
```

- `기반 클래스(Super Class)`는 `open` 이어야 한다. `open`으로 지정되지 않은 클래스는 상속이 허용되지 않는다.
    - `Kotlin`은 `open 키워드`를 붙이지 않으면 기본적으로 `클래스는 final` 이다.
- `Kotlin`에서 `open 키워드`를 사용하면, 해당 클래스가 `상속을 고려해 설계`됐다는 사실을 `명시적으로 선언`한 것이기도 하다.

```kotlin
open class Animal {
  open fun bark() = println("Animal!")
  fun run() = "Run!!"
}

class Dog : Animal() {
  // open인 함수는 오버라이드 할 수 있다.
  override fun bark() = println("Wal!!")
  
  // error -> open이 아닌 함수는 기본적으로 final 이기 때문에, 오버라이드가 불가능하다.
  override fun run() = "Run!!!!!!!!"
}

fun letsBark(animal: Animal) = animal.bark()

fun main() {
  letsBark(Animal()) // -> Animal!
  letsBark(Dog()) // -> Wal!!
}
```

- 함수도 `open`이 아니라면 `오버라이드` 할 수 없다.
- `함수`를 `오버라이드` 하면, 각 타입에 따라서 `다른 동작`을 `수행`한다.
- `오버라이드 된 함수`가 아닌 `기반 클래스`의 함수를 `호출`하고 싶다면, `super 키워드`를 이용할 수 있다.

## 😲 기반 클래스 초기화

- `클래스`가 `다른 클래스`를 `상속`할 때, 두 클래스가 모두 제대로 초기화되도록 `아래의 생성자들`이 정상적으로 호출 되어야 한다.
    - `멤버 객체들`의 생성자
    - `파생 클래스에 추가된 객체`의 생성자
    - `기반 클래스`의 생성자

```kotlin
open class GreatApe(
  val weight: Double,
  val age: Int
)

// 기반 클래스에 생성자 파라미터가 있다면, 기반 클래스의 생성자 인자를 제공해야 한다.
open class Bonobo(weight: Double, age: Int) : 
  GreatApe(weight, age)
```

- `Kotlin`은 `객체`를 `생성`할 때, 사용할 `메모리를 확보`한 후 `기반 클래스의 생성자` → 다음 번 파생 클래스의 생성자 순으로 호출하며, 맨 마지막에 `파생된 클래스의 생성자`를 호출한다.

```kotlin
open class SuperClass2

// 기반 클래스 생성자 파라미터가 없어도, 기반 클래스 이름 뒤에 괄호를 붙이도록 강제한다.
class SubClass2 : SuperClass2()
```

- `Kotlin`은 기반 클래스의 생성자를 인자 없이 호출하기 위해 기반 클래스 이름 뒤에 괄호를 붙이도록 강제한다.
- `기반 클래스`에 `부생성자`가 있으면, 기반 클래스의 `주생성자` 대신 `부생성자`를 `호출`할 수 있다.

```kotlin
open class Base(val i: Int)

class Derived : Base {
  // 파생 클래스의 부생성자는 기반 클래스의 생성자를 호출한다.
  constructor(i: Int) : super(i)
  // 파생 클래스 자신의 생성자를 호출 할수도 있다.
  constructor() : this(9)
}
```

- `파생 클래스`의 `부생성자`는 기반 클래스의 생성자를 호출할 수도 있고, `파생 클래스` 자신의 생성자를 호출할 수도 있다.

## 🤩 추상 클래스

- `추상 클래스`는 하나 이상의 프로퍼티나 함수가 `불완전`하다는 점에서 일반 클래스와 다르다.
- `클래스 멤버`에서 본문이나 초기화를 제거하려면 `abstract 변경자`를 `멤버 앞`에 붙이면 된다.

```kotlin
abstract class WithProperty {
  // 초기화 코드가 없으면 타입 추론이 불가능하므로, abstract 참조에는 반드시 타입을 지정해야 한다.
  abstract val x: Int
}

abstract class WithFunctions {
  abstract fun f(): Int
  // abstract 함수의 반환 타입을 적지 않으면 Unit으로 간주된다.
  abstract fun g(n: Double)
}
```

```kotlin
interface Redundant {
  // interface에서 함수나 프로퍼티 정의가 있으면 기본적으로 추상 멤버이다.
  abstract val x: Int
  abstract fun f(): Int
}

interface IntList {
  val name: String

  // error! -> 컴파일 되지 않는다(인터페이스 안에서 프로퍼티에 값을 저장할 수 없음)
  val list = listOf(0)
}
```

- `인터페이스`에서 `abstract 변경자`를 사용하는 것은 `불필요한 중복`이므로 생략이 가능하다.
- `추상 클래스`는 상태를 가질 수 있지만, `인터페이스`는 상태를 가지지 않는다.
    - `추상 클래스`는 프로퍼티 안에 데이터를 저장할 수 있다.
    - `인터페이스`는 프로퍼티 선언은 가능하지만, `값을 저장`하는 것은 `금지`되어 있다.

```kotlin
interface PropertyAccessor {
  val a: Int
    // 내부에 정의된 프로퍼티가 상태를 바꿀 수 없는 경우에는 Custom Getter를 포함할 수 있다.
    get() = 11
}
```

- `인터페이스`도 내부에 정의된 `프로퍼티`가 상태를 바꿀 수 없는 경우에는 `프로퍼티의 Custom Getter`는 포함할 수 있다.

```kotlin
open class Animal
open class Mammal

// 기반 클래스가 둘 이상이면 에러! -> 한 클래스는 하나의 기반 클래스만 상속 가능
class Dolphin : Mammal(), Animal()

interface Animal
interface Mammal

// 인터페이스는 다중 구현(상속)이 가능하다.
class Dolphin : Animal, Mammal
```

- `클래스`는 하나의 기반 클래스만 상속 가능하지만, `인터페이스`는 `다중 구현`이 가능하다.

```kotlin
interface A {
  fun f() = 1
}

interface B {
  fun f() = 2
}

class C : A, B {
  /*
  * 구현한 인터페이스들의 함수의 시그니처가 동일한 경우 기반 클래스의 함수를 호출하려면, 
  * super<ClassName>으로 이름을 지정해야 한다.
  * -> A, B 인터페이스 모두 f() 함수를 가지고 있지만, 인터페이스 A의 f() 함수를 호출
  */
  override fun f() = super<A>.f()
}
```

## 😄 업캐스트

- `객체 참조`를 받아서 그 객체의 `기반 타입에 대한 참조처럼 취급`하는 것을 `업캐스트`한다 라고 말한다.

```kotlin
interface Animal {
  fun walk(): String
}

class Dog : Animal {
  override fun walk() = "Dog is walking!"
}

class Cat : Animal {
  override fun walk() = "Cat is walking!"
}

fun animalWalk(animal: Animal) = animal.walk()

fun main() {
  println(animalWalk(Dog())) // Dog is walking
  println(animalWalk(Cat())) // Cat is walking
}
```

- `animalWalk()`의 파라미터는 기반 클래스인 `Animal` 이므로, `Cat`과 `Dog` 타입 모두 `허용`되고 Animal 클래스의 객체처럼 취급된다.
    - 이를 구체적인 타입(하위 클래스)이 기반 타입(상위 클래스)으로 `업캐스트 되었다`고 말한다.
    - `업캐스트`를 사용하지 않는데, `상속을 사용`하는 거의 모든 경우는 `상속을 잘못 사용`하는 것일 수 있다.
    

```kotlin
interface Computer {
  fun on(): Unit
}

class MacBook : Computer {
  override fun on() = "MacBook is on"
  fun showAppleIcon() = "Apple!"
}

fun findComputer(computer: Computer) {
  computer.on() // 호출 가능
  
  // MacBook 인스턴스를 Computer 인스턴스로 업캐스트 했으므로 showAppleIcon()은 호출할 수 없다.
  computer.showAppleIcon()
}
```

- `업캐스트`를 한 경우에는 `기반 타입`에 `공통으로 들어 있는 멤버`들만 `사용`이 가능하고, 하위 타입에서 정의된 멤버는 사용할 수 없다.

## 😐 다형성

- `다형성`은 프로그래밍에서 객체나 멤버의 여러 구현이 있는 경우를 말한다.

```kotlin
open class Pet {
  open fun speak() = "Pet"
}

class Dog : Pet() {
  override fun speak() = "Bark!"
}

class Cat : Pet() {
  override fun speak() = "Meow!"
}

fun talk(pet: Pet) = pet.speak()

fun main() {
  talk(Dog()) // Bark!
  talk(Cat()) // Meow!
}
```

- `Cat`과 `Dog`는 `Pet 타입`으로 업캐스트 되지만, 올바른 하위 클래스의 `speak()` 함수가 호출된다.
    - `다형성`은 부모 클래스 참조가 `자식 클래스의 인스턴스`를 가리키는 경우 발생한다.
    - `다형성`은 `런타임에 일어나는 동적 디스패치`를 통해 어떤 `speak()` 함수를 호출해야 하는지 알고 올바른 하위 타입의 함수를 호출하게 된다.
    - `실행 시점`에 타입을 결정하는 `추가 로직`이 성능에 약간 부정적인 영향을 끼친다.
    

## 😝 합성

- `기존 클래스`의 객체를 `새 클래스 안에 생성하는 접근 방법`을 `합성`이라고 부른다.
- `합성`을 쓸 경우에는 `기본 코드의 기능`을 `재사용`하는 것이다.

```kotlin
interface Building
interface Kitchen

interface House: Building {
  val kitchen: Kitchen
}
```

- 집은 건물(빌딩)이고 `(is ~ a)`, 집은 부엌을 포함하고 있다 `(has ~ a)`
    - 여기서 알 수 있는 것은 `상속` 관계는 `A는 B이다`로 표현 가능하며, `합성`은 `A는 B를 포함하고 있다`로 표현 가능해야 한다.
    

```kotlin
class Features {
  fun f1() = "feature1"
  fun f2() = "feature2"
}

class Form {
  private val features = Features()

  fun operation1() = features.f2() + features.f1()
}
```

- `Features` 클래스는 `Form`의 연산에 대한 구현을 제공하고 있다.
- `Form`을 사용하는 `클라이언트`는 features에 접근할 수 없으므로, Form을 구현하는 더 나은 방법을 찾아낸다면 `언제든 자유롭게 제거하고 개선`할 수 있다는 `장점`이 있다.
    - 한번 `Public API`로 공개된 코드는 `다시 수정`하거나 `개선할 기회`조차 잃는다는 사실을 안다면, 합성된 객체는 `숨겨두는 것`이 좋을 수 있다(내부 구현 은닉)
    - `시스템`에 따라서는 `멤버 객체를 공개할 때` 인터페이스가 더 `깔끔`해지는 경우도 있다.
- `상속`보다는 `합성`을 먼저 시도하는 것이 좋은 선택이 될때가 많다.

## 🤔 상속과 확장

- `상속`을 허용함으로 인해서, `코드`를 이해하고 `유지 보수`하기 어려워지는 상황이 올 수도 있다.

```kotlin
open class Heater {
  fun heat(temperature: Int) = 
    "heating to $temperature"
}

fun warm(heater: Heater) {
  heater.heat(70)
}
```

만약 위의 코드에서 `냉방 기능`이 필요하다면, `상속`을 통해 `클래스를 확장`하면 된다.

```kotlin
class HVAC : Heater() {
  fun cool(temperature: Int) = 
    "cooling to $temperature"
}

fun warmAndCool(hvac: HVAC) {
  hvac.heat(70)
  hvac.cool(60)
}
```

- `리스코프 치환 원칙(LSP)`에 의해, `HVAC`에 대해서도 `warm()` 함수는 여전히 `작동`한다.
- `기반 클래스 타입의 참조`를 통해서만 `파생 클래스 인스턴스`에 접근한다면, 파생 클래스에 추가된 함수를 호출할 방법은 없으므로 `쓸데없이 함수를 추가한 셈`이 될 수 있어 `주의`해야 한다.

`Heater 클래스`의 소스코드가 변경 가능하다면, `상속`을 하지 않고 아래와 같은 설계를 통해 클래스를 유연하게 만들 수 있다.

```kotlin
class TemperatureDelta(
  val current: Double,
  val target: Double
)

fun TemperatureDelta.heat() {
  if (current < target)
    trace("heating to $target")
}

fun TemperatureDelta.cool() {
  if (current > target) 
    trace("cooling to $target")
}

fun adjust(deltaT: TemperatureDelta) {
  deltaT.heat()
  deltaT.cool()
}
```

`소스 코드`를 변경할 수 없는 경우에는 `확장 함수`를 `사용`해 상속을 사용하지 않고 `기반 클래스`의 인스턴스를 직접 `확장`할 수 있다.

```kotlin
fun Heater.cool(temperature: Int) = 
  "cooling to $temperature"

fun warmAndCool(heater: Heater) {
  heater.heat(70)
  heater.cool(60)
}
```

- `Kotlin` 에서는 `필수적인 메서드`만 `정의`해 `포함`하는 간단한 `인터페이스`를 만들고, `모든 부가 함수`를 `확장`으로 정의하라라는 `철학`이 있다.

`확장 함수` 대신 `멤버 함수`를 써야하는 경우도 존재한다.

함수가 `private 멤버`에 접근해야 한다면, `멤버 함수`를 정의하는 방법 밖에 없다.

```kotlin
class Z(var i: Int = 0) {
  private var j = 0
  fun increment() {
    i++
    j++
  }
}

fun Z.decrement() {
  i--

// error -> 확장 함수는 private 멤버에 접근할 수 없다. 
//  j--
}
```

`확장 함수`는 `오버라이드` 할 수 없다는 한계도 있다.

```kotlin
open class Base {
  open fun f() = "Base.f()"
}

class Derived : Base() {
  override fun f() = "Derived.f()"
}

fun Base.g() = "Base.g()"
fun Derived.g() = "Derived.g()"
```

- `함수`를 `오버라이드`할 필요가 없고 클래스의 `공개 멤버`만으로 충분하다면 `멤버 함수`로 구현할 수 있고, 또는 확장 함수로 구현할 수도 있다.
- `멤버 함수`는 `타입의 핵심`을 반영한다.
    - `확장 함수`는 타입의 존재에 `필수적이지는 않은`, 대상 타입을 `지원`하고 `활용`하기 위한 `외부 연산`이나 편리를 위한 연산을 위해 정의된다.

```kotlin
interface Device {
  val model: String
  val productionYear: Int
}

fun Device.overpriced() = model.startsWith("i")

fun Device.outdated() = productionYear < 2050
```

- `Device 인터페이스`의 본질을 이루는 것은 `model`과 `productionYear` 프로퍼티이다.
- `overpriced()`와 `outdated()` 같은 함수는 `확장 함수`나 `멤버 함수`로 정의될 수 있다.
    - `오버라이드` 될 가능성이 없다면 `확장 함수`로 정의하는 것이 좋다.
    - `확장 함수`로 만들지 `멤버 함수`로 만들지는 궁극적으로 `설계상의 선택`이라고 본다.

## 🤗 클래스 위임

- 클래스가 `기존의 구현`을 `재사용`하면서 동시에 인터페이스를 구현해야 하는 경우, `상속`과 `클래스 위임`이라는 두 가지 선택지가 있다.
- `클래스 위임`은 `상속`과 `합성`의 `중간 지점`이다.
    - 새 클래스 안에 `멤버 객체`를 심고, 상속과 마찬가지로 심겨진 `하위 객체`의 `인터페이스`를 `노출`시킨다.
    - 새 클래스를 `하위 객체`의 타입으로 `업캐스트` 할 수 있다.
    

```kotlin
interface Controls {
  fun up(velocity: Int): String
  fun down(velocity: Int): String
}

class SpaceShipControls : Controls {
  override fun up(velocity: Int) = 
    "up $velocity"
  
  override fun down(velocity: Int) = 
    "down $velocity"
}
```

`SpaceShipControls`의 제어 장치의 기능을 확장하거나 명령을 일부 조정하고 싶은데 이 클래스는 `open`이 아니라서 `상속`이 `불가능`하다.

`Controls`의 `멤버 함수`를 노출하기 위해서는, `SpaceShipControls`의 인스턴스를 프로퍼티로 하고, `Controls`의 모든 멤버 함수를 명시적으로 `SpaceShipControls`에 `위임`해야 한다.

```kotlin
class ExplicitControls: Controls {
  private val controls = SpaceShipControls()
  
  // 수동으로 위임 구현
  override fun up(velocity: Int) = 
    controls.up(velocity)
  

  override fun down(velocity: Int) = 
    // 변형한 구현
    controls.down(velocity) + "down!!!"
}
```

`언어 차원`에서의 `지원`이 없다면, 위와 같이 `수동`으로 위임을 위한 `코드를 작성`해야 하지만, `Kotlin`은 위임 과정을 `자동화`해주는 `기능`을 `제공`한다.

```kotlin
interface AI
class A : AI

// 클래스 B는 AI 인터페이스를 a 멤버 객체를 사용해(by) 구현한다.
class B(val a: A) : AI by a
```

- `인터페이스`에만 위임을 적용할 수 있다.
- `위임 객체`는 `생성자 인자`로 지정한 `프로퍼티`여야 한다.

```kotlin
class DelegatedControls(
  private val controls: SpaceShipControls = 
    SpaceShipControls()
): Controls by controls {
  override fun turboBoost(): String = 
    "${controls.turboBoost()}... boooooost!"
}
```

- `위임`을 하면 별도로 코드를 작성하지 않아도, `멤버 객체`의 함수를 `외부 객체`를 통해 `접근`할 수 있다.

`Kotlin`은 `다중 클래스 상속`을 허용하지 않지만, 클래스 위임을 사용해 `다중 클래스 상속`을 `흉내`낼 수 있다.

```kotlin
interface Rectangle {
  fun paint(): String
}

class ButtonImage(
  val width: Int,
  val height: Int
): Rectangle {
  override fun paint() = 
    "painting ButtonImage($width, $height)"
}

interface MouseManager {
  fun clicked(): Boolean
  fun hovering(): Boolean
}

class UserInput : MouseManager {
  override fun clicked() = true
  override fun hovering() = true
}

// 앞의 두 클래스가 open으로 정의되었어도, 다중 상속은 허용되지 않는다.
// class Button : ButtonImage(), UserInput()

class Button(
  val width: Int,
  val height: Int,
  var image: Rectangle = ButtonImage(width, height),
  private var input: MouseManager = UserInput()
): Rectangle by image, MouseManager by input

fun main() {
  val button = Button(10, 5)
  // Rectangle 타입의 paint() 함수 호출이 가능하다.
  button.paint()
  
  // MouseManager 타입의 clicked()와 hovering() 함수 호출이 가능하다.
  button.clicked()
  button.hovering()

  // 위임한 두 타입으로 업캐스트가 모두 가능하다.
  val rectangle: Rectangle = button
  val mouseManager: MouseManager = button
}
```

- `Button` 클래스는 `ButtonImage`와 `UserInput` 구현을 `모두 상속`할 수는 없지만, `위임`할 수 있다.
    - `위임`은 `다중 상속`의 필요성을 해결해준다.
    - `상위 클래스`가 `open`이 아니거나, 새 클래스가 다른 클래스를 이미 상속하고 있는 경우에 `클래스 위임`은 `좋은 해결책`이 될 수 있다.
- `클래스 위임`은 `합성`, `상속`, `클래스 위임` 중에 가장 마지막에 시도되어야 한다.
    - `합성`은 가장 단순한 방법으로, 대부분의 `유스케이스 해결`이 가능하다.
    - `상속`은 `타입 계층`과 이 `계층에 속한 타입 사이의 관계`가 필요한 경우 상속이 필요하다.
    - 위의 `두 가지 선택`이 모두 적합하지 않다면, `위임`을 사용할 수 있다.
