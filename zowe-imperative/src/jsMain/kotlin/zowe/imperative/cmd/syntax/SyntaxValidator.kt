@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.syntax

import js.promise.Promise
import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.response.response.ICommandValidatorResponse
import zowe.imperative.cmd.response.CommandResponse

/**
 * The Imperative default syntax validator. Accepts the input arguments, command definitions, and a
 * response object. Validates the syntax and issues the appropriate error messages if necessary.
 *
 * TODO - Consider limiting to a single purpose of producing error documents
 * TODO - that will be outputted by the command processor in a "more structured" TODO - fasion.
 */
external class SyntaxValidator {
  /**
   * Create the object - maintains the definition used to validate against the input arguments.
   *
   * @param commandDefinition The command definition document
   * @param fullCommandDefinition The full command definition
   */
  constructor(commandDefinition: ICommandDefinition, fullCommandDefinition: ICommandDefinition)

  /**
   * Validate the command syntax.
   *
   * @param responseObject The response object to output the messages.
   * @param commandArguments
   */
  fun validate(
    responseObject: CommandResponse,
    commandArguments: ICommandArguments,
  ): Promise<ICommandValidatorResponse>

  companion object {
    /** Command option short/long */
    var SHORT: String
    var LONG: String
  }
}
