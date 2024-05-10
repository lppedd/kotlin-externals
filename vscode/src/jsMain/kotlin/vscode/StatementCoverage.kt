@file:JsModule("vscode")

package vscode

import kotlin.ts.Union

/**
 * Contains coverage information for a single statement or line.
 */
external class StatementCoverage {
  /**
   * The number of times this statement was executed, or a boolean indicating
   * whether it was executed if the exact count is unknown. If zero or false,
   * the statement will be marked as un-covered.
   */
  var executed: Union<Int, Boolean>

  /**
   * Statement location.
   */
  var location: Union<Position, Range>

  /**
   * Coverage from branches of this line or statement. If it's not a
   * conditional, this will be empty.
   */
  var branches: Array<BranchCoverage>

  /**
   * @param location The statement position.
   * @param executed The number of times this statement was executed, or a
   * boolean indicating  whether it was executed if the exact count is
   * unknown. If zero or false, the statement will be marked as un-covered.
   * @param branches Coverage from branches of this line.  If it's not a
   * conditional, this should be omitted.
   */
  constructor(
    executed: Union<Int, Boolean>,
    location: Union<Position, Range>,
    branches: Array<BranchCoverage>? = definedExternally,
  )
}
