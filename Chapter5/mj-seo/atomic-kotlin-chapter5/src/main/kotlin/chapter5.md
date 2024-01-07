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
    - 


## 🧐 다운캐스트

- `기반 클래스`가 `파생 클래스`보다 더 큰 인터페이스를 가질 수 없으므로 `업캐스트`는 항상 안전하다.
- `다운캐스트`는 `실행 시점`에 일어나며, 실행 시점 `타입 식별` 이라고도 한다.
    - `기반 타입`이 `파생 타입`보다 더 좁은 인터페이스를 제공하는 클래스 계층에서는 업캐스트 수행시,                 컴파일러는 `어떤 함수`를 `호출`하면 안전한지 결정할 수 없다.

```kotlin
interface Base {
  fun f()
}

class Derived2: Base {
  override fun f() {}
  fun h() {}
}

fun main() {
  val b1: Base = Derived1() // 업캐스트
  b1.f() // 기반 클래스의 함수 호출
  b1.g() // 기반 클래스에 없는 함수이므로 호출이 불가능!

  val b2: Base = Derived2()
  b2.f() // 기반 클래스의 함수 호출
  b2.h() // 기반 클래스에 없는 함수는 호출 불가!
}
```

- `Base` 인터페이스에 정의되지 않은 `h()`와 `g()`는 업캐스트시 안전하게 `호출`이 `불가능`하다.
    - `잘못된 타입`으로 `다운캐스트`를 해서 존재하지 않는 멤버를 호출하지 않도록 `코틀린`은 스마트 캐스트 기능을 지원한다.

## ☺️ 스마트 캐스트

- `코틀린`의 `스마트 캐스트`는 자동 다운 캐스트이다.
- `is 키워드`는 어떤 객체가 특정 타입인지 `검사`한다. 검사 영역 안에서는 해당 객체를 검사에 성공한 타입이라고 간주한다.

```kotlin
fun main () {
  val b1: Base = Derived1() // 업캐스트
  if (b1 is Dervied1) b1.g() // 'is' 검사의 영역 내부
  
  val b2: Base = Derived2() // 업캐스트
  if (b2 is Dervied2) b2.h()
}
```

- `b1`이 `Derived1` 타입이면 `g()`를 호출할 수 있다. `b2` 역시 `Derived2` 타입이라면 `h()`를 호출할 수 있다.
- `스마트 캐스트`는 `is`를 통해 `when`의 인자가 어떤 타입인지 탐색하는 `when` 식 내부에서 유용하게 사용할 수 있다.

```kotlin
interface Creature

class Human : Creature {
  fun greeting() = "I'm Human"
}

class Dog : Creature {
  fun bark() = "Yip!"
}

class Ailen : Creature {
  fun mobility() = "Three legs"
}

fun what(c: Creture) = when (c) {
  is Human -> c.greeting()
  is Dog -> c.bark()
  is Alien -> c.mobility
  else -> "Something else"
}
```

- `what()`은 이미 `업캐스트`된 `Creature`를 받아서 정확한 타입을 찾는다.
- `Creatrue` 객체를 상속 계층에서 정확한 타입, 더 일반적인 `기반 클래스`에서 더 구체적인 `파생 클래스`로 다운 캐스트 한다.
- `값`을 만들어내는 `when 식`에서는 `else 가지`가 필요하다.

```kotlin
class SmartCast1(val c: Creature) {
  fun contact() {
    when (c) {
      is Human -> c.greeting()
      is Dog -> c.bark()
      is Alien -> c.mobility()
    }
  }
}

class SmartCast2(var c: Creature) {
  fun contact() {
    when (val c = c) {
      is Human -> c.greeting()
      is Dog -> c.bark()
      is Alien -> c.mobility()
    }
  }
}
```

- `자동 다운캐스트`는 대상이 `상수(val)`여야만 제대로 `작동`한다.
- `참조`가 `변경 가능`하다면, `타입을 검증한 시점`과 `함수를 호출한 시점` 사이에 참조가 가리키는 객체가 바뀔 가능성이 있다.
- `가변 프로퍼티`는 `스마트 캐스트` 할 수 없다.
- `식`이 `재계산`될 수 있는 경우에도 `스마트 캐스트`가 되지 않는다.
    - `식`이나 `표현식`을 실행할때마다 `결과가 달라질 수 있는 경우` 스마트 캐스트가 `안전`하지 않기 때문이다.

