@file:JsModule("vscode")

package vscode.window

import vscode.DecorationRenderOptions
import vscode.TextEditorDecorationType

/**
 * Create a TextEditorDecorationType that can be used to add decorations to text editors.
 *
 * @param options Rendering options for the decoration type.
 * @return A new decoration type instance.
 */
external fun createTextEditorDecorationType(options: DecorationRenderOptions): TextEditorDecorationType
