package nullableextensions

import atomictest.eq


fun isNullOrEmpty(s: String?) =
    s == null || s.isEmpty()


fun main() {
    isNullOrEmpty(null) eq true
    isNullOrEmpty("") eq true
}