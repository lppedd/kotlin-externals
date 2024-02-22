@file:JsModule("vscode")

package vscode.debug

import vscode.DebugConfigurationProvider
import vscode.DebugConfigurationProviderTriggerKind
import vscode.Disposable

/**
 * Register a [DebugConfigurationProvider] for a specific debug type.
 * The optional [DebugConfigurationProviderTriggerKind] can be used to specify when the `provideDebugConfigurations` method of the provider is triggered.
 * Currently two trigger kinds are possible: with the value `Initial` (or if no trigger kind argument is given) the `provideDebugConfigurations` method is used to provide the initial debug configurations to be copied into a newly created launch.json.
 * With the trigger kind `Dynamic` the `provideDebugConfigurations` method is used to dynamically determine debug configurations to be presented to the user (in addition to the static configurations from the launch.json).
 * Please note that the `triggerKind` argument only applies to the `provideDebugConfigurations` method: so the `resolveDebugConfiguration` methods are not affected at all.
 * Registering a single provider with resolve methods for different trigger kinds, results in the same resolve methods called multiple times.
 * More than one provider can be registered for the same type.
 *
 * @param debugType The debug type for which the provider is registered.
 * @param provider The [DebugConfigurationProvider] to register.
 * @param triggerKind The [DebugConfigurationProviderTriggerKind] for which the 'provideDebugConfiguration' method of the provider is registered. If `triggerKind` is missing, the value `DebugConfigurationProviderTriggerKind.Initial` is assumed.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerDebugConfigurationProvider(
  debugType: String,
  provider: DebugConfigurationProvider,
  triggerKind: DebugConfigurationProviderTriggerKind = definedExternally,
): Disposable
