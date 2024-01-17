package variance


class Box<T>(private var contents: T) {
    fun put(item: T) { contents = item }
    fun get(): T = contents
}

// in T는 T 타입을 집어 넣을수는 있어도 반환할 수는 없다.
class InBox<in T>(private var contents: T) {
    fun put(item: T) { contents = item }
}

// out T는 T 타입을 반환할 수는 있어도 넣을 수는 없다.
class OutBox<out T>(private var contents: T) {
    fun get(): T = contents
}