```kotlin
fun main() {
    val result: Any = calculateResult()

    if (result is String) {
        // 여기서 result는 String 타입으로 스마트 캐스트되어야 하지만, 실패할 수 있음
        println(result.length)
    }
}

fun calculateResult(): Any {
    // 식을 실행할때마다 결과가 바뀐다.
    return if (System.currentTimeMillis() % 2 == 0L) {
        "Even Time"
    } else {
        42
    }
}
```

## 😀 as 키워드

- `as 키워드`는 `일반적인 타입`을 `구체적인 타입`으로 `강제 변환`한다.
- `as 키워드`로 안전하지 않은 캐스트를 시도하면, 실패시 `ClassCastException`이 발생한다.

```kotlin
// as가 실패하면 예외가 발생한다.
fun dogBarkUnsafe(c: Creature) = 
   (c as Dog).bark()

fun dogBarkUnsafe2(c: Creture): String {
  c as Dog
  c.bark()
  return c.bark() + c.bark()
}
```

- `as?`는 실패해도 예외를 던지지 않고 `null을 반환`하는 `안전한 캐스트`이다.
- `NullPointerException`을 방지하는 `엘비스 연산자`를 사용하면 강제 변환 실패시에도 `예외`를 `발생`시키지 않고 처리할 수 있다.

```kotlin
fun dogBarkSafe(c: Creature) = 
  // bark()를 호출할 때 안전한 호출을 사용해야 한다.
  (c as? Dog)?.bark() ?: "Not a Dog"
```

## 😐 List 원소의 타입 알아내기

- `술어(Predicate)`에서 `is`를 사용하면 List나 다른 Iterable한 타입의 원소가 주어진 객체의 타입인지 알 수 있다.

```kotlin
val group: List<Creture> = listOf(
  Human(), Human(), Dog(), Alien(), Dog()
)

fun main() {
  // group에 Dog 타입이 하나도 없다면 null이 반환될 수 있다.
  val dog = group
     .find { it is Dog } as Dog?

  dog?.bark() eq "Yip"
}
```

- `filterIsInstance()` 함수를 사용하면 코드의 가독성이 더 좋다.
    - `filter()`는 상위 타입의 List를 내놓지만, `filterIsInstance()`는 대상 하위 타입의 List를 반환한다.

```kotlin
fun main() {
  val humans1: List<Creature> = 
    group.filter { it is Human }

  val humans2: List<Human> = 
    group.filterIsInstance<Human>()

  val humans3: List<Human> = 
    // filterIsInstance()와 같은 효과를 낸다.
    group.mapNotNull { it as? Dog }
}
```

## 🤓 봉인된 클래스

- `클래스 계층`을 제한하려면 `sealed` 키워드로 `클래스`를 `선언`하면 된다.

```kotlin
open class Transport

data class Train(
  val line: String
): Transport()

data class Bus(
  val number: String, 
  val capacity: Int
): Transport()

fun travel(transport: Transport) = when (transport) {
  is Train -> "Train ${transport.line}"
  is Bus -> "Bus ... ${transport.number}"
  else -> "$transport is in limbo!"
}
```

- `Transport 클래스`에 `다른 하위 타입`이 있을 수도 있으므로 코틀린은 `else 가지`를 `디폴트`로 `요구`한다.
- `Transport 클래스`에 새로운 `하위 타입`을 추가한다면, `travel()` 함수를 수정해야 하지만, 아무런 단서가 없기 때문에 `유지보수`가 힘들어진다.

```kotlin
sealed class Transport

data class Train(
  val line: String
): Transport()

data class Bus(
  val number: String, 
  val capacity: Int
): Transport()

fun travel(transport: Transport) = when (transport) {
  is Train -> "Train ${transport.line}"
  is Bus -> "Bus ... ${transport.number}"
}
```

- `sealed 클래스`는 상속을 제한한 `봉인된 클래스`라고 부른다.
    - `sealed 클래스`를 직접 상속한 하위 클래스는 반드시 `기반 클래스`와 같은 `패키지`와 `모듈`안에 있어야 한다.
    - `Transport`의 하위 클래스가 존재 할 수 없다는 사실을 확인할 수 있기 때문에 `when 문`이 가능한 모든 경우를 다 처리하므로 `else 가지`는 필요하지 않다.
