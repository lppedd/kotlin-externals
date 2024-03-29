package zowe.imperative.cmd.doc.handler

import js.promise.Promise

/**
 * Brightside command handlers must implement this interface.
 *
 * !!!Note: Handlers must "export" the module name via "module.exports=<module name>" for the
 * handler to be instantiated correctly by the bright command processor.
 */
external interface ICommandHandler {
  /**
   * Process method - the handler for this command invocation - processes the command and populates
   * the response object as needed. Returns a promise that is expected to be fulfilled (never
   * manually rejected).
   *
   * @param commandParameters The parameter object to the handler.
   * @return The promise to be fulfilled when the command processing is complete.
   */
  fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
