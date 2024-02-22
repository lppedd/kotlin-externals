@file:JsModule("vscode")

package vscode

/**
 * A breakpoint specified by a function name.
 */

external class FunctionBreakpoint : Breakpoint {
  /**
   * Create a new function breakpoint.
   */
  constructor (
    functionName: String,
    enabled: Boolean = definedExternally,
    condition: String = definedExternally,
    hitCondition: String = definedExternally,
    logMessage: String = definedExternally,
  )

  /**
   * The name of the function to which this breakpoint is attached.
   */
  val functionName: String
}
