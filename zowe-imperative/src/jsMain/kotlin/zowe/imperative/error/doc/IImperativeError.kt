package zowe.imperative.error.doc

/**
 * Defines an error that occurred in the CLI.
 */
external interface IImperativeError {
  /**
   * Message text of the error
   */
  var msg: String

  /**
   * Original errors that caused/influenced this one
   */
  var causeErrors: Any?

  /**
   * any other extra contextual information (e.g. details pulled out of the cause errors)
   */
  var additionalDetails: String?

  /**
   * Error status
   */
  var stack: String?

  /**
   * If applicable, an error code, for example, HTTP status code surrounding the error
   */
  var errorCode: String?

  /**
   * Whether or not the error should suppress a full error dump, like in Imperative init
   */
  var suppressDump: Boolean?
}
