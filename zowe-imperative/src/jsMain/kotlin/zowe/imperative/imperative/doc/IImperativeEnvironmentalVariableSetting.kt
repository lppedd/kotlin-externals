package zowe.imperative.imperative.doc

/**
 * Interface representing a single setting
 */
external interface IImperativeEnvironmentalVariableSetting {
  /**
   * The key to the process.env object AKA. the environmental variable name e.g. MYCLI_APP_LOG_LEVEL
   */
  var key: String

  /**
   * The value specified by the user for this variable, if any e.g. "DEBUG"
   */
  var value: String
}
