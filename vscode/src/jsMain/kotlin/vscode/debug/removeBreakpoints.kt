@file:JsModule("vscode")

package vscode.debug

import js.array.ReadonlyArray
import vscode.Breakpoint

/**
 * Remove breakpoints.
 * @param breakpoints The breakpoints to remove.
 */
external fun removeBreakpoints(breakpoints: ReadonlyArray<Breakpoint>)
