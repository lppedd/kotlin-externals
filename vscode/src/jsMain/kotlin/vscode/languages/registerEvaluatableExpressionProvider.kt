@file:JsModule("vscode")

package vscode.languages

import vscode.Disposable
import vscode.DocumentSelector
import vscode.EvaluatableExpressionProvider

/**
 * Register a provider that locates evaluatable expressions in text documents.
 * The editor will evaluate the expression in the active debug session and will show the result in the debug hover.
 *
 * If multiple providers are registered for a language an arbitrary provider will be used.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider An evaluatable expression provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerEvaluatableExpressionProvider(
  selector: DocumentSelector,
  provider: EvaluatableExpressionProvider,
): Disposable
