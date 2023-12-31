# CHAPTER 3

### 확장함수

> 필요한 모든 것을 거의 다 제공하는 라이브러리를 발견했지만 이 라이브러리에 멤버 함수만 한두 가지를 추가해보자
>

라이브러리는 내 코드가 아니며, 소스 코드에 접근할 수도 없고, 소스 코드 변경을 마음대로 제어할 수도 없다.

`코틀린 확장 함수`는 기존 클래스에 멤버 함수를 추가하는 것과 같은 효과를 낸다.

확장할 대상 타입은 수신 객체 타입.
`ex)` fun 수신타입. 확장함수() {…}

이 확장 함수를 다른 패키지에서 사용하려면 `임포트`해야 한다.

`this` 키워드를 사용해 멤버 함수나 다른 확장에 접근할 수 있다.

### 이름 붙은 인자와 디폴트 인자

> 함수를 `호출`하면서 인자의 이름을 지정할 수 있다.
>

`이름 붙은 인자`를 사용하면 `코드 가독성이 좋아`진다. 목록이 길수록 특히 그렇다.

이름 붙은 인자는 디폴트 인자와 결합하면 더 유용하다, 디폴트 인자란 `파라미터`의 디폴트 값을 함수 정의에서 지정하는 것

`덧붙은 콤마`는 마지막 파라미터 뒤에 콤마를 추가로 붙인 것, 파라미터 값을 여러 줄에 걸쳐 쓰는 경우에는 유용하다.

`joinToString()` 은 디폴트 인자를 사용하는 표준 라이브러리 함수

- `이터레이션`이 가능한 객체(리스트, 집합, 범위 등) 의 내용을 String으로 합쳐준다.
- 원소 사이에 들어갈 문자열(구분자), 맨 앞에 붙일 문자열(접두사), 맨 뒤에 붙일 문자열(접미사)을 지정 가능

`trimMargin()` 은 디폴트 인자의 여러 줄 String의 형식을 맞춰주는 표준 라이브러리 함수

- 각 줄의 시작 부분을 인식하기 위한 경계를 표현하는 접두사 `String`을 파라미터로 받아 사용.
- `소스 String`의 각 줄 맨 앞에 있는 공백들 다음에 지정한 `접두사 String`까지를 잘라내서 문자열을 다듬어 낸다.

### 오버로딩

> 디폴트 인자를 지원하지 않는 언어에서는 종종 디폴트 인자를 흉내내기 위해 `오버로딩`을 활용한다.
>

함수의 시그니처는 함수 이름, 파라미터 목록, 반환 타입으로 이뤄진다.

함수를 `오버로딩`할 때는 함수 파라미터 리스트를 서로 다르게 만들어야 한다.

`주의` 디폴트 인자를 흉내 내기 위해 확장 함수를 사용하면 안 된다.

함수 `오버로딩`과 디폴트 인자를 함께 사용하는 경우, `오버로딩`한 함수를 호출하면 함수 시그니처와 함수 호출이   `가장 가깝게` 일치 되는 함수를 호출한다.

`오버로딩`을 사용하면 함수 자체에 대해 설명하는 이름을 써서 추상화 수준을 높이고, 독자의 정신적인 부담을 줄일 수 있다. 또한, 불필요한 중복을 줄여주기도 한다.

### When 식

> 컴퓨터 프로그램에는 패턴에 따라 어떤 동작을 수행하는 코드가 많다.
>

두세 가지 이상의 선택지가 있는 경우 `if 식`보다 `when 식`이 훨씬 좋다.

- 식은 **`when`**으로 시작하고 **`when`** 뒤에는 괄호 안에 있는 비교 대상 값이 오고
- 그 뒤에는 값과 일치할 수 있는 여러 매치**（match）**가 들어있는 본문이 온다
- 각 매치는 식 오른쪽 화살표（ー〉）로 시작한다
- 여기서 오른쪽 화살표는 와 》두 문자로 이뤄져 있으며, 중간에 공백을 넣으면 안 된다
- 화살표 오른쪽에는 `결괏값`을 계산하는식이 온다
- **`“when' expression must be exhaustive, add necessary ,else branch`** 컴파일 타입 오류가 발생한다면 else 가지를 추가해줘야한다.
- `when 식`을 문처럼 취급하는 경우에만 `else 가지`를 생략할 수 있다.

