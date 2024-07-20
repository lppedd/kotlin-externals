@file:JsModule("vscode")
@file:JsQualifier("debug")

package vscode.debug

import js.array.ReadonlyArray
import vscode.*
import kotlin.ts.Union

/**
 * The currently active [DebugSession] or `undefined`. The active debug session is the one
 * represented by the debug action floating window or the one currently shown in the drop down menu of the debug action floating window.
 * If no debug session is active, the value is `undefined`.
 */
external var activeDebugSession: DebugSession?

/**
 * The currently active [DebugConsole].
 * If no debug session is active, output sent to the debug console is not shown.
 */
external var activeDebugConsole: DebugConsole

/**
 * List of breakpoints.
 */
external var breakpoints: ReadonlyArray<Breakpoint>

/**
 * An [Event] which fires when the [activeDebugSession]
 * has changed. *Note* that the event also fires when the active debug session changes
 * to `undefined`.
 */
external val onDidChangeActiveDebugSession: Event<DebugSession?>

/**
 * An [Event] which fires when a new [DebugSession] has been started.
 */
external val onDidStartDebugSession: Event<DebugSession>

/**
 * An [Event] which fires when a custom DAP event is received from the [DebugSession].
 */
external val onDidReceiveDebugSessionCustomEvent: Event<DebugSessionCustomEvent>

/**
 * An [Event] which fires when a [DebugSession] has terminated.
 */
external val onDidTerminateDebugSession: Event<DebugSession>

/**
 * An [Event] that is emitted when the set of breakpoints is added, removed, or changed.
 */
external val onDidChangeBreakpoints: Event<BreakpointsChangeEvent>

/**
 * The currently focused thread or stack frame, or `undefined` if no
 * thread or stack is focused. A thread can be focused any time there is
 * an active debug session, while a stack frame can only be focused when
 * a session is paused and the call stack has been retrieved.
 */
external val activeStackItem: Union<DebugThread, DebugStackFrame>?

/**
 * An event which fires when the [activeStackItem] has changed.
 */
external val onDidChangeActiveStackItem: Event<Union<DebugThread, DebugStackFrame>?>
