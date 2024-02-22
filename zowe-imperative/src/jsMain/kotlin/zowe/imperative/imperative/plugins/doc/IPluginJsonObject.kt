package zowe.imperative.imperative.plugins.doc

/**
 * Information about an installed plugin
 */
external interface IPluginJsonObject {
  /**
   * The package location. If this is an npm package, this will be no different than the key in the JSON file.
   */
  var `package`: String

  /**
   * The npm registry to install from.
   */
  var registry: String

  /**
   * The version of the installed plugin.
   */
  var version: String
}