- `sealed 계층`을 도입하면 `새 하위 클래스`를 선언할 때 `오류`를 `발견`할 수 있다.
    - `sealed 클래스`는 `하위 클래스`를 `도입`했을 때 `변경`해야 하는 `모든 지점`을 `표시`해준다.

## 😄 Sealed Class vs Abstract Class

```kotlin
abstract class Abstract(val av: String) {
  open fun concreteFunction() {}

  abstract fun abstractFuntion(): String {}
  init {}
  constructor(c: Char) : this(c.toString())
}

sealed class Sealed(val av: String) {
  open fun concreteFunction() {}

  abstract fun abstractFuntion(): String {}
  init {}
  constructor(c: Char) : this(c.toString())

}
```

- `sealed 클래스`는 기본적으로 `하위 클래스`가 모두 같은 파일 안에 정의되어야 한다는 제약이 가해진 `abstract 클래스`이다.

```kotlin
// sealed 클래스를 직접적으로 상속하지 않는 경우 sealed 클래스와 다른 패키지에 선언할 수 있다.
class ThirdLevel : SealedSubclass()
```

- `sealed 클래스`를 직접 상속하는 클래스가 아니라면 `다른 파일`에 `선언`할 수 있다.
- `sealed interface`도 `kotlin 1.5`부터 `사용`이 `가능`하다.

## 😳 Sealed Class의 하위 클래스 열거하기

```kotlin
sealed class Top
class Middle1 : Top()
class Middle2 : Top()
open class Middle3 : Top()
class Bottom3 : Middle3()

fun main() {
  Top::class.sealedSubClasses
    // sealed 클래스의 모든 하위 클래스 이름을 확인할 수 있다.
    .map { it.simpleName }
}
```

- `sealed 클래스`의 `클래스 객체`를 이용하면 `모든 하위 클래스`를 `확인`할 수 있다.
    - `직접적인 하위 클래스`만 결과에 포함되고, `간접적인 하위 클래스`는 결과에 포함되지 않는다는 것에 주의해야 한다.
    - `sealedSubclasses`는 `리플렉션`을 사용하므로, 시스템의 성능에 영향을 끼칠 수 있다.
    

## 😶‍🌫️ 타입 검사

```kotlin
val Any.name 
  get() = this::class.simpleName

interface Insect {
  fun walk() = "$name: walk"
  fun fly() = "$name: fly"
} 

class HouseFly : Insect

class Flea : Insect {
  override fun fly() = throw Exception("Flea cannot fly")
  fun crawl() = "Flea: crawl"
}

fun Insect.basic() = 
  walk() + " " + 
    if (this is Flea)
      crawl()
    else 
      fly()

interface SwimmingInsect : Insect {
  fun swim() = "$name : swim"
}

interface WaterWalker: Insect {
  fun walkWater() = 
   "$name: walk on water"
}

class WaterBeetle : SwimmingInsect
class WaterStrider: WaterWalker
class WhirligigBeetle: SwimmingInsect, WaterWalker

fun Insect.water() = when (this) {
  is SwimmingInsect -> swim()
  is WaterWalker -> walkWater()
  else -> "$name: drown"
}
```

- `극소수 타입`에만 적합한 `특별한 행동 방식`을 `기반 클래스`에 넣는 것은 타당하지 않다.
- `Insect.water()` 함수와 같이, `특별한 행동`을 하는 타입을 걸러내고 나머지 모든 대상에 대해서는 표준적인 행동을 채택하는 `when 식`을 이용할 수 있다.
- `특별한 처리`를 위해 `별도의 소수 타입`을 선택하면, 새 타입을 추가해도 기존 코드에 영향을 끼치지 않는다.

```kotlin
interface Shape {
  fun draw(): String
}

class Circle : Shape {
  override fun draw() = "Circle: Draw"
}

class Square : Shape {
  override fun draw() = "Square: Draw"
  fun rotate() = "Square: Rotate"
}

fun turn(s: Shape) = when (s) {
  is Square -> s.rotate()
  else -> ""
}
```

- `rotate()` 함수는 `Shape 인터페이스`에 추가하지 않고, `Square 클래스`에 직접 추가해야 한다.
    - `Square`를 회전시키는 연산은 `Square 타입`에서만 사용하고, 다른 `Shape 인터페이스`의 `하위 타입`이 사용하지 않을 수 있기 때문이다.

