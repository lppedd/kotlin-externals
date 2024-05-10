@file:JsModule("vscode")

package vscode

import kotlin.ts.Union

/**
 * Contains coverage information for a declaration. Depending on the reporter
 * and language, this may be types such as functions, methods, or namespaces.
 */
external class DeclarationCoverage {
  /**
   * Name of the declaration.
   */
  var name: String

  /**
   * The number of times this declaration was executed, or a boolean
   * indicating whether it was executed if the exact count is unknown. If
   * zero or false, the declaration will be marked as un-covered.
   */
  var executed: Union<Int, Boolean>

  /**
   * Declaration location.
   */
  var location: Union<Position, Range>

  /**
   * @param executed The number of times this declaration was executed, or a
   * boolean indicating  whether it was executed if the exact count is
   * unknown. If zero or false, the declaration will be marked as un-covered.
   * @param location The declaration position.
   */
  constructor(name: String, executed: Union<Int, Boolean>, location: Union<Position, Range>)
}
