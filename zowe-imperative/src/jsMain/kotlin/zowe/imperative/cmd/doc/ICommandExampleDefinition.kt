package zowe.imperative.cmd.doc

import kotlin.js.plain.JsPlainObject

/**
 * Example command definition - used on command definitions to present examples for the user in the help.
 */
@JsPlainObject
external interface ICommandExampleDefinition {
  /**
   * Options for the example command - should be copy/paste-able - besides variable data - i.e. user name
   */
  var options: String

  /**
   * The example description - what does it do?
   */
  var description: String

  /**
   * Text to prepend to the command and options in the example. Useful for commands that read stdin e.g. "echo hello |"
   */
  var prefix: String?
}
