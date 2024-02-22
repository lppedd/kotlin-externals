@file:JsModule("vscode")

package vscode.languages

import vscode.DiagnosticCollection

/**
 * Create a diagnostics collection.
 *
 * @param name The [DiagnosticCollection.name] of the collection.
 * @return A new diagnostic collection.
 */
external fun createDiagnosticCollection(name: String = definedExternally): DiagnosticCollection
