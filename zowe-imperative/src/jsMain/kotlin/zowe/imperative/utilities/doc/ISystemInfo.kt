package zowe.imperative.utilities.doc

/**
 * Information interface for basic system information
 */
external interface ISystemInfo {
  /**
   * The system's CPU architecture
   */
  var arch: String

  /**
   * The OS platform in use
   */
  var platform: String
}
