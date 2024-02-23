@file:JsModule("vscode")
@file:JsQualifier("extensions")

package vscode.extensions

import vscode.Extension

/**
 * Get an extension by its full identifier in the form of: `publisher.name`.
 *
 * @param extensionId An extension identifier.
 * @return An extension or `undefined`.
 */
external fun <T : Any? /* default is Any? */> getExtension(extensionId: String): Extension<T>?
