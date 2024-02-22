@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * A DebugConfigurationProviderTriggerKind specifies when the `provideDebugConfigurations` method of a `DebugConfigurationProvider` is triggered.
 * Currently there are two situations: to provide the initial debug configurations for a newly created launch.json or
 * to provide dynamically generated debug configurations when the user asks for them through the UI (e.g. via the "Select and Start Debugging" command).
 * A trigger kind is used when registering a `DebugConfigurationProvider` with [vscode.debug.registerDebugConfigurationProvider].
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface DebugConfigurationProviderTriggerKind {
  companion object {
    /**
     * `DebugConfigurationProvider.provideDebugConfigurations` is called to provide the initial debug configurations for a newly created launch.json.
     */
    @JsIntValue(1)
    val Initial: DebugConfigurationProviderTriggerKind

    /**
     * `DebugConfigurationProvider.provideDebugConfigurations` is called to provide dynamically generated debug configurations when the user asks for them through the UI (e.g. via the "Select and Start Debugging" command).
     */
    @JsIntValue(2)
    val Dynamic: DebugConfigurationProviderTriggerKind
  }
}
