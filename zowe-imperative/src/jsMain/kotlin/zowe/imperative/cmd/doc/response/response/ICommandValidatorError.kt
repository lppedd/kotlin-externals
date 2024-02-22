package zowe.imperative.cmd.doc.response.response

import kotlin.js.plain.JsPlainObject

/**
 * Describes the operand in error and provides the full definition for the option/operand - normally
 * exposed when the JSON response format is requested.
 */
@JsPlainObject
external interface ICommandValidatorError {
  /**
   * The validation error message.
   */
  var message: String

  /**
   * The option that failed validation.
   */
  var optionInError: String?

  /**
   * The option definition that failed.
   */
  var definition: Any?
}
