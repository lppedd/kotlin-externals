@file:JsModule("vscode")

package vscode.languages

import vscode.DocumentSelector
import vscode.LanguageStatusItem

/**
 * Creates a new [LanguageStatusItem].
 *
 * @param id The identifier of the item.
 * @param selector The document selector that defines for what editors the item shows.
 * @return A new language status item.
 */
external fun createLanguageStatusItem(
  id: String,
  selector: DocumentSelector,
): LanguageStatusItem
