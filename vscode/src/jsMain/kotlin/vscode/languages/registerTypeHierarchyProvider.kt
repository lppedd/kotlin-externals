@file:JsModule("vscode")
@file:JsQualifier("languages")

package vscode.languages

import vscode.DocumentSelector
import vscode.IDisposable
import vscode.TypeHierarchyProvider

/**
 * Register a type hierarchy provider.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A type hierarchy provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerTypeHierarchyProvider(
  selector: DocumentSelector,
  provider: TypeHierarchyProvider,
): IDisposable
