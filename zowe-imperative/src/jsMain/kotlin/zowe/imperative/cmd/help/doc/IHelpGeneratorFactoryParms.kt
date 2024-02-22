package zowe.imperative.cmd.help.doc

import kotlin.js.plain.JsPlainObject

/**
 * Input to the help generator factory - normally built by imperative and passed to the command
 * definition infrastructure - Each instance of the help generator is created with the command being
 * issued (and the full command tree).
 */
@JsPlainObject
external interface IHelpGeneratorFactoryParms {
  /**
   * The root command for your CLI (i.e. the command that identifies your CLI/binary)
   */
  var rootCommandName: String

  /**
   * Produce a markdown file (rather than the normal help text output).
   * Useful for providing CLI documentation
   */
  var produceMarkdown: Boolean?

  /**
   * The primary highlight color - for the chalk package (coloring of console output)
   */
  var primaryHighlightColor: String?
}
