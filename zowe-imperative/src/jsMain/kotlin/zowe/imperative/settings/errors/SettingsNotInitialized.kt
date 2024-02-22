@file:JsModule("@zowe/imperative")

package zowe.imperative.settings.errors

import zowe.imperative.error.ImperativeError

/**
 * This class represents an error thrown when a null singleton {@link AppSettings} object is referenced.
 */
external class SettingsNotInitialized : ImperativeError {
  constructor()
}
