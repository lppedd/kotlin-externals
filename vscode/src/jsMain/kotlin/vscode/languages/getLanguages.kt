@file:JsModule("vscode")

package vscode.languages

import vscode.Thenable

/**
 * Return the identifiers of all known languages.
 * @return Promise resolving to an array of identifier strings.
 */
external fun getLanguages(): Thenable<Array<String>>
