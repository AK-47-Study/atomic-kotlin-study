package ExtensionProperties


fun main() {
    generateSequence(6) {
        (it - 1).takeIf { it > 0 }
    }

    generateSequence(6) {
        if (it - 1 > 0) it else null
    }
}