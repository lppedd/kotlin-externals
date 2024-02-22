@file:JsModule("vscode")

package vscode.languages

import vscode.CallHierarchyProvider
import vscode.Disposable
import vscode.DocumentSelector

/**
 * Register a call hierarchy provider.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A call hierarchy provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerCallHierarchyProvider(
  selector: DocumentSelector,
  provider: CallHierarchyProvider,
): Disposable
