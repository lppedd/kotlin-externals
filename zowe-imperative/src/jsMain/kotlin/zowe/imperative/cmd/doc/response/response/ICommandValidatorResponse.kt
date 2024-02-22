package zowe.imperative.cmd.doc.response.response

import kotlin.js.plain.JsPlainObject

/**
 * Syntax validator response.
 *
 * TODO - In the future, when we supply an the ability to override/extend the SyntaxValidator, we should change the
 * TODO - validator from printing the syntax errors itself to returning an object with a structured error list.
 */
@JsPlainObject
external interface ICommandValidatorResponse {
  /**
   * Indicates if the syntax/parameters supplied by the user were valid.
   */
  var valid: Boolean
}
