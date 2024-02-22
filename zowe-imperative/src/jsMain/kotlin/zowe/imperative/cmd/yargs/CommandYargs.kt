@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.yargs

import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Define an Imperative Command to Yargs. A command implies that an implementation is present
 * (differs from a "group") and it does not have children.
 */
external class CommandYargs : AbstractCommandYargs {
  /**
   * Define the Imperative JSON command definition to Yargs. Once the command is defined, Yargs will
   * parse and invoke its 'handler' (below). The handler can then invoke the potential "chain" of
   * handlers in sequence and is notified when they complete via a promise.
   *
   * @param commandExecuted Callback invoked when a command execution is complete.
   */
  override fun defineCommandToYargs(commandExecuted: YargsCommandCompleted)

  companion object {
    /**
     * Define the options to Yargs.
     *
     * @param yargsInstance The instance of yargs to define the options.
     * @param brightOptions The option definition document array.
     */
    fun defineOptionsToYargs(
      yargsInstance: Any, /* Argv */ // TODO(Edoardo): use Argv from yargs
      brightOptions: Array<ICommandOptionDefinition>,
    )
  }
}
