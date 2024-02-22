package zowe.imperative.cmd.yargs

import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.yargs.doc.IYargsResponse

/**
 * Callback that is invoked when a command defined to yargs completes execution.
 */
// TODO(Edoardo): use Arguments from yargs
typealias YargsCommandCompleted = (args: ICommandArguments, response: IYargsResponse) -> Unit
