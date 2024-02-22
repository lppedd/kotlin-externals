package zowe.sdk.console.doc

/**
 * Interface for Issue command parameters
 */
external interface IIssueParms : IConsoleParms {
  /**
   * The Command to issue.
   */
  var command: String

  /**
   * The system (withing the z/OSMF sysplex) to route the command.
   */
  var sysplexSystem: String?

  /**
   * The solicited keyword to check for in the response. Causes the API to return immediately when the keyword
   * is found, however, it may include solicited command response messages beyond the keyword itself.
   */
  var solicitedKeyword: String?

  /**
   * Indicates the method of issuing the command is synchronous or asynchronous.
   *
   * Default value is "N" - Synchronous request.
   */
  var async: String?
}
