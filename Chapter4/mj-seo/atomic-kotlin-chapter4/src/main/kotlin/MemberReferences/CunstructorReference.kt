package memberreferences3
import Test.eq


data class Student(
    val id: Int,
    val name: String
)

fun main() {
    val names = listOf("Alice", "Bob")
    val students =
        names.mapIndexed {index, name ->
            Student(index, name)
        }

    students eq listOf(Student(0, "Alice")
        , Student(1, "Bob")
    )

    /*
    *  생성자 참조를 사용하면 단순히 람다로 전달되기만 하는 긴 파라미터 리스트를
    *  지정하는 수고를 하지 않아도 된다.
    * */
    names.mapIndexed(::Student) eq students

}