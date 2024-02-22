@file:JsModule("vscode")

package vscode.languages

import vscode.DocumentSelector
import vscode.IDisposable
import vscode.OnTypeFormattingEditProvider

/**
 * Register a formatting provider that works on type. The provider is active when the user enables the setting `editor.formatOnType`.
 *
 * Multiple providers can be registered for a language. In that case providers are sorted
 * by their [vscode.languages.match] and the best-matching provider is used. Failure
 * of the selected provider will cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider An on type formatting edit provider.
 * @param firstTriggerCharacter A character on which formatting should be triggered, like `}`.
 * @param moreTriggerCharacter More trigger characters.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerOnTypeFormattingEditProvider(
  selector: DocumentSelector,
  provider: OnTypeFormattingEditProvider,
  firstTriggerCharacter: String,
  vararg moreTriggerCharacter: String,
): IDisposable
