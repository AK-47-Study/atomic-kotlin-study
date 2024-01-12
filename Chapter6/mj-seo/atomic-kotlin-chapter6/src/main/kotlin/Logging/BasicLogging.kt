package logging

import mu.KotlinLogging

private val logger = KotlinLogging.logger {  }

fun main() {
    val msg = "Hello, Kotlin Logging!"

    logger.trace(msg)
    logger.debug(msg)
    logger.info(msg)
    logger.warn(msg)
    logger.error(msg)

}

