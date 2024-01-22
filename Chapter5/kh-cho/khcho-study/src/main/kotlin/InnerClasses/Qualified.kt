package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.InnerClasses

import Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.TypeChecking.name
import atomictest.eq

class Fruit {
    fun changeColor(color: String) =
        "Fruit $color"
    fun absorbWater(amount: Int) {}
    inner class Seed { // @Seed라는 레이블이 암시적으로 붙는다
        fun changeColor(color: String) =
            "Seed $color"

        fun germinate() {}
        fun whichThis() {
            this.name eq "Seed"
            // 명확히 하기 위해 디폴트 this를
            // 한정시킬 수 있다
            this@Seed.name eq "Seed"
            this@Fruit.name eq "Fruit"
        }

        inner class DNA { // @DNA라는 레이블이 암시적으로 붙는다
            fun changeColor(color: String) {
// changeColor(color) // 재귀 호출
                this@Seed.changeColor(color)
                this@Fruit.changeColor(color)
            }

            fun plant() {
                // 한정을 시키지 않고 외부 클래스의
                // 함수를 호출할 수 있다
                germinate()
                absorbWater(10)
            }

            // 확장 함수
            fun Int.grow() { // @grow라는 암시적 레이블이 붙는다
                // 디폴트는 Int.grow()로 , 'Int' 를 수신 객체로 받는다
                this.name eq "Int"
                this@grow.name eq "Int"
                this@DNA.name eq "DNA"
                this@Seed.name eq "Seed"
                this@Fruit.name eq "Fruit"
            }

            // 외부 클래스에 대한 확장 함수들
            fun Seed.plant() {}
            fun Fruit.plant() {}
            fun whichThis() {
// 디폴트는 현재 클래스이다
                this.name eq "DNA"
                this@DNA.name eq "DNA"
// 다른 클래스 한정은 꼭 명시해야 한다
                this@Seed.name eq "Seed"
                this@Fruit.name eq "Fruit"
            }
        }
    }
}
fun Fruit.grow(amount: Int) {
    absorbWater(amount)
    // Fruit의 'changeColor()' 를 호출한다
    changeColor("Red") eq "Fruit Red"
}
    // 내부 클래스를 확장한 함수
fun Fruit.Seed.grow(n: Int) {
    germinate()
    // Seed의 changeColor를 호출한다
    changeColor("Green") eq "Seed Green"
}
fun Fruit.Seed.DNA.grow(n: Int) = n.grow()
fun main() {
    val fruit = Fruit()
    fruit.grow(4)
    val seed = fruit.Seed()
    seed.grow(9)
    seed.whichThis()
    val dna = seed.DNA()
    dna.plant()
    dna.grow(5)
    dna.whichThis()
    dna.changeColor("Purple")
}