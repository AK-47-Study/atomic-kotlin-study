package unittesting

import Test.capture
import kotlin.test.assertFails
import kotlin.test.assertFailsWith
import kotlin.test.expect


fun testFortyTwo2(n: Int = 42) {
    expect(n, "Incorrect,") { fortyTwo() }
}

fun main() {
    testFortyTwo2()
    capture {
        testFortyTwo2(43)
    } contains
            listOf("expected:", "<43> but was:", "<42>")
    assertFails { testFortyTwo2(43) }
    capture {
        // assertFails()는 예외가 던져졌는지 확인한다.
        assertFails { testFortyTwo2() }
    } contains listOf("Expected an exception", "to be thrown", "but was completed successfully")

    capture {
        // assertFailsWith()는 던저진 예외의 타입까지 검사한다.
        assertFailsWith<AssertionError> {
            testFortyTwo2()
        }
    } contains
            listOf("Expected an exception", "to be thrown", "but was completed successfully")

}
