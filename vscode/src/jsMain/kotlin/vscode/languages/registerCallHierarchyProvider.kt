@file:JsModule("vscode")
@file:JsQualifier("languages")

package vscode.languages

import vscode.CallHierarchyProvider
import vscode.DocumentSelector
import vscode.IDisposable

/**
 * Register a call hierarchy provider.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A call hierarchy provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerCallHierarchyProvider(
  selector: DocumentSelector,
  provider: CallHierarchyProvider,
): IDisposable
