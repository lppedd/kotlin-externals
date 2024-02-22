@file:JsModule("vscode")

package vscode

/**
 * A breakpoint specified by a source location.
 */
external class SourceBreakpoint : Breakpoint {
  /**
   * Create a new breakpoint for a source location.
   */
  constructor(
    location: Location,
    enabled: Boolean = definedExternally,
    condition: String = definedExternally,
    hitCondition: String = definedExternally,
    logMessage: String = definedExternally,
  )

  /**
   * The source and line position of this breakpoint.
   */
  val location: Location
}
