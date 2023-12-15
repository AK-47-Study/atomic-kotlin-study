package color1.color

import atomictest.eq
import color1.color


/*
*  인자 순서를 변경하고 나면, 인자 목록의 나머지 부분에서도 이름 붙은 인자를 사용해야 한다.
*  -> 이름 붙은 인자는 디폴트 인자와 결합하면 더 유용하다.
* */
fun main() {
    color(blue = 0, red = 99, green = 52) eq
            "(99, 52, 0)"

    color(red = 255, 255, 0) eq
            "(255, 255, 0)"
}