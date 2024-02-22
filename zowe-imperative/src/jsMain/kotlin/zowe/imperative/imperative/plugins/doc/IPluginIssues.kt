package zowe.imperative.imperative.plugins.doc

/**
 * Structure for the list of plugin issues.
 */
external interface IPluginIssues {
  /**
   * The plugin name is the key into a hash of validation issues.
   */
  @seskar.js.JsNative
  operator fun get(key: String): IPluginIssueList?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: IPluginIssueList?,
  )
}