```kotlin
class Triangle : Shape {
  override fun draw() = "Triangle: Draw"
  fun rotate() = "Triangle: Rotate"
}

fun turn2(s: Shape) = when (s) {
  is Square -> s.rotate()
  is Triangle -> s.rotate()
  else -> ""
}
```

- `Triangle`을 추가할 때 원래의 `turn()`은 깨지지 않지만, `원하는 결과`가 나오지 않는다.
    - `turn()`을 원하는 대로 `동작`시키려면 `turn2()` 처럼 코드를 작성해야 한다.
- `turn()` 과 `turn2()`를 `타입 검사 코딩`이라고 표현한다.
    - 타입 검사 코딩은 `안티패턴`으로 `간주`된다.
    - `sealed 클래스`를 사용하면 이런 문제를 `크게 완화`할 수 있다.

## 😓 sealed 클래스를 활용한 타입 검사하기

```kotlin
sealed class Shape {
  fun draw() = "$name: Draw"
}

class Circle : Shape()

class Square: Shape() {
  fun rotate() = "Square: Rotate"
}

class Triangle: Shape() {
  fun rotate() = "Triangle: Rotate"
}

fun turn(s: Shape) = when (s) {
  is Circle -> ""
  is Square -> s.rotate()
  is Triangle -> s.rotate()
}

```

- `sealed 클래스`를 활용하면, 컴파일러가 `Shape`의 하위 타입 추가시 `turn() 함수`에 `검사`를 `추가`해야 한다는 것을 알려준다.

```kotlin
sealed class BeverageContainer {
  abstract fun open(): String
  abstract fun pour(): String
}

sealed class Can : BeverageContainer() {
  override fun open() = "Pop Top"
  override fun pour() = "Can: Pour"
}

class SteelCan : Can()
class AluminumCan : Can()

sealed class Bottle : BeverageContainer() {
  override fun open() = "Remove Cap"
  override fun pour() = "Bottle : Pour"
}

class GlassBottle : Bottle()
sealed class PlasticBottle : Bottle()
class PETBottle : PlasticBottle()
class HDPEBottle : PlasticBottle()

fun BeverageContainer.recycle() = when (this) {
  is Can -> "Recycle Can"
  is Bottle -> "Recycle Bottle"
}

fun BeverageContainer.recycle2() = when (this) {
  is Can -> when (this) {
    is SteelCan -> "Recycle Steel"
    is Aluminum -> "Recyle Aluminum"
  }
  is Bottle -> when (this) {
    is GlassBottle -> "Recycle Glass"
    is PlasticBottle -> when (this) {
      is PETBottle -> "Recycle PET"
      is HDPEBottle -> "Recycle HDPE"
    }
  }
}
```

- `중간 클래스`인 Can과 Bottle도 `sealed`가 되어야만 해법이 제대로 작동한다.
- `when` 안에 `다른 when`을 `내포`시켜야만 컴파일러가 `모든 타입`을 `검사`하도록 해준다.

```kotlin
interface BeverageContainer {
  fun open(): String
  fun pour(): "$name: Pour"
  fun recycle(): String
}

abstract class Can : BeverageContainer {
  override fun open() = "Pop Top"
}

class SteelCan : Can() {
  override fun recycle() = "Recycle Steel"
}

class AluminumCan : Can() {
  override fun recycle() = "Recycle Aluminum"
}

abstract class Bottle : BeverageContainer {
  override fun open() = "Remove Cap"
}

class GlassBottle : Bottle() {
  override fun recycle() = "Recycle Glass"
}

abstract class PlasticBottle : Bottle()

class PETBottle : PlasticBottle() {
  override fun recycle() = "Recycle PET"
}

class HDPEBottle : PlasticBottle() {
  override fun recycle() = "Recycle HDPE"
}
```

- `Can`과 `Bottle`을 `abstract 클래스`로 정의해서 컴파일러는 모든 클래스가 `recycle()` 함수를 오버라이드 하도록 강제했다.
- `recycle()`의 행동 방식이 `여러 클래스`에 `분산`되었지만 이는 `설계상의 선택`이므로 문제가 되지는 않는다.
- `재활용 동작`이 자주 바뀌어서 한군데서 처리하고 싶다면, `외부 함수` 안에서 `타입 검사`를 하는게 더 나은 선택일 수 있다.

