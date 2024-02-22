@file:JsModule("vscode")

package vscode.languages

import vscode.Disposable
import vscode.SymbolInformation
import vscode.WorkspaceSymbolProvider

/**
 * Register a workspace symbol provider.
 *
 * Multiple providers can be registered. In that case providers are asked in parallel and
 * the results are merged. A failing provider (rejected promise or exception) will not cause
 * a failure of the whole operation.
 *
 * @param provider A workspace symbol provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerWorkspaceSymbolProvider(provider: WorkspaceSymbolProvider<SymbolInformation>): Disposable
