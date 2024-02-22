@file:JsModule("@zowe/imperative")

package zowe.imperative.settings.errors

import zowe.imperative.error.ImperativeError

/**
 * This class represents an error that is thrown when a second settings singleton attempts to initialize.
 */
external class SettingsAlreadyInitialized : ImperativeError {
  constructor()
}
