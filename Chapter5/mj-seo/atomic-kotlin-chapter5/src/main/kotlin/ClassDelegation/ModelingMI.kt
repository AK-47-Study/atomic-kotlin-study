package classdelegation

import Test.eq


interface Rectangle {
    fun paint(): String
}

class ButtonImage(
    private val width: Int,
    private val height: Int
): Rectangle {
    override fun paint() =
        "painting ButtonImage($width, $height)"
}

interface MouseManager {
    fun clicked(): Boolean
    fun hovering(): Boolean
}

class UserInput : MouseManager {
    override fun clicked() = true
    override fun hovering() = true
}

/*
*  위임은 다중 상속의 필요성을 해결해준다.
*  -> 구현체를 두 개 상속할 수는 없지만, 두 클래스를 모두 위임할 수는 있다.
*     클래스 위임은, 합성과 상속을 모두 시도해보고 이 두 가지 선택이 모두 적합하지 않을 경우에 사용하는 것이 좋다.
*/
class Button(
    private val width: Int,
    private val height: Int,
    private var image: Rectangle =
        ButtonImage(width, height),
    private var input: MouseManager = UserInput()
): Rectangle by image, MouseManager by input

fun main() {
    val button = Button(10, 5)
    button.paint() eq "painting ButtonImage(10, 5)"

    button.clicked() eq true
    button.hovering() eq true

    // 위임한 두 타입으로 업캐스트가 가능하다.
    val rectangle: Rectangle = button
    val mouseManager: MouseManager = button

}