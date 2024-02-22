@file:JsModule("vscode")

package vscode.window

import vscode.LogOutputChannel
import vscode.OutputChannel
import vscode.TextDocument

/**
 * Creates a new [OutputChannel] with the given name and language id
 * If language id is not provided, then **Log** is used as default language id.
 *
 * You can access the visible or active output channel as a [TextDocument] from [vscode.window.visibleTextEditors] or [vscode.window.activeTextEditor]
 * and use the language id to contribute language features like syntax coloring, code lens etc.,
 *
 * @param name Human-readable string which will be used to represent the channel in the UI.
 * @param languageId The identifier of the language associated with the channel.
 * @return A new output channel.
 */
external fun createOutputChannel(
  name: String,
  languageId: String = definedExternally,
): OutputChannel

/**
 * Creates a new [LogOutputChannel] with the given name.
 *
 * @param name Human-readable string which will be used to represent the channel in the UI.
 * @param options Options for the log output channel.
 * @return A new log output channel.
 */
external fun createOutputChannel(
  name: String,
  options: CreateOutputChannelOptions,
): LogOutputChannel
