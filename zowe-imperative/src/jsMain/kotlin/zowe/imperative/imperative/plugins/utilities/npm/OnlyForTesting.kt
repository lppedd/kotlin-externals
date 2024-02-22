package zowe.imperative.imperative.plugins.utilities.npm

import js.promise.Promise
import zowe.imperative.imperative.doc.IImperativeConfig

external interface OnlyForTesting {
  var callPluginPostInstall: (pluginPackageNm: String, pluginImpConfig: IImperativeConfig) -> Promise<Unit>
}
