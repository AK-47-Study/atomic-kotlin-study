package unittesting

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import kotlin.test.expect


class SampleTest {
    @Test
    fun testFortyTwo() {
        expect(42, "Incorrect,") { fortyTwo() }
    }

    @Test
    fun testAllGood() {
        assertTrue(allGood(), "Not good")
    }
}
