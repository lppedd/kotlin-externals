@file:JsModule("vscode")

package vscode.workspace

import vscode.Thenable

/**
 * Save all dirty files.
 *
 * @param includeUntitled Also save files that have been created during this session.
 * @return A thenable that resolves when the files have been saved. Will return `false`
 *   for any file that failed to save.
 */
external fun saveAll(includeUntitled: Boolean = definedExternally): Thenable<Boolean>
