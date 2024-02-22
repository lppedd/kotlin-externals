package zowe.imperative.cmd.help.doc

import zowe.imperative.cmd.doc.ICommandDefinition
import kotlin.js.plain.JsPlainObject

/**
 * The input parameters to the help generator - the command definition and the tree.
 */
@JsPlainObject
external interface IHelpGeneratorParms {
  /**
   * The command node for the command currently being issued.
   */
  var commandDefinition: ICommandDefinition

  /**
   * The entire command tree (which includes the command node for the command being issued)
   */
  var fullCommandTree: ICommandDefinition

  /**
   * The description text for what "experimental" means in the context of your CLI
   */
  var experimentalCommandsDescription: String?

  /**
   * The indicator that the given help generator should skip introducing breaks based on terminal
   * width
   */
  var skipTextWrap: Boolean?
}
