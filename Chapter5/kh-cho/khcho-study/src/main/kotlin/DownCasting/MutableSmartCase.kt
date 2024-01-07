package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.DownCasting

class SmartCast1(val c : Creature){
    fun contact(){
        when(c) {
            is Human -> c.greeting()
            is Dog -> c.bark()
            is Alien -> c.mobility()
        }
    }
}

class SmartCast2(var c: Creature){
    fun contact(){
        when( val  c = c) {
            is Human -> c.greeting()
            is Dog -> c.bark()
            is Alien -> c.mobility()
        }
    }
}