## CHAPTER 1

### `var`와 `val`, 데이터 타입

`val` 값은 한 번 대입된 이후에는 다시 대입될 수 없다.

`var`는 `val`과 달리 대입된 값을 변경할 수 있다.

- `val 식별자`: 타입 = 초기화식
- `val 식별자`= 초기화식

### 함수

함수는 이름이 붙은 `서브루틴`

함수 본문이 한 식으로만 이뤄진 경우, `축약형`을 사용해 함수를 정의할 수 있다.

- `fun`함수이름(파라미터1: 타입1, 파라미터2: 타입 2, …): 반환 타입 = 결과를 계산하는 식
    - 본문함수, 여는 중괄호 대신 등호(=)를 쓰고 등호 뒤에 식을 넣는다.
    - `코틀린`이 식의 타입을 추론할 수 있기 때문에 반환 타입을 생략할 수도 있다.


### `불리언`(Boolean)

- !(`부정`) : 값을 논리적으로 반전시킨다(true를 false로, false를 true로).
- &&(`논리곱`): 두 `피연산자`들이 **모두** true일 때만 true다.
- ||(`논리합`): 두 `피연산자` 중 어느 한쪽이라도 true면 true다.

### if 식

if 도 식이기 때문에 결과를 만들어내고, 이 결과를 `var나 val`에 대입 가능.

### 문자열 템플릿

```kotlin
//fun main() {
//	val answer = 42
//	println("Found $answer!") // [1 ]
//	val condition = true
//	println(
//		H${if (condition)匕
//		,else b}") // [2]
//	println("printing a $1") // [3]
//)
```

- **|1] `$answer`**는 **answer** 안에 들어 있는 값으로 치환된다
- **[2] ${if(condition) 'a' else 'b**，**}**의 경우 내부의 **if** 식을 평가한 결괏값이 ${...} 전

체를 대치한다

- [3] 이 프로그램 `식별자`가 아닌 문자열 앞에 $가 붙은 경우에는 아무 일도 일어나지 않는다

**`삼중 큰따옴표**(""")` 문자열을 사용하면 여러 줄의 문자나 특수 문자가 포함된 문자를 저장할 수

있다

삼중 큰따옴표 **`String`** 안에서는 " 같은 특수 문자를 `이스케이프`할 필요가 없다

(일반 **`String`**의 경우'" 라고 써야 큰따옴표를 문자열 안에 넣을 수 있다.)

일반 **`String`**과 마찬가지로 삼중 큰따옴표 **`String`** 안에서도 $를 사용해 `식별자`나 식의 값을 `문자열`에 넣을 수 있다.

### 수 타입

`코틀린`은 정수타입(`Int`, Long 등)과 부동소수점 수 타입(`Double` 등) 제공

정수 상수는 기본적으로 `Int`지만 맨 뒤에 `L을 붙이면 Long타입`.

논리 연산(`불리언 연산`)이나 산술 연산 모두의 평가 순서를 이해하면 프로그램이 하는 일을 이해할 때 도움 된다.

평가 순서를 확실히 모를 경우 괄호를 사용해 여러분의 의도를 명확히 하라 괄호를 쓰면 코드를 읽는 사람에게도 여러분의 뜻을 더 명확히 드러낼 수 있다.

### While 반복

- 모든 산술 연산에 대해 더 짧은 연산자로 `대입문`을 수행할 수 있는
- `복합 대입 연산자` (+=, -=, * =.**/=.** 2**=)**가 존재한다.
- `코틀린은` 증가 연산자와 감소 연산자인 ++와 一도 지원한다.
- 두 연산자(증가와 감소) 모두 전위 형태나 후위 형태로 사용할 수 있다.
- **`while`**과 `do 키워드`를 함께 쓸 수도 있다.

### 루프와 범위

- `이터레이션` 가능한 객체에 정수 인덱스를 `증가`시키며 인덱스로 접근하는 프로그래밍 언어가 많다.
- `코틀린`에서 **`for`**를 사용하면 범위나 **`String`**과 같이 `이터레이션` 가능한 `객체`로부터 원소를 직접 얻으면서 루프를 돌 수 있다.
- 범위를 사용하면 `정숫값`을 `이터레이션`할 수 있다.
- .. 으로 범위를 만들면 양 끝 값을 포함한 범위가 생긴다.
- 반면 `until`로 범위를 만들면 오른쪽 끝 값을 제외한 범위가 생긴다.
- `step`을 사용하면 증갓값을 지정할 수 있다.

### In 키워드

`for` 루프의 `이터레이션`에 쓴 것과 같은 `in 키워드`를 사용해 어떤 값이 범위에 속하는지를 검사할 수 있다.

반면 `! in`은 대상 값이 범위 안에 속해 있지 **않은** 경우 `true`를 반환한다.

- `in`을 사용해 어떤 수가 부동소수점 수 범위에 속하는지 여부를 검사 가능
- 부동소수점 수 범위는 `.. 으로만` 생성할 수 있고 `until`로는 생성 불가능

### 식과 문

프로그래밍 언어에서 가장 작은 유용한 코드 조각은 문 또는 식이다.

- `문`은 상태를 변경한다.
- `식`은 값을 만든다.

식이 `결괏값`을 돌려주는 반면에 문은 그렇지 않다는 뜻.

문은 아무 값도 돌려주지 않기 때문에 뭔가 유용한 일을 하기 위해서는 자신을 둘러싼 주변의 상태를 `변경`해야만 한다 ( `부수 효과)`