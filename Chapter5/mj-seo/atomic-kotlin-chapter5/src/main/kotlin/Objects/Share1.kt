package objectshare1
import objectsharing.Shared


fun f() {

    // object Shared를 다른 패키지에서 쓸 수 있다.
    Shared.i += 5
}