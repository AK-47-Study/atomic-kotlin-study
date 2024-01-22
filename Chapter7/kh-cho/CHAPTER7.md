# CHAPTER 7

## 확장 람다

> 확장 람다는 확장 함수와 비슷하다. 차이가 있다면 함수가 아니라 람다라는 점이다.
>

```kotlin
val va: (String, Int) -> String = {str, n ->
    str.repeat(n) + str.repeat(n)
}

val  vb: String.(Int) -> String = {
    this.repeat(it) + repeat(it)
}

fun main() {
    va("Vanbo", 2) eq "VanboVanboVanboVanbo"
    "Vanbo".vb(2) eq "VanboVanboVnabop"
    vb("Vanbo", 2) eq "VanboVanboVnabop"
}
```

- `va` 는 `str, n →` 처럼 화살표 앞에 파라미터 두 개 있고 String을 반환한다. ( `일반 람다` )
- `vb` 는 `String 파라미터`를 괄호 밖으로 옮겨 `String.(Int)`처럼 `확장 함수 구문` 사용, 확장 대상 객체가 수신 객체가 되고 `this` 를 통해 수신 객체에 접근할 수 있다.
- 확장 람다는 `String.(Int)`에 집중하지 않고 `String`을 확장하는 건 파라미터 목록인 `(Int)`가 아니라, 전체 람다 `(Int) → String`이다.
- `String.(Int) → String`  [ 확장 람다 ]

```kotlin
class A {
    fun af() =1
}

class B {
    fun bf() =2
}

fun f1(lambda: (A, B) -> Int) =
    lambda(A(), B())

fun f2(lambda: A.(B) -> Int) =
    A().lambda(B())

fun main() {
    f1 {aa, bb -> aa.af() + bb.bf()}
    f2 {af() + it.bf()}
}
```

- f2() 를 사용 했을 때 람다가 더 `간결`해진다.
- 확장 람다의 반환 타입이 `Unit`이면, 람다 본문이 만들어낸 결과는 `무시`된다.
- → 람다 본문의 마지막 식의 값을 무시한다는 뜻, `return`으로 `Unit이 아닌 값`을 반환하면 타입 `오류가 발생`한다.

```kotlin
private fun messy(): String {
    val built = StringBuilder()
    built.append("ABCs: ")
    ('a' .. 'x').forEach{ built.append(it)}
    return built.toString()
}

private fun clean() = buildString {
    append("ABCs: ")
    ('a' .. 'x').forEach{append((it))}
}

private fun cleaner() =
    ('a'..'x').joinToString ("", "ABCs: ")

fun main() {
    messy() eq  "ABCs: ababcdefghijklmnopqrstuvwx" 
    messy() eq clean()
    clean() eq cleaner()
}
```

- `코틀린` 표준 라이브러리에는 확장 람다와 함께 사용하는 함수가 많이 있다.
- `StringBuilder` 는 `toString()` 을 적용해 `불변 String`을 만들어낼 수 있는 가변 객체
- 반면 `buildString()` 은 확장 람다를 인자로 받아 `StringBuilder 객체`를 생성.
- 확장 람다를 생성한 `StringBuilder` 객체에 적용.
- `toString()`을 호출해 문자열을 얻는다.

### 확장 람다를 사용해 빌더 작성하기

`빌더 패턴의 장점`

- 여러 단계를 거쳐 객체 생성 → 객체 생성이 `복잡할 때 유용`
- 동일한 기본 생성 코드를 사용해 `다양한 조합의 객체`를 생성할 수 있다.
- 공통 생성 코드와 `특화한 코드`를 분리 → `객체`들의 변종 유형에 따른 코드를 더 쉽게 작성.

## 영역 함수

> 영역 함수는 객체의 이름을 사용하지 않아도 그 객체에 접근할 수 있는 임시 영역을 만들어주는 함수다.
>

영역 함수는 코드를 더 간결하고 읽기 좋게 만들기 위해 존재, 다른 추가 기능은 `제공하지 않는`다.

영역함수

- `let()`
- `run()`
- `with()`
- `apply()`
- `also()`
- 각각 람다와 사용, `임포트`할 필요가 없다.
- 문맥 객체를 `it` 으로 다루는지 혹은 `this` 로 다루는지와 각 함수가 어떤 값을 `반환`하는지에 따라 달라진다.

```kotlin
data class Tag(var n: Int = 0){
    var s: String = ""
    fun increment() = ++n
}

fun main() {
    Tag(1).let {
        it.s = "let: ${it.n}"
        it.increment()
    } eq 2

    Tag(2).let {tag ->
    tag.s = "let: ${tag.n}"
        tag.increment()
    } eq 3

    Tag(3).run {
        s = "run: $n"
        increment()
    } eq  4

    with(Tag(4)) {
        s = "with : $n"
        increment()
    } eq 5

    Tag(5).apply {
        s = "apply: $n"
        increment()
    } eq "Tag(n=6)"

    Tag(6).also {
        it.s = "also: ${it.n}"
        it.increment()
    } eq "Tag(n=7)"

    Tag(7).also { tag ->
        tag.s = "also: ${tag.n}"
        tag.increment()
    } eq "Tag(n=8)"
}
```

