@file:JsModule("vscode")
@file:JsQualifier("languages")

package vscode.languages

import vscode.*

/**
 * Register a code action provider.
 *
 * Multiple providers can be registered for a language. In that case providers are asked in
 * parallel and the results are merged. A failing provider (rejected promise or exception) will
 * not cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A code action provider.
 * @param metadata Metadata about the kind of code actions the provider provides.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerCodeActionsProvider(
  selector: DocumentSelector,
  provider: CodeActionProvider<CodeAction>,
  metadata: CodeActionProviderMetadata = definedExternally,
): IDisposable
