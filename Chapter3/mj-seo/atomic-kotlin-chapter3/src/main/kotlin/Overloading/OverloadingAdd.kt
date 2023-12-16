package overloading

import atomictest.eq


/*
*  addInt()나 addDouble() 이라는 이름은
*  함수 파라미터에 있는 정보를 함수 이름에 반복하는 것 뿐이다.
* */
fun addInt(i: Int, j: Int) = i + j
fun addDouble(i: Double, j: Double) = i + j

fun add(i: Int, j: Int) = i + j
fun add(i: Double, j: Double) = i + j

fun main() {
    addInt(5, 6) eq add(5, 6)
    addDouble(56.23, 44.77) eq add(56.23, 44.77)
}