## 😏 내포된 클래스

- `내포된 클래스`는 단순히 외부 클래스의 `이름 공간` 안에 `정의`된 `클래스`이다.
- `내포된 클래스`를 사용하면 `객`체 안에 `더 세분화된 구조`를 `정의`할 수 있다.

```kotlin
class Airport(private val code: Sting) {
  open class Plane {
    fun contact(airport: Airport) = "Contacting ${airport.code}"
  }

  private class PrivatePlane : Plane()
  fun privatePlane() : Plane = PrivatePlane()
}
```

- `일반 클래스`는 다른 클래스의 `private 프로퍼티`에 접근할 수 없지만, `내포된 클래스`는 `접근`할 수 있다.
- `Airport.Plane`을 `import`하면 `Plane`을 `한정`시키지 않아도 `사용 가능`하다.

## 😃 지역 클래스

- `함수` 안에 `내포된 클래스`를 `지역 클래스`라고 한다.

```kotlin
fun localClasses() {
  // 지역 인터페이스는 허용되지 않기 때문에 지역 클래스를 사용한다.
  open class Amphibian
  class Frog : Amphibian()
  val amphibian: Amphibian = Frog()
}

fun createAmphibian() : Amphibian {
  class Frog : Amphibian()
  return Frog()
}
```

- `지역 클래스`의 `객체`를 `반환`하려면 그 객체를 함수 밖에서 정의한 `인터페이스`나 `클래스`로 업캐스트 해야 한다.

## 😵 인터페이스 안에 내포된 클래스

- `인터페이스` 안에 `클래스`를 `내포` 시킬 수 있다.

```kotlin
interface Item {
  val type: Type
  data class Type(val type: String)
}

class Bolt(type: String) : Item {
   override val type = Item.Type(type)
}
```

## 🥺 내포된 Enum

- `Enum`도 `클래스`이므로 `다른 클래스` 안에 `내포`될 수 있다.
- `Enum`을 `함수`에 `내포`시킬 수는 없고, `Enum`이 다른 클래스를 `상속`할 수도 없다.

```kotlin
class Ticket(
  val name: String,
  val seat: Seat = Coach
) {
  enum class Seat {
    Coach,
    Premium,
    Business, 
    First
  }
}
```

`인터페이스` 안에 `Enum`을 `내포`시킬 수 있다.

```kotlin
interface Game {
  enum class State { Playing, Finished }
  enum class Mark { Blank, X, O }
}
```

## 😵‍💫 객체

- `object`는 여러 인스턴스가 필요하지 않거나, `명시적으로 인스턴스를 여러 개 생성하는 것`을 막아야 하는 경우 사용할 수 있다.
- `싱글턴 패턴`을 구현하는 방법이기도 하다.

```kotlin
object JustOne {
  val n = 2
  fun f() = n * 10
  fun g() = this.n * 20
}
```

- `object`에 대해서는 `파라미터 목록`을 `지정`할 수 없다.
- `object`의 이름은 `클래스 이름`을 겸하기 때문에 `첫 글자`를 `영어 대문자`로 `표현`한다.

```kotlin
open class Paint(val color: String) {
  open fun apply() = "Applying $color"
}

object Acrylic : Paint("Blue") {
  override fun apply() = 
   "Acrylic, ${super.apply()}"
}

interface PaintPreparation {
  fun prepare(): String
}

object Prepare: PaintPreparation {
  override fun prepare() = "Scrape"
}
```

- `object`는 다른 `일반 클래스`나 `인터페이스`를 `상속`할 수 있다.

```kotlin
object Outer {
  object Nested {
    val a = "Outer.Nested.a"
  }
}
```

- `object`는 함수 안에 넣을 수 없지만, 다른 `object`나 클래스 안에 `object`를 `내포`시킬 수 있다.
- `내부 클래스(inner class)`의 경우에는 `object`를 선언할 수 없다.

## 😎 내부 클래스

- `내부 클래스`는 `내포된 클래스`와 비슷하지만 `내부 클래스`는 바깥 클래스의 인스턴스에 대한 `참조`를 유지한다.

```kotlin
class Hotel(private val reception: String) {
  open inner class Room(val id: Int = 0) {
    fun callReception() = 
      "Room $id Calling $reception"
  }
}

fun main() {
  val nycHotel = Hotel("311")
  val room = nycHotel.Room(319)
  
  room.callReceptoin()
}
```

