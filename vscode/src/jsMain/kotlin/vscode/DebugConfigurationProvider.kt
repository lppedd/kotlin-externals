package vscode

/**
 * A debug configuration provider allows to add debug configurations to the debug service
 * and to resolve launch configurations before they are used to start a debug session.
 * A debug configuration provider is registered via [debug.registerDebugConfigurationProvider].
 */

external interface DebugConfigurationProvider {
/**
   * Provides [DebugConfiguration debug configuration] to the debug service. If more than one debug configuration provider is
   * registered for the same type, debug configurations are concatenated in arbitrary order.
   *
   * @param folder The workspace folder for which the configurations are used or `undefined` for a folderless setup.
   * @param token A cancellation token.
   * @return An array of [DebugConfiguration debug configurations].
   */
  fun provideDebugConfigurations(
    folder: WorkspaceFolder?,
    token: CancellationToken = definedExternally,
  ): ProviderResult<Array<DebugConfiguration>>

/**
   * Resolves a [DebugConfiguration debug configuration] by filling in missing values or by adding/changing/removing attributes.
   * If more than one debug configuration provider is registered for the same type, the resolveDebugConfiguration calls are chained
   * in arbitrary order and the initial debug configuration is piped through the chain.
   * Returning the value 'undefined' prevents the debug session from starting.
   * Returning the value 'null' prevents the debug session from starting and opens the underlying debug configuration instead.
   *
   * @param folder The workspace folder from which the configuration originates from or `undefined` for a folderless setup.
   * @param debugConfiguration The [DebugConfiguration debug configuration] to resolve.
   * @param token A cancellation token.
   * @return The resolved debug configuration or undefined or null.
   */
  fun resolveDebugConfiguration(
    folder: WorkspaceFolder?,
    debugConfiguration: DebugConfiguration,
    token: CancellationToken = definedExternally,
  ): ProviderResult<DebugConfiguration>

/**
   * This hook is directly called after 'resolveDebugConfiguration' but with all variables substituted.
   * It can be used to resolve or verify a [DebugConfiguration debug configuration] by filling in missing values or by adding/changing/removing attributes.
   * If more than one debug configuration provider is registered for the same type, the 'resolveDebugConfigurationWithSubstitutedVariables' calls are chained
   * in arbitrary order and the initial debug configuration is piped through the chain.
   * Returning the value 'undefined' prevents the debug session from starting.
   * Returning the value 'null' prevents the debug session from starting and opens the underlying debug configuration instead.
   *
   * @param folder The workspace folder from which the configuration originates from or `undefined` for a folderless setup.
   * @param debugConfiguration The [DebugConfiguration debug configuration] to resolve.
   * @param token A cancellation token.
   * @return The resolved debug configuration or undefined or null.
   */
  fun resolveDebugConfigurationWithSubstitutedVariables(
    folder: WorkspaceFolder?,
    debugConfiguration: DebugConfiguration,
    token: CancellationToken = definedExternally,
  ): ProviderResult<DebugConfiguration>
}
