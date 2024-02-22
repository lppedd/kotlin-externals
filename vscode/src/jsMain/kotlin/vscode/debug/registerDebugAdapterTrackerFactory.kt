@file:JsModule("vscode")

package vscode.debug

import vscode.DebugAdapterTrackerFactory
import vscode.Disposable

/**
 * Register a debug adapter tracker factory for the given debug type.
 *
 * @param debugType The debug type for which the factory is registered or '*' for matching all debug types.
 * @param factory The [DebugAdapterTrackerFactory] to register.
 * @return A [Disposable] that unregisters this factory when being disposed.
 */
external fun registerDebugAdapterTrackerFactory(
  debugType: String,
  factory: DebugAdapterTrackerFactory,
): Disposable
