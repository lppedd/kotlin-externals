@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd

import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.handler.IChainedHandlerEntry
import zowe.imperative.logger.Logger

/**
 * Service for processing chained handlers and their argument mappings.
 */
external class ChainedHandlerService {
  companion object {
    /**
     * Get the arguments for the current handler in the chain
     *
     * @param binName name of the binary/primary command for this CLI
     * @param chainedHandlerConfigs the configured chained handlers.
     * @param handlerIndex current index into the chained handlers e.g. 0 is the first chained handler
     * @param previousResponseObjects command responses completed so far
     * @param overallArguments arguments specified by the use for the overall chained command
     * @param logger a logger to use as we check and perform the argument mappings
     * @return fully mapped arguments for this command
     */
    fun getArguments(
      binName: String,
      chainedHandlerConfigs: Array<IChainedHandlerEntry>,
      handlerIndex: Int,
      previousResponseObjects: Array<Any?>,
      overallArguments: ICommandArguments, // TODO(Edoardo): use Arguments from yargs
      logger: Logger,
    ): ICommandArguments // TODO(Edoardo): use Arguments from yargs
  }
}
