@file:JsModule("vscode")

package vscode

/**
 * Log levels
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface LogLevel {
  companion object {
    /**
     * No messages are logged with this level.
     */
    val Off: LogLevel

    /**
     * All messages are logged with this level.
     */
    val Trace: LogLevel

    /**
     * Messages with debug and higher log level are logged with this level.
     */
    val Debug: LogLevel

    /**
     * Messages with info and higher log level are logged with this level.
     */
    val Info: LogLevel

    /**
     * Messages with warning and higher log level are logged with this level.
     */
    val Warning: LogLevel

    /**
     * Only error messages are logged with this level.
     */
    val Error: LogLevel
  }
}