- 문맥 객체를 `this` 로 접근할 수 있는 영역 함수(`run()`, `with()`, `apply()`) 사용해 영역 블록 안에서 깔끔한 구문 사용
- 문맥 객체를 `it` 로 접근할 수 있는 영역 함수 (`let()`, `also()`) 사용해 람다 인자에 이름을 붙일 수 있다.
- 결과를 만들어야 하는 경우, 람다의 마지막 식의 값을 돌려주는 영역 함수 (`let()`, `run()`, `with()`)를 사용
- `객체에 대한 호출식`을 연쇄적으로 사용할 경우, 변경한 객체를 돌려주는 영역 함수 (`apply()`, `also()`) 사용

|  | this 문맥 객체 | it 문맥 객체 |
| --- | --- | --- |
| 마지막 식의 값을 돌려줌 | with, run | let |
| 수신 객체를 돌려줌 | apply | also |

```kotlin
fun gets(): String? =
    if (Random.nextBoolean()) "str!" else null

fun main() {
    gets()?.let {
        it.removeSuffix("!") + it.length
    }?.eq("str4")
}
```

- `gets()` 가 `null` 이 아닌 값을 반환하면 `let` 이 호출
- `let` 에서 널이 될 수 없는 수신 객체는 람다 내부에서 널이 될 수 없는 `it`이 된다.

```kotlin
class Gnome(
    val name: String
) {
    fun who() = "Gnome: $name"
}

fun whatGnome(gnome: Gnome?) {
    gnome?.let { it.who() } // [1 ]
    gnome.let { it?.who() }

    gnome?.run { who() } // [2]
    gnome.run { this?.who() }

    gnome?.apply { who() } // [3]
    gnome.apply { this?.who() }

    gnome?.also { it.who() } // [4]
    gnome.also { it?.who() }

    // gnomeOl 널인지 검사할 방법이 없다

    with(gnome) { this?.who() }
}
```

- 문맥 객체에 대한 안전한 접근 연산을 적용하기 앞서 `null 검사를 수행`한다
- 안전한 접근을 사용하지 않는다면 영역 함수 안에서 개별적으로 `null 검사를 해야`한다.
- `let()`, `run()`, `apply()`, `also()` 에 안전한 접근 연산자를 적용하면 수신 객테가 `null` 인 경우 전체 영역이 `무시`된다.

```kotlin
val functions = listOf(
    fun (name: String?) {
        name
            ?.takeUnless { it.isBlank() }
            ?.let { trace("$it in let") }
    },
    fun (name: String?) {
        name
            ?.takeUnless { it.isBlank() }
            ?.run { trace("$this in run") }
    },

    fun (name: String?) {
        name
            ?.takeUnless { it.isBlank() }
            ?.also { trace("$it in also") }
    }
)

fun main() {
    functions.forEach{it(null)}
    functions.forEach{it(" ")}
    functions.forEach{it("Yumyulack")}
    trace eq  """
        Yumyulack in let 
        Yumyulack in run 
        Yumyulack in apply 
        Yumyulack in also
    """
}
```

- `forEach()` 호출에서 `it` 과 함수 호출 구문을 써서 사용될 함수 `참조의 List`다.
- `functions`의 각 함수는 다른 영역 함수를 사용한다.
- `forEach()` 에서 `it(null)`이나 `it(” “)`는 결국 `무시` 되므로,  `null`도 아니고 `공백`들도 아닌 입력만 출력.

```kotlin
fun nesting(s: String, i: Int): String =
    with(s){
        with(i) {
            toString()
        }
    } +
            s.let {
                i.let {
                    it.toString()
                }
            } +
            s.run {
                i.run {
                    toString()
                }
            } +
            s.apply {
                i.apply {
                    toString()
                }
            } +
            s.also {
                i.also {
                    it.toString()
                }
            }

fun main() {
    nesting("X", 7) eq "777XX"
}
```

- 가장 가까운 `this` 나 `it` 은 `암시적 수신 객체`인 `Int`이므로 `Int 객체`에 대해 `toString()` 호출 적용
- `apply()` 나 `also()` 는 계산 결과 대신 변경된 객체 `s를 반환`
- 영역 함수가 `가독성을 높`이려는 목적에서 만들어진 것

### 영역 함수는 인라인 된다

람다를 `인자로 전달` → 람다 코드를 외부 객체에 넣기 때문에 일반 함수 호출에 비해 실행 시점의 `부가 비용 좀 더 발생`.

`람다가 주는 이점`에 비하면 이런 부가 비용은 큰 문제가 되지 않는다. → `JVM `에는 부가 비용을 상쇄해줄만한 `최적화 기능`이 들어있다.

- 영역 함수를 `inline`으로 만들면 `모든 실행 시점 부가 비용`을 없앨 수 있다. → 원하는대로 사용
- `컴파일러`는 `inline 함`수 호출을 보면 함수 호출 식을 함수의 본문으로 `치환`하며, 함수의 모든 파라미터를 `실제 제공된 인자로 바꿔`준다.