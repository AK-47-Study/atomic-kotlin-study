package unittesting
import org.junit.jupiter.api.Test
import unittesting.Language.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

fun makeLearner(
    id: Int,
    language: Language = Kotlin,
    name: String = "Test Name $id",
    surname: String = "Test Surname $id"
) = Learner(id, name, surname, language)

class LearnerTest {
    @Test
    fun `single Learner`() {
        val learner = makeLearner(10, Java)
        assertEquals("Test Name 10", learner.name)
    }

    @Test
    fun `multiple Learners`() {
        val learners = (1..9).map(::makeLearner)
        assertTrue(
            learners.any { it.language == Kotlin }
        )
    }
}