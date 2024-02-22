package zowe.imperative.utilities.doc

/**
 * Option interface to construct request to daemon client
 */
external interface IDaemonRequest {
  /**
   * Process exit code
   */
  var exitCode: Int?

  /**
   * Content is for stdout
   */
  var stdout: String?

  /**
   * Content is for stderr
   */
  var stderr: String?

  /**
   * Content is for prompting
   */
  var prompt: String?

  /**
   * Content is for secure prompting
   */
  var securePrompt: String?

  /**
   * Content is progress spinner
   */
  var progress: Boolean?
}