### Enum

> Enum은 이름을 모아둔 것이다.
>

`enum`을 만들면 enum의 이름에 해당하는 문자열을 돌려주는 `toString()`이 생성된다.

`enum`은 인스턴스 개수가 미리 정해져 있고 클래스 본문 안에 이 `모든 인스턴스`가 나열되어 있는 특별한 종류의 `클래스`이다.

`멤버 함수나 멤버 프로퍼티`를 enum에 정의할 수도 있다 → 마지막 enum 값 다음에 세미클론 추가하기

`enum`은 코드 가독성을 높여주므로 항상 사용하는 게 바람직하다.

### 데이터 클래스

> `코틀린`은 반복적인 코딩을 `줄여`준다.
>

`class 메커니즘`은 일을 상당 부분 덜어준다 → 하지만 데이터를 저장하는 게 주목적인 클래스를 `정의`하려면 여전히 반복적인 코드를 꽤 많이 작성해야 한다.

데이터 저장만 담당하는 클래스가 필요하면 `data 클래스`를 사용해 `코드양을 줄이자.`

`data 키워드`로 몇 가지 기능을 클래스에 추가하라고 `코틀린`에게 지시한다.

모든 생성자 파라미터를 `var 나  val`로 선언해야 한다.

모든 `data 클래스`에 생성되는 `copy() 함수`로 현재 객체의 모든 데이터를 포함하는 새 객체를 `생성`해준다.

→ 새 객체를 생성할 때 몇몇 값을 새로 지정할 수 있다.

**`HashMap과 HashSet`**

**`data** 클래스`를 만들면 객체를 **`HashMap**이나 **HashSet**`에 넣을 때 키로 사용할 수 있는 해시 함수를

자동으로 `생성`해준다.

- **`hashCode()**를 **equals()**`와 함께 사용해 **`Key**를 빠르게 검색한`다.
- 올바른 **`hashCode(**)`를 직접 작성하는 건 까다롭고 실수하기도 쉬운데
- 이런 일을 **`data** 클래스`가 대신 해주면 꽤 편리하다.

### 구조 분해 선언

> 함수에서 하나 이상의 아이템을 반환하고 싶다면 결과를 돌려줄 때 결과와 더불어 결과에 대한 다른 정보를 추가로 돌려주고 싶다면 어떻게 해야 할까?
>

표준 라이브러리에 있는 `Pair 클래스`를 쓰면 두 값을 반환 할 수 있다.

구조 분해 선언을 사용하면 `여러 식별자`를 동시에 선언하면서 `초기화`할 수도 있다.

```kotlin
val (a, b, c) = 여러_값이_들어있는_값
```

- 이 코드는 여러 값이 들어 있는 값(객체)을 `여러 컴포넌트로 분해`해서 `각 컴포넌트`를 순서대로 `대입`해준다
- 이 구문은 `식별자`를 하나만 선언하는 구문과 다르다.
- `구조 분해 구문`에서는(등호 왼쪽에 있는)식별자 이름을 괄호 안에 넣어야 한다.

`Triple 클래스`는 정확히 세 가지 값을 묶는다.

더 많은 값을 저장하고 싶거나 코드에서 `Pair 와 Triple`을 많이 사용한다면 각 상황에 맞는 특별한 클래스를 작성

`data 클래스`는 자동으로 구조 분해 선언을 지원한다.

**`data** 클래스`의 `인스턴스`를 구조 분해할 때는 **`data** 클래스 생성자`에 `각 프로퍼티`가 나열된 순서대로 값이 대입된다.

구조 분해 선언은 지역 **`var**나 **val**`에만 적용할 수 있으며 `* 클래스 프로퍼티`를 정의할 때는 사용할 수 없다.

### 널이 될 수 있는 타입

> 경우에 따라 ‘결과가 없는’ 함수를 생각해보자. 이런일이 발생해도 함수는 자체적으로 오류를 발생시키지 않는다. 단지 ‘값 없음’일 뿐이다.
>

