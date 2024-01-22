package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.extensionLambdas

fun unitReturn(lambda: A.() -> Unit)= A().lambda()
fun nonUnitReturn(lambda: A.() -> String)= A().lambda()
fun main() {
    unitReturn {
        "Unit ignores the return value" +
                "So it can be anything ..."
    }
    unitReturn { 1 } // ... 임의의 타입 ...
    unitReturn { } // ... 아무 값도 만들어내지 않는 경우
    nonUnitReturn {
        "Must return the proper type"
    }
    // nonUnitReturn { } // 이렇게 쓸 수 없음
}
