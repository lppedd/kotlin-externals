package zowe.imperative.utilities.diff.doc

/**
 * interface for diff options related to naming
 */
external interface IDiffNameOptions {
  /**
   * Optional name for string1
   */
  var name1: String?

  /**
   * Optional name for string2
   */
  var name2: String?
}
