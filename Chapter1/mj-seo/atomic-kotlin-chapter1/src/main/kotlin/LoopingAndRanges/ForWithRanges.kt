package LoopingAndRanges


fun showRange(r: IntProgression) {
    for (i in r) {
        print("$i ")
    }

    print(" // $r")
    println()
}

fun main() {
    // 1 ~ 5 까지 반복
    showRange(1..5)
    // 0 ~ 4 까지 반복
    showRange(0 until 5)
    // 5 ~ 1 까지 반복 -> 감소하면서 반복(downTo 사용)
    showRange(5 downTo 1)
    // 0 ~ 9 까지 2씩 증가하며 반복(step 2 사용)
    showRange(0..9 step 2)
    // 0 ~ 9 까지 3씩 증가하며 반복(step 3)
    showRange(0 until 10 step 3)
    // 9 ~ 2 까지 3씩 감소하며 반복(step 3)
    showRange(9 downTo 2 step 3)
}