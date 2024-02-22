@file:JsModule("vscode")

package vscode

/**
 * Represents a collection of [CompletionItem]s to be presented
 * in the editor.
 */
external class CompletionList<
  @Suppress("FINAL_UPPER_BOUND")
  T : CompletionItem, // default is CompletionItem
> {
  /**
   * Creates a new completion list.
   *
   * @param items The completion items.
   * @param isIncomplete The list is not complete.
   */
  @Suppress("ConvertSecondaryConstructorToPrimary")
  constructor(items: Array<T> = definedExternally, isIncomplete: Boolean = definedExternally)

  /**
   * This list is not complete. Further typing should result in recomputing
   * this list.
   */
  var isIncomplete: Boolean?

  /**
   * The completion items.
   */
  var items: Array<T>
}
