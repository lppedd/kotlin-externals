package zowe.imperative.imperative.plugins.doc

/**
 * Format of plugins.json file. Represents the list of installed plugins.
 */
external interface IPluginJson {
  /**
   * Each object key is the name of a plugin and the value is information about said plugin.
   */
  @seskar.js.JsNative
  operator fun get(key: String): IPluginJsonObject?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: IPluginJsonObject?,
  )
}
