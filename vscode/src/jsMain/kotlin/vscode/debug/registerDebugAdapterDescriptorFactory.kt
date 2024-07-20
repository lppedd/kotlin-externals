@file:JsModule("vscode")
@file:JsQualifier("debug")

package vscode.debug

import vscode.DebugAdapterDescriptorFactory
import vscode.IDisposable

/**
 * Register a [DebugAdapterDescriptorFactory] for a specific debug type.
 * An extension is only allowed to register a DebugAdapterDescriptorFactory for the debug type(s) defined by the extension.
 * Otherwise, an error is thrown.
 *
 * Registering more than one [DebugAdapterDescriptorFactory] for a debug type results in an error.
 *
 * @param debugType The debug type for which the factory is registered.
 * @param factory The [DebugAdapterDescriptorFactory] to register.
 * @return A [IDisposable] that unregisters this factory when being disposed.
 */
external fun registerDebugAdapterDescriptorFactory(
  debugType: String,
  factory: DebugAdapterDescriptorFactory,
): IDisposable