- `reception` 프로퍼티는 `Hotel`의 일부분이지만 `아무런 한정` 없이 `inner class` Room이 사용하고 있다.
- `내포된 클래스`는 `inner 클래스`를 상속할 수 없다.
- `inner 클래스`의 객체를 생성하려면 `외부 객체`를 제공해야 하고, `코틀린`은 `inner data class`는 허용하지 않는다.

## 👿 한정된 this

- `inner 클래스`의 `this`는 inner 객체나 외부 객체를 가리킬 수 있다.
- 이 문제를 해결하기 위해 `코틀린`에서는 `한정된 this 구문`을 `사용`한다.
- 한정된 this 구문은 `this` 뒤에 `@`를 붙이고 `대상 클래스 이름`을 덧붙인 것이다.

```kotlin
class Fruit {
  fun changeColor(color: String) = ""
  fun absorbWater(amount: Int) {}

  // @Seed라는 레이블이 암시적으로 붙는다.
  inner class Seed {
     fun changeColor(color: String) = ""
    
     // name은 Fruit와 Seed에 다 있기 때문에 한정된 this 구문을 사용해야 한다.
     this@Seed.name eq "Seed"
  }

  inner class DNA {
     fun changeColor(color: String) {
       // 재귀 호출 -> 자신의 changeColor()를 호출한다.
       changeColor(color)

       // 한정된 this 구문을 활용해 어떤 클래스의 함수를 호출할지 한정한다.
       this@Seed.changeColor(color)
       this@Fruit.changeColor(color)
     }
  }
}
```

## 🥰 내부 클래스 상속

- `내부 클래스`는 다른 `외부 클래스`에 있는 `내부 클래스`를 `상속`할 수 있다.

```kotlin
open class Egg {
  private var yolk = Yolk()
  open inner class Yolk {
    init {}
    open fun f() {}
  }
}

class BigEgg : Egg {
  // Egg의 내부 클래스인 Yolk()를 기반 클래스로 정의한다.
  inner class Yolk : Egg.Yolk() {

  }
}
```

## 😝 지역 내부 클래스와 익명 내부 클래스

- `멤버 함수` 안에 정의된 클래스를 `지역 내부 클래스`라고 한다.
- 이런 클래스는 `객체 식`이나 `SAM 변환`을 사용해 `익명`으로 `생성`할 수 있다.
    - `inner 키워드`를 모든 경우에 대해 사용하지는 않지만, `암시적`으로 `내부 클래스`가 된다.

```kotlin
fun interface Pet {
  fun speak(): String
}

object CreatePet {
  fun dog(): Pet {
    val say = "Bark"
    // 지역 내부 클래스
    class Dog : Pet {
      override fun speak() = say + " home!"
    }  
  }

  fun cat(): Pet {
    val emit = "Meow"
    // 익명 내부 클래스
    return object: Pet {
      override fun speak() = emit() + " home!"
    }
  }

  fun hamster() : Pet {
    val squeak = "Squeak"
    // SAM 변환
    return Pet { squeak + " home!" }
  }
}
```

- `지역 내부 클래스`는 함수에 정의된 `다른 원소`와 `함수 정의`를 포함하는 `외부 클래스 객체`의 `원소`에 모두 접근 가능하다.
- `내부 클래스`는 `외부 클래스` 객체에 대한 참조를 저장하므로, `지역 내부 클래스`도 자신을 둘러싼 클래스에 속한 객체의 `모든 멤버`에 `접근`할 수 있다.

```kotlin
fun interface Counter {
  fun next(): Int
}

object CounterFactory {
  private var count = 0
  fun new(name: String): Counter {
    // 지역 내부 클래스
    class Local : Counter {
      init {}
      override fun next() : Int {
        trace("$name $count")
        return count++
      } 
    }
    return Local()
  }

  fun new2(name: String): Counter {
    // 익명 클래스 내부 인스턴스
    return object: Counter {
      init {}
      override fun next(): Int {
        trace("$name $count")
        return count++
      }
    }
  }

  fun new3(name: String): Counter {
    return Counter { // SAM 변환
      trace("$name $count")
      count++
    }
  }
}
```