`자바`에서는 null 또는 의미 있는 값이 결과가 되도록 허용한다. 그러나 `불행히도 null`을 정상적인 값과 같은 방식으로 다루면 극적인 실패가 발생한다. 이 문제에 대한 언어적 해법 중 하나는 애초에 `null을 허용하지 않는 것`.

`코틀린`에서 모든 타입은 기본적으로 널이 될 수 없는 타입이다. 하지만 무언가 `null 결과`를 내놓을 수 있다면, 타입 이름 뒤에 `물음표를 (?)` 붙여서 결과가 `null이 될수도 있음을 표시`해야한다.

- null이 될 수 있는 타입을 단순히 역참조할 수 없다.
- 대부분 타입의 값은 메모리에 있는 객체에 대한 참조를 저장된다.
- 객체에 접근하기 위해서는 메모리에서 객체를 가져와야 한다.
- 명시적으로 if 검사를 수행하고 나면 코틀린이 널이 될 수 있는 객체를 참조하도록 허용한다.

### 안전한 호출과 엘비스 연산자

> 코틀린은 널 가능성을 편리하게 처리할 수 있도록 여러 연산자를 제공한다.
>
- 안전한 호출은 일반 호출에 사용되는 점(.)을 물음표와 점(?.)으로 바꾼 것이다.
- 물음표와 점 사이에 공백이 있으면 안된다.
- 안전한 호출을 사용하면 널이 될 수 있는 타입의 멤버에 접근하면서 아무 예외도 발생하지 않게 해준다.
- 안전한 호출은 수신 객체가 null이 아닐 때만 연산을 수행한다.

?: 의 왼쪽 식의 값이 null이 아니면 왼쪽 식의 값이 전체 엘비스 식의 결괏값이 된다.

왼쪽식이 null이면 ?: 의 오른쪽 식의 값이 전체 결괏값이 된다.

### 널 아님 단언

> 널이 될 수 있는 타입을 처리하는 두 번째 접근 방법으로, 어떤 참조가 null이 될 수 없다는 사실을 특별히 알 수 있는 경우를 들 수 있다.
>

null이 될 수 없다고 주장하기 위해 느낌표 두 개(!!)를 쓴다. [ 널 아님 단언 ]

- 널 아님 단언을 한 줄에 하나씩 사용하면 NPE 예외가 발생했을 때 해당 줄 번호 알 수 있다.
- 안전한 호출 ?. 은 단일 연산자지만, 널 아님 단언 호출은 널 아님 단언(!!)과 역참조(.)로 이뤄진다.
- 널 아님 단언을 사용하지 않고 안전한 호출이나 명시적인 null 검사를 활용하는 것을 권장.
- 최적의 코드는 항상 안전한 호출과 자세한 예외를 반환하는 특별한 함수만 사용한다.
- null이 아니라는 점을 단언한 호출은 꼭 필요할 때만 사용해라.

### 확장 함수와 널이 될 수 있는 타입

> 때로는 눈에 보이는 것과 실체가 다를 수도 있다.
>

s?.f()는 s가 널이 될 수 있는 타입임을 암시, 그렇지 않다면 s.f()를 호출했을 것.

코틀링 표준 라이브러리 String 확장 함수

- isNullOrEmpty() : 수신 String이 null이거나 빈 문잘열인지 검사.
- isNullOrBlank() : isNullOrEmpty()와 같은 검사 수행, 수신 객체 String이 온전히 공백 문자로만 구성되었는지 검사.

```kotlin
s == null || s.isEmtpy()
//쇼트 서킷을 사용한다.
```

쇼트 서킷 || 에서 첫 번째 식이 true면 전체 식이 true로 결정 되므로, 두 번째 식은 아예 계산을 하지 않는다.

```kotlin
s == null || s.isEmpty()
//s가 null 이어도 NPE가 발생하지 않는다.
```

- 확장 함수는 **this**를 사용해 수신 객체(확장 대상 타입에 속하는 객체)를 표현한다.
- 이때 수신 객체를 널이 될 수 있는 타입으로 지정하려면 확장 대상 타입 뒤에 ?를 붙이면 된다.

### 제네릭스 소개

> 제네릭스는 파라미터화한 타입을 만든다. 파라미터화한 타입은 여러 타입에 대해 작동할 수 있는 컴포넌트다.
>

