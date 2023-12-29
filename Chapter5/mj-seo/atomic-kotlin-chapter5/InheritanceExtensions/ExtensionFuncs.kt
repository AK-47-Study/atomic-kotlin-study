package inheritanceextensions2
import inheritanceextensions.Heater
import Test.eq


// 상속을 사용하지 않아도 확장 함수로 함수를 추가할 수 있다.
fun Heater.cool(temperature: Int) =
    "cooling to $temperature"

fun warmAndCool(heater: Heater) {
    heater.heat(70) eq "heating to 70"
    heater.cool(60) eq "cooling to 60"
}

fun main() {
    val heater = Heater()
    warmAndCool(heater)
}