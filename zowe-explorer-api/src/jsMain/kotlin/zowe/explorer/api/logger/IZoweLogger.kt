@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.logger

import zowe.imperative.logger.Logger

/**
 * Creates an instance of the Imperative logger for extenders to use
 */
external class IZoweLogger {
  /**
   * Creates an instance of the Imperative logger
   */
  constructor(extensionName: String, loggingPath: String)

  fun getExtensionName(): String

  fun getImperativeLogger(): Logger

  /**
   * Log an error message to the Imperative logger.
   * Default severity is DEBUG if not specified.
   */
  fun logImperativeMessage(
    message: String,
    severity: MessageSeverity = definedExternally,
  )
}
