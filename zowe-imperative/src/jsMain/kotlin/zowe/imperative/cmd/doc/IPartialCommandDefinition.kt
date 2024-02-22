package zowe.imperative.cmd.doc

import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Interface that allows CLIs to override properties on command definitions.
 */
external interface IPartialCommandDefinition {
  /**
   * The description - keep group descriptions "small" and include lengthier descriptions for "commands".
   */
  var description: String?

  /**
   * A shorter (~one line) description of your command
   */
  var summary: String?

  /**
   * The set of examples displayed in the help for this command.
   */
  var examples: Array<ICommandExampleDefinition>?

  /**
   * The options to be exposed on the command.
   */
  var options: Array<ICommandOptionDefinition>?
}
