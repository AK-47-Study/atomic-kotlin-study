package exceptionhandling
import Test.CapturedException


fun capture(f:() -> Unit): CapturedException =
    try {
        f()
        CapturedException(null,
            "<Error>: Expected an Exception")
    } catch (e: Throwable) {
        CapturedException(e::class,
            if (e.message != null) ": ${e.message}" else "")
    }


fun main() {
    capture {
        throw Exception("!!!")
    } eq "Exception: !!!"

    capture {
        1
    } eq "<Error>: Expected an Exception"
}