package zowe.imperative.cmd.help.doc

/**
 * Help generator API.
 *
 * See the AbstractHelpGenerator+DefaultHelpGenerator for the base implementation.
 */
external interface IHelpGenerator {
  /**
   * Constructs the help text for a command/group.
   */
  fun buildHelp(): String
}
