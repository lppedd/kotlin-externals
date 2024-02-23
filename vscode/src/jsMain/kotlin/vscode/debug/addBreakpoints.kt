@file:JsModule("vscode")
@file:JsQualifier("debug")

package vscode.debug

import js.array.ReadonlyArray
import vscode.Breakpoint

/**
 * Add breakpoints.
 * @param breakpoints The breakpoints to add.
 */
external fun addBreakpoints(breakpoints: ReadonlyArray<Breakpoint>)