클래스나 함수를 작성할 때 타입 제약을 느슨하게 해서 프로그래머에게 표현력을 최대로 제공하는 것이다.

```kotlin
class GenericHolder<T>( // [1]
	private val value: T
) {
	fun getValue(): T = value
}

fun main() {
	val hi = GenericHolder(Automobile("Ford"))
	val a: Automobile = hi.getValue() // [2]
	a eq "Automobile(brand=Ford)"
	val h2 = GenericHolder(1)
	val i: Int = h2.getValue() // [3]
	i eq 1
	val h3 = GenericHolder("Chartreuse")
	val s: String = h3.getValue() // [4]
}
```

- [1] **GenericHolder**는 **T** 타입의 객체를 저장하며, 멤버 함수 **getValue()**는 **T** 타입의 값을 반환한다.
- ****[2], [**3], [4] 에**서 **getValue(**)를 호출할 때 결과 타입이 자동으로 올바른 타입으로 지정된다.

### 제네릭 함수

```kotlin
fun <T> List<T>.first(): T {
    if (isEmpty())
        throw NoSuchElementException("Empty List")
    return this[0]
}
    fun <T> List<T>.firstOrNull(): T?=
    if (isEmpty()) null else this[0]

    fun main() {
        listOf(1, 2, 3).first() eq 1

        val i: Int? =
        listOf(1, 2, 3).firstOrNull()
        i eq 1

        val s: String? =
        listOf<String>().firstOrNull()
        s eq null
}
```

**first()**와 **firstOrNull()**은 모든 **List**에 대해 작동할 수 있다. **T** 타입의 값을 반환하기 위해서는 제네릭 함수로 이 두 함수를 정의해야만 한다.

- [1] **List<Int＞**에 대해 **firstOrNull(**)을 호출하면 **Int?**가 반환되는 모습을 보여준다.
- [2] **List<String>**에 대해 같은 함수를 호출해서 **String?**를 받는다.

### 확장 프로퍼티

> 확장 함수를 정의할 수 있는 것처럼 확장 프로퍼티를 정의할 수도 있다.
>

확장 프로퍼티에는 커스텀 게터가 필요하다. 확장 프로퍼티에 접근할 때마다 프로퍼티 값이 계산된다.

```kotlin
fun main() {
	val list: List< * > = listOf(1, 2)
	val any: Any? = list[0]
any eq 1
}
```

**List**く*〉에 저장된 값이 널이 될 수 있는 타입인지에 대해서도 아무 정보가 없다.

따라서 이런 경우 해당 값을 **Any?** 타입의 변수에만 대입할 수 있다.

### break 와 continue

> break 와 continue를 사용하면 루프 안에서 ‘점프’ 할 수 있다.
>

break 와 continue를 사용해 제한적인 점플르 제공한다.

```kotlin
fun main() {
	val nums = mutableListOf(0)
	var i = 0
	while (i < 100) {
		i += 4
		if (i == 8) continue
		if (i == 40) break
		nums.add(i)
	}
	nums eq "[0, 4, 12, 16, 20, 24, 28, 32, 36]"
}
```

### 레이블

- 단순한 **break**와 **continue**는 자신이 속한 루프의 범위보다 더 밖으로 점프할 수 없다.
- 그러나 레이블을 사용하면 **break**와 **continue**가 자신을 둘러싼 여러 루프의 경계 중 한군데로 점프할 수 있어서 현재 실행 중인 맨 안쪽 루프의 영역에 제한되지 않고 점프할 수 있다.
- ‘레이블@'과 같이 레이블 이름 다음에 @을 사용해 레이블을 붙일 수 있다.

```kotlin
fun main() {
    val strings = mutableListOf<String>()
    outer@ for (c in 'a'..'e') {
        for (i in 1..9) {
            if (i == 5) continue@outer
            if ("$c$i" == "c3") break@outer
            strings.add("$c$i")
        }
    }
    strings eq listOf("a1", "a2", "a3", "a4",
    "b2", "b2", "b3", "b4", "c1", "c2")
}

//레이블이 붙은 break@
//outer는 outer@이 붙은 루프의 마지막을 찾아서 거기서부터 실행을 계속한다.
```

**break**와 **continue**를 사용하면 코드가 복잡해지고 유지 보수가 어려워질 수 있다.