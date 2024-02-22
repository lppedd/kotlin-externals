@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.yargs

/**
 * Imperative define group command to Yargs - defines the group and it's children to Yargs.
 */
external class GroupCommandYargs : AbstractCommandYargs {
  /**
   * Define the group and its children to Yargs.
   *
   * @param commandExecuted The callback when this command is executed.
   */
  override fun defineCommandToYargs(commandExecuted: YargsCommandCompleted)
}
