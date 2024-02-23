@file:JsModule("vscode")
@file:JsQualifier("debug")

package vscode.debug

import vscode.DebugSession
import vscode.Thenable

/**
 * Stop the given debug session or stop all debug sessions if session is omitted.
 *
 * @param session The [DebugSession debug session] to stop; if omitted all sessions are stopped.
 * @return A thenable that resolves when the session(s) have been stopped.
 */
external fun stopDebugging(session: DebugSession = definedExternally): Thenable<Unit>
