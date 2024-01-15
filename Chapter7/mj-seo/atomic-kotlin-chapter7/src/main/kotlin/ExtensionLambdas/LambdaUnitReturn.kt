package extensionlambdas


fun unitReturn(lambda: A.() -> Unit) =
    A().lambda()

fun nonUnitReturn(lambda: A.() -> String) =
    A().lambda()

fun main() {
    unitReturn {
        "Unit ignores the return value" +
                "So it can be anything ..."
    }


    unitReturn { 1 }
    unitReturn {  }

    nonUnitReturn {
        "Must return the proper type"
    }

    // 이렇게 작성하면 컴파일이 되지 않는다.
//    nonUnitReturn {  }
}