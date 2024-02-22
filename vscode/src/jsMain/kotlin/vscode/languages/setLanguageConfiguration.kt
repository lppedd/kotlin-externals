@file:JsModule("vscode")

package vscode.languages

import vscode.Disposable
import vscode.LanguageConfiguration

/**
 * Set a [LanguageConfiguration] for a language.
 *
 * @param language A language identifier like `typescript`.
 * @param configuration Language configuration.
 * @return A [Disposable] that unsets this configuration.
 */
external fun setLanguageConfiguration(
  language: String,
  configuration: LanguageConfiguration,
): Disposable
