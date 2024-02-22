@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.utilities.npm

import js.promise.Promise
import zowe.imperative.error.ImperativeError
import zowe.imperative.imperative.doc.IImperativeConfig

/**
 * Call a plugin's lifecycle hook to enable a plugin to take some action after the plugin has been
 * installed.
 *
 * @param pluginPackageNm The package name of the plugin being installed.
 * @param pluginImpConfig The imperative configuration for this plugin.
 * @throws ImperativeError
 */
external fun callPluginPostInstall(
  pluginPackageNm: String,
  pluginImpConfig: IImperativeConfig,
): Promise<Unit>
