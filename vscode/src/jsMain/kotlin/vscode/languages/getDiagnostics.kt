@file:JsModule("vscode")
@file:JsQualifier("languages")

package vscode.languages

import js.array.JsTuple2
import vscode.Diagnostic
import vscode.Uri

/**
 * Get all diagnostics for a given resource.
 *
 * @param resource A resource
 * @return An array of [Diagnostic] objects or an empty array.
 */
external fun getDiagnostics(resource: Uri): Array<Diagnostic>

/**
 * Get all diagnostics.
 *
 * @return An array of uri-diagnostics tuples or an empty array.
 */
external fun getDiagnostics(): Array<JsTuple2<Uri, Array<Diagnostic>>> // [ Uri, Diagnostic[] ]
