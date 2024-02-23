@file:JsModule("vscode")
@file:JsQualifier("languages")

package vscode.languages

import vscode.IDisposable
import vscode.LanguageConfiguration

/**
 * Set a [LanguageConfiguration] for a language.
 *
 * @param language A language identifier like `typescript`.
 * @param configuration Language configuration.
 * @return A [IDisposable] that unsets this configuration.
 */
external fun setLanguageConfiguration(
  language: String,
  configuration: LanguageConfiguration,
): IDisposable
