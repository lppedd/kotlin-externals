@file:JsModule("vscode")

package vscode

import kotlin.ts.Union

/**
 * Contains coverage information for a branch of a [StatementCoverage].
 */
external class BranchCoverage {
  /**
   * The number of times this branch was executed, or a boolean indicating
   * whether it was executed if the exact count is unknown. If zero or false,
   * the branch will be marked as un-covered.
   */
  var executed: Union<Int, Boolean>

  /**
   * Branch location.
   */
  var location: Union<Position, Range>?

  /**
   * Label for the branch, used in the context of "the ${label} branch was
   * not taken," for example.
   */
  var label: String?

  /**
   * @param executed The number of times this branch was executed, or a
   * boolean indicating  whether it was executed if the exact count is
   * unknown. If zero or false, the branch will be marked as un-covered.
   * @param location The branch position.
   */
  constructor(
    executed: Union<Int, Boolean>,
    location: Union<Position, Range>? = definedExternally,
    label: String? = definedExternally,
  )
}
