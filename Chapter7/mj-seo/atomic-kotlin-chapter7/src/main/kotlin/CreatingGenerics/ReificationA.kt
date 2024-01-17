package creatinggenerics

import kotlin.reflect.KClass


fun <T: Any> a(kClass: KClass<T>) {
    // kClass<T>를 사용하면 런타임에 타입 정보를 알 수 있다.
}