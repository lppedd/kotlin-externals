@file:JsModule("vscode")
@file:JsQualifier("languages")

package vscode.languages

import vscode.*

/**
 * Register a completion provider.
 *
 * Multiple providers can be registered for a language. In that case providers are sorted
 * by their [vscode.languages.match] and groups of equal score are sequentially asked for
 * completion items. The process stops when one or many providers of a group return a
 * result. A failing provider (rejected promise or exception) will not fail the whole
 * operation.
 *
 * A completion item provider can be associated with a set of `triggerCharacters`. When trigger
 * characters are being typed, completions are requested but only from providers that registered
 * the typed character. Because of that trigger characters should be different than [LanguageConfiguration.wordPattern],
 * a common trigger character is `.` to trigger member completions.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A completion provider.
 * @param triggerCharacters Trigger completion when the user types one of the characters.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerCompletionItemProvider(
  selector: DocumentSelector,
  provider: CompletionItemProvider<CompletionItem>,
  vararg triggerCharacters: String,
): IDisposable
