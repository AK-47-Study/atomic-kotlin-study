package color2

import atomictest.eq


fun color(
    red: Int = 0,
    green: Int = 0,
    /*
    *  덧붙은 콤마는 마지막 파라미터 뒤에 콤마를 추가로 붙인 것을 말한다.
    *  -> 콤마를 추가하거나 빼지 않아도 새로운 아이템을 추가하거나 아이템의 순서를 바꿀 수 있다.
    * */
    blue: Int = 0,
) = "($red, $green, $blue)"

fun main() {
    color(139) eq "(139, 0, 0)"
    color(blue = 139) eq "(0, 0, 139)"
    color(255, 165) eq "(255, 165, 0)"
    color(red = 128, blue = 128) eq "(128, 0, 128)"
}