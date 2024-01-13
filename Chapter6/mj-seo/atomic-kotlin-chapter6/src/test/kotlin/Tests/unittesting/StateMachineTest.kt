package unittesting

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class StateMachineTest {
    val sm = StateMachine()
    @Test
    fun start() {
        sm.start()
        assertEquals(State.On, sm.state)
    }

    @Test
    // 원칙적으로 함수 이름은 글자와 숫자만 허용되지만, 백틱(`)으로 함수 이름을 감싸면 공백을 포함한 문장으로 테스트를 기술할 수 있다.
    fun `pause and resume`() {
        sm.start()
        sm.pause()
        assertEquals(State.Paused, sm.state)
        sm.resume()
        assertEquals(State.On, sm.state)
        sm.pause()
        assertEquals(State.Paused, sm.state)
    }
 }
