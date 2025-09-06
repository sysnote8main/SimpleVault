package com.sysnote8.simplevault

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KProperty

/**
 * Example:
 * ```kotlin
 * val logger by DelegatedLogger()
 * ```
 */
class DelegatedLogger {
    private var logger: Logger? = null

    operator fun getValue(
        thisRef: Any,
        property: KProperty<*>,
    ): Logger =
        logger ?: run {
            val className = thisRef::class.java.name.removeSuffix("\$Companion")
            LoggerFactory.getLogger("$PL_ID:$className").also { logger = it }
        }
}
