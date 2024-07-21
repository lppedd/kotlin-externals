package vscode

import seskar.js.JsIntValue

/**
 * Log levels
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface LogLevel {
  companion object {
    /**
     * No messages are logged with this level.
     */
    @JsIntValue(0)
    val Off: LogLevel

    /**
     * All messages are logged with this level.
     */
    @JsIntValue(1)
    val Trace: LogLevel

    /**
     * Messages with debug and higher log level are logged with this level.
     */
    @JsIntValue(2)
    val Debug: LogLevel

    /**
     * Messages with info and higher log level are logged with this level.
     */
    @JsIntValue(3)
    val Info: LogLevel

    /**
     * Messages with warning and higher log level are logged with this level.
     */
    @JsIntValue(4)
    val Warning: LogLevel

    /**
     * Only error messages are logged with this level.
     */
    @JsIntValue(5)
    val Error: LogLevel
  }
}
