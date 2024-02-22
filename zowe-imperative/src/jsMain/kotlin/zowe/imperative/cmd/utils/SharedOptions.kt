@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.utils

import js.promise.Promise
import zowe.imperative.cmd.doc.ICommandNodeType
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.response.CommandResponse

/**
 * Options which can be reused between different Brightside commands
 */
external class SharedOptions {
  companion object {
    /**
     * Promise based API for reading the standard in if the arguments dictate to do so. The response
     * is placed in the arguments to be passed on the the command handlers.
     *
     * @param args The yargs style command line arguments supplied by the user
     * @param response The command response object (for messages, etc.)
     * @param commandType The type of the command
     * @return The promise to be fulfilled (or rejected with an imperative
     *   error) - false if stdin was read and false if it wasn't
     */
    fun readStdinIfRequested(
      args: ICommandArguments, // TODO(Edoardo): replace with Arguments from yargs
      response: CommandResponse,
      commandType: ICommandNodeType,
      stream: Any /* SharedOptionsReadStdinIfRequestedStream */ = definedExternally, // TODO(Edoardo): fix type
    ): Promise<Boolean>
  }
}
