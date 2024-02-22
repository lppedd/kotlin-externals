@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.errors

import zowe.imperative.error.ImperativeError
import zowe.imperative.imperative.plugins.PluginRequireProvider

/**
 * This error is thrown when a second call to [PluginRequireProvider.createPluginHooks] has
 * been made without destroying a previous hook call.
 */
external class PluginRequireAlreadyCreatedError : ImperativeError {
  constructor()
}
