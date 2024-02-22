@file:JsModule("vscode")

package vscode.languages

import vscode.Disposable
import vscode.DocumentSelector
import vscode.TypeHierarchyProvider

/**
 * Register a type hierarchy provider.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A type hierarchy provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerTypeHierarchyProvider(
  selector: DocumentSelector,
  provider: TypeHierarchyProvider,
): Disposable
