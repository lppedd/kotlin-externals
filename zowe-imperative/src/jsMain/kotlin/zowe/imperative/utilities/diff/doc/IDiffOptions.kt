package zowe.imperative.utilities.diff.doc

/**
 * interface for diff options
 */
external interface IDiffOptions : IDiffNameOptions {
  /**
   * Output format of differences between two, to be returned
   */
  var outputFormat: OutputFormat

  /**
   * Number of context line arguments
   */
  var contextLinesArg: Int?
}
