@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.errors

import zowe.imperative.error.ImperativeError
import zowe.imperative.imperative.plugins.PluginRequireProvider

/**
 * This error is thrown when a call to [PluginRequireProvider.destroyPluginHooks] has been
 * made without hooks in place.
 */
external class PluginRequireNotCreatedError : ImperativeError {
  constructor()
}
