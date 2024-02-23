@file:JsModule("vscode")
@file:JsQualifier("debug")

package vscode.debug

import vscode.*

/**
 * Start debugging by using either a named launch or named compound configuration,
 * or by directly passing a [DebugConfiguration].
 * The named configurations are looked up in '.vscode/launch.json' found in the given folder.
 * Before debugging starts, all unsaved files are saved and the launch configurations are brought up-to-date.
 * Folder specific variables used in the configuration (e.g. '${workspaceFolder}') are resolved against the given folder.
 * @param folder The [WorkspaceFolder] for looking up named configurations and resolving variables or `undefined` for a non-folder setup.
 * @param nameOrConfiguration Either the name of a debug or compound configuration or a [DebugConfiguration] object.
 * @param parentSessionOrOptions Debug session options. When passed a parent [DebugSession], assumes options with just this parent session.
 * @return A thenable that resolves when debugging could be successfully started.
 */
external fun startDebugging(
  folder: WorkspaceFolder?,
  nameOrConfiguration: String,
  parentSessionOrOptions: DebugSession = definedExternally,
): Thenable<Boolean>

external fun startDebugging(
  folder: WorkspaceFolder?,
  nameOrConfiguration: String,
  parentSessionOrOptions: DebugSessionOptions = definedExternally,
): Thenable<Boolean>

external fun startDebugging(
  folder: WorkspaceFolder?,
  nameOrConfiguration: DebugConfiguration,
  parentSessionOrOptions: DebugSession = definedExternally,
): Thenable<Boolean>

external fun startDebugging(
  folder: WorkspaceFolder?,
  nameOrConfiguration: DebugConfiguration,
  parentSessionOrOptions: DebugSessionOptions = definedExternally,
): Thenable<Boolean>