- `SAM 변환`은 `init 블록`이 들어갈 수 없다는 `한계점`이 있다.
- `지역 클래스`로는 아주 기본적이고 `단순한 클래스`만 사용해야 한다.
    - `지역 클래스`가 복잡해지면 이 클래스를 함수에서 꺼내 `일반 클래스`로 `격상`시켜야 한다.

## 😳 동반 객체

- `companion object(동반 객체)`는 `java`의 `static`과 같은 특징을 가진다.
- 일반 클래스의 원소는 `동반 객체의 원소`에 접근할 수 있지만, `동반 객체의 원소`는 일반 클래스의 원소에 접근할 수 없다.

```kotlin
class WithCompanion {
  // 일반 클래스 안에서 동반 객체를 정의하면 동반 객체 원소를 투명하게 참조할 수 있다.
  companion object {
    val i = 3
    fun f() = i * 3
  }

  fun g() = i + f()
}
```

- `동반 객체`는 클래스당 하나만 허용되며, `명확성`을 위해 `동반 객체`에 `이름`을 `부여`할 수도 있다.
- `동반 객체`는 이름을 지정하지 않는다면, `Companion`이 `default` 이름이다.

```kotlin
class WithNamed {
  companion object Named {
    fun s() = "from Named"
  }
}

class WithDefault {
  companion object {
    fun s() = "from Default"
  }
}
```

- `동반 객체` 안에서 `프로퍼티`를 `생성`하면 해당 필드는 `메모리상에 단 하나`만 `존재`하게 된다.
- `동반 객체`와 연관된 클래스의 `모든 인스턴스`가 이 필드를 `공유`한다.

```kotlin
class WithObjectProperty {
  companion object {
    private var n: Int = 0 // 단 하나만 생긴다.
  }

  // 동반 객체를 둘러싼 클래스는 동반 객체의 private 멤버에 접근할 수 있다.
  fun increment() = ++n
}
```

- 어떤 함수가 오직 `동반 객체의 프로퍼티`만 사용하면, 이 함수를 `동반 객체`로 옮기는 것이 타당하다.

```kotlin
class CompanionObjectFunction {
  companion object {
    private var n: Int = 0

    // 동반 객체의 프로퍼티만 사용하므로, 동반 객체에 존재하는 것이 타당하다.
    fun increment() = ++n
  }
}
```

- `동반 객체`는 다른 곳에 정의한 `클래스`의 `인스턴스`일 수도 있다.
- `동반 객체`는 `인터페이스`를 `구현`할 수도 있다.
- `동반 객체`는 `기반 클래스`를 `상속`하고, `확장`할 수 있다.

```kotlin
interface ZI {
  fun f(): String
}

open class ZIOpen : ZI {
  override fun f() = "ZIOpen.f()"
}

class ZICompanion {
  // 동반 객체에 다른 곳에 정의한 클래스의 인스턴스를 대입
  companion object: ZIOpen()
}

class ZICompanionInheritance {
  companion object: ZIOpen() {
    // 다른 클래스를 상속하고, 확장할 수 있다.
    override fun f() = "ZICompanionInheritance.f()"
  }
}

class ZIClass {
  companion object: ZI {
    // 인터페이스를 구현할 수 있다.
    override fun f() = "ZIClass.f()"
  }
}
```

- `동반 객체`가 확장하려는 클래스가 `open`이 아닌 경우, `위임`을 이용해 `오버라이드` 하고 `확장`할 수 있다.

```kotlin
interface Extended: ZI {
  fun u(): String
}

class Extend : ZI by Companion, Extended {
   companion object: ZI {
     override fun f() = "Extend.f()"
     override fun g() = "Extend.g()"
   }
} 
```

- `동반 객체`는 `객체 생성을 제어`하는 경우에 유용하게 사용할 수 있다.
    - `팩토리 메서드` 패턴을 이용해 `객체 생성 방식`을 `제한`할 수 있다.

```kotlin
class Numbered2
private constructor(private val id: Int) { // Numbered2의 비공개 생성자
  override fun toString(): String = "#$id"
  companion object Factory {
    fun create(size: Int) = 
      List(size) { Numbered2(it) }
  }
}
```

- `Numbered2` 인스턴스를 생성하는 방법은 `create()` 팩토리 함수를 통하는 방법 뿐이다.

- `동반 객체`의 생성자는 동반 객체를 둘러싼 클래스가 최초로 `프로그램`에 `적재` 될 때 이뤄진다.

```kotlin
class CompanionInit {
  init {}
}
```
