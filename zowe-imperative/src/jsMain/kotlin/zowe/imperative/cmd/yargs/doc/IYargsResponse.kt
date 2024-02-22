package zowe.imperative.cmd.yargs.doc

import zowe.imperative.cmd.doc.response.response.ICommandResponse

/**
 * The Yargs response is provided on the callback for a command definition defined through the
 * Brightside Yargs definer - when an execution of that command is complete - this response will be
 * given to the callback.
 */
external interface IYargsResponse {
  var success: Boolean

  /**
   * Requested exit code for the process
   */
  var exitCode: Int
  var message: String
  var actionPerformed: ImperativeYargsCommandAction
  var commandResponses: Array<ICommandResponse>?
  var causeErrors: Error?
}
