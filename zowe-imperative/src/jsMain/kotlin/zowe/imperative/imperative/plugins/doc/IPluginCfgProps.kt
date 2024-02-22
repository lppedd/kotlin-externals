package zowe.imperative.imperative.plugins.doc

import zowe.imperative.imperative.doc.IImperativeConfig

/**
 * A plugin's configuration properties. All are obtained from the plugin's package.json.
 */
external interface IPluginCfgProps {
  var pluginName: String
  var npmPackageName: String
  var impConfig: IImperativeConfig
  var cliDependency: IPluginPeerDepends
  var impDependency: IPluginPeerDepends
}
