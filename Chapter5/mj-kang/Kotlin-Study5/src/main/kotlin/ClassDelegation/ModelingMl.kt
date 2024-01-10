package classdelegation

import atomictest.eq


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

    val rectangle: Rectangle = button
    val mouseManager: MouseManager = button

}

