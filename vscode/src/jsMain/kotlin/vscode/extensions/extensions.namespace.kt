@file:JsModule("vscode")

package vscode.extensions

import js.array.ReadonlyArray
import vscode.Event
import vscode.Extension

/**
 * All extensions currently known to the system.
 */
external val all: ReadonlyArray<Extension<Any?>>

/**
 * An event which fires when `extensions.all` changes. This can happen when extensions are
 * installed, uninstalled, enabled or disabled.
 */
external val onDidChange: Event<Unit>
