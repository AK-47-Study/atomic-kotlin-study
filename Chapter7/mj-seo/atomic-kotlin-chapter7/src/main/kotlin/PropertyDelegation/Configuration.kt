package propertydelegation

import Test.eq


class Configuration {
    var user by FileDelegate()
    var id by FileDelegate()
    var project by FileDelegate()
}

fun main() {
    val config = Configuration()
    // 자동으로 각 프로퍼티와 연결된 파일을 만들고 프로퍼티에 쓴 데이터를 파일에 저장할 수 있다.
    config.user = "Luciano"
    config.id = "Ramalho47"
    config.project = "MyLittlePython"
    DataFile("user.txt").readText() eq "Luciano"
    DataFile("id.txt").readText() eq "Ramalho47"
    DataFile("project.txt").readText() eq "MyLittlePython"
}