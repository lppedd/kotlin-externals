@file:JsModule("vscode")

package vscode.languages

import vscode.DiagnosticChangeEvent
import vscode.Event

/**
 * An [Event] which fires when the global set of diagnostics changes. This is
 * newly added and removed diagnostics.
 */
external val onDidChangeDiagnostics: Event<DiagnosticChangeEvent>
